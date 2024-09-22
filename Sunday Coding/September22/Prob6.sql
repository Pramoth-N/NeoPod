-- The hospital wants to analyze the workload of each doctor by counting the number of patients assigned to them. Write a query to retrieve the count of patients assigned to each doctor.



-- Table details are given below:







-- The table is created, and the records are already inserted at the backend. The sample records are given below.

-- Table name: patient							Table name: doctor

        

-- Table name: admission



-- Note:

-- Table names are case-sensitive and use in upper case.

-- Input format :
-- The input records are already prepopulated, as given in the problem statement.

-- Output format :
-- The output displays the count of the patients as shown below.



-- doctor_id	doctor_name	patient_count
-- 101	Dr. Smith	1
-- 102	Dr. Johnson	1
-- 103	Dr. White	1
-- 104	Dr. Davis	1
-- 105	Dr. Taylor	1


-- Refer to the sample output for the column headers.



select 
    doctor_id,
    doctor_name,
    count(*) patient_count
from
    doctor
natural join admission group by 1;