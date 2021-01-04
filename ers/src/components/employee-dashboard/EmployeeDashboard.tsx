import { Button, ButtonGroup } from "@material-ui/core";
import React from "react";
import {
  Redirect,
  Route,
  Switch,
  useHistory,
  useRouteMatch,
} from "react-router-dom";
import { User } from "../../models/User";
import { ReimbursementHistory } from "./reimbursement-history/ReimbursementHistory";
import { PendingReimbursements } from "./reimbursement-pending/PendingReimbursements";
import { ReimbursementRequest } from "./reimbursement-request/ReimbursementRequest";

interface IEmployeeDashboardProps {
  updateCurrentUser: (u: User) => void;
  currentUser: User;
}

export const EmployeeDashboard: React.FunctionComponent<IEmployeeDashboardProps> = (
  props
) => {
  let { path, url } = useRouteMatch();

  let history = useHistory();

  const newReimbursementNav = () => {
    history.push(`${url}/new-reimbursement`);
  };

  const reimbursementHistoryNav = () => {
    history.push(`${url}/reimbursement-history`);
  };

  const pendingReimbursementNav = () => {
    history.push(`${url}/pending-reimbursements`);
  };

  const signoutNav = () => {
    history.push(`/`);
  };

  return props.currentUser ? (
    <div>
      <h1>Welcome to employee dashboard</h1>
      <h2>What would you like to do?</h2>
      <ButtonGroup color="primary" aria-label="outlined primary button group">
        <Button
          variant="contained"
          color="primary"
          onClick={newReimbursementNav}
        >
          New Reimbursement
        </Button>
        <Button
          variant="contained"
          color="primary"
          onClick={reimbursementHistoryNav}
        >
          History
        </Button>
        <Button
          variant="contained"
          color="primary"
          onClick={pendingReimbursementNav}
        >
          Pending
        </Button>
        <Button variant="contained" color="primary" onClick={signoutNav}>
          Signout
        </Button>
      </ButtonGroup>

      <Switch>
        <Route path={`${path}/new-reimbursement`}>
          <ReimbursementRequest
            currentUser={props.currentUser}
            updateCurrentUser={props.updateCurrentUser}
          />
        </Route>
        <Route path={`${path}/reimbursement-history`}>
          <ReimbursementHistory
            currentUser={props.currentUser}
            updateCurrentUser={props.updateCurrentUser}
          />
        </Route>
        <Route path={`${path}/pending-reimbursements`}>
          <PendingReimbursements
            currentUser={props.currentUser}
            updateCurrentUser={props.updateCurrentUser}
          />
        </Route>
      </Switch>
    </div>
  ) : (
    <Redirect to="/" />
  );
};
