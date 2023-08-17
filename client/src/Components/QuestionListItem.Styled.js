import { styled } from 'styled-components';

export const Question = styled.div`
  display: flex;
  width: 416px;
  height: 209px;
  padding: 30px;
  flex-direction: column;
  align-items: flex-start;
  gap: 14px;
  justify-content: center;
  border-radius: 45px;
  background: #f2ead3;
  box-shadow: 4px 4px 4px 0px rgba(0, 0, 0, 0.25);
`;

export const ContentCard = styled.div`
  h2 {
    align-self: stretch;
    color: #3f2305;
    font-family: Inter;
    font-size: 22px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
  .question-message {
    flex: 1 0 0;
    align-self: stretch;
    color: #000;
    font-family: Inter;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
  .wrapper {
    width: 247px;
    flex-shrink: 0;
    color: #000;
    font-family: Inter;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
`;
export const BottomContainer = styled.div`
  display: flex;
  align-items: center;
  gap: 95px;
  align-self: stretch;
`;
