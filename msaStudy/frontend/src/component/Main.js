import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Main(){
    const navigate = useNavigate();
    const [isLoading, setIsLoading] = useState(false);

    const massageService = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('/Main/MessagePage/Message'); // 회원가입 페이지로 이동
      };

    const logout = () => {
      //jwt반환추가
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('/Login'); // 회원가입 페이지로 이동
      };

      return (
        <div>
            <h1>Main Page</h1>
            <br/>
            <button class="btn" onClick={massageService}>{isLoading ? '로딩 중...' : 'Message'}</button>
            <br/>
            <br/>
            <button class="btn" onClick={logout}>{isLoading ? '로딩 중...' : 'Log Out'}</button>
        </div>
      );
}

export default Main;