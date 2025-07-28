-- Insert Adminstrator data
INSERT INTO Adminstrator (admin_ID, Username, Password)
VALUES ('001', 'admin1', 'password1');

-- Insert Books data
INSERT INTO Books (ISBN, Title, Author, Category, Publication_year, Quantity, Is_borrowed, admin_ID)
VALUES 
    -- History category
    ('978-0-393-03858-3', 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'History', 2011, 5, 0, '001'),
    ('978-0-684-83259-7', 'Guns, Germs, and Steel: The Fates of Human Societies', 'Jared Diamond', 'History', 1997, 3, 0, '001'),
    ('978-0199225900', 'A History of the Middle Ages, 300-1500', 'John M. Riddle', 'History', 2008, 4, 0, '001'),
    ('978-0743236714', 'The Rise and Fall of Ancient Egypt', 'Toby Wilkinson', 'History', 2010, 2, 0, '001'),

    -- Math category
    ('978-0132297516', 'Introduction to Algorithms', 'Thomas H. Cormen', 'Math', 2009, 3, 0, '001'),
    ('978-0387982698', 'Concrete Mathematics: A Foundation for Computer Science', 'Ronald L. Graham', 'Math', 1994, 2, 0, '001'),
    ('978-0521272892', 'Principles of Mathematical Analysis', 'Walter Rudin', 'Math', 1976, 4, 0, '001'),
    ('978-3319118013', 'Linear Algebra and Its Applications', 'David C. Lay', 'Math', 2015, 5, 0, '001'),

    -- Coding category
    ('978-0262033848', 'Introduction to the Theory of Computation', 'Michael Sipser', 'Coding', 2012, 5, 0, '001'),
    ('978-0131103627', 'Programming Language Pragmatics', 'Michael L. Scott', 'Coding', 2005, 3, 0, '001'),
    ('978-0262510875', 'Structure and Interpretation of Computer Programs', 'Harold Abelson', 'Coding', 1996, 4, 0, '001'),
    ('978-0321486813', 'Clean Code: A Handbook of Agile Software Craftsmanship', 'Robert C. Martin', 'Coding', 2008, 3, 0, '001'),

    -- Religion (general) category
    ('978-0060649234', 'The World''s Religions: Our Great Wisdom Traditions', 'Huston Smith', 'Religion', 1958, 4, 0, '001'),
    ('978-0140195835', 'The Tao of Pooh', 'Benjamin Hoff', 'Religion', 1982, 3, 0, '001'),
    ('978-1594488907', 'The Case for God', 'Karen Armstrong', 'Religion', 2009, 2, 0, '001'),
    ('978-0674026766', 'The Varieties of Religious Experience', 'William James', 'Religion', 1902, 5, 0, '001'),

    -- Islam category
    ('978-0199535958', 'The Qur''an', 'M. A. S. Abdel Haleem', 'Islam', 2004, 3, 0, '001'),
    ('978-0306825550', 'Muhammad: Prophet of Peace Amid the Clash of Empires', 'Juan Cole', 'Islam', 2018, 2, 0, '001'),
    ('978-0691158539', 'In the Shadow of the Sword: The Birth of Islam and the Rise of the Global Arab Empire', 'Tom Holland', 'Islam', 2012, 4, 0, '001'),
    ('978-0713996232', 'No god but God: The Origins, Evolution, and Future of Islam', 'Reza Aslan', 'Islam', 2005, 5, 0, '001'),

    -- Ahl al-Bayt category
    ('978-0860375278', 'The Fourteen Infallibles: A Compilation of Speeches and Lectures', 'Abbas Abedi', 'Ahl al-Bayt', 2007, 3, 0, '001'),
    ('978-1567447201', 'The Lantern of The Path', 'Ja''far ibn Hasan al-Barzanji', 'Ahl al-Bayt', 1984, 4, 0, '001'),
    ('978-9642190707', 'The Life of Fatima Az-Zahra', 'Baqir Sharif al-Qarashi', 'Ahl al-Bayt', 1996, 3, 0, '001'),
    ('978-1907903077', 'The Twelve Successors of Muhammad: Their Lives and Times', 'Maulana Muhammad Ali', 'Ahl al-Bayt', 2013, 2, 0, '001');

    
    
-- Insert Student Data 
INSERT INTO Student (Std_ID, Fname, MidName, Lname, Email, Phone, Faculty, admin_ID)
VALUES
    ('90331', 'John', 'H', 'Doe', 'john@example.com', '123456789', 'Engineering', '001'),
    ('90417', 'Jane', 'L' ,'Smith', 'jane@example.com', '987654321', 'Science', '001'),
    ('90126', 'Lara', 'Q', 'Pine', 'lara@example.com', '987654321', 'Engineering', '001'),
    ('90379', 'Sarah', 'R', 'Sue', 'sarah@example.com', '987654321', 'Business', '001'),
    ('91177', 'David', 'H', 'Micho', 'david@example.com', '987654321', 'Health', '001'),
    ('90222', 'Mike', 'D', 'Ross', 'mike@example.com', '234567890', 'Engineering', '001'),
    ('90333', 'Rachel', 'M','Green', 'rachel@example.com', '345678901', 'Science', '001'),
    ('90444', 'Monica', 'S', 'Geller', 'monica@example.com', '456789012', 'Business', '001'),
    ('90555', 'Chandler', 'M', 'Bing', 'chandler@example.com', '567890123', 'Health', '001'),
    ('90666', 'Ross', 'R', 'Geller', 'ross@example.com', '678901234', 'Arts', '001');
    
    

-- Insert Borrow Data
INSERT INTO Borrows (Std_ID, ISBN, Borrow_date, Return_date)
VALUES
    ('90126', '978-0060649234', '2023-01-01', '2023-01-15'),
    ('90126', '978-0132297516', '2023-01-10', '2023-02-24'),
    ('90417', '978-0140195835', '2022-05-07', '2023-05-21'),
    ('91177', '978-1907903077', '2022-05-01', '2023-05-15'),
    ('90331', '978-0521272892', '2023-03-10', '2023-03-24'),
    ('90444', '978-0140195835', '2023-02-20', '2023-03-06');



