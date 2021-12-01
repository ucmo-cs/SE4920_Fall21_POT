import React, { useState } from "react";
import { Route } from "react-router";
import { Link } from "react-router-dom";
import './styling.css';
import { withRouter } from "react-router";
import Variables from "./Variables";

function Login(props) {
  //testing variable.
  Variables.email = "toon@toon.com";

  function Authorization() {
    var username = document.getElementById('email').value;
    var password = document.getElementById('pass').value;
    alert(username+" "+password);
    console.log(props.history)
    props.history.push("/home")
  }

  return (
    <div className="login">
        <div className="login-email">
          <label title="Email" className="login-email-label">Email: </label>
          <input type="email" className="login-email-input" title="Email" id="email"></input>
        </div>
        <div className="login-pass">
          <label title="Password" className="login-pass-label">Password: </label>
          <input type="password" className="login-pass-input" title="Password" id="pass"></input>
        </div>
        <button type="submit" onClick={Authorization}>Submit</button>
      </div>
  );
}

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
