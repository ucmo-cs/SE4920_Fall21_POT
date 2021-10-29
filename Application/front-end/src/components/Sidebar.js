import { ProSidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import 'react-pro-sidebar/dist/css/styles.css';
import './styling.css';

function Sidebar(props) {
  return (
    <div>
      <ProSidebar>
  <Menu iconShape="square">
    <MenuItem icon={""}>Dashboard</MenuItem>
    <SubMenu title="Components" icon={""}>
      <MenuItem>Component 1</MenuItem>
      <MenuItem>Component 2</MenuItem>
    </SubMenu>
  </Menu>
      </ProSidebar>
    </div>
  );
}
{//<Nav className="me-auto"></Nav>
}
export default Sidebar;




