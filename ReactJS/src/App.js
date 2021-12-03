import React from "react";
import logo from './logo.svg';
//import './App.css';
//import 'styling.css';
import HeaderNav from './components/HeaderNav';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container} from 'react-bootstrap';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import Calendar from "./components/Calendar";
import Account from "./components/Account";
import Meeting from "./components/Meeting";
import Update from "./components/Update";
import Organizations from "./components/Organizations";
import UsersOrg from "./components/UsersOrg";
import Schedule from "./components/Schedule";

/*function setToken(userToken) {
  console.log("tokenTEst")
  console.log(userToken)
  sessionStorage.setItem('token', JSON.stringify(userToken));
}

function getToken() {
  const tokenString = sessionStorage.getItem('token');
  const userToken = JSON.parse(tokenString);
  return userToken?.token
}*/

function App() {

  
  //const token = getToken();
  //const [token, setToken] = useState();
  //const {token, setToken} = useToken();

  /*if(!token){
    return <Login setToken = {setToken}></Login>
  }*/

  return (
    <div style={{background:'#67b1e2'}}>
      <div className="nav-bar"><HeaderNav/></div>
      <div className="content-box"><Container>
      <Route path="/login" exact={true} component={Login}/>
      <Route path="/home" exact={true} component={Home}/>
      <Route path="/calendar" exact={true} component={Calendar}/>
      <Route path="/account" exact={true} component={Account}/>
      <Route path="/" exact={true} component={Login}/>
      <Route path="/meeting" exact={true} component={Meeting}/>
      <Route path="/account/update" exact={true} component={Update}/>
      <Route path="/organization" exact={true} component={UsersOrg}/>
      <Route path="/schedule" exact={true} component={Schedule}/>
      
      </Container></div>
    </div>
  );
}
{//<Container>
      //<Route />
      //</Container>
      //Dinesh Nagulapelly
      //dxn63100@ucmo.edu
      //^^GA, knows react
    }
export default App;
