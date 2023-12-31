import React, { useState } from 'react';
import { Button } from '../Components/Button';
import { SignInBox } from './styles/SignInBox';
import { PageStyle } from './styles/PageStyle';
import { api } from '../Api/api';
import { useNavigate } from 'react-router-dom';
import BeforePage from '../Components/BeforePage';

export default function SignUp() {
  const [id, setId] = useState('');
  const [idIsValid, setIdIsValid] = useState(false);
  const [password, setPassword] = useState('');
  const [passwordIsValid, setPasswordIsValid] = useState(false);
  const [password2, setPassword2] = useState('');
  const [password2IsValid, setPassword2IsValid] = useState(false);
  const [name, setName] = useState('');
  const [nameIsValid, setNameIsValid] = useState(false);

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
    if (
      e.target.value.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,}$/)
    ) {
      setPasswordIsValid(true);
    } else {
      setPasswordIsValid(false);
    }
  };
  const onChangeHandlerPassword2 = (e) => {
    setPassword2(e.target.value);
    if (e.target.value !== password) {
      setPassword2IsValid(false);
    } else {
      setPassword2IsValid(true);
    }
  };
  const onChangeHandlerName = (e) => {
    setName(e.target.value);
    if (e.target.value.length < 1) {
      setNameIsValid(false);
    } else {
      setNameIsValid(true);
    }
  };

  const signUp = async () => {
    if (idIsValid && passwordIsValid && password2IsValid && nameIsValid) {
      api('/signin', 'post', { id, password })
        .then((response) => {
          console.log(response.data.message);
          if (response.data.success) {
            alert('회원가입에 성공하셨습니다.');
            navigate('/signin');
          }
        })
        .catch((error) => {
          // Handle any errors
          console.log('failed to signUp');
          console.error('Request error:', error);
        });
    }
  };

  return (
    <PageStyle>
      <BeforePage></BeforePage>
      <SignInBox>
        <div className="top">
          <div className="title">회원가입</div>
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
              <div className="error-message">
                최소 8글자 이상, 영문, 숫자, 특수문자 포함
              </div>
            ) : null}
          </div>
          <div>
            <div className="input-container">
              <img src="/images/mdi-password-outline.png" alt=""></img>
              <input
                type="password"
                onChange={onChangeHandlerPassword2}
                value={password2}
                placeholder="password"
              ></input>
            </div>
            {!password2IsValid ? (
              <div className="error-message">비밀번호가 일치하지 않습니다.</div>
            ) : null}
          </div>
          <div>
            <div className="input-container">
              <img src="/images/ph-user.png" alt=""></img>
              <input
                type="text"
                onChange={onChangeHandlerName}
                value={name}
                placeholder="김코딩"
              ></input>
            </div>
            {!nameIsValid ? (
              <div className="error-message">이름을 입력 해주세요</div>
            ) : null}
          </div>
        </div>
        <div className="buttons">
          <Button primary onClick={signUp}>
            Sign Up
          </Button>
        </div>
      </SignInBox>
    </PageStyle>
  );
}
