import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { styled } from 'styled-components';

const PageStyle = styled.div`
  /* 페이지 전체 스타일링 */
`;

const QuestionFormContainer = styled.div`
  /* 폼 컨테이너 스타일링 */
`;

const TitleBox = styled.div`
  display: flex;
  width: 649px;
  padding: 30px;
  flex-direction: column;
  align-items: flex-start;
  gap: 15px;
  border: 2px solid #3f2305;
  background: #f2ead3;
`;

const ContentBox = styled.div`
  display: flex;
  width: 649px;
  height: 488px;
  padding: 30px;
  flex-direction: column;
  align-items: flex-start;
  gap: 15px;
  flex-shrink: 0;
  border: 2px solid #3f2305;
  background: #f2ead3;
`;

const NewQuestion = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [submitEnabled, setSubmitEnabled] = useState(false);
  const history = useNavigate();

  const handleTitleChange = (e) => {
    setTitle(e.target.value);
    updateSubmitButton(e.target.value, content);
  };

  const handleContentChange = (e) => {
    setContent(e.target.value);
    updateSubmitButton(title, e.target.value);
  };

  const updateSubmitButton = (newTitle, newContent) => {
    setSubmitEnabled(newTitle.trim() !== '' && newContent.trim() !== '');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!submitEnabled) return;

    try {
      const response = await fetch('/api/questions', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title, content }),
      });

      if (response.ok) {
        const question = await response.json();
        history.push(`/question/${question.questionId}`);
      } else {
        // Handle error
      }
    } catch (error) {
      // Handle error
    }
  };

  return (
    <PageStyle>
      <QuestionFormContainer>
        <TitleBox>
          <h2>Title</h2>
          <p>
            Be specific and imagine you’re asking a question to another person.
          </p>
          <input
            type="text"
            value={title}
            onChange={handleTitleChange}
            required
          />
        </TitleBox>
        <ContentBox>
          <h2>Content</h2>
          <p>What are the details of your problem?</p>
          <textarea value={content} onChange={handleContentChange} required />
        </ContentBox>
        <button onClick={handleSubmit} disabled={!submitEnabled}>
          Submit
        </button>
      </QuestionFormContainer>
    </PageStyle>
  );
};

export default NewQuestion;
