DROP DATABASE University;

create DATABASE University;

use University;

CREATE TABLE Major(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL
);

INSERT INTO Major(name) VALUES ('Computer Science');
INSERT INTO Major(name) VALUES ('Math');
INSERT INTO Major(name) VALUES ('Physics');
INSERT INTO Major(name) VALUES ('Chemistry');
INSERT INTO Major(name) VALUES ('Economics');

CREATE TABLE Student (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  registration_year INTEGER NOT NULL,
  average_gpa FLOAT NOT NULL,
  major_id INTEGER NOT NULL DEFAULT 0,
  FOREIGN KEY (major_id) REFERENCES Major (id)
);

INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('John', 'Smith', 2005, 2.8, 1);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('James', 'Anderson', 2015, 1.6, 2);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('Jenna', 'Hilbert', 2006, 3.2, 3);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('Stephen', 'Colbert', 2009, 2.7, 4);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('Neil', 'deGrasse Tyson', 2016, 3.5, 5);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('Chriss', 'Pratt', 2016, 3.5, 1);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('John', 'Oliver', 2008, 2.8, 2);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('James', 'Gaffigan', 2018, 2.8, 3);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('John', 'Stewart', 2007, 2.9, 4);
INSERT INTO Student(first_name, last_name, registration_year, average_gpa, major_id) VALUES ('John', 'Stewart', 2010, 2.4, 5);


CREATE TABLE Course(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  course_name VARCHAR(50) NOT NULL DEFAULT "",
  teacher_name VARCHAR(50) NOT NULL DEFAULT ""
);

INSERT INTO Course(course_name, teacher_name) VALUES ('Image processing', 'Lina Al-Khansa');
INSERT INTO Course(course_name, teacher_name) VALUES ('Network security', 'Kassem Ahmad');
INSERT INTO Course(course_name, teacher_name) VALUES ('Analog signal processing', 'Lina Al-Khansa');
INSERT INTO Course(course_name, teacher_name) VALUES ('Programming 101', 'Rabih Wazneh');
INSERT INTO Course(course_name, teacher_name) VALUES ('Routing and Switching', 'Walid Fahes');
INSERT INTO Course(course_name, teacher_name) VALUES ('Data communication', 'Jamal Haidar');
INSERT INTO Course(course_name, teacher_name) VALUES ('Marketting', 'Karim Kobeisy');
INSERT INTO Course(course_name, teacher_name) VALUES ('Entrepreneurship', 'Mohammad Tirani');
INSERT INTO Course(course_name, teacher_name) VALUES ('C#: Introduction', 'Ahmad Kobeisy');
INSERT INTO Course(course_name, teacher_name) VALUES ('Algorithms 101', 'Ahmad Khalifeh');


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
INSERT INTO Student_Course(student_id, course_id) VALUES (2, 4);
INSERT INTO Student_Course(student_id, course_id) VALUES (2, 7);
INSERT INTO Student_Course(student_id, course_id) VALUES (3, 3);
INSERT INTO Student_Course(student_id, course_id) VALUES (3, 9);
INSERT INTO Student_Course(student_id, course_id) VALUES (3, 4);
INSERT INTO Student_Course(student_id, course_id) VALUES (4, 3);
INSERT INTO Student_Course(student_id, course_id) VALUES (4, 6);
INSERT INTO Student_Course(student_id, course_id) VALUES (5, 6);
INSERT INTO Student_Course(student_id, course_id) VALUES (5, 10);
INSERT INTO Student_Course(student_id, course_id) VALUES (6, 10);
INSERT INTO Student_Course(student_id, course_id) VALUES (7, 7);
INSERT INTO Student_Course(student_id, course_id) VALUES (7, 8);
INSERT INTO Student_Course(student_id, course_id) VALUES (8, 8);
INSERT INTO Student_Course(student_id, course_id) VALUES (8, 2);
INSERT INTO Student_Course(student_id, course_id) VALUES (9, 7);
INSERT INTO Student_Course(student_id, course_id) VALUES (9, 2);
INSERT INTO Student_Course(student_id, course_id) VALUES (9, 5);
INSERT INTO Student_Course(student_id, course_id) VALUES (10, 4);
INSERT INTO Student_Course(student_id, course_id) VALUES (10, 5);
INSERT INTO Student_Course(student_id, course_id) VALUES (10, 10);
INSERT INTO Student_Course(student_id, course_id) VALUES (10, 1);

