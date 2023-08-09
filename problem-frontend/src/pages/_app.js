//import 'bootstrap/dist/css/bootstrap.css'
import '../../public/css/bootstrap.min.css';
import '../app/globals.css'

function MyApp({ Component, pageProps }) {
  return (
    <div>
      <Component {...pageProps} />
    </div>
    
  )
}

export default MyApp
