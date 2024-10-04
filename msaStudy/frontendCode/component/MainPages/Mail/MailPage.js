import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function MessagePage(){
    const navigate = useNavigate();
    const [userMessage, setUserMessage] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const fetchStrings = async () => {
            const token = localStorage.getItem('accessToken');
            const response = await axios.get('http://localhost:1001/mailService/mailHome', {
              headers: {
                Authorization: `Bearer ${token}`, // Authorization 헤더에 토큰 추가
              }
            });
            setUserMessage(response.data);
        };

        fetchStrings();
    }, []);

    const BackMainPage = () => {
      setIsLoading(true); // 요청 시작 시 버튼 비활성화
      navigate('/Main'); //메인 페이지 이동(복귀)
    };

    const SendMessage = () => {
      setIsLoading(true); // 요청 시작 시 버튼 비활성화
      navigate('./MailSend'); //메시지 송신
    };

    const SendMessageBox = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('./SendMessageBox'); //송신한 메시지보관소
      };

    const ReceiveMessageBox = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('./ReceiveMessageBox'); //수신한 메시지보관소
      };
      
      return (
        <div>
          <h1>Message Page</h1>
          <br/>
          <h3>{userMessage[0]}의 메일서비스</h3>
          <p>
            Mail Send
            <br/>
            <button class="btn" onClick={SendMessage}>{isLoading ? '로딩 중...' : 'Send'}</button>
            <br/>
            <br/>
            Send Box
            <br/>
            Send Message: {userMessage[1]}
            <br/>
            <button class="btn" onClick={SendMessageBox}>{isLoading ? '로딩 중...' : 'Send Box'}</button>
            <br/>
            <br/>
            Receive Box
            <br/>
            Receive Message: {userMessage[2]}
            <br/>
            <button class="btn" onClick={ReceiveMessageBox}>{isLoading ? '로딩 중...' : 'Receive Box'}</button>
            <br/>
          </p>
          <button class="btn" onClick={BackMainPage}>{isLoading ? '로딩 중...' : 'Back Main Page'}</button>
          <br/>
        </div>
      );
}

export default MessagePage;