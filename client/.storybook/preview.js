/** @type { import('@storybook/react').Preview } */
import { BrowserRouter } from 'react-router-dom';
import GlobalStyles from '../src/GlobalStyles';
const preview = {
  parameters: {
    actions: { argTypesRegex: '^on[A-Z].*' },
    controls: {
      matchers: {
        color: /(background|color)$/i,
        date: /Date$/,
      },
    },
  },
};

export default preview;

export const decorators = [
  (Story) => (
    <>
      <GlobalStyles />
      <BrowserRouter>
        <Story />
      </BrowserRouter>
    </>
  ),
];
