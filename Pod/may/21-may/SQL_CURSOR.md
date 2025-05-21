Here's your stored procedure in **Markdown (MD) format**, formatted for readability and easy sharing in documentation or code review platforms:

## Stored Procedure: `Employee_Updated_Salary()`

This stored procedure updates the salary of employees based on their designation using a cursor.

### Salary Increment Rules:
- **Manager**: +5000
- **Developer**: +7000
- **Trainer**: +10000

### Table: `Employees`

### Procedure Definition:

```sql
DELIMITER $$

CREATE PROCEDURE Employee_Updated_Salary()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE id INT;
    DECLARE desig VARCHAR(30);
    DECLARE sal INT;
    
    DECLARE cur CURSOR FOR
        SELECT EMPLOYEE_ID, DESIGNATION, EMP_SALARY FROM Employees;
        
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO id, desig, sal;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        IF desig = 'Manager' THEN
            UPDATE Employees SET EMP_SALARY = sal + 5000 WHERE EMPLOYEE_ID = id;
        ELSEIF desig = 'Developer' THEN
            UPDATE Employees SET EMP_SALARY = sal + 7000 WHERE EMPLOYEE_ID = id;
        ELSEIF desig = 'Trainer' THEN
            UPDATE Employees SET EMP_SALARY = sal + 10000 WHERE EMPLOYEE_ID = id;
        END IF;
    END LOOP;
    
    CLOSE cur;
END $$

DELIMITER ;
````

### To Execute:

```sql
CALL Employee_Updated_Salary();
```

### To Verify Updated Salaries:

```sql
SELECT * FROM Employees;
```

