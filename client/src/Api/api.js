import axios from 'axios';

const serverUrl =
  'http://ec2-13-209-7-250.ap-northeast-2.compute.amazonaws.com';

export const api = (uri, method, data) => {
  const config = {
    method: method ? method : 'get',
    url: serverUrl + uri,
    headers: {
      'Content-Type': 'application/json',
      // Add more headers as needed
    },
    data: data,
  };

  return axios(config);
};
