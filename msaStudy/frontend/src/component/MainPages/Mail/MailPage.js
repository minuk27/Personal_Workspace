import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function MessagePage(){
    const navigate = useNavigate();
    const [userMessage, setUserMessage] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const fetchStrings = async () => {
            const response = await axios.get('');

            setUserMessage(response.data);
        };

        fetchStrings();
    }, []);

    const BackMainPage = () => {
      setIsLoading(true); // 요청 시작 시 버튼 비활성화
      navigate('./SendMessageBox'); //메인 페이지 이동
    };

    const SendMessage = () => {
      setIsLoading(true); // 요청 시작 시 버튼 비활성화
      navigate('./SendMessageBox'); //메시지 송신
    };

    const ReceiveMessage = () => {
      setIsLoading(true); // 요청 시작 시 버튼 비활성화
      navigate('./SendMessageBox'); //수신 메시지 읽기
    };

    const SendMessageBox = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('./SendMessageBox'); //송신한 메시지보관소
      };

    const ReceiveMessageBox = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('./ReceiveMessageBox'); //수신한 메시지보관소
      };
    
    const WasteBasketBox = () => {
        setIsLoading(true); // 요청 시작 시 버튼 비활성화
        navigate('./WasteBasketBox'); //휴지통
      };
      
      return (
        <div>
          <h1>Message Page</h1>
          <br/>
          <button class="btn" onClick={BackMainPage}>{isLoading ? '로딩 중...' : 'Back Main Page'}</button>
          <br/>
          <h3>{userMessage[0]}</h3>
          <p>
            Send Box
            <br/>
            Send Message: {userMessage[1]}
            <button class="btn" onClick={SendMessageBox}>{isLoading ? '로딩 중...' : 'Send Box'}</button>
            <br/>
            Receive Box
            <br/>
            Receive Message: {userMessage[2]}
            <button class="btn" onClick={ReceiveMessageBox}>{isLoading ? '로딩 중...' : 'Receive Box'}</button>
            <br/>
            Waste Backet Box
            <br/>
            Waste Backet: {userMessage[3]}
            <button class="btn" onClick={WasteBasketBox}>{isLoading ? '로딩 중...' : 'Waste Backet Box'}</button>
          </p>
          <button class="btn" onClick={SendMessage}>{isLoading ? '로딩 중...' : 'Send'}</button>
          <br/>
          <button class="btn" onClick={ReceiveMessage}>{isLoading ? '로딩 중...' : 'Receive'}</button>
        </div>
      );
}

export default MessagePage;