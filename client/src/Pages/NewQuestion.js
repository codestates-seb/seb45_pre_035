import React from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../../public/images/NewQuestion.png';
import styled from 'styled-components';

const MyQuestionContainer = styled.button`
  border-radius: 19px;
  background: #3f2305;
  color: #fff;
  font-family: Inter;
  font-size: 15px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
`;

const NewQuestion = () => {
  const navigate = useNavigate();

  return (
    <MyQuestionContainer>
      <Button
        src="{../../public/images/NewQuestion.png}"
        onClick={navigate('/NewQuestion')}
      ></Button>
    </MyQuestionContainer>
  );
};
