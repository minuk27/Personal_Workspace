const express = require('express');
const app = express();
const port = 5000;
app.use(express.json());

app.post('/login', (req, res) => {
  const { username, password } = req.body;
  if (username === 'test' && password === '1234') {
    res.json({ success: true });
  } else {
    res.json({ success: false, message: '로그인 정보가 잘못되었습니다.' });
  }
});

app.post('/signup', (req, res) => {
  const { username, password } = req.body;
  if (username === 'test') {
    res.json({ success: false, message: '이미 존재하는 아이디입니다.' });
  } else {
    res.json({ success: true });
  }
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});