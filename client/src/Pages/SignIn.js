import React, { useEffect, useState } from 'react';
import { Button } from '../Components/Button';
import { SignInBox } from './styles/SignInBox';
import { PageStyle } from './styles/PageStyle';
import { api } from '../Api/api';
import { useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
// eslint-disable-next-line no-unused-vars
import { setUser } from '../redux/userSlice';
import BeforePage from '../Components/BeforePage';

export default function SignIn() {
  const [id, setId] = useState('');
  const [idIsValid, setIdIsValid] = useState(false);
  const [password, setPassword] = useState('');
  const [passwordIsValid, setPasswordIsValid] = useState(false);
  const [loggedIn, setLoggedIn] = useState(false);

  const user = useSelector((state) => state.user);
  const dispatch = useDispatch();

  const navigate = useNavigate();

  const onChangeHandlerId = (e) => {
    setId(e.target.value);
    if (e.target.value.match(/^[^\s@]+@[^\s@]+\.[^\s@]+$/)) {
      setIdIsValid(true);
    } else {
      setIdIsValid(false);
    }
  };
  const onChangeHandlerPassword = (e) => {
    setPassword(e.target.value);
    if (e.target.value.length < 8) {
      setPasswordIsValid(false);
    } else {
      setPasswordIsValid(true);
    }
  };

  const signIn = async () => {
    if (idIsValid && passwordIsValid) {
      api('/signin', 'post', { id, password })
        .then((response) => {
          console.log(response.data.message);
          if (response.data.success) {
            dispatch(setUser(response.data));
            // 응답 헤더 정보 가져오기
            const headers = response.headers;

            // 특정 헤더 값 가져오기 (예: Content-Type)
            const jwt = headers['authorization'];
            localStorage.setItem('token', jwt);
            console.log(jwt);
          }
        })
        .catch((error) => {
          // Handle any errors
          console.log('failed to signin');
          console.error('Request error:', error);
          return error;
        });
    }
  };

  const signUp = () => {
    navigate('/signup');
  };

  useEffect(() => {
    setLoggedIn(user.loggedIn);
  }, [user]);

  useEffect(() => {
    if (loggedIn) {
      navigate(-1);
    }
  }, [loggedIn, navigate]);

  return (
    <PageStyle>
      <BeforePage></BeforePage>
      <SignInBox>
        <div className="top">
          <div className="title">로그인</div>
          <div>
            <div className="input-container">
              <img src="/images/ic-outline-email.png" alt=""></img>
              <input
                type="text"
                onChange={onChangeHandlerId}
                value={id}
                placeholder="example@email.com"
              ></input>
            </div>
            {!idIsValid ? (
              <div className="error-message">
                유효한 이메일을 입력 해주세요.
              </div>
            ) : null}
          </div>
          <div>
            <div className="input-container">
              <img src="/images/mdi-password-outline.png" alt=""></img>
              <input
                type="password"
                onChange={onChangeHandlerPassword}
                value={password}
                placeholder="password"
              ></input>
            </div>
            {!passwordIsValid ? (
              <div className="error-message">비밀번호를 입력 해주세요.</div>
            ) : null}
          </div>
        </div>
        <div className="buttons">
          <Button onClick={signUp}>Sign Up</Button>
          <Button primary onClick={signIn}>
            Sign In
          </Button>
        </div>
      </SignInBox>
    </PageStyle>
  );
}
