DROP TABLE IF EXISTS task;

CREATE TABLE task (
    uuid varchar(255) PRIMARY KEY,
    title varchar(255),
    description text,
    dead_line Datetime,
    priority varchar(255)
);

INSERT INTO task (uuid, title, description, dead_line, priority) VALUES
('A0EEBC99-9C0B-4EF8-BB6D-6BB9BD380A18', 'Task 1', 'Description 1', '2021-12-31 23:59:59', 'HIGH'),
('A0EEBC99-9C0B-4EF8-BB6D-6BB9BD380A19', 'Task 2', 'Description 2', '2021-12-31 23:59:59', 'MEDIUM'),
('A0EEBC99-9C0B-4EF8-BB6D-6BB9BD380A17', 'Task 3', 'Description 3', '2021-12-31 23:59:59', 'LOW');