import React, { useEffect, useState } from "react";
import "./styling.css";
import Org from "./Org";



function Organizations(props) {


  const[organizations, setOrganization] = useState([]);

 
  useEffect(()=>{
    fetch("http://localhost:8080/organization", {method:"GET"})
    .then(res =>res.json())
    .then(res =>{setOrganization(res);})
    },[])




  return (
    
    <div>
      {organizations.map(org => <Org key={org.id} org = {org}> </Org>)}      
    </div>
  );
}

export default Organizations;
