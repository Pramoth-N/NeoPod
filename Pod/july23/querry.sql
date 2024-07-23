-- Dave owns a bookshop. He is planning to stock all the best-selling books in his shop. 
-- He collected all the information on the author, book names, and the number of copies sold in the below format. 
-- Table Details: Table names are case-sensitive 

-- Table Name: authorBooks 
-- Column Name: authorName, bookName 

-- Table2 Details: 
-- Table Name: soldCopies 
-- Column Name: bookName, soldCopies

select
    authorName Author_Name,
    sum(soldCopies) sold_sum
from
    authorBooks a
join 
    soldCopies c
on
    a.bookName = c.bookName
group by 1
order by 2 desc 
limit 3;