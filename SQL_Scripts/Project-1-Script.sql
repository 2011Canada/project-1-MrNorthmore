-- First drop schema and re-create if necessary to allow for full script execution

drop schema if exists ers cascade;
create schema ers;
set schema 'ers';

create table ers_reimbursement_status(
	reimb_status_id serial unique not null primary key,
	reimb_status varchar(10) not null
);

create table ers_reimbursement_type(
	reimb_type_id serial unique not null primary key,
	reimb_type varchar(10) not null
);

create table ers_user_roles(
	ers_user_role_id serial unique not null primary key,
	user_role varchar(10) not null
);

create table ers_users(
	ers_users_id serial unique not null primary key,
	ers_username text unique not null,
	ers_password text not null,
	user_first_name text not null,
	user_last_name text not null,
	user_email text unique not null,
	user_role_id int not null references ers_user_roles(ers_user_role_id)
);

create table ers_reimbursement(
	reimb_id serial unique not null primary key,
	reimb_amount numeric(10,2) not null,
	reimb_submitted timestamp not null,
	reimb_resolved timestamp,
	reimb_description text,
	reimb_receipt text,
	reimb_author int references ers_users(ers_users_id),
	reimb_resolver int references ers_users(ers_users_id),
	reimb_status_id int references ers_reimbursement_status(reimb_status_id),
	reimb_type_id int references ers_reimbursement_type(reimb_type_id)
);

INSERT INTO ers_user_roles (user_role)
	VALUES ('Admin');

INSERT INTO ers_user_roles (user_role)
	VALUES ('Employee');

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	VALUES ('admin', 'pass', 'Matthew', 'Northmore', 'mattnorthmore@outlook.com', 1);

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	VALUES ('user', 'pass', 'test', 'user', 'test@outlook.com', 2);

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
	VALUES ('user2', 'pass', 'test', 'user', 'test2@outlook.com', 2);

insert into ers_reimbursement_type (reimb_type)
	values ('Lodging');
	
insert into ers_reimbursement_type (reimb_type)
	values ('Travel');
	
insert into ers_reimbursement_type (reimb_type)
	values ('Food');	
	
insert into ers_reimbursement_type (reimb_type)
	values ('Other');

insert into ers_reimbursement_status (reimb_status)
	values ('Pending');

insert into ers_reimbursement_status (reimb_status)
	values ('Approved');

insert into ers_reimbursement_status (reimb_status)
	values ('Rejected');

insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (100.50, Now(), NULL, 'test description', 'test receipt', 2, NULL, 2, 1);
	
insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (100.50, Now(), NULL, 'test description', 'test receipt', 2, NULL, 1, 1);

select * from ers_reimbursement;

select * from ers_reimbursement_type;









