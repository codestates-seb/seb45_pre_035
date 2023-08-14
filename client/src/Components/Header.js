import styled from 'styled-components';

// components
import TitleLogo from './TitleLogo';
import SignNav from './SignNav';
import UserNav from './UserNav';

const Header = () => {
  return (
    <HeaderContainer>
      <StyledHeader>
        <>
          <TitleLogo />
          {loginVerified ? <UserNav /> : <SignNav />}
        </>
      </StyledHeader>
    </HeaderContainer>
  );
};

export default Header;
