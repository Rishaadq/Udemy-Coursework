create table disorders (
    id int not null,
    name varchar(255),
    description varchar(255),
    primary key (id));

create table symptoms (
   id int not null,
   name varchar(255),
   description varchar(255),
   primary key (id));