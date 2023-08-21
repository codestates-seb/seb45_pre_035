/* eslint-disable react/prop-types */
import { PageStyle } from './styles/PageStyle';
import { api } from '../Api/api';
// eslint-disable-next-line import/named
import QuestionListItem from '../Components/QuestionListItem';
import PagiNation from '../Components/PagiNation';
import React, { useEffect, useState } from 'react';
import { HomeBox, QuestionListContainer } from './styles/HomeBox';

export default function Home(props) {
  const [questions, setQuestions] = useState(
    props.questions ? props.questions : [],
  );
  const [count, setCount] = useState(0);
  const [currentPage, setCurrentPage] = useState(1); // 현재페이지
  const [questionsPerPage] = useState(6);
  const [currentQuestions, setCurrentQuestions] = useState([]); // 질문데이터 배열
  // const [startIndex, setStartIndex] = useState(0);
  // const [endIndex, setEndIndex] = useState(questionsPerPage);

  const handlePageChange = ({ selected }) => {
    setCurrentPage(selected + 1);
  };

  const fetchQuestions = async () => {
    try {
      const response = await api.get('/questions');

      setQuestions(response.data);
      setCount(response.data.length);
    } catch (error) {
      console.error('Error fetching questions:', error);
    }
  };

  useEffect(() => {
    fetchQuestions();
  }, []);

  useEffect(() => {
    const newStartIndex = (currentPage - 1) * questionsPerPage;
    const newEndIndex = newStartIndex + questionsPerPage;

    setCurrentQuestions(questions.slice(newStartIndex, newEndIndex));
  }, [currentPage, questions, questionsPerPage]);

  return (
    <PageStyle>
      <HomeBox>
        <QuestionListContainer>
          {currentQuestions.map((question) => (
            <QuestionListItem key={question.questionId} question={question} />
          ))}
        </QuestionListContainer>
        <PagiNation
          page={currentPage}
          count={count}
          onPageChange={handlePageChange}
        />
      </HomeBox>
    </PageStyle>
  );
}
