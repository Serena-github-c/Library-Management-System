
package pkg.library_management_system;

import java.sql.*;
import javax.swing.JOptionPane;

public class Book {
   
    private String ISBN;
    private String title;
    private String author;
    private String quantity;
    private String publicationYear;
    private String category;
    private static String admin_ID;

    // Constructor to initialize all attributes
    public Book(String isbn, String title, String author, String quantity, String pub_year, String category) {
        this.ISBN = isbn;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.publicationYear = pub_year;
        this.category = category;
        
        this.admin_ID=jdbc_test.retrieveAdminID(); // Call the method to retrieve admin ID when the object is created
    }
    
    

    // Method to add a book to the database
    public void addBook() {
        String query = "INSERT INTO Books (ISBN, Title, Author, Category, Publication_year, Quantity, Is_borrowed, admin_ID) "
                        +"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1, getISBN());
            pstmt.setString(2, getTitle());
            pstmt.setString(3, getAuthor());
            pstmt.setString(4, getCategory());
            pstmt.setString(5, getPublicationYear());
            pstmt.setString(6, getQuantity());
            pstmt.setString(7, "0");
            pstmt.setString(8, jdbc_test.retrieveAdminID()); 
            
            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Insert successful. Rows affected: " + rowsAffected);
                JOptionPane.showMessageDialog(null, "Book Added Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Insert failed. No rows were affected.");
                JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Method to edit existing books in the database    
     public void editBook() {
            String query = "UPDATE books SET title = ?, author = ?, category = ?, publication_year = ?, quantity = ? WHERE isbn = ?";        
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1, getTitle());
            pstmt.setString(2, getAuthor());
            pstmt.setString(3, getCategory());
            pstmt.setString(4, getPublicationYear());
            pstmt.setString(5, getQuantity());
            pstmt.setString(6, getISBN());
           
            
            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Insert successful. Rows affected: " + rowsAffected);
                JOptionPane.showMessageDialog(null, "Changes saved successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Insert failed. No rows were affected.");
                JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     
     // Mehod to delete books from the database
     public void deleteBook() {
            String query = "DELETE FROM books WHERE isbn = ?";        
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  getISBN());
           
            
            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Delete book successful. Rows affected: " + rowsAffected);
                JOptionPane.showMessageDialog(null, "Book deleted successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Delete book failed. No rows were affected.");
                JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     
     // Method to display book statistics
     public static ResultSet displayStats (String title){
String query = "SELECT * FROM Statistics WHERE title like ?"; 
         ResultSet rs= null;
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  "%"+title+ "%");
           
            // Execute the query
            rs= pstmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return rs;

              
     } 
    
     // Method to search for books by title
     public static ResultSet searchBook(String title){
         String query = "SELECT * FROM books WHERE title like ?"; 
         ResultSet rs= null;
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  "%"+title+ "%");
           
            // Execute the query
            rs= pstmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
         return rs;

     }
     
     // Method to search for a book by the first few numbers of the ISBN
     public static ResultSet searchBookISBN(String isbn){
         String query = "SELECT * FROM books WHERE ISBN like ?"; 
         ResultSet rs= null;
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  isbn+ "%");
           
            // Execute the query
            rs= pstmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
         return rs;

     }
     
     // Method to search for a book by the first few numbers of the ISBN
     public static ResultSet searchBookCategory(String category){
         String query = "SELECT * FROM books WHERE category like ?"; 
         ResultSet rs= null;
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  category+ "%");
           
            // Execute the query
            rs= pstmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
         return rs;

     }
     
     public static void borrowBook(String std_id, String isbn, String borrow_date){
         String query = " INSERT INTO  borrows (Std_ID, ISBN, Borrow_date, Return_date) VALUES (?,?,?,?)";
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  std_id);
            pstmt.setString(2,  isbn);
            pstmt.setString(3,  borrow_date);
            pstmt.setNull(4, java.sql.Types.DATE); // Setting the last value to NULL
            
            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Insert successful. Rows affected: " + rowsAffected);
                JOptionPane.showMessageDialog(null, "Operation successful.\nPlease note that the book must be returned within 2 weeks of the current date", "Information", JOptionPane.INFORMATION_MESSAGE);
            } 
            else {
                System.out.println("Insert failed. No rows were affected.");
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
     }
     
     
     
     public static void returnBook(String return_date, String std_ID, String isbn){
         String query = " UPDATE  borrows SET return_date = ? WHERE std_ID =? AND ISBN= ?";
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  return_date);
            pstmt.setString(2,  std_ID);
            pstmt.setString(3,  isbn);
            
            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Insert successful. Rows affected: " + rowsAffected);
                JOptionPane.showMessageDialog(null, "Book Returned successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Insert failed. No rows were affected.");
                JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);

            }

            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(" Error occurred during upadting the return date.");
        }
     }
     

    // Getters
    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getQuantity() { return quantity; }
    public String getPublicationYear() { return publicationYear; }
    public String getCategory() { return category; }

    // Setters
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public void setPublicationYear(String publicationYear) { this.publicationYear = publicationYear; }
    public void setCategory(String category) { this.category = category; }
}

