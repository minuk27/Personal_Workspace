import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import "../styles/App.css";

function Signup() {
  const [name, setName] = useState('');
  const [userID, setUserID] = useState('');  
  const [password, setPassword] = useState('');    
  //const [setResponseMessage] = useState('');
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = useState(false);

  const postData = async () => {
    setIsLoading(true); // 요청 시작 시 버튼 비활성화
    try {
      const response = await axios.post('http://localhost:1001/userService/Signup', {
        name: name,
        userID: userID,
        password: password,
      });

      if (response.data.success) {
        navigate('/Login');
      } else {
        console.error('요청 실패: ', response.data); // 실패 시 콘솔에 로그
      }

    } catch (error) {
      console.error('데이터 전송 실패: ', error);
    }
  };

  const loginPage = () => {
    navigate('/Login'); // 회원가입 페이지로 이동
  };

  return (
    <div>
      <h2>Sign Up</h2>
      <form>
      <input 
          type="text" 
          placeholder="이름" 
          value={name} 
          onChange={(e) => setName(e.target.value)} 
        />
        <br/>
        <input 
          type="text" 
          placeholder="아이디" 
          value={userID} 
          onChange={(e) => setUserID(e.target.value)} 
        />
        <br/>
        <input 
          type="password" 
          placeholder="비밀번호" 
          value={password} 
          onChange={(e) => setPassword(e.target.value)} 
        />
        <br/>
        <button type="submit" onClick={postData}>{isLoading ? '로딩 중...' : 'Sign Up'}</button>
        <br/>
        <button type="submit" onClick={loginPage}>{isLoading ? '로딩 중...' : 'Sign In'}</button>
      </form>
    </div>
  );
}

export default Signup;