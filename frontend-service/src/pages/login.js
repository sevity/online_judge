import { useState, useEffect } from 'react';
import axios from 'axios';

export default function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  //const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userInfo, setUserInfo] = useState(null);
  const [sessionStatus, setSessionStatus] = useState("");

  // API를 호출하여 세션 상태를 가져오는 함수
  const fetchSessionStatus = async () => {
    try {
      const response = await axios.get('https://sevity.com:9991/api/session/status', { withCredentials: true });
      /*
      const response = await fetch('https://sevity.com:9991/api/session/status', {
        method: 'GET',
        //mode: "no-cors", // no-cors, *cors, same-origin
        //cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        redirect: "follow", // manual, *follow, error
        referrerPolicy: "unsafe-url", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url        
        credentials: "same-origin", // include, *same-origin, omit
         });  // 이상하게 fetch로는 정상동작하지 않는다;
         */
      
      setSessionStatus(response.data);
      //setSessionStatus("");
      console.log('session:', response);
    } catch (error) {
      console.error('Session status error:', error);
    }
  };

  // 페이지 로드 시 Local Storage에서 로그인 정보 불러오기
  useEffect(() => {
    // API를 호출하여 세션 상태를 가져옵니다.
    fetchSessionStatus();

    /*
    const storedUserInfo = localStorage.getItem('userInfo');
    const storedIsLoggedIn = localStorage.getItem('isLoggedIn');
    if (storedUserInfo && storedIsLoggedIn === 'true') {
      setIsLoggedIn(true);
      setUserInfo(JSON.parse(storedUserInfo));
    }
    */
  }, []);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post('https://sevity.com:9991/login', `username=${username}&password=${password}`, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        withCredentials: true,  // 이 줄 없으면 브라우저에 쿠키저장 안된다!!

      });

      console.log('Login successful:', response.data);
      // 로그인 성공 후 세션 상태 다시 가져오기
      fetchSessionStatus();      
      
      /*
      setIsLoggedIn(true);
      setUserInfo(response.data);
      // Local Storage에 사용자 정보 저장
      localStorage.setItem('userInfo', JSON.stringify(response.data));
      localStorage.setItem('isLoggedIn', 'true');
      */
    } catch (error) {
      console.error('Login error:', error);
    }
  };

// 로그아웃 처리
const handleLogout = async () => {
  try {
    // 서버에 로그아웃 요청을 보냅니다.
    const response = await fetch('https://sevity.com:9991/logout', {
      //mode: 'no-cors',
      method: 'POST',
      credentials: 'include',  // 쿠키 정보를 포함하여 요청을 보냅니다.
    });
    console.log(response);

    if (!response.ok) {
      throw new Error(`Logout failed: ${response.statusText}`);
    }

    fetchSessionStatus();

    // Local Storage에서 정보 제거
    /*
    localStorage.removeItem('userInfo');
    localStorage.removeItem('isLoggedIn');
    setIsLoggedIn(false);
    setUserInfo(null);
    */
  } catch (error) {
    console.error('Logout failed:', error);
  }
};
  console.log('session2:', sessionStatus);
  const isNullOrWhitespace = (sessionStatus === null || sessionStatus === '' || sessionStatus === undefined) ? true : false;

  if (!isNullOrWhitespace) {
    return (
      <div>
        Welcome!!!, {userInfo}!
        <button onClick={handleLogout}>Logout</button>
        {/* 세션 상태 출력 */}
        <div>Session Status: {JSON.stringify(sessionStatus, null, 2)}</div>
      </div>
    );
  }  else {
    return (
      <form onSubmit={handleSubmit} className="container mt-4">
        <div>Session Status: {JSON.stringify(sessionStatus, null, 2)}</div>
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


}
