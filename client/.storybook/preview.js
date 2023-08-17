/** @type { import('@storybook/react').Preview } */
import { BrowserRouter } from 'react-router-dom';
import GlobalStyles from '../src/GlobalStyles';
import { Provider } from 'react-redux';
import store from '../src/redux/store';
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
    <Provider store={store}>
      <GlobalStyles />
      <BrowserRouter>
        <Story />
      </BrowserRouter>
    </Provider>

  ),
];
