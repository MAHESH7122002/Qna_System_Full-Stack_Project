
import './App.css'
import Signup from './Components/Signup'
import { BrowserRouter,Routes,Route} from 'react-router-dom'
import Home from './Components/Home'
import Header from './Components/HeaderComponent'
import UploadAFile from './Components/UploadAFile'
import View from './Components/View'
import NextPrev from './Components/NextPrev';
import Topic_Related_Qnas from './Components/Topic_Related_Qnas'
import LoginComponent from './Components/LoginComponent'
import UserDetails from './Components/UserDetails'
function App() {

  return (
    <>
    <BrowserRouter>
    <Header />
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/signup" element={<Signup />}></Route>
        <Route path='/upload-file' element={<UploadAFile />}></Route>
        <Route path='/view/qna/:id' element={<View />}></Route>
        <Route path='/qna/:id' element={<NextPrev />}></Route> 
        <Route path='/view/qnas/:topic/:id' element={<Topic_Related_Qnas />}></Route>
        <Route path='/login' element={<LoginComponent />}></Route>
        <Route path='/userDetails' element={<UserDetails />}></Route>
      </Routes>
    </BrowserRouter> 
    
    </>
  )
}

export default App
