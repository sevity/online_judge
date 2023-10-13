//import 'bootstrap/dist/css/bootstrap.css'
import '../../public/css/bootstrap.min.css';
import '../app/globals.css';
import { SessionProvider } from '../context/SessionContext';  // Adjust the path if necessary
import { ApolloProvider } from '@apollo/client';
import client from '../apolloClient';  // Adjust the path if necessary

function MyApp({ Component, pageProps }) {
  return (
    <ApolloProvider client={client}>
      <div>
        <SessionProvider>
          <Component {...pageProps} />
        </SessionProvider>
      </div>
    </ApolloProvider>
  )
}

export default MyApp;
