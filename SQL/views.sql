DELIMITER //

CREATE TRIGGER set_due_date
BEFORE INSERT ON Borrows
FOR EACH ROW
BEGIN
    SET NEW.Due_date = DATE_ADD(NEW.Borrow_date, INTERVAL 14 DAY);
END //

DELIMITER ;




drop view statistics;

CREATE VIEW Statistics AS
SELECT 
    b.ISBN, 
    b.Title, 
    b.category,
    COUNT(br.ISBN) AS nbr_of_borrowings, -- Total number of times the book has been borrowed
    DATE_FORMAT(br.Borrow_date, '%Y-%m') AS Month, -- The month and year of the borrow record
    MIN(br.Borrow_date) AS First_Borrow_Date, -- The earliest date the book was borrowed
    MAX(br.Borrow_date) AS Last_Borrow_Date -- The most recent date the book was borrowed
FROM 
    Books b
JOIN 
    Borrows br ON b.ISBN = br.ISBN 
GROUP BY 
    b.ISBN, 
    b.Title, 
    b.category,
    DATE_FORMAT(br.Borrow_date, '%Y-%m')
ORDER BY 
    Month DESC; 








drop view student_profile;
CREATE VIEW Student_Profile AS
SELECT 
    s.Std_ID,
    s.Fname,
    s.Lname,
    -- Get the title of the most recently borrowed book
    (SELECT b.Title
     FROM Borrows br2
     JOIN Books b ON br2.ISBN = b.ISBN
     WHERE br2.Std_ID = s.Std_ID
     ORDER BY br2.Borrow_date DESC
     LIMIT 1) AS Most_Recent_Book_Title,
	-- Get the first borrow date
    MIN(br.Borrow_date) AS First_Borrow_Date,
    
    -- Get the most recent return date
    MAX(br.Return_date) AS Last_Return_Date,

    -- Determine overdue status
    CASE 
        WHEN MAX(br.Return_date) IS NULL AND NOW() > MAX(br.Due_date) THEN 'Overdue'
        ELSE 'On Time'
    END AS Overdue_Status,
    
    -- Count number of borrowings per month for the month of the last borrow date 
    (SELECT COUNT(*)
     FROM Borrows br3 
     WHERE br3.Std_ID = s.Std_ID 
     AND DATE_FORMAT(br3.Borrow_date, '%Y-%m') = DATE_FORMAT(MAX(br.Borrow_date), '%Y-%m')) AS nbr_of_borrowings_per_month,
     
    -- Count number of borrowings per year for the year of the last borrow date
    (SELECT COUNT(*)
     FROM Borrows br4 
     WHERE br4.Std_ID = s.Std_ID 
     AND DATE_FORMAT(br4.Borrow_date, '%Y') = DATE_FORMAT(MAX(br.Borrow_date), '%Y')) AS nbr_of_borrowings_per_year,
     
    -- Count of overdue books
    (SELECT COUNT(*)
     FROM Borrows br5 
     WHERE br5.Std_ID = s.Std_ID 
     AND br5.Return_date IS NULL 
     AND NOW() > br5.Due_date) AS nbr_of_overdue_books,
    -- Calculate average duration of borrowed books in days with 1 decimal place
    ROUND(AVG(DATEDIFF(COALESCE(br6.Return_date, NOW()), br6.Borrow_date)), 1) AS avg_borrow_duration
FROM 
    Student s
JOIN 
    Borrows br ON s.Std_ID = br.Std_ID
LEFT JOIN 
    Borrows br6 ON s.Std_ID = br6.Std_ID AND br6.Return_date IS NOT NULL
GROUP BY
    s.Std_ID,
    s.Fname,
    s.Lname;
