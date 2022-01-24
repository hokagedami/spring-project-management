drop table if exists project CASCADE;
drop table if exists employee CASCADE;
drop table if exists project_employee CASCADE;
create table employee (employee_id bigint not null auto_increment, email varchar(255), first_name varchar(255), last_name varchar(255), primary key (employee_id));
create table project (project_id bigint not null auto_increment, description varchar(255), name varchar(255), stage varchar(255), primary key (project_id));
create table project_employee (project_id bigint not null, employee_id bigint not null,
 foreign key(project_id) references employee(employee_id), foreign key(project_id) references project(project_id));
 