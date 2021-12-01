import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
    },
  },
}));


export default function Feedback() {
  const paperStyle = { padding: '50px 30px', width: 500, margin: '30px auto' }
  const [code, setCode] = useState('');
  const [feedback, setFeedback] = useState('');
  const [score, setScore] = useState('');
  const [formValid, setFormValid] = useState(false);

  const classes = useStyles();

  useEffect(() => {
    if (code != '' && feedback != '' && score != '')
      setFormValid(true)
    else
      setFormValid(false)
  }, [code, feedback, score])

  const handleClick = (e) => {
    e.preventDefault();
    const feed = { code, feedback, score };
    if (code == '' || feedback == '' || score == '')
      return;
    fetch("http://localhost:5006/feedback",
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(feed)
      }
    );
    setCode('');
    setFeedback('');
    setScore('');
  }

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{color:"blue"}}><u>Add feedback</u></h1>
        <form classcode={classes.root} noValidate autoComplete="off">
          <TextField
            id="outlined-basic" label="Код книги" variant="outlined" fullWidth
            value={code}
            onChange={(e) => setCode(e.target.value)}
          />
          <TextField id="outlined-basic" label="Отзыв" variant="outlined" fullWidth
            value={feedback}
            onChange={(e) => setFeedback(e.target.value)}
          />
          <TextField id="outlined-basic" label="Рейтинг(0-10)" variant="outlined" fullWidth
            value={score}
            onChange={(e) => setScore(e.target.value)}
          />
          <Button disabled={!formValid} variant="contained" color="primary" onClick={handleClick}>
            Отправить
          </Button>
        </form>
      </Paper>
    </Container>
  );
}
