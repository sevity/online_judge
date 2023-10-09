// context/SessionContext.js
import React, { createContext, useState, useEffect } from 'react';
import axios from 'axios';

export const SessionContext = createContext();

export const SessionProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [username, setUsername] = useState('');

  const fetchSessionStatus = async () => {
    try {
      const response = await axios.get('https://sevity.com:9991/api/session/status', { withCredentials: true });
      if (response.data.username) {
        setIsAuthenticated(true);
        setUsername(response.data.username);
      } else {
        setIsAuthenticated(false);
        setUsername('');
      }
    } catch (error) {
      console.error('Session status error:', error);
    }
  };

  useEffect(() => {
    fetchSessionStatus();
  }, []);

  return (
    <SessionContext.Provider value={{ isAuthenticated, username, fetchSessionStatus }}>
      {children}
    </SessionContext.Provider>
  );
};
