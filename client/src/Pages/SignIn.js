import React from 'react';
import { Button } from '../Components/Button';
import { SignInBox } from './styles/SignInBox';
import { PageStyle } from './styles/PageStyle';
export default function SignIn() {
  return (
    <PageStyle>
      <SignInBox>
        <div className="top">
          <div className="title">로그인</div>
          <div className="input-container">
            <img src="/images/ic-outline-email.png" alt=""></img>
            <input type="text"></input>
          </div>
          <div className="input-container">
            <img src="/images/mdi-password-outline.png" alt=""></img>
            <input type="password"></input>
          </div>
        </div>
        <div className="buttons">
          <Button>Sign Up</Button>
          <Button primary>Sign In</Button>
        </div>
      </SignInBox>
    </PageStyle>
  );
}
