import { Component } from "react";
import Landing from "./Landing";
import Login from "./Login";

class ContentBox extends Component{
  constructor(props){
    super(props);
    this.state = {
      page: "login",
    };
    this.loginFunction = this.loginFunction.bind(this);
  }

  loginFunction() {
    this.setState({page:"landing"});
  }

  render(){
    return(
      <div className="content-box">
         {this.state.page === "login" && 
          <Login loginFunction={this.loginFunction} />
         }
         {this.state.page === "landing" &&
          <Landing/>
         }
      </div>
    )
  }
}

export default ContentBox;