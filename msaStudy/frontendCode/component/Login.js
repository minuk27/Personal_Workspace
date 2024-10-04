import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import "../styles/App.css";

function Login() {
  const [userID, setUserID] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = useState(false);

  const postData = async () => {
    //setIsLoading(true); // 요청 시작 시 버튼 비활성화
    try {
      const response = await axios.post('http://localhost:1001/userService/Signin', {
        userID: userID,
        password: password,
      });

      const accessToken = response.data; // 서버에서 반환한 토큰

      if (response.status >= 200 && response.status < 300) {
        localStorage.removeItem('accessToken');
        //localStorage.removeItem('refreshToken');
        
        localStorage.setItem('accessToken', accessToken); // 토큰을 로컬 스토리지에 저장
        //localStorage.setItem('refreshToken', refreshToken); // 토큰을 로컬 스토리지에 저장

        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('/Main'); // 로그인 성공 시 성공 페이지로 이동
      } else {
        console.error('요청 실패: ', response.data); // 실패 시 콘솔에 로그
      }

    } catch (error) {
      console.error('데이터 전송 실패: ', error); // 에러 발생 시 콘솔에 로그
    }
  };

  const joinPage = () => {
    navigate('/Signup'); // 회원가입 페이지로 이동
  };

  return (
    <div class="container right-panel-active">
      <h1 class="form__title">IT eyes</h1>
      <br/>
      <section class="container__form container--signin">
        <form action="#" class="form" id="form2">
          <h2 class="form__title">Sign In</h2>
          <input
            type="text"
            placeholder="아이디"
            value={userID}
            onChange={(e) => setUserID(e.target.value)}
          />
          <br/>
          <input
            type="password" placeholder="Password" class="input" 
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <br/>
          <button class="btn" id="signIn" onClick={postData}>{isLoading ? '로딩 중...' : 'Sign In'}</button>
          <br/>
          <button class="btn" id="signUp" onClick={joinPage}>Sign Up</button>
          </form>
      </section>
      <section class="container__overlay">
          
      </section>
    </div>
  );
}

export default Login;