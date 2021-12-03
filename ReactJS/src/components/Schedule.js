import React, { useEffect, useState } from "react";
import "./styling.css";
import Sch from "./Sch";
import Sidebar from "./Sidebar";



function Schedule(props) {


  const[schedules, setSchedule] = useState([]);

 
  useEffect(()=>{
    fetch("http://localhost:8080/schedule/user/" + window.name, {method:"GET"})
    .then(res =>res.json())
    .then(res =>{setSchedule(res);})
    },[])




  return (
    
    <div>
      <div className="left-child">
        <Sidebar/>  
      </div>
      <div>
        {schedules.map(sch => <Sch key={sch.id} sch = {sch}> </Sch>)}      
      </div>
      
    </div>
  );
}

export default Schedule;