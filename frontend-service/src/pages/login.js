import { useState, useEffect } from 'react';
import axios from 'axios';

export default function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userInfo, setUserInfo] = useState(null);

  // 페이지 로드 시 Local Storage에서 로그인 정보 불러오기
  useEffect(() => {
    const storedUserInfo = localStorage.getItem('userInfo');
    const storedIsLoggedIn = localStorage.getItem('isLoggedIn');

    if (storedUserInfo && storedIsLoggedIn === 'true') {
      setIsLoggedIn(true);
      setUserInfo(JSON.parse(storedUserInfo));
    }
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post('http://sevity.com:9991/login', `username=${username}&password=${password}`, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
      });

      console.log('Login successful:', response.data);
      setIsLoggedIn(true);
      setUserInfo(response.data);

      // Local Storage에 사용자 정보 저장
      localStorage.setItem('userInfo', JSON.stringify(response.data));
      localStorage.setItem('isLoggedIn', 'true');
    } catch (error) {
      console.error('Login error:', error);
    }
  };

  // 로그아웃 처리
  const handleLogout = () => {
    // 서버에 로그아웃 요청을 보내는 로직을 여기에 추가할 수 있습니다.

    // Local Storage에서 정보 제거
    localStorage.removeItem('userInfo');
    localStorage.removeItem('isLoggedIn');

    setIsLoggedIn(false);
    setUserInfo(null);
  };

  if (isLoggedIn) {
    return (
      <div>
        Welcome, {userInfo}!
        <button onClick={handleLogout}>Logout</button>
      </div>
    );
  }

  return (
    <form onSubmit={handleSubmit} className="container mt-4">
      <div className="mb-3">
        <label htmlFor="username" className="form-label">
          Username:
        </label>
        <input
          type="text"
          className="form-control"
          id="username"
          value={username}
          onChange={(event) => setUsername(event.target.value)}
        />
      </div>
      <div className="mb-3">
        <label htmlFor="password" className="form-label">
          Password:
        </label>
        <input
          type="password"
          className="form-control"
          id="password"
          value={password}
          onChange={(event) => setPassword(event.target.value)}
        />
      </div>
      <button type="submit" className="btn btn-primary">
        Login
      </button>
    </form>
  );
}
