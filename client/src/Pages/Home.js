import React from 'react';
import { useNavigate } from 'react-router-dom';
import Logo from '../../public/images/s-stack-overflow.png';
import { styled } from 'styled-components';

const LogoContainer = styled.div`
  display: block;
  color: #3f2305;

  .title {
    color: #000;
    font-family: Inter;
    font-size: 32px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
`;

export default function Home() {
  const navigate = useNavigate();

  return (
    <LogoContainer>
      <div className="title">문제나우's Stack Overflow</div>
      <Logo src={Logo} onClick={navigate('/')} />
    </LogoContainer>
  );
}
