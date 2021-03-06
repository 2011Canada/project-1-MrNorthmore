# Employee Reimbursement System

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used
- Java (version 8)
- Servlets (version 3.1.0)
- JDBC
- Log4j (version 2.11.2)
- PostgreSQL (version 42.2.18)
- Apache Tomcat (version 9.0.41)
- React
- Axios
- Material UI
- CSS

## Features

### Current Features
> Employee Features
- Can login
- Can submit new reimbursement requests
- Can view pending requests
- Can view rejected requests
- Can view history of submitted requests

> Manager Features
- Can login
- Can view all reimbursement history
- Can view submitted requests
- Can approve/reject requests

### Future Features
- Improve user experience with better user error reporting
- Including more unit testing (both frontend and backend)
- Implement proper password hashing + salting
- Include feature for receipt uploading
- Add more endpoints to rest API with correct REST principles

## Getting Started
### Backend
1. Run ```git clone https://github.com/2011Canada/project-1-MrNorthmore.git``` to clone the project
2. Import the maven project into an IDE of your choice
3. Download an apache tomcat distribution from http://tomcat.apache.org/ and import into IDE
4. Create an Amazon RDS instance and using a tool of choice, configure the DB schema with the SQL scripts provided
5. Configure your database environment variables in your server run configuration
6. Run the server

### Frontend
1. Run ```git clone https://github.com/2011Canada/project-1-MrNorthmore.git``` to clone the project (same as clone as above)
2. Run ```cd ers```
3. Run ```npm install```
4. Run ```npm start```
5. Navigate to ```http://localhost:8080```

## Usage
- Login with either employee or manager credentials and be redirected to appropriate dashboard
![Login Screen](https://github.com/2011Canada/project-1-MrNorthmore/blob/main/Screenshots/login_screen.png)
- As an employee...
  - Navigate to New Reimbursement page to submit a new request
  - Navigate to Pending page to view pending requests
  - Navigate to History page to view all past requests
![Employee Dashboard](https://github.com/2011Canada/project-1-MrNorthmore/blob/main/Screenshots/employee_dashboard.png)
- As a manager...
  - Navigate to Approve/Reject page to approve or reject requests
  - Navigate to View All Reimbursements page to view history of all requests
![Manager Dashboard](https://github.com/2011Canada/project-1-MrNorthmore/blob/main/Screenshots/manager_dashboard.png)
- On either page, hit the Signout button to logout and return to the login screen

## Contributors
> Matthew Northmore (myself)

## License
This project uses the following license: [GNU GENERAL PUBLIC LICENSE](<https://www.gnu.org/licenses/gpl-3.0.en.html>)
