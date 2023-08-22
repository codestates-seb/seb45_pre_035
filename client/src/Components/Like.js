/* eslint-disable react/prop-types */
import React, { useState } from 'react';
import { api } from '../Api/api';
import { styled } from 'styled-components';
const Wrapper = styled.div`
  cursor: pointer;
`;

export default function Like({
  likes_count,
  questionId,
  answerId,
  user_has_liked,
}) {
  const [likes, setlikes] = useState(likes_count);
  const [liked, setliked] = useState(user_has_liked);
  let uri = '';
  let method = '';

  const handleClick = () => {
    method = liked ? 'delete' : 'post';
    uri =
      `/questions/${questionId}` +
      (answerId ? `/answers/${answerId}/likes` : `/likes`);
    console.log(method, uri);
    api(uri, method)
      .then((response) => {
        if (response.success) {
          setlikes(response.likes_count);
          setliked(response.user_has_liked);
        }
      })
      .catch((error) => console.log(error));
  };

  return (
    <Wrapper>
      <div onClick={handleClick} aria-hidden="true">
        {liked ? (
          <img src="/images/like.png" alt=""></img>
        ) : (
          <img src="/images/unliked.png" alt=""></img>
        )}
      </div>
      <div>{likes}</div>
    </Wrapper>
  );
}
