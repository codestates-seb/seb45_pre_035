import { styled, css } from 'styled-components';

export const Button = styled.button`
  display: flex;
  width: 124px;
  height: 61px;
  padding-bottom: 5px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  flex-shrink: 0;
  border-radius: 24px;
  border: 2px solid #3f2305;
  background: #f2ead3;

  color: #3f2305;
  font-family: Inter;
  font-size: 24px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;

  ${(props) =>
    props.primary &&
    css`
      border: none;
      background: #3f2305;
      color: #fff;
    `}
`;
