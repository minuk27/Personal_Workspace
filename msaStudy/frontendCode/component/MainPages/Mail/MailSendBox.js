import React, { useState, useEffect, useCallback } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function SendMessageBox() {
    const [messages, setMessages] = useState([]);
    const [page, setPage] = useState(0);
    const [size, setSize] = useState(10);
    const [totalPages, setTotalPages] = useState(0);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    setSize(10);

    const fetchMessages = useCallback(async () => {
        try {
            const response = await axios.get('http://localhost:1001/mailService/sendMilBox', {
                params: { page, size },
            });
            setMessages(response.data.content);
            setTotalPages(response.data.totalPages);
            setError(null);
        } catch (err) {
            setError('데이터를 가져오는 중 오류가 발생했습니다.');
        }
    }, [page, size]);

    useEffect(() => {
        fetchMessages();
    }, [fetchMessages]);

    const nextPage = () => {
        if (page < totalPages - 1) {
            setPage(page + 1);
        }
    };

    const prevPage = () => {
        if (page > 0) {
            setPage(page - 1);
        }
    };

    const backMain = () => {
        navigate('/MailPage'); // Mail메인 페이지로 이동
    };

    return (
        <div>
            <h2>Message Send Box</h2>
            {error && <p>{error}</p>} {/* 에러 메시지 표시 */}
            <ul>
                {messages.map((msg, index) => (
                    <li key={index}>{msg.content}</li>
                ))}
            </ul>
            <div>
                <button onClick={prevPage} disabled={page === 0}>이전</button>
                <button onClick={nextPage} disabled={page === totalPages - 1}>다음</button>
            </div>
            <button className="btn" onClick={backMain}>Back Main</button>
        </div>
    );
}

export default SendMessageBox;