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
  box-shadow: 2px 2px 2px 2px gray;
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
    &:hover {
      color: #deb887;
    }
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
