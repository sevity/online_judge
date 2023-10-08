import { useEffect, useState } from 'react';
import axios from 'axios';

export default function Logout() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    const logout = async () => {
      try {
        const response = await axios.post('https://sevity.com:9991/logout');

        console.log('Logout successful:', response.data);
        setMessage('Logout successful!');
      } catch (error) {
        console.error('Logout error:', error);
        setMessage('Logout error: ' + (error.response && error.response.data));
      }
    };

    logout();
  }, []);

  return <p>{message}</p>;
}
