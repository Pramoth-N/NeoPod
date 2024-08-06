-- You are given a table STATION containing information about various cities and their corresponding weather stations.



-- Write an SQL query to select all records from the table where the last letter of the city name ends with a vowel ('a', 'e', 'i', 'o', 'u').



-- Table: STATION







-- Note

-- All records are prepopulated on the back end.

-- Input format :
-- The input records are already prepopulated, as given in the problem statement.



-- No console input.

-- Output format :
-- The output displays the following format:

-- ID	CITY	STATE
-- 6	Louisville	Kentucky
-- 7	Fresno	California
-- 8	Albuquerque	New Mexico
-- 9	Atlanta	Georgia
-- 10	Omaha	Nebraska


select *  from STATION 
where
    city like '%a' or city like '%e' or city like '%i' or city like '%o' or city like '%u'; 