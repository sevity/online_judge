//import 'bootstrap/dist/css/bootstrap.css'
import '../../public/css/bootstrap.min.css';
import '../app/globals.css'

function MyApp({ Component, pageProps }) {
  return (
    <div style={{ backgroundColor: 'lightgray' }}>
      <Component {...pageProps} />
    </div>
  )
}

export default MyApp
