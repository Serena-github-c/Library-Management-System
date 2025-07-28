package pkg.library_management_system;
import java.sql.*;

public class jdbc_test {
    public static Connection cnt = null;

    public static Connection getCon(){
        String Driver = "com.mysql.cj.jdbc.Driver";
        try {
            // Register MySQL JDBC driver   
            Class.forName(Driver);
            String URL="jdbc:mysql://localhost:3306/library_management_system";
            String username = "library";
            String password = "LIBRARYjuly2024";
            cnt = DriverManager.getConnection(URL,username, password );
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return cnt;
    }

    
    // The sole purpose of this code is to test the connection to our database
    public static void main(String[] args) {
        Statement stm = null;
        ResultSet set = null;

        try {
            // Get a connection
            Connection conn = getCon();

            // Create a statement and execute query
            stm = conn.createStatement();
            set = stm.executeQuery("SELECT std_ID, Fname, MidName, Lname FROM student");

            // Print results
            while (set.next()) {
                System.out.println("ID: " + set.getString(1) +
                                   "\tFirst name: " + set.getString(2) +
                                   "\tMidName: " + set.getString(3) +
                                   "\tLast name: " + set.getString(4));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close resources but don't close the connection here because it is used in other classes
            try {
                if (set != null) set.close();
                if (stm != null) stm.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    
    public static String admin_ID;
    public static String retrieveAdminID() {
        Statement adm = null;
        ResultSet rest = null;
        try {
            if (jdbc_test.getCon() == null) {
                throw new SQLException("Database connection is not established.");
            }
            
            adm = jdbc_test.getCon().createStatement();
            String q1 = "SELECT admin_ID FROM adminstrator";
            rest = adm.executeQuery(q1);
            if (rest.next()) {
                admin_ID = rest.getString("admin_ID");
                System.out.println("Admin ID retrieved: " + admin_ID);            
            }
             else {
            System.out.println("No admin_ID found in administrator table.");}
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if (rest != null) rest.close();
                if (adm != null) adm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admin_ID;
    }
}

