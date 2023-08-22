import { styled } from 'styled-components';

export const SmallButton = styled.button`
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 74px;
  height: 32px;
  padding: 0;
  border-radius: 19px;
  background: #3f2305;
  color: #fff;
  font-family: Inter;
  font-size: 14px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  cursor: pointer;
  border: unset;
  &:hover {
    background-color: #deb887;
  }
`;
