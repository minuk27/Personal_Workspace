import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function RequestErorrPage(){
    const navigate = useNavigate();
    const [isLoading, setIsLoading] = useState(false);

    const massageService = () => {
        setIsLoading(true);
        navigate('/Main');
      };
      return (
        <div>
            <h1>Error Page</h1>
            <p>페이지 요청 실패<br/>메인 페이지로 이동하시겠습니까?</p>
            <button class="btn" onClick={massageService}>{isLoading ? '로딩 중...' : 'Back'}</button>
        </div>
      );
}

export default RequestErorrPage;