import { styled } from 'styled-components';

export const QuestionContainer = styled.div`
  box-sizing: border-box;
  display: flex;
  width: 416px;
  height: 209px;
  padding: 30px;
  flex-direction: column;
  align-items: flex-start;
  gap: 14px;
  /* justify-content: center;
  white-space: normal;
  line-height: 1.2;
  word-wrap: break-word;
  text-align: left;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical; */
  border-radius: 45px;
  background: #f2ead3;
  box-shadow: 4px 4px 4px 0px rgba(0, 0, 0, 0.25);
  cursor: pointer;
  color: #3f2305;
`;
export const ContentCard = styled.div`
  .question-message {
    flex: 1 0 0;
    align-self: stretch;
    color: #000;
    font-family: Inter;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
    width: 356px;
    height: 63px;
  }
`;
export const ContainerTitle = styled.text`
  align-self: stretch;
  color: #3f2305;
  font-family: Inter;
  font-size: 22px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  width: 356px;
  height: 27px;
`;

export const BottomContainer = styled.div`
  display: flex;
  align-items: center;
  width: 356px;
  height: 31px;
  justify-content: space-between;
  align-self: stretch;
  .icon-count {
    display: flex;
    align-items: flex-start;
    gap: 13px;
  }
  .icon-count > div {
    display: flex;
    align-items: center;
    gap: 5px;
  }
  .icon-count > div > div:first-child {
    display: flex;
    width: 31px;
    height: 31px;
    justify-content: center;
    align-items: center;
    gap: 10px;
  }
  .icon-count > div > div:first-child > img {
    width: 22px;
    height: 22px;
    flex-shrink: 0;
  }
  .icon-count > div > div:last-child {
    color: #000;
    font-family: Inter;
    font-size: 20px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
  .wrapper {
    color: #000;
    font-family: Inter;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
`;
