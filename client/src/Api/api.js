import axios from 'axios';

const serverUrl = 'https://github.com/codestates-seb/seb45_pre_035';

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
