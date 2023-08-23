/* eslint-disable no-unused-expressions */
/* eslint-disable no-undef */
/* eslint-disable react/prop-types */
import React from 'react';
import {
  QuestionContainer,
  ContentCard,
  BottomContainer,
  ContainerTitle,
} from './QuestionListItem.Styled';
import { useNavigate } from 'react-router-dom';

const QuestionItem = ({ question }) => {
  const navigate = useNavigate();

  const questiondetail = () => {
    navigate('/questiondetail/:id');
  };
  const parsedDate = new Date(question.createdAt).toLocaleDateString('ko-kr', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit',
    timeZone: 'UTC',
  });

  return (
    <QuestionContainer>
      <ContainerTitle>{question.title}</ContainerTitle>
      <ContentCard onClick={questiondetail} key={question.questionId}>
        <div className="question-message">{question.content}</div>
      </ContentCard>
      <BottomContainer>
        <div className="icon-count">
          <div>
            <div>
              <img src="/images/message.png" alt="" />
            </div>
            {/* <span>{question.comments.length}</span> */}
          </div>

          <div>
            <div>
              <img src="/images/like.png" alt="" />
            </div>
            <span>{question.likes_count}</span>
          </div>
        </div>

        <div className="wrapper">
          <span className="question-author">{question.author} </span>

          <span className="question-createdAt">{parsedDate}</span>
        </div>
      </BottomContainer>
    </QuestionContainer>
  );
};
export default QuestionItem;
