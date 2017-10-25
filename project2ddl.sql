--under octocat admin user create new user for project 2
CREATE USER project2 IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO project2;
ALTER USER project2 QUOTA 100M ON 'USERS';

--under project2 user
--Lookup table 1-User, 2-Scrum Master, 3-Developer, 4-QA
CREATE TABLE role_type(
 rt_id INT,
 rt_name VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(rt_id)
);
/
--Lookup table 1-Backlog, 2-To Do, 3-In Progress, 4-Test, 5-Verify, 6-Done
CREATE TABLE lane_type(
 lt_id INT,
 lt_name VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(lt_id)
);
/
CREATE TABLE scrum_user(
 su_id INT,
 rt_id INT DEFAULT 1 NOT NULL,
 su_fn VARCHAR2(4000),
 su_ln VARCHAR2(4000),
 su_username VARCHAR2(4000) UNIQUE NOT NULL,
 su_password VARCHAR2(4000) NOT NULL,
 PRIMARY KEY(su_id),
 FOREIGN KEY(rt_id) REFERENCES role_type(rt_id)
);
/
CREATE TABLE board(
 board_id INT,
 board_name VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(board_id)
);
/
CREATE TABLE story(
 story_id INT,
 board_id INT NOT NULL,
 lt_id INT DEFAULT 1 NOT NULL,
 story_name VARCHAR2(4000) NOT NULL,
 story_points INT DEFAULT 0 NOT NULL,
 story_desc VARCHAR2(4000),
 last_move_date DATE,
 PRIMARY KEY(story_id),
 FOREIGN KEY(board_id) REFERENCES board(board_id),
 FOREIGN KEY(lt_id) REFERENCES lane_type(lt_id)
);
/
CREATE TABLE task(
 task_id INT,
 story_id INT NOT NULL,
 task_desc VARCHAR2(4000) NOT NULL,
 PRIMARY KEY(task_id),
 FOREIGN KEY(story_id) REFERENCES story(story_id)
);
/
CREATE TABLE chart(
 chart_id INT,
 board_id INT NOT NULL,
 chart_title VARCHAR2(4000),
 start_date DATE NOT NULL,
 end_date DATE NOT NULL,
 PRIMARY KEY(chart_id),
 FOREIGN KEY(board_id) REFERENCES board(board_id)
);
/
CREATE TABLE user_comment(
 uc_id INT,
 story_id INT NOT NULL,
 su_id INT NOT NULL,
 chart_title VARCHAR2(4000),
 uc_date DATE NOT NULL,
 PRIMARY KEY(uc_id),
 FOREIGN KEY(story_id) REFERENCES story(story_id),
 FOREIGN KEY(su_id) REFERENCES scrum_user(su_id)
);
/
CREATE TABLE board_user_join(
 board_id INT,
 su_id INT,
 PRIMARY KEY(board_id, su_id),
 FOREIGN KEY(board_id) REFERENCES board(board_id),
 FOREIGN KEY(su_id) REFERENCES scrum_user(su_id)
);
/
--Sequences and triggers for primary keys
CREATE SEQUENCE scrum_user_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE story_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE task_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE chart_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_comment_seq START WITH 1 INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER scrum_user_seq_trg
BEFORE INSERT ON scrum_user
FOR EACH ROW
BEGIN
IF :new.su_id IS NULL THEN
  SELECT scrum_user_seq.NEXTVAL INTO :new.su_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER board_seq_trg
BEFORE INSERT ON board
FOR EACH ROW
BEGIN
IF :new.board_id IS NULL THEN
  SELECT board_seq.NEXTVAL INTO :new.board_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER story_seq_trg
BEFORE INSERT ON story
FOR EACH ROW
BEGIN
IF :new.story_id IS NULL THEN
  SELECT story_seq.NEXTVAL INTO :new.story_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER task_seq_trg
BEFORE INSERT ON task
FOR EACH ROW
BEGIN
IF :new.task_id IS NULL THEN
  SELECT task_seq.NEXTVAL INTO :new.task_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER chart_seq_trg
BEFORE INSERT ON chart
FOR EACH ROW
BEGIN
IF :new.chart_id IS NULL THEN
  SELECT chart_seq.NEXTVAL INTO :new.chart_id FROM dual;
END IF;
END;
/
CREATE OR REPLACE TRIGGER user_comment_seq_trg
BEFORE INSERT ON user_comment
FOR EACH ROW
BEGIN
IF :new.uc_id IS NULL THEN
  SELECT user_comment_seq.NEXTVAL INTO :new.uc_id FROM dual;
END IF;
END;
/
