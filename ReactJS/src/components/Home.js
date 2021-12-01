import React from "react";
import Sidebar from "./Sidebar";
import "./styling.css";



function Login(props) {

  function check_meetings(){
    //stuff to pull meetings from server
    var server_input = "Created by check_meetings";
    var pulled_meeting = server_input;
    return pulled_meeting;
  }
  function check_announcements(){
    //stuff to pull announcements from server
    var server_input = "Created by check_announcements";
    var pulled_meeting = server_input;
    return pulled_meeting;
  }

  return (
    
    <div>
      
      <div className="left-child">
      <Sidebar/>
      </div>
      <div className="right-child">
      <h1>Upcoming Meetings</h1>
      <div id="upcoming_meetings">{check_meetings()}</div>
      
      <h1>Important Announcements</h1>
      <div id="important_announcements">{check_announcements()}</div>
      </div>
    </div>
  );
}

export default Login;
