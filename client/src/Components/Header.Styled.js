import { styled } from 'styled-components';

export const HeaderContainer = styled.header`
  display: flex;
  box-sizing: border-box;
  width: 100%;
  height: 61px;
  padding: 18px;
  justify-content: space-between;
  align-items: center;
  position: sticky;
  border-bottom: 2px solid #3f2305;
  background: #f2ead3;
`;
export const LogoContainer = styled.div`
  display: flex;
  width: 411px;
  height: 47px;
  flex-direction: column;
  justify-content: center;
  flex-shrink: 0;

  .title {
    color: #3f2305;
    font-family: Inter;
    font-size: 32px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    cursor: pointer;
  }
`;
export const ButtonContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  gap: 10px;
  flex-shrink: 0;
`;
export const Button = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 74px;
  height: 32px;
  text-align: center;
  border-radius: 19px;
  background: #3f2305;
  color: #fff;
  font-family: Inter;
  font-size: 15px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  cursor: pointer;
`;
