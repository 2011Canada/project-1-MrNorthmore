import React, { useState } from "react";
import { Button, Grid, TextField } from "@material-ui/core";
import { ersLogin } from "../../remote/ers/ers-functions";

export const LoginForm: React.FunctionComponent<any> = (props) => {
  const [username, changeUsername] = useState("");
  const [password, changePassword] = useState("");
  const [user, changeUser] = useState();

  const handleUsernameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changeUsername(e.target.value);
  };

  // This will handle the password change and update state
  const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    changePassword(e.target.value);
  };

  // Synthetic event is from react for creating a standard event between different browsers
  const handleSubmitLogin = async (e: React.SyntheticEvent) => {
    // Prevent default html submit behaviour
    e.preventDefault();
    // Send username and password along with token
    try {
      let user = await ersLogin(username, password);
      changeUser(user);
    } catch (e) {
      changePassword("");
      console.log(e.message);
    }
  };

  return (
    <form onSubmit={handleSubmitLogin}>
      <Grid
        container
        direction="column"
        justify="flex-start"
        alignItems="center"
        spacing={2}
      >
        <Grid item>
          <TextField
            value={username}
            onChange={handleUsernameChange}
            id="username-input"
            type="text"
            label="Username"
            variant="outlined"
          />
        </Grid>
        <Grid item>
          <TextField
            value={password}
            onChange={handlePasswordChange}
            id="password-input"
            type="password"
            label="Password"
            variant="outlined"
          />
        </Grid>
        <Grid item>
          <Button type="submit" variant="contained" color="primary">
            Submit
          </Button>
        </Grid>
      </Grid>
    </form>
  );
};
