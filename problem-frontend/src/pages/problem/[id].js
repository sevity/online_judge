import { useContext, useEffect, useState } from 'react';
import { SessionContext } from '../../context/SessionContext';
import { useRouter } from 'next/router';
import 'bootstrap/dist/css/bootstrap.css';

const Problem = () => {
  const router = useRouter();
  const { id } = router.query; // URL에서 id 값을 가져옵니다.
  const [problem, setProblem] = useState(null);
  const { isAuthenticated, username } = useContext(SessionContext);

  useEffect(() => {
    console.log('isAuth:' + isAuthenticated + ', username: '+username);
    if(isAuthenticated===undefined) return;  // 최초 렌더링은 스킵
    if (!username) {
      // 로그인 필요 시 클라이언트에서 리디렉션
      window.location.href = 'https://sevity.com:9992/login';
    }
  }, [isAuthenticated]);

  useEffect(() => {
    // id가 설정되면 API 호출을 수행합니다.
    if (id) {
      const fetchData = async () => {
        try {
          const response = await fetch(`http://sevity.com:9993/problems/${id}`);
          const data = await response.json();
          console.log('data:', JSON.stringify(data, null, 2));
          setProblem(data);
        } catch (error) {
          console.error('문제 불러오기 실패:', error);
        }
      };

      fetchData();
    }
  }, [id]);

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
        </>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default Problem;
