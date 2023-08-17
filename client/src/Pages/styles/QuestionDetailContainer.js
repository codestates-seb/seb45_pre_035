import { styled } from 'styled-components';
export const QuestionDetailContainer = styled.div`
  display: flex;
  width: 908px;
  padding: 33px;
  flex-direction: column;
  align-items: flex-start;
  gap: 18px;
  border: 2px solid #3f2305;
  .title {
    width: 792px;
    color: #000;
    font-family: Inter;
    font-size: 32px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
  .author-container {
    display: flex;
    padding: 8px 0px;
    justify-content: space-between;
    align-items: center;
    align-self: stretch;
    border-top: 2px solid #3f2305;
    border-bottom: 2px solid #3f2305;
  }
  .author {
    color: #000;
    font-family: Inter;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
  .author-right-container {
    display: flex;
    align-items: center;
    gap: 18px;
  }
  .my-text {
    display: flex;
    align-items: flex-start;
    gap: 12px;
  }
  .my-text > div > img {
    width: 27px;
    height: 27px;
  }
  .content {
    flex: 1 0 0;
    color: #000;
    font-family: Inter;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: 170%; /* 23.8px */
  }
  .time {
    height: 21px;
    color: #000;
    font-family: Inter;
    font-size: 14px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
  .bottom-menu {
    display: flex;
    padding-bottom: 10px;
    align-items: center;
    gap: 674px;
    align-self: stretch;
    border-bottom: 2px dashed #3f2305;
  }
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
  .answer-container {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    align-self: stretch;
    gap: 18px;
  }
  .new-answer-container {
    display: flex;
    height: 334px;
    padding: 23px;
    flex-direction: column;
    align-items: flex-start;
    gap: 18px;
    align-self: stretch;
    border: 2px solid #3f2305;
    background: #f2ead3;
  }
  .answer-input {
    flex: 1 0 0;
    align-self: stretch;
    border-radius: 13px;
    border: 1px solid #d9d9d9;
    background: #f5f5f5;
    padding: 10px;
  }
  .submit-container {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    gap: 10px;
    align-self: stretch;
  }
`;
