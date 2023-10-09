// src/pages/_app.js
import 'bootstrap/dist/css/bootstrap.css';
import '../app/globals.css';
import { SessionProvider } from '../context/SessionContext';  // Adjust the path if necessary

function MyApp({ Component, pageProps }) {
  return (
    <SessionProvider>
      <Component {...pageProps} />
    </SessionProvider>
  );
}

export default MyApp;
