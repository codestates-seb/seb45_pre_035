import React from 'react';
import Pagination from 'react-js-pagination';
// eslint-disable-next-line import/no-named-as-default
import styled from 'styled-components';

const PaginationContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 64px;
  color: #3f2305;
  width: 429px;
  height: 29px;
  cursor: pointer;

  font-family: Inter;
  font-size: 24px;
  font-style: normal;
  font-weight: 400;
  line-height: normal;

  .pagination li {
    display: flex;
    align-items: flex-end;
    gap: 36px;
  }

  .pagination .active {
    font-weight: bold;
  }
`;

// eslint-disable-next-line react/prop-types
const PagiNation = ({ count, page, onPageChange }) => {
  return (
    <PaginationContainer>
      <Pagination
        containerClassName={'pagination'}
        activeClassName={'active'}
        prevPageText={'‹'} // "이전"을 나타낼 텍스트
        nextPageText={'›'} // "다음"을 나타낼 텍스트
        totalItemsCount={count}
        activePage={page}
        onChange={onPageChange} // 페이지 변경을 핸들링하는 함수
      />
    </PaginationContainer>
  );
};

export default PagiNation;
