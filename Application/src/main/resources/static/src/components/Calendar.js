import Sidebar from "./Sidebar";
import { Component } from "react";
import React, { useState } from 'react';
import {Calendar as Cal} from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

function Calendar(props) {

  const [value, setValue] = useState(new Date());
  //this.state = { Text:"This is a test.!"}
  //this.componentRef = React.createRef();

  var today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth()+1;
  var yyyy = today.getFullYear();
  var farthest = mm+2;

  if(farthest >12){
    farthest-=12;
    yyyy+=1;
  }

  function changeText() {
    var next_times = ""+"";
    document.getElementById('1').innerHTML =(today.getHours()+1)+"<br/>";
    document.getElementById('1').innerHTML +="Hello";
  }

  function onChange(nextValue) {
    //setValue(nextValue);
  }

  function onDay(){
    changeText();
  }

  function time_change(){
    var time_hours = document.getElementById('time_hours').value;
    var time_minutes = document.getElementById('time_minutes').value;
    time_hours = parseInt(time_hours);
    
    if(time_hours+5>12){
      document.getElementById('1').innerHTML = time_hours +":"+time_minutes+"AM";
    }
    else{
      document.getElementById('1').innerHTML = time_hours +":"+time_minutes+"PM";
    }
    //alert("Arrived in hour_change");
  }


  return (
    <div>
      
      <div className="left-child">
      <Sidebar/>
      </div>
      <div className="right-child">
      <Cal
        onChange={onChange}
        value={value}
        minDate= {today}
        maxDate= {new Date(yyyy+'-'+farthest+'-'+dd)}
        onClickDay={onDay}
      />
      <br/>Meeting time: 
      <select name="time_hours" id="time_hours" onChange={time_change}>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
      </select>:
      <select name="time_minutes" id="time_minutes" onChange={time_change}>
        <option value="00">00</option>
        <option value="15">15</option>
        <option value="30">30</option>
        <option value="45">45</option>
      </select>
      <br/>
      <div id='1'>8:00AM</div>
      </div>
      
    </div>
  );
}

export default Calendar;