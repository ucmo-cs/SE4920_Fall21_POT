import { Navbar } from 'react-bootstrap';
import { ProSidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import 'react-pro-sidebar/dist/css/styles.css';
import { Link } from 'react-router-dom';
import './styling.css';

function Sidebar(props) {
  return (
    <div>
      <ProSidebar>
  <Menu iconShape="square">
    <MenuItem icon={""}><Link to="/home" className="navbar-brand">Home</Link></MenuItem>
    <MenuItem icon={""}><Link to="/calendar" className="navbar-brand">Calendar</Link></MenuItem>
    <MenuItem icon={""}><Link to="/organization" className="navbar-brand">Organization</Link></MenuItem>
    
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




