import { styled } from 'styled-components';
export const SignInBox = styled.div`
  box-sizing: border-box;
  width: 480px;
  height: 720px;
  flex-shrink: 0;
  border: 2px solid #3f2305;
  background: #f5f5f5;
  padding: 58px 38px 87px 38px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  .top {
    display: flex;
    flex-direction: column;
    row-gap: 50px;
  }
  .title {
    color: #000;
    font-family: Inter;
    font-size: 32px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
  .input-container {
    display: flex;
    column-gap: 23px;
    border-bottom: #3f2305 1px solid;
    align-items: center;
  }
  input {
    width: 355px;
    height: 35px;
    border: none;
    background: unset;
    color: #000;
    font-family: Inter;
    font-size: 22px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
  input:focus {
    border: 0;
    outline: none;
  }
  img {
    width: 24px;
    height: 24px;
  }
  .buttons {
    display: flex;
    flex-direction: row;
    justify-content: center;
    column-gap: 43px;
  }
`;
