import React from 'react';
import './App.css';
import Home from './Pages/Home';
import MyPage from './Pages/MyPage';
import SignIn from './Pages/SignIn';
import SignUp from './Pages/SignUp';
import NewQuestion from './Pages/NewQuestion';
import QuestionDetail from './Pages/QuestionDetail';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from './Components/Header';
import GlobalStyles from './GlobalStyles';

export default function App() {
  return (
    <>
      <GlobalStyles />
      <BrowserRouter>
        <Header />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route path="/mypage" element={<MyPage />} />
          <Route path="/signin" element={<SignIn />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/newquestion" element={<NewQuestion />} />
          <Route path="/questiondetail" element={<QuestionDetail />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}