CREATE TABLE Schedule(
  course_id INTEGER NOT NULL,
  from_hour VARCHAR(20) NOT NULL DEFAULT '00:00',
  to_hour VARCHAR(20) NOT NULL DEFAULT '00:00',
  room VARCHAR(50) NOT NULL DEFAULT 'Common room A',
  day VARCHAR(50) NOT NULL DEFAULT 'not the weekend',
  FOREIGN KEY (course_id) REFERENCES Course (id),
  PRIMARY KEY (from_hour, to_hour, course_id, day)
);


INSERT INTO Schedule(course_id, from_hour, to_hour, day, room) VALUES (1, '13:00', '15:00', 'Mon', 'A105');
INSERT INTO Schedule(course_id, from_hour, to_hour, day, room) VALUES (2, '13:00', '15:00', 'Tue', 'B206');
INSERT INTO Schedule(course_id, from_hour, to_hour, day, room) VALUES (3, '13:00', '15:00', 'Wed', 'B252');
INSERT INTO Schedule(course_id, from_hour, to_hour, day, room) VALUES (1, '10:00', '13:00', 'Mon', 'C145');
INSERT INTO Schedule(course_id, from_hour, to_hour, day, room) VALUES (1, '10:00', '13:00', 'Thu', 'D544');
INSERT INTO Schedule(course_id, from_hour, to_hour, day, room) VALUES (4, '08:00', '10:00', 'Thu', 'E515');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (4, '08:00', '10:00', 'Fri');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (4, '16:00', '18:00', 'Mon');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (4, '08:00', '10:00', 'Tue');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (5, '08:00', '10:00', 'Fri');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (5, '09:00', '11:00', 'Thu');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (6, '08:00', '10:00', 'Fri');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (6, '08:00', '11:00', 'Wed');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (7, '08:00', '10:00', 'Mon');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (8, '08:00', '10:00', 'Mon');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (9, '08:00', '10:00', 'Mon');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (9, '12:00', '14:00', 'Mon');
INSERT INTO Schedule(course_id, from_hour, to_hour, day) VALUES (10, '08:00', '10:00', 'Mon');

# Queries

# get students and their major
SELECT stu.first_name, maj.name FROM Student as stu
  INNER JOIN Major as maj
    ON stu.major_id = maj.id
ORDER BY stu.first_name;

# get student and major by student id
# get students and their major
SELECT stu.first_name, maj.name FROM Student as stu
  INNER JOIN Major as maj
    ON stu.major_id = maj.id
WHERE stu.id = 1;

# get students and courses enrolled in
SELECT stu.first_name, maj.name, cou.course_name, sc.from_hour, sc.to_hour, sc.room, sc.day from Student as stu
  INNER JOIN Course as cou
  INNER JOIN Student_Course
  INNER JOIN Schedule as sc
  INNER JOIN Major as maj
    ON Student_Course.student_id = stu.id
       AND Student_Course.course_id = cou.id
       AND sc.course_id = cou.id
       AND stu.major_id = maj.id
ORDER BY stu.first_name;

# get student and courses enrolled in by student id
SELECT stu.first_name as student_name, cou.course_name, cou.id as course_id
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
SELECT cou.course_name, sc.from_hour, sc.to_hour, sc.room, sc.day
from Course as cou
  INNER JOIN Student as stu
  INNER JOIN Student_Course
  INNER JOIN Schedule as sc
  INNER JOIN Major as maj
    ON Student_Course.student_id = stu.id
       AND Student_Course.course_id = cou.id
       AND sc.course_id = cou.id
       AND stu.major_id = maj.id
WHERE stu.id = 10;
