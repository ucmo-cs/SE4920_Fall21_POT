import React, { useEffect, useState } from "react";
import "./styling.css";
import Org from "./Org";
import Sidebar from "./Sidebar";



function UsersOrg(props) {

    

  
  const[organizations, setOrganization] = useState([]);

  var boo = "";
  var organs = organizations.map(org => <Org key={org.id} org = {org}> </Org>);
  var noOrgans = "This user does not have any organizations."
  if(organizations.length != 0){
    boo = organs;
  }
  if(organizations.length == 0){
      boo = noOrgans;
  }
  

    useEffect(()=>{
        fetch("http://localhost:8080/user/"+window.name+"/organization", {method:"GET"})
        .then(res =>res.json())
        .then(res =>{setOrganization(res);})
        },[])



  return (
    
    <div>
      <div className="left-child">
        <Sidebar/>  
      </div>
      <div>
          {boo}
      </div>
            
    </div>
  );
}

export default UsersOrg;