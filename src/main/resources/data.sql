-- Insert Departments
INSERT INTO department (id, name, budget) VALUES
(1, 'IT', 100000),
(2, 'HR', 50000),
(3, 'Finance', 70000),
(4, 'Marketing', 80000),
(5, 'Operations', 60000);

-- Insert Employees
INSERT INTO employee (id, name, email, department_id, date_of_joining, salary, manager_id) VALUES
(1, 'John Doe', 'john.doe@example.com', 1, '2022-06-15', 75000, NULL),
(2, 'Jane Smith', 'jane.smith@example.com', 1, '2023-01-10', 68000, 1),
(3, 'Mike Johnson', 'mike.johnson@example.com', 2, '2021-11-20', 55000, NULL),
(4, 'Emily Davis', 'emily.davis@example.com', 3, '2020-09-05', 72000, 3),
(5, 'Robert Brown', 'robert.brown@example.com', 4, '2019-08-12', 81000, NULL);

-- Insert Projects
INSERT INTO project (id, name, start_date, end_date, department_id) VALUES
(1, 'Project Alpha', '2023-03-01', '2023-12-31', 1),
(2, 'Project Beta', '2022-07-15', '2023-10-15', 2),
(3, 'Project Gamma', '2023-05-20', '2024-03-10', 3),
(4, 'Project Delta', '2021-01-10', '2022-11-30', 4),
(5, 'Project Epsilon', '2024-02-01', '2025-06-30', 5);

-- Insert Employee-Project Assignments (Many-to-Many)
INSERT INTO employee_project (employee_id, project_id, assigned_date, role) VALUES
(1, 1, '2023-03-05', 'Developer'),
(2, 1, '2023-03-10', 'Tester'),
(3, 2, '2022-07-20', 'HR Manager'),
(4, 3, '2023-05-25', 'Finance Analyst'),
(5, 4, '2021-02-15', 'Marketing Lead'),
(1, 5, '2024-02-10', 'Operations Manager'),
(3, 3, '2023-06-05', 'HR Analyst'),
(4, 2, '2023-08-14', 'Budget Planner'),
(5, 1, '2024-01-01', 'Project Coordinator'),
(2, 4, '2022-03-22', 'Market Analyst');

-- Insert Performance Reviews
INSERT INTO performance_review (id, employee_id, review_date, score, review_comments) VALUES
(1, 1, '2023-12-10', 4.5, 'Excellent work on Project Alpha.'),
(2, 1, '2022-12-15', 4.2, 'Good performance in IT department.'),
(3, 2, '2023-12-10', 3.8, 'Needs improvement in testing.'),
(4, 3, '2023-06-25', 4.0, 'Managed HR activities well.'),
(5, 4, '2023-11-18', 4.7, 'Great financial analysis skills.'),
(6, 5, '2022-09-30', 4.3, 'Strong leadership in Marketing.'),
(7, 2, '2021-10-12', 3.9, 'Decent contributions to projects.'),
(8, 3, '2022-11-05', 4.1, 'Improved HR operations.'),
(9, 4, '2023-05-22', 4.6, 'Exceptional financial management.'),
(10, 5, '2021-08-18', 4.8, 'Led marketing campaigns effectively.');
