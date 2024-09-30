import React, { useState, handleSender } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function MessageSend() {
  const navigate = useNavigate();

  const [responseMessage, setResponseMessage] = useState(''); //보낸 사람
  const [sender, setSender] = useState(''); // 보낼 사람
  const [title, setTitle] = useState(''); // 제목
  const [message, setMessage] = useState(''); // 메시지 내용  
  const [serverResponse, setServerResponse] = useState(''); // 서버로부터 받은 값

  const token = localStorage.getItem('accessToken');

  handleSender(() => {
    const fetchData = async () => {
    try {
      const response = await axios.get('', {
        headers: {
          Authorization: `Bearer ${token}`, // Authorization 헤더에 토큰 추가
        }
      });
      // 서버 응답 메시지를 상태로 저장
      setResponseMessage(response.data);
    } catch (error) {
        console.error('데이터 가져오기 실패: ', error.response);
        navigate('/Main/RequestError');
      }
    };

    fetchData();
  })
  
  const handleReceiver = (event) => {
    setSender(event.target.value);
  };
  
  const handleTitle = (event) => {
    setTitle(event.target.value);
  };
  
  const handleMessage = (event) => {
    setMessage(event.target.value);
  };
  
  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      // 메시지를 서버로 POST 요청
      const response = await axios.post('http://localhost:8080/api/messages', { sender, title, message });
      setResponseMessage(`서버 응답: ${response.data.message}`);
      setServerResponse(sender); // 보낸 사람으로 서버 응답 값 설정
      setSender(''); // 입력 필드 초기화
      setTitle(''); // 입력 필드 초기화
      setMessage(''); // 입력 필드 초기화
    } catch (error) {
      setResponseMessage(`오류 발생: ${error.message}`);
    }
  };
  
    return (
        <div>
            <h1>Message Service</h1>
          <form onSubmit={handleSubmit}>
            <text>
              {responseMessage}
            </text>
            <input
              type="text"
              value={sender}
              onChange={handleReceiver}
              placeholder="보낼 사람"
              required
              style={{ width: '1000px', height: '40px', marginBottom: '10px' }} // 100% 너비, 높이 40px
            />
            <input
              type="text"
              value={title}
              onChange={handleTitle}
              placeholder="제목"
              required
              style={{ width: '1000px', height: '40px', marginBottom: '10px' }} // 100% 너비, 높이 40px
            />
            <textarea
              value={message}
              onChange={handleMessage}
              placeholder="메시지를 입력하세요"
              required
              style={{ width: '1000px', height: '500px', resize: 'none' }} // 너비 100%, 높이 300px, 크기 조절 불가
            />
            <button type="submit" style={{ marginTop: '10px', padding: '10px 20px' }}>전송</button>
          </form>
          {responseMessage && <p>{responseMessage}</p>}
          {serverResponse && <p>보낸 사람: {serverResponse}</p>} {/* 서버로부터 받은 값 표시 */}
        </div>
      );
  }

export default MessageSend;