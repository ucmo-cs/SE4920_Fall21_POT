import logo from './logo.svg';
// import './App.css';
import './styling.css';
import Nav from './components/Nav';
import ContentBox from './components/ContentBox';
import placeholder from './placeholder.png'
import HeaderNav from './components/HeaderNav';

function App() {
  return (
    <div className="parent">
      <div className="top-bar">
        <img src={placeholder}></img>
        <HeaderNav/>
      </div> 
      <Nav/>
      <ContentBox/>
    </div>
  );
}

export default App;
