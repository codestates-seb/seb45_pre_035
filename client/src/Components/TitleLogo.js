/* eslint-disable import/no-named-as-default */
import styled from 'styled-components';
import { ReactComponent as TitleLogoSvg } from '../../assets/images/Stack_Overflow_logo.svg';
import { useNavigate } from 'react-router-dom';

const LogoContainer = styled.div`
  padding: 0 0.5rem 0.2rem 0.5rem;
  display: flex;
  align-items: center;
  height: 100%;
  cursor: pointer;

  svg {
    height: 30px;
    width: 150px;
  }
  .is_desktop_display {
    display: block;
  }
  .is_mobile_display {
    display: none;
  }
`;

const TitleLogo = () => {
  const navigate = useNavigate();
  return (
    <LogoContainer
      onClick={() => {
        window.scrollTo(0, 0);
        navigate('/');
        // window.location.href = "/";
      }}
    >
      <TitleLogoSvg className="is_desktop_display" />
    </LogoContainer>
  );
};

export default TitleLogo;
