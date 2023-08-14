import styled from 'styled-components';

// components
import Home from './Home';
import NewQuestion from './NewQuestion';
import SignIn from './SignIn';
import MyPage from './MyPage';

const HeaderContainer = styled.header`
  display: flex;
  width: 74px;
  height: 32px;
  padding: 16px 20px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  flex-shrink: 0;
  background-color: #ccc;
`;

const Header = () => {
  return (
    <HeaderContainer>
      <>
        <Home />
        <NewQuestion />
        <MyPage />
        <SignIn />
      </>
    </HeaderContainer>
  );
};

export default Header;
