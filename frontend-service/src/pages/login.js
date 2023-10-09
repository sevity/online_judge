// components/Login.js
import React, { useContext, useState } from 'react';
import axios from 'axios';
import { SessionContext } from '../context/SessionContext';

export default function Login() {
  const { isAuthenticated, username, setUsername, fetchSessionStatus } = useContext(SessionContext);
  const [password, setPassword] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post('https://sevity.com:9991/login', `username=${username}&password=${password}`, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        withCredentials: true,
      });

      console.log('Login successful:', response.data);
      // 로그인 성공 후 세션 상태 다시 가져오기
      fetchSessionStatus();
    } catch (error) {
      console.error('Login error:', error);
    }
  };

  const handleLogout = async () => {
    try {
      const response = await fetch('https://sevity.com:9991/logout', {
        method: 'POST',
        credentials: 'include',
      });
      console.log(response);

      if (!response.ok) {
        throw new Error(`Logout failed: ${response.statusText}`);
      }
      fetchSessionStatus();
    } catch (error) {
      console.error('Logout failed:', error);
    }
  };

  if (isAuthenticated) {
    return (
      <div>
        <div>어서오세요 {username}님!
        <button onClick={handleLogout}>Logout</button></div>
        <a href="http://sevity.com:9994/problems">
          <button>문제리스트로 가기</button>
        </a>
      </div>
    );
  } else {
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
}
