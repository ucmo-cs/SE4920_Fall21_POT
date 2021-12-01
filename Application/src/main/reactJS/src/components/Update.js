import React from "react";
import Sidebar from "./Sidebar";

function Update(props) {
  return (
    <div>
      <div className="left-child">
      <Sidebar/>
      </div>
      <div className="right-child">
      This is Update page.
      </div>
    </div>
  );
}

export default Update;
