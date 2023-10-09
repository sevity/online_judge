import { useContext, useEffect, useState } from 'react';
import { SessionContext } from '../context/SessionContext';
import 'bootstrap/dist/css/bootstrap.css';

export default function Problems() {
  const { username } = useContext(SessionContext);
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

  if (!username) {
    return (
      <div>
        로그인 필요!
      </div>
    );
  }

  return (
    <div className="container">
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
