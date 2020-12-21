-- First drop schema and re-create if necessary to allow for full script execution

drop schema if exists ers cascade;
create schema ers;
set schema 'ers';

create table ers_reimbursement_status(
	reimb_status_id serial unique not null primary key,
	reimb_status numeric(10,2) not null
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
	reimb_resolved timestamp not null,
	reimb_description text,
	reimb_receipt text,
	reimb_author int references ers_users(ers_users_id),
	reimb_resolver int references ers_users(ers_users_id),
	reimb_status_id int references ers_reimbursement_status(reimb_status_id),
	reimb_type_id int references ers_reimbursement_type(reimb_type_id)
);
