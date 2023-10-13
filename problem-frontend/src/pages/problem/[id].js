import { useContext, useEffect, useState } from 'react';
import { SessionContext } from '../../context/SessionContext';
import { useRouter } from 'next/router';
import 'bootstrap/dist/css/bootstrap.css';
import { useQuery } from '@apollo/client';
import gql from 'graphql-tag';

// 아래 스트링 방식이 후진적으로 보일 수 있는데, 간접적으로 문법검사나, 자동생성 툴이 존재한다.
// 하지만, 결국 서버측에 문자열로 graphQL을 보내야한다. 현재 graphQL의 한계점.
const GET_PROBLEM_SUBMISSION_COUNT = gql`
  query GetProblemSubmissionCount($problemId: Int!) {
    submissionCountByProblem(problemId: $problemId)
  }
`;


const Problem = () => {
  const router = useRouter();
  const { id } = router.query; // URL에서 id 값을 가져옵니다.
  const [problem, setProblem] = useState(null);
  const { isAuthenticated, username } = useContext(SessionContext);
  const [sourceCode, setSourceCode] = useState("");

  const { data, loading, error } = useQuery(GET_PROBLEM_SUBMISSION_COUNT, {
    variables: { problemId: Number(id) },
    skip: !id  // id가 없는 경우 쿼리를 건너뜁니다.
  });

  // JavaScript의 옵셔널 체이닝(Optional Chaining)사용('?.'부분들)
  const submissionCount = data?.submissionCountByProblem;
  if(data)
    console.log('GraphQL response:', JSON.stringify(data, null, 2));


  useEffect(() => {
    console.log('isAuth:' + isAuthenticated + ', username: '+username);
    if(isAuthenticated===undefined) return;  // 최초 렌더링은 스킵
    if (!username) {
      // 로그인 필요 시 클라이언트에서 리디렉션
      window.location.href = 'https://sevity.com:9992/login';
    }
  }, [isAuthenticated]);

  useEffect(() => {
    if (id) {
      const fetchData = async () => {
        try {
          const response = await fetch(`https://sevity.com:9993/problems/${id}`);
          const data = await response.json();
          console.log('REST data:', JSON.stringify(data, null, 2));
          setProblem(data);
        } catch (error) {
          console.error('문제 불러오기 실패:', error);
        }
      };
      fetchData();
    }
  }, [id]);

  const handleSubmit = async () => {
    try {
      const response = await fetch("https://sevity.com:9993/submit", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        credentials: 'include',
        body: JSON.stringify({
          problemId: id,
          sourceCode,
        }),
      });

      if (response.ok) {
        alert("제출 성공!");
      } else {
        alert("제출 실패!");
      }
    } catch (error) {
      console.error("제출 중 오류 발생:", error);
    }
  };  

  if (!username) {
    // 서버 사이드 렌더링 시 리디렉션을 위한 컴포넌트 반환
    return (
      <div className="alert alert-success mt-3">로그인 필요!! </div>
    );
  };

  return (
    <div className="container">
      <div className="alert alert-success mt-3">username: {username} </div>
      {problem ? (
        <>
          <h1>{problem.title}</h1>
          <p>{problem.description}</p>
          <p><strong>예제 입력:</strong> {problem.exampleInput}</p>
          <p><strong>예제 출력:</strong> {problem.exampleOutput}</p>
          <p><strong>실제 입력:</strong> {problem.realInput}</p>
          <p><strong>실제 출력:</strong> {problem.realOutput}</p>
          {submissionCount && (
            <p><strong>제출 횟수:</strong> {submissionCount}</p>
          )}
          <textarea
            className="form-control"
            rows="10"
            value={sourceCode}
            onChange={(e) => setSourceCode(e.target.value)}
          ></textarea>
          <button className="btn btn-primary" onClick={handleSubmit}>
            제출
          </button>
        </>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default Problem;