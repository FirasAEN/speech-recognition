DROP DATABASE University;

create DATABASE University;

use University;

CREATE TABLE Major(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL
);

INSERT INTO Major(name) VALUES ('Computer Science');
INSERT INTO Major(name) VALUES ('Math');
INSERT INTO Major(name) VALUES ('Astronomy');

CREATE TABLE Student (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  major_id INTEGER NOT NULL DEFAULT 0,
  FOREIGN KEY (major_id) REFERENCES Major (id)
);

INSERT INTO Student(name, major_id) VALUES ('Rida AEN', 1);
INSERT INTO Student(name, major_id) VALUES ('Firas AEN', 3);
INSERT INTO Student(name, major_id) VALUES ('Karim AEN', 2);

CREATE TABLE Course(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  course VARCHAR(50) NOT NULL
);

INSERT INTO Course(course) VALUES ('Java 101');
INSERT INTO Course(course) VALUES ('C# 101');
INSERT INTO Course(course) VALUES ('Algorithms 101');


CREATE TABLE Student_Course(
  student_id INTEGER NOT NULL,
  course_id INTEGER NOT NULL,
  FOREIGN KEY (student_id) REFERENCES Student (id),
  FOREIGN KEY (course_id) REFERENCES Course (id),
  PRIMARY KEY (student_id, course_id)
);

INSERT INTO Student_Course(student_id, course_id) VALUES (1, 1);
INSERT INTO Student_Course(student_id, course_id) VALUES (1, 3);
INSERT INTO Student_Course(student_id, course_id) VALUES (2, 2);
INSERT INTO Student_Course(student_id, course_id) VALUES (3, 3);
INSERT INTO Student_Course(student_id, course_id) VALUES (3, 1);

CREATE TABLE Schedule(
  course_id INTEGER NOT NULL,
  from_hour VARCHAR(20) NOT NULL DEFAULT '00:00',
  to_hour VARCHAR(20) NOT NULL DEFAULT '00:00',
  room VARCHAR(50) NOT NULL DEFAULT 'some where inside',
  day VARCHAR(50) NOT NULL DEFAULT 'not the weekend',
  FOREIGN KEY (course_id) REFERENCES Course (id),
  PRIMARY KEY (from_hour, to_hour, course_id, day)
);


INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (1, '13:00', '15:00', 'Mon');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (2, '13:00', '15:00', 'Tue');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (3, '13:00', '15:00', 'Wed');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (1, '10:00', '13:00', 'Mon');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (1, '10:00', '13:00', 'Thu');

# Queries

# get students and their major
SELECT stu.name, maj.name FROM Student as stu
  INNER JOIN Major as maj
    ON stu.major_id = maj.id
ORDER BY stu.name;

# get student and major by student id
# get students and their major
SELECT stu.name, maj.name FROM Student as stu
  INNER JOIN Major as maj
    ON stu.major_id = maj.id
WHERE stu.id = 1;

# get students and courses enrolled in
SELECT stu.name, maj.name, cou.course, sc.from_hour, sc.to_hour, sc.room, sc.day from Student as stu
  INNER JOIN Course as cou
  INNER JOIN Student_Course
  INNER JOIN Schedule as sc
  INNER JOIN Major as maj
    ON Student_Course.student_id = stu.id
       AND Student_Course.course_id = cou.id
       AND sc.course_id = cou.id
       AND stu.major_id = maj.id
ORDER BY stu.name;

# get student and courses enrolled in by student id
SELECT stu.name as student_name, cou.course, cou.id as course_id
from Student as stu
  INNER JOIN Course as cou
  INNER JOIN Student_Course
    ON Student_Course.student_id = stu.id
       AND Student_Course.course_id = cou.id
WHERE stu.id = 1;

# get schedules for course
SELECT sc.from_hour, sc.to_hour, sc.day, sc.room from Course as cou
  INNER JOIN Schedule as sc
    on cou.id = sc.course_id
WHERE cou.id = 1;


# get courses and schedules enrolled in by student id
SELECT cou.course, sc.from_hour, sc.to_hour, sc.room, sc.day
from Course as cou
  INNER JOIN Student as stu
  INNER JOIN Student_Course
  INNER JOIN Schedule as sc
  INNER JOIN Major as maj
    ON Student_Course.student_id = stu.id
       AND Student_Course.course_id = cou.id
       AND sc.course_id = cou.id
       AND stu.major_id = maj.id
WHERE stu.id = 1;
