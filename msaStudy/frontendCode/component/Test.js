import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Test() {
  const [responseMessage, setResponseMessage] = useState('');
  const navigate = useNavigate();

  // 컴포넌트가 렌더링될 때 데이터를 가져옵니다.
  useEffect(() => {
    const fetchData = async () => {
      try {
        // 로컬 스토리지에서 토큰 가져오기
        const token = localStorage.getItem('accessToken');
        // axios를 사용하여 GET 요청 보내기
        const response = await axios.get('http://localhost:1001/userService/testPage', {
          headers: {
            Authorization: `Bearer ${token}`, // Authorization 헤더에 토큰 추가
          }
        });
        // 서버 응답 메시지를 상태로 저장
        setResponseMessage(response.data);
      } catch (error) {
        console.error('데이터 가져오기 실패: ', error.response);
        if (error.response && error.response.status === 401) {
          navigate('/Login');
        } else {
          setResponseMessage('데이터를 불러오는 데 실패했습니다.');
        }
      }
    };

    fetchData();
  }, [navigate]); // useNavigate 의존성 추가

  return (
    <div>
      <h2>서버로부터 받은 메시지:</h2>
      <p>{responseMessage}</p>
    </div>
  );
}

export default Test;