import React, { useState } from "react";
import { Link, Redirect, Route, Switch, useRouteMatch } from "react-router-dom";
import { User } from "../../models/User";
import { ReimbursementRequest } from "./reimbursement-request/ReimbursementRequest";

interface IEmployeeDashboardProps {
  updateCurrentUser: (u:User) => void
  currentUser: User
}

export const EmployeeDashboard: React.FunctionComponent<IEmployeeDashboardProps> = (props) => {

  const [user, changeUser] = useState<User>();

  let { path, url } = useRouteMatch();

  return (
    (props.currentUser) ?
    <div>
      <h1>Welcome to employee dashboard</h1>
      <h2>What would you like to do?</h2>
      <ul>
        <li>
          <Link to={`${url}/new-reimbursement`}>Submit New Request</Link>
        </li>
        <li>
          <Link to={`/`}>View History</Link>
        </li>
        <li>
          <Link to={`/`}>View Pending</Link>
        </li>
        <li>
          <Link to={`/`}>Signout</Link>
        </li>
      </ul>
      
      <Switch>
        <Route path={`${path}/new-reimbursement`}>
          <ReimbursementRequest currentUser={user} updateCurrentUser={changeUser} />
        </Route>
      </Switch>
    </div>
    :
    <Redirect to="/" />
  );
};
