import React, { useState } from "react";
import { Route } from "react-router";
import { Link } from "react-router-dom";
import './styling.css';
import { withRouter } from "react-router";
import Variables from "./Variables";
import { Form } from "react-bootstrap";
import Button from "@restart/ui/esm/Button";


function Login(props) {

  const[user, setUser] = useState({
    email:'',
    password:'',
  });


  const changeValue=(e)=>{
    setUser({
     ...user, [e.target.name]:e.target.value  
    });
    console.log(e.target.name + " name "  );
    console.log(e.target.value + " value " );
  }

  const submitLogin =(e)=>{
    e.preventDefault();
    fetch("http://localhost:8080/login", {
      method:"POST",
      headers:{
        "Content-Type" : "application/json"
      },
      body: JSON.stringify(user)
    })
    .then(res=>{
        console.log(1,res);
          return res.json();
      })
    .then(res=>{
      console.log(res)
      if(res!==false){
        window.name = res;
        props.history.push('/home');
      }else{
        alert('Email and/or password is incorrect, try again.');
      }
    
    });

  }

  return (
    <div className="login-box">
    <Form onSubmit = {submitLogin} style={{width: '40%'}}>
      <Form.Group controlId="formBasicEmail">
        <Form.Label style={{fontSize:'1.5em'}}>Email</Form.Label>
        <Form.Control type="text" placeholder="email" onChange = {changeValue} name="email"/>
      </Form.Group>

      <Form.Group controlId="formBasicEmail">
        <Form.Label style={{fontSize:'1.5em'}}>Password</Form.Label>
        <Form.Control type="text" placeholder="password" onChange = {changeValue} name="password"/>
      </Form.Group>

      <Button variant="primary" type="submit" id="login-button">
        Submit  
      </Button>
    </Form>
    </div>
  );
}


// function Login(props) {
  //testing variable.
  // Variables.email = "toon@toon.com";

  
  // function Authorization() {
  //   var username = document.getElementById('email').value;
  //   var password = document.getElementById('pass').value;
  //   alert(username+" "+password);
  //   console.log(props.history)
  //   props.history.push("/home")
  // }

  // return (

  //   <div className="login">
  //       <div className="login-email">
  //         <label title="Email" className="login-email-label">Email: </label>
  //         <input type="email" className="login-email-input" title="Email" id="email"></input>
  //       </div>
  //       <div className="login-pass">
  //         <label title="Password" className="login-pass-label">Password: </label>
  //         <input type="password" className="login-pass-input" title="Password" id="pass"></input>
  //       </div>
  //       <button type="submit" onClick={Authorization}>Submit</button>
  //     </div>
  // );


// function OAuth(props){
//   //connect to db
//   //check if user exists, then check if password is correct
//   //if neither, dont change page and dont auth
//   //if user exists AND 
//   console.log(props.history)
// }
/*
function Login(propps) {
  const [username, setUserName] = useState();
  const [password, setPassword] = useState();

  function Authorization(props) {
    //console.log(props.history)
    this.props.history.push("/home")
    /*if(username==null || password==null)
    {

      alert("problem");
    }
    else{
      handleSubmit();
    }
  }
  const handleSubmit = (e) => {
    //e.preventDefault();
    const user = { username, password };
    
/*
    fetch('http://localhost:8080/jpa/login', {
   
      method: 'POST',
      headers: { 
        'Content-Type': 'application/json',
        'Accept': 'application/json' },
      body: JSON.stringify(user),
      credentials : 'same-origin',
      }).then((res) => {
        console.log(res)     
        return res.json(); 
      }).then((res) =>{
        console.log(res);
        setToken(res);
      });

  }
  

  return (
    <div className="login">
        <div id="error_message"></div>
        <div className="login-email">
          <label title="Email" className="login-email-label">Email: </label>
          <input type="email" className="login-email-input" title="Email" id="email" onChange = {(e)=> setUserName(e.target.value)}></input>
        </div>
        <div className="login-pass">
          <label title="Password" className="login-pass-label">Password: </label>
          <input type="password" className="login-pass-input" title="Password" id="pass" onChange = {(e)=> setPassword(e.target.value)}></input>
        </div>
        <button type="submit" onClick={Authorization}>Submit</button>
      </div>
  );
  }*/

export default Login;
