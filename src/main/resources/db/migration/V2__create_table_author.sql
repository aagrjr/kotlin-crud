CREATE TABLE AUTHOR (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  primary key (id)
);

insert into AUTHOR(id, name, email) values (1, 'Joao', 'joao@email.com');
insert into AUTHOR(id, name, email) values (2, 'test', 'test@email.com');