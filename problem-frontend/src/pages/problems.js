import { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';

export default function Problems() {
  const [problems, setProblems] = useState([]);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userInfo, setUserInfo] = useState(null);
  const [username, setUsername] = useState('');

  useEffect(() => {
    const storedUsername = localStorage.getItem('username');
    //const storedIsLoggedIn = localStorage.getItem('isLoggedIn');

    if (storedUsername === 'true') {
      setUsername(storedUsername);
      //setUserInfo(JSON.parse(storedUserInfo));
    }

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
