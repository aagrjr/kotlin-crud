CREATE TABLE answer (
           id bigint NOT NULL AUTO_INCREMENT,
           message varchar(300) NOT NULL,
           creation_date datetime NOT NULL,
           topic_id bigint NOT NULL,
           author_id bigint NOT NULL,
           solution boolean NOT NULL,
           primary key (id),
           foreign key (author_id) references author (id),
           foreign key (topic_id) references topic (id)
);