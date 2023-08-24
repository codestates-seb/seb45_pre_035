import React, { useState, useEffect } from 'react';
import { PageStyle } from './styles/PageStyle';
import { api } from '../Api/api';
import QuestionListItem from '../Components/QuestionListItem';
import BeforePage from '../Components/BeforePage';
import ReactPagiNation from 'react-paginate';
import { HomeBox, QuestionListContainer } from './styles/HomeBox';
import { useSelector } from 'react-redux';

export default function MyPage(props) {
  const [questions, setQuestions] = useState(
    // eslint-disable-next-line react/prop-types
    props.questions ? props.questions : [],
  );
  const [currentPage, setCurrentPage] = useState(1); // 현재페이지
  const questionsPerPage = 6;
  const [currentQuestions, setCurrentQuestions] = useState([]); // 질문데이터 배열
  const pageCount = Math.ceil(questions.length / questionsPerPage);

  const user = useSelector((state) => state.user);

  const handlePageChange = (event) => {
    setCurrentPage(event.selected + 1);
  };

  const fetchQuestions = async () => {
    try {
      // eslint-disable-next-line react/prop-types
      const response = await api(`/questions/${user.memberId}`);

      setQuestions(response.data);
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
    console.log(newStartIndex, newEndIndex);

    setCurrentQuestions(questions.slice(newStartIndex, newEndIndex));
  }, [currentPage, questions]);

  return (
    <PageStyle>
      <BeforePage />
      <HomeBox>
        <QuestionListContainer>
          {currentQuestions.map((question) => (
            <QuestionListItem key={question.questionId} question={question} />
          ))}
        </QuestionListContainer>
        <ReactPagiNation
          containerClassName={'pagination'}
          activeLinkClassName={'active'}
          pageLinkClassName={'page_num'}
          previousLinkClassName={'page_num'}
          nextLinkClassName={'page_num'}
          onPageChange={handlePageChange}
          pageRangeDisplayed={5}
          pageCount={pageCount}
          breakLabel="..."
          renderOnZeroPageCount={null}
          nextLabel=">"
          previousLabel="<"
        />
      </HomeBox>
    </PageStyle>
  );
}
