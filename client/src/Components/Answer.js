/* eslint-disable react/prop-types */
import React, { useState } from 'react';
import { SmallButton } from './SmallButton';
import { api } from '../Api/api';
import { useSelector } from 'react-redux';

const Answer = (props) => {
  const [answer, setAnswer] = useState(props.answer ? props.answer : {});
  const [editedContent, setEditedContent] = useState('');
  const [editing, setEditing] = useState(false);
  const user = useSelector((state) => state.user);

  const handleEdit = (currentContent) => {
    setEditedContent(currentContent);
    setEditing(true);
  };

  const handleSaveEdit = async () => {
    if (editedContent.trim() !== '') {
      setAnswer({ ...answer, content: editedContent });
      setEditing(false);
      setEditedContent('');
      try {
        const response = await api(
          `/questions/${props.questionId}/answers/${answer.answerId}`,
          'patch',
          { editedContent },
        );
        if (response.data.success) {
          console.log(response);
          setAnswer({
            answerId: response.data.answerId,
            content: response.data.content,
            createdAt: response.data.createdAt,
            author: response.data.author,
            memberId: response.data.memberId,
          });
        }
      } catch (error) {
        // Handle error
      }
    }
  };

  const parsedDate = new Date(answer.createdAt).toLocaleDateString('ko-kr', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit',
    timeZone: 'UTC',
  });

  return (
    <>
      {/* 답변 목록을 맵핑하여 각 답변을 렌더링 */}
      <div className="answer-container" key={answer.id}>
        <div className="author-container">
          <div className="author">{answer.author}</div>
          <div className="author-right-container">
            {user.memberId === answer.memberId ? (
              <div className="my-text">
                <div
                  onClick={() => handleEdit(answer.content)}
                  aria-hidden="true"
                >
                  <img src="/images/mdi-pen.png" alt=""></img>
                </div>
                <div
                  onClick={() => props.handleDelete(answer.answerId)}
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
              {answer.content}
            </div>
          </div>
        )}
      </div>
    </>
  );
};

export default Answer;
