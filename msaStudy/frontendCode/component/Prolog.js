import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Prolog(){
    const navigate = useNavigate();
    const [isLoading, setIsLoading] = useState(false);

    const signIn = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('/Login'); // 회원가입 페이지로 이동
    };

    const joinPage = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('/Signup'); // 회원가입 페이지로 이동
    };

    return (
        <div>
          <h1>Minuk Page</h1>

          <button class="btn" id="signIn" onClick={signIn}>{isLoading ? '로딩 중...' : 'Sign In'}</button>
          <button class="btn" id="signUp" onClick={joinPage}>{isLoading ? '로딩 중...' : 'Sign Up'}</button>
        </div>
    );
}

export default Prolog;