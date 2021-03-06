package Interface;


import Process.Customer;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kieef
 */
public class frmReport_Customer extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmReport_DishSold
     */
    
    
    private final DefaultTableModel tableCus = new DefaultTableModel();
    String get_date = "";
    Customer customer = new Customer();
    
    public frmReport_Customer() throws SQLException {
        initComponents();
        setTitle("CUSTOMER REPORTS PAGE");
        
        BasicInternalFrameUI bs = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener l: bs.getNorthPane().getMouseListeners()){
            bs.getNorthPane().removeMouseListener(l);
        }
        
        ///setting for tbCate
        String []colsName_Cate = {"Customer ID","Customer Name","Total spend", "Phone"};
        // đặt tiêu đề cột cho tableModel
        tableCus.setColumnIdentifiers(colsName_Cate);
        tbCustomer.setModel(tableCus);
        tbCustomer.setDefaultEditor(Object.class, null);
                
        CustomerSort(0);
        
        ButtonGroup G = new ButtonGroup();
        G.add(rdIncr);
        G.add(rdDec);
    }

    public void CustomerSearch() throws SQLException{
        String search = txtSearch.getText();
        
        if (search.trim() != null)
        {
            tableCus.getDataVector().removeAllElements();
            ResultSet rs = customer.CustomerSearch(search);
            while(rs.next())
            {
                String rows[] = new String[4];
                rows[0] = rs.getString(2); // ID
                rows[1] = rs.getString(3); // Nam
                rows[2] = rs.getString(1); // Spend
                rows[3] = rs.getString(4); //phone
                tableCus.addRow(rows);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnClear2 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rdIncr = new javax.swing.JRadioButton();
        rdDec = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCustomer = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setMinimumSize(new java.awt.Dimension(393, 150));
        jPanel1.setPreferredSize(new java.awt.Dimension(693, 120));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(373, 100));
        jPanel3.setMinimumSize(new java.awt.Dimension(373, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(373, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARH"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnClear2.setBackground(new java.awt.Color(237, 163, 35));
        btnClear2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClear2.setForeground(new java.awt.Color(255, 255, 255));
        btnClear2.setText("CLEAR");
        btnClear2.setBorderPainted(false);
        btnClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear2ActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(237, 163, 35));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("SEARCH");
        btnSearch.setBorderPainted(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("SORT"));
        jPanel5.setMinimumSize(new java.awt.Dimension(229, 120));

        rdIncr.setBackground(new java.awt.Color(255, 255, 255));
        rdIncr.setText("Price increasing");
        rdIncr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdIncrMouseClicked(evt);
            }
        });
        jPanel5.add(rdIncr);

        rdDec.setBackground(new java.awt.Color(255, 255, 255));
        rdDec.setText("Price decreasing");
        rdDec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdDecMouseClicked(evt);
            }
        });
        jPanel5.add(rdDec);

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tbCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Total spend"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCustomer);
        if (tbCustomer.getColumnModel().getColumnCount() > 0) {
            tbCustomer.getColumnModel().getColumn(0).setMinWidth(0);
            tbCustomer.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbCustomer.getColumnModel().getColumn(0).setMaxWidth(0);
            tbCustomer.getColumnModel().getColumn(1).setResizable(false);
            tbCustomer.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void CustomerSort (int sort) throws SQLException
    {
        tableCus.getDataVector().removeAllElements();
        ResultSet rs= customer.CustomerReport(sort);
        try {
            while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[4];
            rows[0] = rs.getString(2); // ID
            rows[1] = rs.getString(3); // Nam
            rows[2] = rs.getString(1); // Spend
            rows[3] = rs.getString(4); //phone
            tableCus.addRow(rows); // đưa dòng dữ liệu vào tableModelDish
            //mỗi lần có sự thay đổi dữ liệu ở tableModelDish thì Jtable sẽ tự động update
            
            }
        }
        catch (SQLException e) {
        }
        
    }
    private void rdIncrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdIncrMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            CustomerSort(1);
        } catch (SQLException ex) {
            Logger.getLogger(frmReport_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdIncrMouseClicked

    private void rdDecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDecMouseClicked
        try {
            // TODO add your handling code here:
            CustomerSort(0);
        } catch (SQLException ex) {
            Logger.getLogger(frmReport_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdDecMouseClicked

    private void btnClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear2ActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        if (rdDec.isSelected())
        {
            try {
                CustomerSort(0);
            } catch (SQLException ex) {
                Logger.getLogger(frmReport_DishSold.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (rdIncr.isSelected())
        {
            try {
                CustomerSort(1);
            } catch (SQLException ex) {
                Logger.getLogger(frmReport_DishSold.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
                CustomerSort(0);
            } catch (SQLException ex) {
                Logger.getLogger(frmReport_DishSold.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnClear2ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            // TODO add your handling code here:
            CustomerSearch();
        } catch (SQLException ex) {
            Logger.getLogger(frmReport_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        try {
            // TODO add your handling code here:
            CustomerSearch();
        } catch (SQLException ex) {
            Logger.getLogger(frmReport_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnClear2;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdDec;
    private javax.swing.JRadioButton rdIncr;
    private javax.swing.JTable tbCustomer;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
