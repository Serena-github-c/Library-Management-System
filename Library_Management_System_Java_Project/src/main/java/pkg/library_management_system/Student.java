package pkg.library_management_system;

import java.sql.*;
import javax.swing.JOptionPane;

public class Student {
    
    private String std_ID;
    private String Fname;
    private String MidName;
    private String Lname;
    private String email;
    private String phone;
    private String faculty;
    private static String admin_ID;

    // Constructor
    public Student(String id, String f, String m, String l, String email, String phone, String faculty) {
        this.std_ID = id;
        this.Fname = f;
        this.MidName = m;
        this.Lname = l;
        this.email = email;
        this.phone = phone;
        this.faculty = faculty;
        this.admin_ID=jdbc_test.retrieveAdminID(); // Call the method to retrieve admin ID when the object is created
    }
    
 

    // Method to add a student to the database
    public void addStudent() {
        String query = "INSERT INTO student (Std_ID, Fname, MidName, Lname, Email, Phone, Faculty, admin_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1, getStd_ID());
            pstmt.setString(2, getFname());
            pstmt.setString(3, getMidName());
            pstmt.setString(4, getLname());
            pstmt.setString(5, getEmail());
            pstmt.setString(6, getPhone());
            pstmt.setString(7, getFaculty());
            pstmt.setString(8, admin_ID); 
            
            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Insert successful. Rows affected: " + rowsAffected);
                JOptionPane.showMessageDialog(null, "Student added successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Insert failed. No rows were affected.");
                JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ResultSet searchStudent(String ID){
        String query = "SELECT * FROM student_profile WHERE std_ID like ?"; 
         ResultSet rs= null;
            try {
            PreparedStatement pstmt = jdbc_test.getCon().prepareStatement(query);
            pstmt.setString(1,  ID);
           
            // Execute the query
            rs= pstmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Operation Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
         return rs;
    }

    // Getters
    public String getStd_ID() { return std_ID; }
    public String getFname() { return Fname; }
    public String getMidName() { return MidName; }
    public String getLname() { return Lname; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getFaculty() { return faculty; }

    // Setters
    public void setStd_ID(String std_ID) { this.std_ID = std_ID; }
    public void setFname(String Fname) { this.Fname = Fname; }
    public void setMidName(String MidName) { this.MidName = MidName; }
    public void setLname(String Lname) { this.Lname = Lname; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
}
