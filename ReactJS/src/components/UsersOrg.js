import React, { useEffect, useState } from "react";
import "./styling.css";
import Org from "./Org";
import Sidebar from "./Sidebar";



function UsersOrg(props) {

  const[org, setOrg] = useState({
    id:'',
    name:'',
    owner_id:'',
    description:''
  });

  
  const[organizations, setOrganization] = useState([]);

  
  

    useEffect(()=>{
        fetch("http://localhost:8080/user/"+window.name+"/organization", {method:"GET"})
        .then(res =>res.json())
        .then(res =>{setOrg(res);})
        },[])

        var boo = "";
        var organs = "";
        var noOrgans = "This user does not have any organizations."
        if(organizations.length != 0){
          boo = organs;
        }
        if(organizations.length == 0){
            boo = noOrgans;
        }

  return (
    
    <div>
      <div className="left-child">
        <Sidebar/>  
      </div>
      <div className="right-child">
        <h2>Id</h2><div id="id">{org.id}</div>
        <h2>Name</h2><div id="name">{org.name}</div>
        <h2>Description</h2><div id="email">{org.description}</div><br/>
       
      </div>
            
    </div>
  );
}

export default UsersOrg;