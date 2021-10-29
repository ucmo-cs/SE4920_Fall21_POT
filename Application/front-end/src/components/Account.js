import React from "react";
import Sidebar from "./Sidebar";

function Account(props) {
  return (
    <div>
      <div className="left-child">
        <Sidebar/>
      </div>
      <div className="right-child">
        <h1>Account</h1>
        <h2>Name</h2>
        <h2>Email</h2>
        Make Changes
      </div>
    </div>
  );
}

export default Account;
