import { Button, FormControl, Grid, InputLabel, Select } from "@material-ui/core";
import TextField from "@material-ui/core/TextField";
import React, { useState } from "react";
import { useHistory } from "react-router";
import { User } from "../../../models/User";
import { ersCreateNewReimbursement } from "../../../remote/ers/ers-functions";

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

  let history = useHistory();

  const handleAmountChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeAmount(e.target.value);
  };

  const handleDescriptionChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeDescription(e.target.value);
  };

  const handleReceiptChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeReceipt(e.target.value);
  };

  const handleReimbursementTypeChange = (
    e: any
  ) => {
    changeReimbursementType(e.target.value);
  };

  // Synthetic event is from react for creating a standard event between different browsers
  const handleSubmitReimbursement = async (e: React.SyntheticEvent) => {
    // Prevent default html submit behaviour
    e.preventDefault();
    // Send username and password along with token
    try {
      let reimbursement = await ersCreateNewReimbursement(
        amount,
        description,
        receipt,
        props.currentUser.userId.toString(),
        reimbursementType
      );
      console.log(reimbursement);
      history.push("/employee");
    } catch (e) {
      console.log(e.message);
    }
  };

  return (
    <div>
      <h3>New Reimbursement Request</h3>
      <form onSubmit={handleSubmitReimbursement} noValidate autoComplete="off">
        <Grid
          container
          direction="column"
          justify="flex-start"
          alignItems="center"
          spacing={2}
        >
          <Grid item>
            <TextField
              value={amount}
              onChange={handleAmountChange}
              id="amount-input"
              type="text"
              label="Amount"
              variant="outlined"
              autoComplete="off"
            />
          </Grid>
          <Grid item>
            <TextField
              value={description}
              onChange={handleDescriptionChange}
              id="description-input"
              type="text"
              label="Description"
              variant="outlined"
              autoComplete="off"
            />
          </Grid>
          <Grid item>
            <TextField
              value={receipt}
              onChange={handleReceiptChange}
              id="receipt-input"
              type="text"
              label="Receipt"
              variant="outlined"
              autoComplete="off"
            />
          </Grid>
          <Grid item>
            <FormControl variant="outlined">
              <InputLabel htmlFor="outlined-type-native-simple">Type</InputLabel>
              <Select
                native
                value={reimbursementType}
                onChange={handleReimbursementTypeChange}
                label="Reimbursement Type"
                inputProps={{
                  name: "type",
                  id: "outlined-type-native-simple",
                }}
              >
                <option aria-label="None" value="" />
                <option value={1}>Lodging</option>
                <option value={2}>Travel</option>
                <option value={3}>Food</option>
                <option value={4}>Other</option>
              </Select>
            </FormControl>
          </Grid>
          <Grid item>
            <Button type="submit" variant="contained" color="primary">
              Submit
            </Button>
          </Grid>
        </Grid>
      </form>
    </div>
  );
};
