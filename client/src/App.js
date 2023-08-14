import logo from './logo.svg';
import './App.css';
import React from 'react';
import Home from './Pages/Home'
import MyPage from './Pages/MyPage'
import SignIn from './Pages/SignIn'
import SignUp from './Pages/SignUp'
import NewQuestion from './Pages/NewQuestion'
import QuestionDetail from './Pages/QuestionDetail'
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
          <Route exact path ="/" element={<Home />} />
          <Route path="/mypage" element={<MyPage />} />
         <Route path="/signin" element={<SignIn />} />
         <Route path="/signup" element={<SignUp />} />
         <Route path="/newquestion" element={<NewQuestion />} />
         <Route path="/questiondetail/:id" element={<QuestionDetail />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App;
