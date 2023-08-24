/* eslint-disable react/no-unescaped-entities */
/* eslint-disable jsx-a11y/click-events-have-key-events */
import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux';

// components
// eslint-disable-next-line import/named
import {
  HeaderContainer,
  LogoContainer,
  ButtonContainer,
} from './Header.Styled';
import { SmallButton } from './SmallButton';

const Header = () => {
  const navigate = useNavigate();
  const user = useSelector((state) => state.user);

  const home = () => {
    navigate('/');
  };
  const newquestion = () => {
    user.loggedIn ? navigate('/newquestion') : navigate('/signin');
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
        <SmallButton onClick={newquestion}>질문 작성</SmallButton>
        {user.loggedIn ? (
          <SmallButton onClick={mypage}>내 질문</SmallButton>
        ) : (
          <SmallButton onClick={signin}>Sign In</SmallButton>
        )}
      </ButtonContainer>
    </HeaderContainer>
  );
};

export default Header;
