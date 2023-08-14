import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import Button from '../../public/images/MyPage.png';

const MyPageCotainer = styled.button`
  border-radius: 19px;
  background: #3f2305;
  color: #fff;
  font-family: Inter;
  font-size: 15px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
`;

const MyPage = () => {
  const navigate = useNavigate();

  return (
    <MyPageCotainer>
      <Button
        src="{../../public/images/MyPage.png}"
        onClick={navigate('/MyPage')}
      />
    </MyPageCotainer>
  );
};
export default MyPage;
