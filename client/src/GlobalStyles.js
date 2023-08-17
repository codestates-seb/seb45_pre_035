import { createGlobalStyle } from 'styled-components';

const GlobalStyles = createGlobalStyle`
  /* Your global CSS styles go here */
  body {
    margin: 0;
    padding: 0;
    background: #f5f5f5;
  }
  * {
    box-sizing: border-box;
  }
`;

export default GlobalStyles;
