
-- Вставка начальных данных в таблицу Employee
INSERT INTO employee (employee_name) VALUES ('John1');
INSERT INTO employee (employee_name) VALUES ('John2');
INSERT INTO employee (employee_name) VALUES ('John3');

-- Вставка начальных данных в таблицу Project
INSERT INTO project (project_name) VALUES ('Spring1');
INSERT INTO project (project_name) VALUES ('Spring2');
INSERT INTO project (project_name) VALUES ('Spring3');

-- Вставка начальных данных в таблицу Employee_Project
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 1);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (1, 3);
INSERT INTO employee_project (employee_id, project_id) VALUES (2, 2);
INSERT INTO employee_project (employee_id, project_id) VALUES (3, 3);


-- Вставка начальных данных в таблицу Timesheet
INSERT INTO timesheet (timesheet_project_id, timesheet_employee_id, minutes, created_at) VALUES (1, 1, 800, '2022-01-01');
INSERT INTO timesheet (timesheet_project_id, timesheet_employee_id, minutes, created_at) VALUES (2, 1, 200, '2022-01-02');
INSERT INTO timesheet (timesheet_project_id, timesheet_employee_id, minutes, created_at) VALUES (2, 2, 300, '2022-01-03');
INSERT INTO timesheet (timesheet_project_id, timesheet_employee_id, minutes, created_at) VALUES (3, 2, 500, '2022-01-04');
INSERT INTO timesheet (timesheet_project_id, timesheet_employee_id, minutes, created_at) VALUES (3, 3, 70, '2022-01-05');

-- Вставка начальных данных в таблицу roles
INSERT INTO roles (role_name) VALUES ('ADMIN');
INSERT INTO roles (role_name) VALUES ('USER');
INSERT INTO roles (role_name) VALUES ('REST');

-- Вставка начальных данных в таблицу users
INSERT INTO users (login, password) VALUES ('admin', 'admin'); -- password: admin
INSERT INTO users (login, password) VALUES ('user', 'user'); -- password: user
INSERT INTO users (login, password) VALUES ('rest', 'rest');

-- INSERT INTO users (login, password) VALUES ('admin', '$2a$10$D8tZnqQKpiopDh/nAE3y5u/Z9PT2eNH8nh7GVlXflAb7HrH8jtM.G'); -- password: admin
-- INSERT INTO users (login, password) VALUES ('user', '$2a$10$DnqD3/ZycOd/JYxqPUVJ6u0U2bc9H1BLmPBFnF7DF9UB5s9vRtpwK'); -- password: user
-- INSERT INTO users (login, password) VALUES ('rest', '$2a$10$ksJ1OqKqJltq6wz/9LJvce/kZu4qZpXt6icWnOi1f78HKJdK1Qqlm'); -- password: rest

-- Вставка начальных данных в таблицу user_roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- admin -> ADMIN
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- user -> USER
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3); -- rest -> REST

-- UPDATE users SET password = '$2a$10$...hashed_password...' WHERE login = 'admin';
-- UPDATE users SET password = '$2a$10$...hashed_password...' WHERE login = 'user';
-- UPDATE users SET password = '$2a$10$...hashed_password...' WHERE login = 'rest';



-- -- Вставка начальных данных в таблицу users
-- INSERT INTO users (login, password) VALUES ('admin', '$2a$12$3P6UhS68ORdDAv8jGm5CP.zHnRCS8XrYi1XgDzQRTi3EeXh8Htayy');
-- INSERT INTO users (login, password) VALUES ('user', 'hashed_user');
-- INSERT INTO users (login, password) VALUES ('rest', 'hashed_rest');

--INSERT INTO timesheet (project_id, minutes) VALUES (1, 800);
--INSERT INTO timesheet (project_id, minutes) VALUES (2, 200);
--INSERT INTO timesheet (project_id, minutes) VALUES (2, 300);
--INSERT INTO timesheet (project_id, minutes) VALUES (3, 500);
--INSERT INTO timesheet (project_id, minutes) VALUES (3, 70);