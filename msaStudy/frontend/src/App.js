import React from 'react';
import {BrowserRouter as BrowserRouterRouter, Route, Routes } from 'react-router-dom';

import Prolog from './component/Prolog';
import Login from './component/Login';
import Signup from './component/Signup';
import Test from './component/Test';
import Main from './component/Main';

import MessagePage from './component/MainPages/Mail/MailPage';
import MessageSend from './component/MainPages/Mail/MailSend';
import MessageSendBox from './component/MainPages/Mail/MailSendBox';
import MessageReceiveBox from './component/MainPages/Mail/MailReceiveBox';
import WasteBasketBox from './component/MainPages/Mail/WasteBasketBox';

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
        
        <Route path="/Main/MessagePage/Message" element={<MessagePage />} />
        <Route path="/Main/MessagePage/MessageSend" element={<MessageSend />} />
        <Route path="/Main/MessagePage/MessageSendBox" element={<MessageSendBox />} />
        <Route path="/Main/MessagePage/MessageReceiveBox" element={<MessageReceiveBox />} />
        <Route path="/Main/MessagePage/WasteBasketBox" element={<WasteBasketBox />} />

        <Route path="/Main/ErrorPage/RequestError" element={<RequestError />} />
      </Routes>
    </BrowserRouterRouter>
  );
}

export default App;