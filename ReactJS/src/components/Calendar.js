import Sidebar from "./Sidebar";
import { Component } from "react";
import React, { useState } from 'react';
import {Calendar as Cal} from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

function Calendar(props) {

  const [value, setValue] = useState(new Date());

  var today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth()+1;
  var yyyy = today.getFullYear();
  var farthest = mm+2;
  var far_yyyy = yyyy;
  var clicked_day;
  var clicked_month;
  var clicked_year;
  var time_hours;
  var time_minutes;

  if(farthest >12){
    farthest-=12;
    far_yyyy+=1;
  }

  function onChange(nextValue) {
    //setValue(nextValue);
  }

  function onDay(value){
    //var clicked_date = onClickDay.getDate();
    clicked_day = value.getDate();
    clicked_month = value.getMonth()+1;
    clicked_year = value.getFullYear();

    document.getElementById('clicked_date').innerHTML = clicked_month+"/"+clicked_day +"/"+ clicked_year;
    //document.getElementById('1').innerHTML +="Hello";
  }

  function time_change(){
    time_hours = document.getElementById('time_hours').value;
    time_minutes = document.getElementById('time_minutes').value;
    time_hours = parseInt(time_hours);
    
    if(time_hours+5>12 && time_hours!=12){
      document.getElementById('clicked_time').innerHTML = time_hours +":"+time_minutes+"AM";
    }
    else{
      document.getElementById('clicked_time').innerHTML = time_hours +":"+time_minutes+"PM";
    }
    //alert("Arrived in hour_change");
  }

  function create_meeting(){
    alert("Created meeting at the following time: " + document.getElementById('clicked_date').innerHTML+" at " 
    +document.getElementById('clicked_time').innerHTML );
  }

  return (
    
    <div>
      <div className="left-child">
      <Sidebar/>
      </div>
      <div className="right-child">
        <div id="cal-box">
      <Cal
        //onChange={onChange}
        value={value}
        minDate= {today}
        maxDate= {new Date(far_yyyy+'-'+farthest+'-'+dd)}
        onClickDay={value,onDay}
      />
      </div>
      <div id="meeting-info">
      <br/>Meeting time: <p></p>
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
      <div id='clicked_date'>{mm+"/"+dd +"/"+ yyyy}</div>
      <div id='clicked_time'>8:00AM</div>
      </div>
      <button type="submit" onClick={create_meeting} id="meeting-button">Create Meeting</button>
      </div>
      
    </div>
  );
}

export default Calendar;