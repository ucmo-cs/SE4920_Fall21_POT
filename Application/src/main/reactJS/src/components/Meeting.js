import React from "react";
import Sidebar from "./Sidebar";

function Meeting(props) {
  return (
    <div>
      <div className="left-child">
      <Sidebar/>
      </div>
      <div className="right-child">
      This is Meeting page.
      </div>
    </div>
  );
}

export default Meeting;
