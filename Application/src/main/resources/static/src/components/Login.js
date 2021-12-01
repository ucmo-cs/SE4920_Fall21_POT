import React from "react";
import { Route } from "react-router";
import { Link } from "react-router-dom";
import './styling.css';

// function OAuth(props){
//   //connect to db
//   //check if user exists, then check if password is correct
//   //if neither, dont change page and dont auth
//   //if user exists AND 
//   console.log(props.history)
// }

function Login(props) {

  function Authorization() {
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

export default Login;
