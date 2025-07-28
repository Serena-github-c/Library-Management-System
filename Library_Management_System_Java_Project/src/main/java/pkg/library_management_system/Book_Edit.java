/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkg.library_management_system;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static pkg.library_management_system.Book_Add.isValidAuthor;
import static pkg.library_management_system.Book_Add.isValidPublicationYear;
import static pkg.library_management_system.Book_Add.isValidQuantity;
import static pkg.library_management_system.Book_Add.isValidTitle;
  
public class Book_Edit extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private static DefaultTableModel tableModel;
     private static TableRowSorter<DefaultTableModel> sorter;

    public Book_Edit() {
        initComponents();
        initializeTableModel();
        loadBookData();
    }
    
    public void initializeTableModel() {
        
        tableModel = (DefaultTableModel) Table_Book_Edit.getModel();
        // Enable sorting
        sorter = new TableRowSorter<>(tableModel);
        Table_Book_Edit.setRowSorter(sorter);
    }
    
     public static DefaultTableModel getTableModel() {
        return tableModel;
    }
     
     public boolean validateInputs(){
         boolean result = false;
         if (tf_isbn.getText().trim().isEmpty() || tf_quantity.getText().trim().isEmpty() ||
            tf_title.getText().trim().isEmpty() || tf_author.getText().trim().isEmpty() ||
            tf_publicationYear.getText().trim().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);

        }
        else if (!isValidTitle(tf_title.getText())){
            JOptionPane.showMessageDialog(null, "Please enter a valid book Title.", "Invalid input", JOptionPane.ERROR_MESSAGE);

         }
        else if (!isValidAuthor(tf_author.getText())){            
            JOptionPane.showMessageDialog(null, "Please enter a valid Author.", "Invalid input", JOptionPane.ERROR_MESSAGE);

         }
        else if (!isValidPublicationYear(tf_publicationYear.getText())){            
            JOptionPane.showMessageDialog(null, "Please enter a valid Publication Year of 4 digits.", "Invalid input", JOptionPane.ERROR_MESSAGE);

         }
        else if (!isValidQuantity(tf_quantity.getText())){            
            JOptionPane.showMessageDialog(null, "Please enter a valid Quantity (A positive integer).", "Invalid input", JOptionPane.ERROR_MESSAGE);

         }
      
         
         else
             result =true;
         
         return result;
         
         
     }
     
     
    public Book createBook(){
            String isbn = tf_isbn.getText();
            String title = tf_title.getText();
            String author = tf_author.getText();
            String category = cb_Category.getSelectedItem().toString();
            String publicationYear = tf_publicationYear.getText();
            String quantity = tf_quantity.getText();
            
            Book b = new Book(isbn, title, author, quantity, publicationYear,category );
            return b;
    }
 
    public void clearInputFields(){
        tf_isbn.setText("");
        tf_title.setText("");
        tf_author.setText("");
        cb_Category.setSelectedIndex(0);
        tf_publicationYear.setText("");
        tf_quantity.setText("");
    }
    
    public static void loadBookData(){
        Connection cnt= null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            cnt= jdbc_test.getCon();
            stmt = cnt.createStatement();
            String query = "SELECT * FROM Books";
            rs = stmt.executeQuery(query);

            // Clear the existing data in the table model
            tableModel.setRowCount(0);

            // Populate the table model with the data from the result set
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("ISBN"));
                row.add(rs.getString("Title"));
                row.add(rs.getString("Author"));
                row.add(rs.getString("Category"));
                row.add(rs.getString("Publication_year"));
                row.add(rs.getString("Quantity"));
                row.add(rs.getString("Is_borrowed"));

                tableModel.addRow(row);        
            }
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Book_Edit = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tf_search_book = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_pub_year = new javax.swing.JLabel();
        tf_isbn = new javax.swing.JTextField();
        tf_author = new javax.swing.JTextField();
        cb_Category = new javax.swing.JComboBox<>();
        lbl_Quantity = new javax.swing.JLabel();
        tf_publicationYear = new javax.swing.JTextField();
        tf_title = new javax.swing.JTextField();
        lbl_category = new javax.swing.JLabel();
        lbl_isbn = new javax.swing.JLabel();
        tf_quantity = new javax.swing.JTextField();
        lbl_isbn1 = new javax.swing.JLabel();
        lbl_isbn2 = new javax.swing.JLabel();
        btn_confirm_changes = new javax.swing.JButton();
        btn_Select = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_back1 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar1.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashoard bg left.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(445, 981));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashoard bg right.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 32)); // NOI18N
        jLabel1.setText("                       Edit Book ");

        Table_Book_Edit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Title", "Author", "Category", "Publication Year", "Quantity", "Borrowed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_Book_Edit);

        jLabel4.setText("Search for a book by its title to edit it");

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon search.png"))); // NOI18N
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel5.setText("   Book title :");

        jLabel6.setText("Select the book you want to edit :");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selected Book Info will be dispalyed here :", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Trebuchet MS", 0, 14))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(420, 300));

        lbl_pub_year.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_pub_year.setText("Publication Year :");

        tf_isbn.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tf_isbn.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tf_isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_isbnActionPerformed(evt);
            }
        });

        tf_author.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        cb_Category.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cb_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "History", "Religion", "Coding", "Math", "Islam", "Ahl al-Bayt", "Literature", "Health", "Sociology", "Economy" }));
        cb_Category.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cb_Category.setFocusCycleRoot(true);
        cb_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_CategoryActionPerformed(evt);
            }
        });

        lbl_Quantity.setText("Quantity :");

        tf_publicationYear.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tf_publicationYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_publicationYearActionPerformed(evt);
            }
        });

        tf_title.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        lbl_category.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_category.setText("Category :");

        lbl_isbn.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_isbn.setText("ISBN :");

        tf_quantity.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        lbl_isbn1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_isbn1.setText("Title :");

        lbl_isbn2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_isbn2.setText("Author :");

        btn_confirm_changes.setBackground(new java.awt.Color(229, 207, 207));
        btn_confirm_changes.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_confirm_changes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon confirm.png"))); // NOI18N
        btn_confirm_changes.setText("CONFIRM CHANGES ");
        btn_confirm_changes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confirm_changes.setBorderPainted(false);
        btn_confirm_changes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirm_changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirm_changesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lbl_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(87, 87, 87)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_isbn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_isbn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbl_pub_year)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_isbn2)
                                    .addComponent(lbl_category))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_title)
                            .addComponent(tf_author, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_publicationYear, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_quantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_isbn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_Category, 0, 245, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_confirm_changes)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_isbn))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_isbn1))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_isbn2))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_category)
                    .addComponent(cb_Category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_publicationYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pub_year))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Quantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btn_confirm_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_Select.setBackground(new java.awt.Color(229, 207, 207));
        btn_Select.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_Select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon confirm.png"))); // NOI18N
        btn_Select.setText("SELECT ");
        btn_Select.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Select.setBorderPainted(false);
        btn_Select.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(229, 207, 207));
        btn_delete.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon x.png"))); // NOI18N
        btn_delete.setText("DELETE BOOK ");
        btn_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_delete.setBorderPainted(false);
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_back1.setBackground(new java.awt.Color(229, 207, 207));
        btn_back1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-back-btn-22.png"))); // NOI18N
        btn_back1.setText("BACK  ");
        btn_back1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_back1.setBorderPainted(false);
        btn_back1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_Select)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_delete))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tf_search_book, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(btn_back1))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_search_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Select, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1564, 1018));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_back1ActionPerformed

    private void cb_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_CategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_CategoryActionPerformed

    private void tf_publicationYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_publicationYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_publicationYearActionPerformed

    private void btn_confirm_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirm_changesActionPerformed
        // TODO add your handling code here:
        int selectedRow = Table_Book_Edit.getSelectedRow();
        if (selectedRow != -1){

            // Retrieve the data from text fields and combo box and create new Book object
            String isbn = tf_isbn.getText();
            String title = tf_title.getText();
            String author = tf_author.getText();
            String category = cb_Category.getSelectedItem().toString();
            String publicationYear = tf_publicationYear.getText();
            String quantity = tf_quantity.getText();
            
            if (validateInputs()){


            int response = JOptionPane.showConfirmDialog(null, 
            "Are you sure you confirm these changes?", 
            "Confirm Edit", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
            // Update the JTable model with the new data
            
            Table_Book_Edit.setValueAt(isbn, selectedRow, 0);
            Table_Book_Edit.setValueAt(title, selectedRow, 1);
            Table_Book_Edit.setValueAt(author, selectedRow, 2);
            Table_Book_Edit.setValueAt(category, selectedRow, 3);
            Table_Book_Edit.setValueAt(publicationYear, selectedRow, 4);
            Table_Book_Edit.setValueAt(quantity, selectedRow, 5);
            
            // Create a book object and perform the update action to the database
            Book b = new Book(isbn, title, author, quantity, publicationYear,category );
            b.editBook();

            clearInputFields();
            
        } else {
            JOptionPane.showMessageDialog(null, "Edit Cancelled.");

            }
            }
    }
        else {
            JOptionPane.showMessageDialog(null, "Please select a book to edit.");
        }
        
         
    }//GEN-LAST:event_btn_confirm_changesActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
       
        int selectedRow = Table_Book_Edit.getSelectedRow();
        
        if (selectedRow != -1) { 
            // Retrieve the ISBN from the selected row
            String isbn = Table_Book_Edit.getValueAt(selectedRow, 0).toString();
            
            // Display confirmation dialog
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this book?", "Confirm action", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (response==JOptionPane.YES_OPTION){
        
             
            // Call the deleteBook method in the Book class
            Book b = createBook(); 
            b.deleteBook();
            
            // Remove the row from the JTable model after deletion
            DefaultTableModel model = (DefaultTableModel) Table_Book_Edit.getModel();
            model.removeRow(selectedRow);
            
            // Show a confirmation dialog
        } else {
                // If the user cancels the deletion
                JOptionPane.showMessageDialog(null, "Deletion canceled.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book to delete.");
        }
        
    
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectActionPerformed
        // TODO add your handling code here:
         int selectedRow = Table_Book_Edit.getSelectedRow();
        
        if (selectedRow != -1) { 
            // Retrieve the values from the selected row and set them in the text fields and combo box
            tf_isbn.setText(Table_Book_Edit.getValueAt(selectedRow, 0).toString());
            tf_isbn.setEditable(false);
            tf_title.setText(Table_Book_Edit.getValueAt(selectedRow, 1).toString());
            tf_author.setText(Table_Book_Edit.getValueAt(selectedRow, 2).toString());
            cb_Category.setSelectedItem(Table_Book_Edit.getValueAt(selectedRow, 3).toString());
            tf_publicationYear.setText(Table_Book_Edit.getValueAt(selectedRow, 4).toString());
            tf_quantity.setText(Table_Book_Edit.getValueAt(selectedRow, 5).toString());
        } else {
            // If no row is selected
            JOptionPane.showMessageDialog(null, "Please select a book to edit.");
        }
        
    }//GEN-LAST:event_btn_SelectActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        String title = tf_search_book.getText();
        ResultSet rs= Book.searchBook(title);
        //Clear the table then refill it with the resultset 
        DefaultTableModel model = (DefaultTableModel) Table_Book_Edit.getModel();
        model.setRowCount(0); 
        try {
        while (rs != null && rs.next()) {
            Object[] row = {
                rs.getString("ISBN"),
                rs.getString("Title"),
                rs.getString("Author"),
                rs.getString("Category"),
                rs.getInt("Publication_Year"),
                rs.getInt("Quantity"),
                rs.getInt("Is_borrowed")
            };
            model.addRow(row);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tf_isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_isbnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book_Edit().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Book_Edit;
    private javax.swing.JButton btn_Select;
    private javax.swing.JButton btn_back1;
    private javax.swing.JButton btn_confirm_changes;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> cb_Category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Quantity;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_isbn;
    private javax.swing.JLabel lbl_isbn1;
    private javax.swing.JLabel lbl_isbn2;
    private javax.swing.JLabel lbl_pub_year;
    private javax.swing.JTextField tf_author;
    private javax.swing.JTextField tf_isbn;
    private javax.swing.JTextField tf_publicationYear;
    private javax.swing.JTextField tf_quantity;
    private javax.swing.JTextField tf_search_book;
    private javax.swing.JTextField tf_title;
    // End of variables declaration//GEN-END:variables
}
