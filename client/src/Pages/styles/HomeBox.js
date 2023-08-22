import { styled } from 'styled-components';

export const HomeBox = styled.div`
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 27px;
  width: 883px;
  height: 681px;
  .pagination {
    list-style: none;
    padding-bottom: 50px;
    gap: 20px;
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
  }
  .page_num {
    border: none;
    background: transparent;
    font-size: 24px;
    width: 30px;
    font-weight: 400;
    padding: 10px;
    cursor: pointer;

    &:hover {
      font-weight: bold;
    }
  }
  .active {
    font-weight: bold;
  }
`;
export const QuestionListContainer = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  justify-content: center;
  gap: 51px;
`;
