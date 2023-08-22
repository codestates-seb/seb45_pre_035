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
    gap: 0px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
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
    display: block;
    border: none;
    background: transparent;
    font-size: 24px;
    width: 100px;
    font-weight: 400;
    padding: 10px;
    cursor: pointer;
    text-align: center;

    &:hover {
      font-weight: bold;
    }
  }
  .pagination > li {
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
