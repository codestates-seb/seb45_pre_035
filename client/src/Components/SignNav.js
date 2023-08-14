import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const SignNav = () => {
  const navigate = useNavigate();

  return (
    <SignContainer>
      <button
        className="login_in"
        onClick={() => {
          navigate('/users/login');
        }}
      >
        LogIn
      </button>
      <button
        className="sign_up"
        onClick={() => {
          navigate('/users/signup');
        }}
      >
        Sign
      </button>
    </SignContainer>
  );
};
export default SignNav;
