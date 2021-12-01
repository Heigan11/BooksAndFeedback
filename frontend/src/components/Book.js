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


export default function Book() {
  const paperStyle = { padding: '50px 30px', width: 500, margin: '30px auto' }
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [formValid, setFormValid] = useState(false);

  const classes = useStyles();

  useEffect(() => {
    if (name != '' && description != '')
      setFormValid(true)
    else
      setFormValid(false)
  }, [name, description])

  const handleClick = (e) => {
    e.preventDefault();
    const book = { name, description };
    if (name == '' || description == '')
      return;
    fetch("http://localhost:5006/book",
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(book)
      }
    );
    setName('');
    setDescription('');
  }

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{color:"blue"}}><u>Add book</u></h1>
        <form className={classes.root} noValidate autoComplete="off">
          <TextField
            id="outlined-basic" label="Название" variant="outlined" fullWidth
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <TextField id="outlined-basic" label="Описание" variant="outlined" fullWidth
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
          <Button disabled={!formValid} variant="contained" color="primary" onClick={handleClick}>
            Отправить
          </Button>
        </form>
      </Paper>
    </Container>
  );
}
