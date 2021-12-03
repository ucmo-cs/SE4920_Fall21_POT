import { Navbar } from 'react-bootstrap';
import { ProSidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
// import 'react-pro-sidebar/dist/css/styles.css';
import { Link } from 'react-router-dom';
import './styling.css';

function Sidebar(props) {
  return (
    <div className="sidebar">
      <ProSidebar >
  <Menu iconShape="square">
    <MenuItem icon={""} style={{listStyle: 'none', fontSize:'large'}}><Link to="/home" className="sidebar-options">Home</Link></MenuItem>
    <MenuItem icon={""} style={{listStyle: 'none', fontSize:'large'}}><Link to="/account" className="sidebar-options">Account</Link></MenuItem>
    <MenuItem icon={""} style={{listStyle: 'none', fontSize:'large'}}><Link to="/calendar" className="sidebar-options">Calendar</Link></MenuItem>
    <MenuItem icon={""} style={{listStyle: 'none', fontSize:'large'}}><Link to="/schedule" className="sidebar-options">Schedule</Link></MenuItem>
    <MenuItem icon={""} style={{listStyle: 'none', fontSize:'large'}}><Link to="/organization" className="sidebar-options">Organization</Link></MenuItem>
    
    {/*<SubMenu title="Components" icon={""}>
      <MenuItem>Component 1</MenuItem>
      <MenuItem>Component 2</MenuItem>
  </SubMenu>*/}
  </Menu>
      </ProSidebar>
    </div>
  );
}
{//<Nav className="me-auto"></Nav>
}
export default Sidebar;




