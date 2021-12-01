import React from "react";
import Sidebar from "./Sidebar";

function Account(props) {

function current_name(){
  
}

function gotoUpdate(){
    console.log(props.history)
    props.history.push("/account/update")
}

  return (
    <div>
      <div className="left-child">
        <Sidebar/>
      </div>
      <div className="right-child">
        <h1>Account</h1>
        <h2>Name</h2><div id="name">Hi1</div>
        <h2>Email</h2><div id="email">Hi2</div>
        <h3>Password</h3><div id="password">Hi3</div><br/>
        <button type="submit" onClick={gotoUpdate}>Change Information</button>
      </div>
    </div>
  );
}

export default Account;
