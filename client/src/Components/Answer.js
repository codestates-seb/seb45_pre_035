/* eslint-disable react/prop-types */
import React, { useState } from 'react';
import { Button } from '../Components/Button';
import { QuestionDetailContainer } from '../Pages/styles/QuestionDetailContainer';

const Answer = (props) => {
  const [answers, setAnswers] = useState(props.answers ? props.answers : []);
  const [editingId, setEditingId] = useState(null);
  const [editedContent, setEditedContent] = useState('');

  const handleEdit = (answerId, currentContent) => {
    setEditingId(answerId);
    setEditedContent(currentContent);
  };

  const handleSaveEdit = () => {
    if (editedContent.trim() !== '') {
      const updatedAnswers = answers.map((answer) =>
        answer.id === editingId
          ? { ...answer, content: editedContent }
          : answer,
      );
      setAnswers(updatedAnswers);
      setEditingId(null);
      setEditedContent('');
    }
  };

  const handleDelete = (answerId) => {
    const updatedAnswers = answers.filter((answer) => answer.id !== answerId);
    setAnswers(updatedAnswers);
  };

  return (
    <QuestionDetailContainer>
      <div className="title">{answers.length} Answer</div>
      {/* 답변 목록을 맵핑하여 각 답변을 렌더링 */}
      {answers.map((answer) => (
        <div className="answer-container" key={answer.id}>
          <div className="author-container">
            <div className="author">{answer.author}</div>
            <div className="author-right-container">
              <div className="my-text">
                <div
                  onClick={() => handleEdit(answer.id, answer.content)}
                  aria-hidden="true"
                >
                  <img src="/images/mdi-pen.png" alt=""></img>
                </div>
                <div onClick={() => handleDelete(answer.id)} aria-hidden="true">
                  <img src="/images/mdi-trash.png" alt=""></img>
                </div>
              </div>
              <div className="time">{answer.createdAt}</div>
            </div>
          </div>
          {editingId === answer.id ? (
            <div>
              {/* 편집 중인 답변의 내용을 입력하는 텍스트 에어리어 */}
              <textarea
                value={editedContent}
                onChange={(e) => setEditedContent(e.target.value)}
              />
              {/* 수정된 답변을 저장하는 버튼 */}
              <Button primary onClick={handleSaveEdit}>
                Save
              </Button>
            </div>
          ) : (
            <div>
              <div className="content">
                {/* 답변 내용을 표시 */}
                {answer.content}
              </div>
            </div>
          )}
        </div>
      ))}
      <div className="new-answer-container">
        <div className="title">Your Answer</div>
        <textarea className="answer-input" type="text"></textarea>
        <div className="submit-container">
          <Button primary>Submit</Button>
        </div>
      </div>
    </QuestionDetailContainer>
  );
};

export default Answer;
