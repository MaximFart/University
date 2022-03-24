drop table if exists groups, timetable, course, student, student_course, teacher, department, university cascade;
create table groups (
    id integer primary key,
    name varchar(255) not null
);

create table course (
    id serial primary key,
    name varchar(255) not null,
    description varchar(255) not null
);

create table student (
    id serial primary key,
    groups_id int references groups(id) on delete cascade,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    age int not null
);

create table student_course (
    id serial primary key,
    student_id int references student(id) on delete cascade,
    course_id int references course(id)on delete cascade
);

create table teacher (
    id serial primary key,
    email varchar(255),
    position varchar(255),
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    age int not null
);

create table timetable (
    id serial primary key,
    date date,
    groups_id int references groups(id) on delete cascade,
    teacher_id int references teacher(id) on delete cascade,
    course_id int references course(id) on delete cascade
);

create table department (
    id serial primary key,
    name varchar(255) not null
);

create table university (
    id serial primary key,
    name varchar(255) not null
);
