import React, { useEffect, useState } from "react";
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
    var server_input = "There are no announcements, have a great day!";
    var pulled_meeting = server_input;
    return pulled_meeting;
  }

  const[closestSchedule, setClosestSchedule] = useState({
    id:'',
    user_id:'',
    start_time:'',
    end_time:'',
    description:''
  });

  useEffect(()=>{
    fetch(("http://localhost:8080/schedule/user/" + window.name + "/closest"), {method:"GET"})
    .then(res =>res.json())
    .then(res =>{setClosestSchedule(res);})
    },[])

  

  return (
    
    <div>
      
      <div className="left-child">
      <Sidebar/>
      </div>
      <div className="right-child">
      <h1>Closest Schedule</h1>
      <h6>
      <div id="closeId">Id: {closestSchedule.id}</div>
      <div id="closeStart">Start: {closestSchedule.start_time}</div>
      <div id="closeEnd">End: {closestSchedule.end_time}</div>
      <div id="closeDesc">Description: {closestSchedule.description}</div>
      </h6>
      
      <h1>Important Announcements</h1>
      <div id="important_announcements">{check_announcements()}</div>
      </div>
    </div>
  );
}

export default Login;
