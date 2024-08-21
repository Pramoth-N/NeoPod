-- Report the names of all SalesPerson

-- Write an SQL query to report the names of all the salespersons who did not have any orders related to the company with the name "RED".



-- Return the result table in any order.

-- SalesPerson(Table)



-- Company(Table)



-- Orders(Table)



-- Sample Data:



-- Table Name: Orders





-- Table Name: Company





-- Table Name: SalesPerson



-- Input format :
-- The input table is already created, and records are already prepopulated, as mentioned in the problem statement.



-- Output format :
-- The output displays the names of salespersons who did not have any orders related to the company with the name "RED".



-- name
-- Amy
-- Mark
-- Alex


select
    name
from
    SalesPerson
where
    sales_id not in (select
                        sales_id
                    from
                        Orders
                    where
                        com_id = (
                                select 
                                    com_id
                                from
                                    Company
                                where
                                    name = 'RED'
                                )
                    );