import React from 'react';
import {BrowserRouter as BrowserRouterRouter, Route, Routes } from 'react-router-dom';

import Prolog from './component/Prolog';
import Login from './component/Login';
import Signup from './component/Signup';
import Test from './component/Test';
import Main from './component/Main';

import MailPage from './component/MainPages/Mail/MailPage';
import MailSend from './component/MainPages/Mail/MailSend';
import MailSendBox from './component/MainPages/Mail/MailSendBox';
import MailReceiveBox from './component/MainPages/Mail/MailReceiveBox';

import RequestError from './component/ErrorPages/RequestErorrPage';

function App(){
  return(
    <BrowserRouterRouter>
      <Routes>
        <Route path="/" element={<Prolog />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/Test" element={<Test />}/>
        <Route path="/Signup" element={<Signup />} />
        <Route path="/Main" element={<Main />} />
        
        <Route path="/Main/MailPage" element={<MailPage />} />
        <Route path="/Main/MailPage/MailSend" element={<MailSend />} />
        <Route path="/Main/MailPage/MailSendBox" element={<MailSendBox />} />
        <Route path="/Main/MailPage/MailReceiveBox" element={<MailReceiveBox />} />

        <Route path="/Main/ErrorPage/RequestError" element={<RequestError />} />
      </Routes>
    </BrowserRouterRouter>
  );
}

export default App;