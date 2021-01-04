import { Button, ButtonGroup } from "@material-ui/core";
import React from "react";
import { Redirect, Route, Switch, useHistory, useRouteMatch } from "react-router-dom";
import { User } from "../../models/User";
import { AllReimbursementHistory } from "./all-reimbursement-history/AllReimbursementHistory";
import { ReimbursementReview } from "./reimbursement-review/ReimbursementReview";

interface IManagerDashboardProps {
  updateCurrentUser: (u:User) => void
  currentUser: User
}

export const ManagerDashboard: React.FunctionComponent<IManagerDashboardProps> = (props) => {

  let { path, url } = useRouteMatch();

  let history = useHistory();

  const reviewReimbursementNav = () => {
    history.push(`${url}/review-reimbursement`);
  };

  const allReimbursementsNav = () => {
    history.push(`${url}/all-reimbursements`);
  };

  const signoutNav = () => {
    history.push(`/`);
  };

  return (
    (props.currentUser) ?
    <div>
      <h1>Welcome to Manager dashboard</h1>
      <h2>What would you like to do?</h2>
      <ButtonGroup color="primary" aria-label="outlined primary button group">
        <Button
          variant="contained"
          color="primary"
          onClick={reviewReimbursementNav}
        >
          Approve/Reject Reimbursements
        </Button>
        <Button
          variant="contained"
          color="primary"
          onClick={allReimbursementsNav}
        >
          View All Reimbursements
        </Button>
        <Button variant="contained" color="primary" onClick={signoutNav}>
          Signout
        </Button>
      </ButtonGroup>
      
      <Switch>
        <Route path={`${path}/review-reimbursement`}>
          <ReimbursementReview currentUser={props.currentUser} updateCurrentUser={props.updateCurrentUser} />
        </Route>
        <Route path={`${path}/all-reimbursements`}>
          <AllReimbursementHistory currentUser={props.currentUser} updateCurrentUser={props.updateCurrentUser} />
        </Route>
      </Switch>

    </div>
    :
    <Redirect to="/" />
  );
};
