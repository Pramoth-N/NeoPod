-- Write a SQL query to retrieve the names of employees who are assigned to the project 'P4'.



-- Table: Employee

-- Field: Id (primary key), Name, Location







-- Table: Project

-- Field: Employeeid (foreign key), Project, Manager_id, Manager







-- Note: Tables and Values are Prepopulated.



-- Refer to the sample output for better understanding.

-- Input format :
-- No console input.

-- Two tables are prepopulated: Employee and Project.

-- Output format :
-- The output should display a list of names (Name) of employees who are assigned to the project named 'P4' in the following format:



-- Name
-- James
-- Paul

select
    Name
from
    Employee
join 
    Project
on
    id = Employeeid and Project = 'P4'
order by 1;

