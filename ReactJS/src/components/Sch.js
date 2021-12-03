import React from "react";
import {Card} from "react-bootstrap";
import "./styling.css";



function Sch(props) {

  const{ id, user_id, start_time, end_time, description} = props.sch;

 

  return (
    
    <div>
      <Card>
        <Card.Body>
          <Card.Title>
               {id}  :  {start_time}   :  {description}
           </Card.Title>
        </Card.Body>
      </Card>
    </div>
  );
}

export default Sch;
