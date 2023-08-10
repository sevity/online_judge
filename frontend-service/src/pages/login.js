import { useState } from 'react';
import axios from 'axios';

export default function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userInfo, setUserInfo] = useState(null);

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
    } catch (error) {
      console.error('Login error:', error);
    }
  };

  if (isLoggedIn) {
    return <div>Welcome, {userInfo}!</div>;
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
