import Sidebar from "./Sidebar";
import React, { useState, useEffect } from "react";

function Account(props) {

  function gotoUpdate(){
    console.log(props.history)
    props.history.push("/account/update")
  }

  const[user, setUser] = useState({
    id:'',
    email:'',
    username:'',
    password:'',
    priority:'',
    locked:'',
    online:''
  });

 
  useEffect(()=>{
    fetch(("http://localhost:8080/user/" + window.name), {method:"GET"})
    .then(res =>res.json())
    .then(res =>{setUser(res);})
    },[])


  return (
    <div>
      <div className="left-child">
        <Sidebar/>
      </div>
      <div className="right-child">

        <h1>Account</h1>
        <h2>Id</h2><div id="name">{user.id}</div>
        <h2>Name</h2><div id="name">{user.username}</div>
        <h2>Email</h2><div id="email">{user.email}</div>
        <h3>Password</h3><div id="password">{user.password}</div><br/>
        <button type="submit" onClick={gotoUpdate} id="change-button">Change Information</button>
      </div>
    </div>
  );
}

export default Account;
