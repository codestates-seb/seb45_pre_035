import React, { useEffect, useState } from 'react';
import { Button } from '../Components/Button';
import { SignInBox } from './styles/SignInBox';
import { PageStyle } from './styles/PageStyle';
import { api } from '../Api/api';
import { useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
// eslint-disable-next-line no-unused-vars
import { decrement, increment } from '../redux/counterSlice';

export default function SignIn() {
  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  const [loggedIn, setLoggedIn] = useState(false);

  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  const navigate = useNavigate();

  const onChangeHandlerId = (e) => {
    setId(e.target.value);
  };
  const onChangeHandlerPassword = (e) => {
    setPassword(e.target.value);
  };

  const signIn = async () => {
    setLoggedIn(api('/signin', 'post', { id, password }));
  };

  useEffect(() => {
    if (loggedIn) {
      navigate(-1);
    }
  }, [loggedIn, navigate]);

  return (
    <PageStyle>
      <button
        aria-label="Increment value"
        onClick={() => dispatch(increment())}
      >
        Increment
      </button>
      <span>{count}</span>
      <SignInBox>
        <div className="top">
          <div className="title">로그인</div>
          <div className="input-container">
            <img src="/images/ic-outline-email.png" alt=""></img>
            <input type="text" onChange={onChangeHandlerId} value={id}></input>
          </div>
          <div className="input-container">
            <img src="/images/mdi-password-outline.png" alt=""></img>
            <input
              type="password"
              onChange={onChangeHandlerPassword}
              value={password}
            ></input>
          </div>
        </div>
        <div className="buttons">
          <Button>Sign Up</Button>
          <Button primary onClick={signIn}>
            Sign In
          </Button>
        </div>
      </SignInBox>
    </PageStyle>
  );
}
