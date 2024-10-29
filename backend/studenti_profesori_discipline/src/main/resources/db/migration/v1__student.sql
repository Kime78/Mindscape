CREATE SEQUENCE if not exists student_seq increment 1;
CREATE TABLE if not exists student (
    id integer,
    name varchar(40),
    surname varchar(40),
    email varchar(100),
    an_studiu integer,
    grupa integer,
    ciclu_studii smallint,
    PRIMARY KEY (id)
)