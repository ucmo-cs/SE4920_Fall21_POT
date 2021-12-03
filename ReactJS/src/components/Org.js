import React from "react";
import {Card} from "react-bootstrap";
import "./styling.css";



function Org(props) {

  const{ id, name, owner_id, description} = props.org;

 

  return (
    
    <div>
      <Card>
        <Card.Body>
          <Card.Title>
               {id}  :  {name}   :  {owner_id}   :  {description}
           </Card.Title>
        </Card.Body>
      </Card>
    </div>
  );
}

export default Org;
