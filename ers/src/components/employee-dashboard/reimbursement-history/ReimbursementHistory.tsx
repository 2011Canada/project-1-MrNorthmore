import {
  TableContainer,
  Paper,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
} from "@material-ui/core";
import React, { useEffect, useState } from "react";
import { Reimbursement } from "../../../models/Reimbursement";
import { User } from "../../../models/User";
import { ersGetAllReimbursementsByUser } from "../../../remote/ers/ers-functions";

interface IReimbursementHistoryProps {
  updateCurrentUser: (u: User) => void;
  currentUser: User;
}

export const ReimbursementHistory: React.FunctionComponent<IReimbursementHistoryProps> = (
  props
) => {
  const [reimbursements, changeReimbursements] = useState<Reimbursement[]>();

  useEffect(() => {
    const getReimbursements = async () => {
      let reimbs = await ersGetAllReimbursementsByUser(
        props.currentUser.userId.toString()
      );
      console.log(reimbs);
      changeReimbursements(reimbs);
    };
    getReimbursements();
  }, []);

  return (
    <>
    <div>
      <h3>Reimbursement History</h3>
    </div>
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
            <TableCell align="center">Date Resolved</TableCell>
            <TableCell align="center">Resolved By</TableCell>
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
                  {row.reimbursementResolved}
                </TableCell>
                <TableCell align="center">
                  {row.reimbursementResolver}
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
    </>
  );
};
