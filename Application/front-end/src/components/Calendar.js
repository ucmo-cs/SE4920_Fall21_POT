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
    alert("Do something.");
    //this.setState({Text: "New State Achieved."});
  }

  function onChange(nextValue) {
    //setValue(nextValue);
  }

  function onDay(){
    changeText();
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
      <div id='1'>Sorta Working</div>
      </div>
      
    </div>
  );
}

export default Calendar;