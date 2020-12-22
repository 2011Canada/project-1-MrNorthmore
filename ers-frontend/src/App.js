import "./App.css";
import TextField from '@material-ui/core/TextField';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1> Welcome to the Employee Reimbursement System</h1>
        <h6> Please login below to continue </h6>
      </header>
    </div>
  );
}

function Login() {
  <form className={classes.root} noValidate autoComplete="off">
    <TextField id="outlined-basic" label="Outlined" variant="outlined" />
  </form>;
}

export default App;
