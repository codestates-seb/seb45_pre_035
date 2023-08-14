/* eslint-disable import/no-named-as-default */
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
// eslint-disable-next-line no-unused-vars
import { sign_in } from '../../public/images/SignIn.png';

const SignContainer = styled.button`
  display: flex;
  width: 74px;
  height: 32px;
  padding: 16px 20px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  flex-shrink: 0;
  border-radius: 19px;
  background: #3f2305;
`;

const SignNav = () => {
  const navigate = useNavigate();

  return (
    <SignContainer>
      <button
        className="sign_in"
        onClick={() => {
          navigate('/users/signin');
        }}
      >
        Sign In
      </button>
    </SignContainer>
  );
};
export default SignNav;
