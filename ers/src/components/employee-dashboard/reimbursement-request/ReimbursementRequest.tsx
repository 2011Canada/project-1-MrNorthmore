import TextField from "@material-ui/core/TextField";
import React, { useState } from "react";
import { User } from "../../../models/User";

interface IReimbursementRequestProps {
  updateCurrentUser: (u: User) => void;
  currentUser: User;
}

export const ReimbursementRequest: React.FunctionComponent<IReimbursementRequestProps> = (
  props
) => {
  const [amount, changeAmount] = useState("");
  const [description, changeDescription] = useState("");
  const [receipt, changeReceipt] = useState("");
  const [reimbursementType, changeReimbursementType] = useState("");

  const handleAmountChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeAmount(e.target.value);
  };

  const handleDescriptionChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeAmount(e.target.value);
  };

  const handleReceiptChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeAmount(e.target.value);
  };

  const handleReimbursementTypeChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeAmount(e.target.value);
  };

  return (
    <div>
      <h3>New Reimbursement Request</h3>
      <form>
        <TextField
          value={amount}
          onChange={handleAmountChange}
          id="amount-input"
          type="text"
          label="Password"
          variant="outlined"
          autoComplete="off"
        />
      </form>
    </div>
  );
};
