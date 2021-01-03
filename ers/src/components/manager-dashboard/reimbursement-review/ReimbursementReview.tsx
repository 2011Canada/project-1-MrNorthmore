import {
  TableContainer,
  Paper,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  ButtonGroup,
  Button,
} from "@material-ui/core";
import React, { useEffect, useState } from "react";
import { Reimbursement } from "../../../models/Reimbursement";
import { User } from "../../../models/User";
import { ersGetAllPendingReimbursements, ersUpdateReimbursement } from "../../../remote/ers/ers-functions";

interface IReimbursementReviewProps {
  updateCurrentUser: (u: User) => void;
  currentUser: User;
}

export const ReimbursementReview: React.FunctionComponent<IReimbursementReviewProps> = (
  props
) => {
  const [reimbursements, changeReimbursements] = useState<Reimbursement[]>();

  useEffect(() => {
    const getReimbursements = async () => {
      let reimbs = await ersGetAllPendingReimbursements();
      console.log(reimbs);
      changeReimbursements(reimbs);
    };
    getReimbursements();
  }, []);

  const approveReimbursement = async (reimbursementId:number) => {
    try {
      let user = await ersUpdateReimbursement(reimbursementId, props.currentUser.userId, 2);
      console.log(user)
      const getReimbursements = async () => {
        let reimbs = await ersGetAllPendingReimbursements();
        console.log(reimbs);
        changeReimbursements(reimbs);
      };
      getReimbursements();
      
    } catch (e) {
      console.log(e.message);
    }
  }

  const rejectReimbursement = async (reimbursementId:number) => {
    try {
      let user = await ersUpdateReimbursement(reimbursementId, props.currentUser.userId, 3);
      console.log(user)
      const getReimbursements = async () => {
        let reimbs = await ersGetAllPendingReimbursements();
        console.log(reimbs);
        changeReimbursements(reimbs);
      };
      getReimbursements();
    } catch (e) {
      console.log(e.message);
    }
  }

  return (
    <TableContainer component={Paper}>
      <Table aria-label="simple table">
        <TableHead>
          <TableRow>
          <TableCell>Id</TableCell>
            <TableCell align="center">Amount</TableCell>
            <TableCell align="center">Description</TableCell>
            <TableCell align="center">Date Submitted</TableCell>
            <TableCell align="center">Submitted By</TableCell>
            <TableCell align="center">Type</TableCell>
            <TableCell align="center">Status</TableCell>
            <TableCell align="center">Reject/Approve</TableCell>
          </TableRow>
        </TableHead>
        {}
        <TableBody>
          {reimbursements ? (
            reimbursements.map((row) => (
              <TableRow key={row.reimbursementId}>
                <TableCell component="th" scope="row" align="center">
                  {row.reimbursementId}
                </TableCell>
                <TableCell align="center">{row.reimbursementAmt}</TableCell>
                <TableCell align="center">{row.reimbursementDesc}</TableCell>
                <TableCell align="center">
                  {row.reimbursementSubmitted}
                </TableCell>
                <TableCell align="center">{row.reimbursementAuthor}</TableCell>
                <TableCell align="center">
                  {row.reimbursementType === 1
                    ? "Lodging"
                    : row.reimbursementType === 2
                    ? "Travel"
                    : row.reimbursementType === 3
                    ? "Food"
                    : "Other"}
                </TableCell>
                <TableCell align="center">
                  {row.reimbursementStatus === 1
                    ? "Pending"
                    : row.reimbursementStatus === 2
                    ? "Approved"
                    : "Rejected"}
                </TableCell>
                <TableCell align="center">
                  <ButtonGroup
                    color="primary"
                    aria-label="outlined primary button group"
                  >
                    <Button onClick={() => {rejectReimbursement(row.reimbursementId)}}>Reject</Button>
                    <Button onClick={() => {approveReimbursement(row.reimbursementId)}}>Approve</Button>
                  </ButtonGroup>
                </TableCell>
              </TableRow>
            ))
          ) : (
            <TableRow key={1}>
              <TableCell component="th" scope="row">
                Loading...
              </TableCell>
            </TableRow>
          )}
        </TableBody>
      </Table>
    </TableContainer>
  );
};
