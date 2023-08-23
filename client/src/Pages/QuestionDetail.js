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
import { useNavigate, useLocation } from 'react-router-dom';

export default function QuestionDetail() {
  // eslint-disable-next-line no-unused-vars
  const location = useLocation();
  const questionData = location.state.question;
  const [question, setQuestion] = useState(
    // eslint-disable-next-line react/prop-types
    questionData ? questionData : [],
  );
  const [answers, setAnswers] = useState(
    question.answers ? question.answers : [],
  );
  const [editedContent, setEditedContent] = useState('');
  const [editedTitle, setEditedTitle] = useState('');
  const [editing, setEditing] = useState(false);
  const user = useSelector((state) => state.user);
  const navigate = useNavigate();
  const [newAnswerContent, setNewAnswerContent] = useState('');

  const parsedDate = new Date(question.createdAt).toLocaleDateString('ko-kr', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit',
    timeZone: 'UTC',
  });

  const handleEdit = () => {
    setEditedContent(question.content);
    setEditedTitle(question.title);
    setEditing(true);
  };

  const handleSaveEdit = async () => {
    if (editedContent.trim() !== '' && editedTitle.trim() !== '') {
      setQuestion({ ...question, content: editedContent, title: editedTitle });
      setEditing(false);
      setEditedContent('');
      try {
        const response = await api(
          `/questions/${question.questionId}`,
          'patch',
          {
            editedContent,
            editedTitle,
          },
        );
        if (response.data.success) {
          console.log(response);
          setQuestion({
            ...response.data,
          });
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
        `questions/${question.questionId}/answers/${answerId}`,
        'delete',
      );
      if (response.data.success) {
        console.log(response.data.message);
      } else {
        // Handle error
      }
    } catch (error) {
      // Handle error
    }
  };
  const handleDeleteQuestion = async (questionId) => {
    try {
      const response = await api(`questions/${questionId}`, 'delete');
      if (response.data.success) {
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

  const handleSubmit = async () => {
    try {
      const response = await api(
        `/questions/${question.questionId}/answers`,
        'post',
        newAnswerContent,
      );
      if (response.data.success) {
        console.log(response.data.message);
        setAnswers([
          ...answers,
          {
            answerId: response.data.answerId,
            content: response.data.content,
            createdAt: response.data.createdAt,
            author: response.data.author,
            memberId: response.data.memberId,
          },
        ]);
      } else {
        // Handle error
      }
    } catch (error) {
      // Handle error
      console.log('서버에 답변등록 요청은 보냇음');
    }
  };
  return (
    <PageStyle>
      <BeforePage></BeforePage>
      <QuestionDetailContainer>
        {editing ? (
          <div className="title-edit">
            {/* 편집 중인 답변의 내용을 입력하는 텍스트 에어리어 */}
            <input
              value={editedTitle}
              onChange={(e) => setEditedTitle(e.target.value)}
            />
            {/* 수정된 답변을 저장하는 버튼 */}
          </div>
        ) : (
          <div className="title">{question.title}</div>
        )}
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
            <div className="time">{parsedDate}</div>
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
              {/* <div>{question.comments.length}</div> */}
            </div>
            <Like
              likes_count={question.likes_count}
              questionId={question.questionId}
              user_has_liked={question.user_has_liked}
            ></Like>
          </div>
        </div>

        <div className="title">{answers.length} Answer</div>
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
          <textarea
            className="answer-input"
            type="text"
            onChange={(e) => setNewAnswerContent(e.target.value)}
            value={newAnswerContent}
          ></textarea>
          <div className="submit-container">
            <Button primary onClick={() => handleSubmit()}>
              Submit
            </Button>
          </div>
        </div>
      </QuestionDetailContainer>
    </PageStyle>
  );
}
