import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

// components
import Home from './Home';
import NewQuestion from './NewQuestion';
import SignIn from './SignIn';
import MyPage from './MyPage';

const NewQuestion = () => {
  const navigate = useNavigate();

  return (
    <MyQuestionContainer>
      <Button
        src="{../../public/images/NewQuestion.png}"
        onClick={navigate('/NewQuestion')}
      ></Button>
    </MyQuestionContainer>
  );
};
const MyPage = () => {
  const navigate = useNavigate();

  return (
    <MyPageCotainer>
      <Button
        src="{../../public/images/MyPage.png}"
        onClick={navigate('/MyPage')}
      />
    </MyPageCotainer>
  );
};
const Header = () => {
  return (
    <HeaderContainer>
      <>
        <Button />
        <NewQuestion />
        <MyPage />
        <SignIn />
      </>
    </HeaderContainer>
  );
};

export default Header;
