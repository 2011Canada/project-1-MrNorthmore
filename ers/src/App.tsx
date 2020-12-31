import React, { useState } from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import { LoginForm } from './components/login/LoginForm';
import { EmployeeDashboard } from './components/employee-dashboard/EmployeeDashboard';
import { ManagerDashboard } from './components/manager-dashboard/ManagerDashboard';
import { User } from './models/User';

function App() {

  // All the lifted states we will need to provide to children components. Ex. the current logged in user
  const [user, changeUser] = useState<User>();


  return (
    <div className="App">
      <header className="App-header">
        <Router>
          <Switch>
            <Route exact path="/">
              <LoginForm currentUser={user} updateCurrentUser={changeUser} />
            </Route>
            <Route path="/employee">
              <EmployeeDashboard currentUser={user} updateCurrentUser={changeUser} />
            </Route>
            <Route path="/manager">
              <ManagerDashboard currentUser={user} updateCurrentUser={changeUser} />
            </Route>
          </Switch>
        </Router>
      </header>
    </div>
  );
}

export default App;
