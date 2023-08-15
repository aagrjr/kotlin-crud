CREATE TABLE author (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  primary key (id)
);

insert into author(id, name, email) values (1, 'Joao', 'joao@email.com');
insert into author(id, name, email) values (2, 'test', 'test@email.com');