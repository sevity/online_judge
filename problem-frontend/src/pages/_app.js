//import 'bootstrap/dist/css/bootstrap.css'
import '../../public/css/bootstrap.min.css';
import '../app/globals.css'
import { SessionProvider } from '../context/SessionContext';  // Adjust the path if necessary

function MyApp({ Component, pageProps }) {
  return (
    <div>
      <SessionProvider>
        <Component {...pageProps} />
      </SessionProvider>
    </div>
    
  )
}

export default MyApp;



