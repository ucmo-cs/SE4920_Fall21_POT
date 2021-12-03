import React from "react";
//import '../App.css';
import {Container, Nav, Navbar} from 'react-bootstrap';
//import 'bootstrap/dist/css/bootstrap.min.css';
import './styling.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

function HeaderNav(props) {
  return (
    <div className="nav-bar">
    <Navbar>
      <Container fluid>
      <Nav >
        {//<Link to="/home" className="navbar-brand">Home</Link>
        }
        <Link to="/login" className="navbar-link">Login</Link>
        {/* <Link to="/account" className="navbar-link">Account</Link> */}
        {//<Link to="/calendar" className="navbar-brand">Calendar</Link>
        }
        
        </Nav>
      </Container>
    </Navbar>
    
  </div>
  );
}

export default HeaderNav;
