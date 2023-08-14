import { useNavigate } from 'react-router-dom';

const BeforePage = () => {
  const navigate = useNavigate();

  const goBack = () => {
    navigate(-1); //이전 페이지로 이동
  };
  return (
    <div>
      <img src={'/images/BeforePageImage.png'} alt="뒤로가기 버튼"></img>
      <button onClick={goBack}>이전 페이지로 이동</button>
    </div>
  );
};

export default BeforePage;
