CREATE TABLE topic (
  id bigint NOT NULL AUTO_INCREMENT,
  title varchar(50) NOT NULL,
  message varchar(300) NOT NULL,
  creation_date datetime NOT NULL,
  status varchar(50) NOT NULL,
  course_id bigint NOT NULL,
  author_id bigint NOT NULL,
  primary key (id),
  foreign key (course_id) references course (id),
  foreign key (author_id) references author (id)
);
