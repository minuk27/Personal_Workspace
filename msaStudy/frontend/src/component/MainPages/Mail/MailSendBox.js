import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function SendMessageBox(){
    const [sendMessage, setSendMessage] = useState(['']);
    const messageBoxError = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        const ReceiveMessages = async () => {
          try {
            const response = await axios.get('');
            setSendMessage(response.data);
            messageBoxError(null);
          } catch (err) {
            messageBoxError('데이터를 가져오는 중 오류가 발생했습니다.');
          }
        };
        
        ReceiveMessages();
      });
      const backMain = () => {
        navigate('/Signup'); // 회원가입 페이지로 이동
      };

      return (
        <div>
          <h2>Message Send Box</h2>
          <ul>
            {sendMessage.map((str, index) => (
              <li key={index}>{str}</li> // 현재 상태 변수를 사용하여 렌더링
            ))}
          </ul>
          <br/>
          <button class="btn" onClick={backMain}>Back Main</button>
        </div>
      );
}

export default SendMessageBox;