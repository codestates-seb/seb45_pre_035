import { styled } from 'styled-components';

export const HomeBox = styled.div`
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 27px;
  width: 883px;
  height: 681px;
`;
export const QuestionListContainer = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  justify-content: center;
  gap: 51px;
`;
