import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ReceiveMessageBox = () => {
  
  const [receiveMessage, setReceiveMessage] = useState([]);
  const messageBoxError = useState('');
  const [readData, setReadData] = useState('');
  const [readDataError, setReadDataError] = useState('');

  useEffect(() => {
    const ReceiveMessages = async () => {
      try {
        const response = await axios.get('');
        setReceiveMessage(response.data);
        messageBoxError(null);
      } catch (err) {
        messageBoxError('데이터를 가져오는 중 오류가 발생했습니다.');
      }
    };

    ReceiveMessages();
  });

  const ReadMessage = async () => {
    try {
      const response = await axios.get('');
      setReadData(response.data);
      setReadDataError(null);
    } catch (err) {
      setReadDataError('데이터를 가져오는 중 오류가 발생했습니다.');
    }
  };

  return (
    <div>
      <h2>Message Recieve Box</h2>
      <ul>
        {receiveMessage.map((str, index) => (
          <li key={index}>{str}</li> // 현재 상태 변수를 사용하여 렌더링
        ))}
      </ul>
      <br/>
      <button onClick={ReadMessage}>데이터 요청</button>
      {readData && (
        <div>
          <h3>서버에서 받은 데이터:</h3>
          <pre>{JSON.stringify(readData, null, 2)}</pre>
        </div>
      )}
      
      {/* 에러가 발생한 경우 출력 */}
      {readDataError && <p>{readDataError}</p>}
    </div>
  );
};

export default ReceiveMessageBox;