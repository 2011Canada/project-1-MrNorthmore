import React from "react";
import { Link, Redirect } from "react-router-dom";
import { User } from "../../models/User";

interface IManagerDashboardProps {
  updateCurrentUser: (u:User) => void
  currentUser: User
}

export const ManagerDashboard: React.FunctionComponent<IManagerDashboardProps> = (props) => {
  return (
    (props.currentUser) ?
    <div>
      <h1>Welcome to Manager dashboard</h1>
      <h2>What would you like to do?</h2>
      <ul>
        <li>
          <Link to={`/`}>View All Requests</Link>
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
    </div>
    :
    <Redirect to="/" />
  );
};
