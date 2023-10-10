import { useContext, useEffect, useState } from 'react';
import { SessionContext } from '../context/SessionContext';
import 'bootstrap/dist/css/bootstrap.css';

export default function Problems() {
  const { isAuthenticated, username } = useContext(SessionContext);
  const [problems, setProblems] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://sevity.com:9993/problems');
        const data = await response.json();
        setProblems(data);
      } catch (error) {
        console.error('데이터 불러오기 오류:', error);
      }
    };

    fetchData();
  }, []);

  useEffect(() => {
    console.log('isAuth:' + isAuthenticated + ', username: '+username);
    if(isAuthenticated===undefined) return;  // 최초 렌더링은 스킵
    if (!username) {
      // 로그인 필요 시 클라이언트에서 리디렉션
      window.location.href = 'https://sevity.com:9992/login';
    }
  }, [isAuthenticated]);

  if (!username) {
    // 서버 사이드 렌더링 시 리디렉션을 위한 컴포넌트 반환
    return (
      <div className="alert alert-success mt-3">로그인 필요! </div>
    );
  }

  return (
    <div className="container">
      <div> username: {username} </div>
      <h1>문제 리스트!</h1>
      <table className="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>제목</th>
            <th>설명</th>
          </tr>
        </thead>
        <tbody>
          {problems.map((problem) => (
            <tr key={problem.id}>
              <td>{problem.id}</td>
              <td>{problem.title}</td>
              <td>{problem.description}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
