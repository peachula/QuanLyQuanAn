package Interface;


import Process.Dish;
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
    
    
    private final DefaultTableModel tableDish = new DefaultTableModel();
    String get_date = "";
    Dish dish = new Dish();
    
    public frmReport_Customer() throws SQLException {
        initComponents();
        setTitle("DISH SOLD PAGE");
        
        BasicInternalFrameUI bs = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener l: bs.getNorthPane().getMouseListeners()){
            bs.getNorthPane().removeMouseListener(l);
        }
        
        ///setting for tbCate
        String []colsName_Cate = {"Dish ID","Dish Name","Quantity"};
        // đặt tiêu đề cột cho tableModel
        tableDish.setColumnIdentifiers(colsName_Cate);
        tbDish.setModel(tableDish);
        tbDish.getColumnModel().getColumn(0).setWidth(0);
        tbDish.getColumnModel().getColumn(0).setMinWidth(0);
        tbDish.getColumnModel().getColumn(0).setMaxWidth(0);
        
        ///giá trị sort: 1 là tăng, 0 là giảm
        LocalDateTime now = LocalDateTime.now().minus(Period.ofDays( 30 ));  
        DateTimeFormatter date_f = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        get_date = date_f.format(now);
        
        DishSort(get_date,0);
        
        ButtonGroup G = new ButtonGroup();
        G.add(rdIncr);
        G.add(rdDec);
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
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rdIncr = new javax.swing.JRadioButton();
        rdDec = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDish = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setMinimumSize(new java.awt.Dimension(393, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(693, 100));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setMaximumSize(new java.awt.Dimension(373, 100));
        jPanel3.setMinimumSize(new java.awt.Dimension(373, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(373, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARH"));

        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("SORT"));

        rdIncr.setText("Price increasing");
        rdIncr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdIncrMouseClicked(evt);
            }
        });
        jPanel5.add(rdIncr);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tbDish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dish ID", "Dish Name", "Quantity"
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
        jScrollPane1.setViewportView(tbDish);
        if (tbDish.getColumnModel().getColumnCount() > 0) {
            tbDish.getColumnModel().getColumn(0).setMinWidth(0);
            tbDish.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbDish.getColumnModel().getColumn(0).setMaxWidth(0);
            tbDish.getColumnModel().getColumn(1).setResizable(false);
            tbDish.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void DishSort (String date,int sort) throws SQLException
    {
        tableDish.getDataVector().removeAllElements();
        ResultSet rs= dish.DishSold(date,sort);
        try {
            while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[3];
            rows[0] = rs.getString(1); // dishID
            rows[2] = rs.getString(2); // Quantity
            rows[1] = rs.getString(3); // Dish name
            tableDish.addRow(rows); // đưa dòng dữ liệu vào tableModelDish
            //mỗi lần có sự thay đổi dữ liệu ở tableModelDish thì Jtable sẽ tự động update
            
            }
        }
        catch (SQLException e) {
        }
        
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void rdIncrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdIncrMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            DishSort(get_date,1);
        } catch (SQLException ex) {
            Logger.getLogger(frmReport_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdIncrMouseClicked

    private void rdDecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDecMouseClicked
        try {
            // TODO add your handling code here:
            DishSort(get_date,0);
        } catch (SQLException ex) {
            Logger.getLogger(frmReport_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdDecMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdDec;
    private javax.swing.JRadioButton rdIncr;
    private javax.swing.JTable tbDish;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
