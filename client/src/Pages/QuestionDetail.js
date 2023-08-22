/* eslint-disable react/prop-types */
import React, { useState } from 'react';
import { PageStyle } from './styles/PageStyle';
// eslint-disable-next-line no-unused-vars
import BeforePage from '../Components/BeforePage';
import { QuestionDetailContainer } from './styles/QuestionDetailContainer';
import { Button } from '../Components/Button';
import Like from '../Components/Like';
import Answer from '../Components/Answer';
import { api } from '../Api/api';
import { useSelector } from 'react-redux';
import { SmallButton } from '../Components/SmallButton';
import { useNavigate } from 'react-router-dom';

export default function QuestionDetail(props) {
  // eslint-disable-next-line no-unused-vars
  const [question, setQuestion] = useState(
    // eslint-disable-next-line react/prop-types
    props.question ? props.question : [],
  );
  const [answers, setAnswers] = useState(
    props.question.answers ? props.question.answers : [],
  );
  const [editedContent, setEditedContent] = useState('');
  const [editing, setEditing] = useState(false);
  const user = useSelector((state) => state.user);
  const navigate = useNavigate();
  const handleEdit = (currentContent) => {
    setEditedContent(currentContent);
    setEditing(true);
  };

  const handleSaveEdit = async () => {
    if (editedContent.trim() !== '') {
      setQuestion({ ...question, content: editedContent });
      setEditing(false);
      setEditedContent('');
      try {
        const response = await api(`/questions/${props.questionId}`, 'patch', {
          editedContent,
        });
        if (response.success) {
          console.log(response);
        } else {
          // Handle error
        }
      } catch (error) {
        // Handle error
      }
    }
  };

  const handleDeleteAnswer = async (answerId) => {
    const updatedAnswers = answers.filter(
      (answer) => answer.answerId !== answerId,
    );
    setAnswers(updatedAnswers);
    try {
      const response = await api(
        `questions/${props.questionId}/answers/${answerId}`,
        'delete',
      );
      if (response.success) {
        console.log(response.message);
      } else {
        // Handle error
      }
    } catch (error) {
      // Handle error
    }
  };
  const handleDeleteQuestion = async (questionId) => {
    try {
      const response = await api(`questions/${props.questionId}`, 'delete');
      if (response.success) {
        console.log(response.message);
      } else {
        // Handle error
      }
    } catch (error) {
      // Handle error
      console.log('서버에 삭제 요청은 보냇음');
    }
    navigate(-1);
  };

  return (
    <PageStyle>
      <BeforePage></BeforePage>
      <QuestionDetailContainer>
        <div className="title">{question.title}</div>
        <div className="author-container">
          <div className="author">{question.author}</div>
          <div className="author-right-container">
            {user.memberId === question.memberId ? (
              <div className="my-text">
                <div
                  onClick={() => handleEdit(question.content)}
                  aria-hidden="true"
                >
                  <img src="/images/mdi-pen.png" alt=""></img>
                </div>
                <div
                  onClick={() => handleDeleteQuestion(question.questionId)}
                  aria-hidden="true"
                >
                  <img src="/images/mdi-trash.png" alt=""></img>
                </div>
              </div>
            ) : null}
            <div className="time">{question.createdAt}</div>
          </div>
        </div>
        {editing ? (
          <div>
            {/* 편집 중인 답변의 내용을 입력하는 텍스트 에어리어 */}
            <textarea
              className="editarea"
              value={editedContent}
              onChange={(e) => setEditedContent(e.target.value)}
            />
            {/* 수정된 답변을 저장하는 버튼 */}
            <SmallButton onClick={handleSaveEdit}>Save</SmallButton>
          </div>
        ) : (
          <div>
            <div className="content">
              {/* 답변 내용을 표시 */}
              {question.content}
            </div>
          </div>
        )}

        <div className="bottom-menu">
          <div className="icon-count">
            <div>
              <div>
                <img src="/images/message.png" alt=""></img>
              </div>
              <div>{question.comments.length}</div>
            </div>
            <Like
              likes_count={question.likes_count}
              questionId={question.questionId}
              user_has_liked={question.user_has_liked}
            ></Like>
          </div>
        </div>

        <div className="title">{question.answers.length} Answer</div>
        {answers.map((answer) => {
          return (
            <Answer
              key={answer.answerId}
              answer={answer}
              questionId={question.questionId}
              handleDelete={handleDeleteAnswer}
            ></Answer>
          );
        })}
        <div className="new-answer-container">
          <div className="title">Your Answer</div>
          <textarea className="answer-input" type="text"></textarea>
          <div className="submit-container">
            <Button primary>Submit</Button>
          </div>
        </div>
      </QuestionDetailContainer>
    </PageStyle>
  );
}
