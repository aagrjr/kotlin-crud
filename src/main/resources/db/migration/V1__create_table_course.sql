CREATE TABLE COURSE (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  category varchar(50) NOT NULL,
  primary key (id)
);

insert into COURSE(id, name, category) values (1, 'JPA in 50 Steps', 'Spring Data JPA');
insert into COURSE(id, name, category) values (2, 'Kotlin', 'kotlin');