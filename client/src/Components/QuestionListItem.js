/* eslint-disable react/prop-types */
import React from 'react';
import {
  Question,
  ContentCard,
  BottomContainer,
} from './QuestionListItem.Styled';
import { useNavigate } from 'react-router-dom';
// import { AnswerIcon, LikeIcon } from './IconBtn';

const QuestionItem = ({ question }) => {
  const navigate = useNavigate();

  const questiondetail = () => {
    navigate('/questiondetail/:id');
  };
  const parsedDate = new Date(question.createdAt).toLocaleDateString('ko-kr');

  // const question = {
  //   questionId,
  //   title,
  //   content,
  //   createAt,
  //   author,
  //   answers: [].length,
  //   likes: [].length,
  // };

  return (
    <Question onClick={questiondetail}>
      <ContentCard className="question" id={question.questionId}>
        <h2 className="title">{question.title}</h2>
        <div className="question-message">{question.content}</div>
        <BottomContainer>
          {/* <IconBtn>
            <button src={AnswerIcon} onClick={question.answers} />

            <button src={LikeIcon} onClick={question.likes} />
          </IconBtn> */}
          <div className="wrapper">
            <span className="question-author">{question.author}</span>

            <span className="question-createdAt">{parsedDate}</span>
          </div>
        </BottomContainer>
      </ContentCard>
    </Question>
  );
};
export default QuestionItem;
