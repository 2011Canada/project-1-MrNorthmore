import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import { LoginForm } from './components/login/LoginForm';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Router>
          <Switch>
            <Route path="/login">
              <LoginForm />
            </Route>
          </Switch>
        </Router>
      </header>
    </div>
  );
}

export default App;
