/* eslint-disable react/no-unescaped-entities */
/* eslint-disable jsx-a11y/click-events-have-key-events */
import React from 'react';
import { useNavigate } from 'react-router-dom';

// components
// eslint-disable-next-line import/named
import {
  HeaderContainer,
  Button,
  LogoContainer,
  ButtonContainer,
} from './Header.Styled';

const Header = () => {
  const navigate = useNavigate();

  const home = () => {
    navigate('/');
  };
  const newquestion = () => {
    navigate('/newquestion');
  };
  const mypage = () => {
    navigate('/mypage');
  };
  const signin = () => {
    navigate('/signin');
  };

  return (
    <HeaderContainer>
      <LogoContainer onClick={home}>
        <div className="title">문제나우's Stack Overflow</div>
      </LogoContainer>
      <ButtonContainer>
        <Button onClick={newquestion}>질문 작성</Button>
        <Button onClick={mypage}>내 질문</Button>
        <Button onClick={signin}>SignIn</Button>
      </ButtonContainer>
    </HeaderContainer>
  );
};

export default Header;
