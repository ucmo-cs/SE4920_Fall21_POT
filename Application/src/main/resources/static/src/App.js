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

function App() {
  return (
    <div>
      <div><HeaderNav/></div>
      <div><Container>
      <Route path="/login" exact={true} component={Login}/>
      <Route path="/home" exact={true} component={Home}/>
      <Route path="/calendar" exact={true} component={Calendar}/>
      <Route path="/account" exact={true} component={Account}/>
      <Route path="/" exact={true} component={Login}/>
      <Route path="/meeting" exact={true} component={Meeting}/>
      
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
