import React from 'react';
import Pagination from 'react-js-pagination';
import { styled } from 'styled-components';

const PaginationContainer = styled.div`
  display: flex;
  flex-direction: row;
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

  .pagination {
    display: flex;
  }
`;
const PagiNumButton = styled.button`
  border: none;
  background: transparent;
  font-size: 24px;
  font-weight: 400;
  cursor: pointer;

  &:hover {
    font-weight: bold;
  }
`;

// eslint-disable-next-line react/prop-types
const PagiNation = ({ count, page, onPageChange }) => {
  const numPages = Math.ceil(count / 6);

  const pageButtons = () => {
    const buttons = [];
    for (let i = 1; i <= numPages && i <= 6; i++) {
      buttons.push(
        <PagiNumButton
          key={i}
          onClick={() => onPageChange(i)}
          className={page === i ? 'active' : ''}
        >
          {i}
        </PagiNumButton>,
      );
    }
    return buttons;
  };

  return (
    <PaginationContainer>
      {pageButtons()}
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
