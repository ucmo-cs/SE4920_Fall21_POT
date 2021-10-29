import React from "react";
import Sidebar from "./Sidebar";
import "./styling.css";


function Login(props) {
  return (
    <div>
      <div className="left-child">
      <Sidebar/>
      </div>
      <div className="right-child">
      <h1>Upcoming Meetings</h1>
      None.
      
      <h1>Important Announcements</h1>
      None.
      </div>
    </div>
  );
}

export default Login;
