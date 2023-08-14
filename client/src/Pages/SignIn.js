import { styled } from 'styled-components';
const SignInBox = styled.div`
  width: 480px;
  height: 720px;
  flex-shrink: 0;
  border: 2px solid #3f2305;
  background: #f5f5f5;

  .title {
    color: #000;
    font-family: Inter;
    font-size: 32px;
    font-style: normal;
    font-weight: 400;
    line-height: normal;
  }
`;
export default function SignIn() {
  return (
    <div>
      <SignInBox>
        <div className="title">로그인</div>
        <div>
          <img src="/images/ic-outline-email.png" alt=""></img>
          <input type="text"></input>
        </div>
        <div>
          <img src="/images/mdi-password-outline.png" alt=""></img>
          <input type="password"></input>
        </div>
      </SignInBox>
    </div>
  );
}
