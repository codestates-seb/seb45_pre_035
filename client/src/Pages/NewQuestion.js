import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { styled } from 'styled-components';
import { Button } from '../Components/Button';
import { PageStyle } from './styles/PageStyle';

const QuestionFormContainer = styled.div`
  display: inline-flex;
  height: 909px;
  flex-direction: column;
  align-items: flex-end;
  gap: 26px;
  flex-shrink: 0;
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
const TitleBoxTitle = styled.text`
  color: #000;
  font-family: Inter;
  font-size: 32px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
`;
const TitleBoxEx = styled.text`
  color: #000;
  font-family: Inter;
  font-size: 14px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
`;

const TitleBoxInput = styled.input`
  padding-left: 10px;
  width: 592px;
  height: 41px;
  flex-shrink: 0;
  border-radius: 13px;
  border: 1px solid #d9d9d9;
  background: #f5f5f5;
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

const ContentBoxTitle = styled.text`
  color: #000;
  font-family: Inter;
  font-size: 32px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
`;
const ContentBoxEx = styled.text`
  color: #000;
  font-family: Inter;
  font-size: 14px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
`;

const ContentBoxTextArea = styled.textarea`
  padding: 10px;
  width: 592px;
  flex: 1 0 0;
  border-radius: 13px;
  border: 1px solid #d9d9d9;
  background: #f5f5f5;
`;

const NewQuestion = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [submitEnabled, setSubmitEnabled] = useState(false);
  const navigate = useNavigate();

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
        navigate.push(`/question/${question.questionId}`);
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
          <TitleBoxTitle>Title</TitleBoxTitle>
          <TitleBoxEx>
            Be specific and imagine you’re asking a question to another person.
          </TitleBoxEx>
          <TitleBoxInput
            placeholder="e.g Is there an R function for finding the index of an element in a vector?"
            type="text"
            value={title}
            onChange={handleTitleChange}
            required
          />
        </TitleBox>
        <ContentBox>
          <ContentBoxTitle>Content</ContentBoxTitle>
          <ContentBoxEx>What are the details of your problem?</ContentBoxEx>
          <ContentBoxTextArea
            value={content}
            onChange={handleContentChange}
            required
          />
        </ContentBox>
        <button onClick={handleSubmit} disabled={!submitEnabled}>
          Submit
        </button>
        <Button primary onClick={handleSubmit}>
          Submit
        </Button>
      </QuestionFormContainer>
    </PageStyle>
  );
};

export default NewQuestion;
