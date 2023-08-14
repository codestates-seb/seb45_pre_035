/* eslint-disable import/no-named-as-default */
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import { TitleLogo } from '../../public/images/s-stack-overflow.png';

const LogoContainer = styled.div`
  display: flex;
  width: 411px;
  height: 47px;
  flex-direction: column;
  justify-content: center;
  flex-shrink: 0;

  .is_desktop_display {
    display: block;
    color: #3f2305;
    font-family: Inter;
    font-size: 32px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
  }
`;

const TitleLogo = () => {
  const navigate = useNavigate();
  return (
    <><LogoContainer
      onClick={() => {
        window.scrollTo(0, 0);
        navigate('/');
      }} >
      <TitleLogo classname="is_desktop_display"/> </>
    </LogoContainer >
   );
};

export default TitleLogo;
