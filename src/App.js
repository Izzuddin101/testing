import React from 'react'; 
import logo from './logo.svg'; 
import './App.css'; 

function App() {

  return (
    
    <div className="App">
      
      <header className="App-header">
        
        <img src={logo} className="App-logo" alt="logo" />
        
        <h1>Welcome to My React App</h1> {/* Change the heading */}
        
        <p>This is a sample React application created for learning purposes.</p>
        
        <a className="App-link" href="https://reactjs.org" target="_blank" rel="noopener noreferrer">Learn React</a>

      </header>
    
    </div>
  
  );

}

export default App;