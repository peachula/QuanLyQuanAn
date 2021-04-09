package Interface;

import Filter.FileTypeFilter;
import Process.Receipt;
import Process.ReceiptDetail;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kieef
 */
public class frmReport_Order extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmReport_DishSold
     */
    
    
    private final DefaultTableModel tableOrder = new DefaultTableModel();
    private final DefaultTableModel tableDetail = new DefaultTableModel();
    
    Receipt r = new Receipt(); 
    ReceiptDetail d = new ReceiptDetail();
    
    public frmReport_Order() throws SQLException {
        initComponents();
        setTitle("ORDERS REPORTS PAGE");
        
        BasicInternalFrameUI bs = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener l: bs.getNorthPane().getMouseListeners()){
            bs.getNorthPane().removeMouseListener(l);
        }
        
        ///setting for tbCate
        String []colsName_Order = {"ID","Date","Total"};
        // đặt tiêu đề cột cho tableModel
        tableOrder.setColumnIdentifiers(colsName_Order);
        tbOrder.setModel(tableOrder);
        ShowOrderList();
        
        
        String []colsName_Detail = {"Dish ID","Dish Name","Quantity","Total"};
        // đặt tiêu đề cột cho tableModel
        tableDetail.setColumnIdentifiers(colsName_Detail);
        tbDetail.setModel(tableDetail);
        
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
        btnExport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbOrder = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDetail = new javax.swing.JTable();

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
        jPanel6.setPreferredSize(new java.awt.Dimension(373, 100));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("EXCEL"));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 82));

        btnExport.setBackground(new java.awt.Color(237, 163, 35));
        btnExport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setText("EXPORT");
        btnExport.setBorderPainted(false);
        btnExport.setMaximumSize(new java.awt.Dimension(77, 23));
        btnExport.setMinimumSize(new java.awt.Dimension(77, 23));
        btnExport.setPreferredSize(new java.awt.Dimension(77, 23));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setPreferredSize(new java.awt.Dimension(472, 382));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("ORDERS"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        tbOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Date", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class
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
        tbOrder.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOrderMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbOrder);
        if (tbOrder.getColumnModel().getColumnCount() > 0) {
            tbOrder.getColumnModel().getColumn(1).setResizable(false);
            tbOrder.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel7.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("ORDER DETAILS"));
        jPanel8.setLayout(new java.awt.BorderLayout());

        tbDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dish ID", "Dish Name", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbDetail);
        if (tbDetail.getColumnModel().getColumnCount() > 0) {
            tbDetail.getColumnModel().getColumn(0).setResizable(false);
            tbDetail.getColumnModel().getColumn(1).setResizable(false);
            tbDetail.getColumnModel().getColumn(2).setResizable(false);
            tbDetail.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void DishSearch ()
    {
        String search = txtSearch.getText(); 
        
        if (search.trim() != null)
        {
            tableOrder.getDataVector().removeAllElements();
            try {
                ResultSet rs= r.ReceiptSearch(search);
                while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[3];
                rows[0] = rs.getString(1); // ID
                rows[1] = rs.getString(2); // Date
                rows[2] = rs.getString(3); // Total
                tableOrder.addRow(rows); // đưa dòng dữ liệu vào tableModelDish
                //mỗi lần có sự thay đổi dữ liệu ở tableModelDish thì Jtable sẽ tự động update

                }
            }
            catch (SQLException e) {
            }
        }
    }
    
    public void ShowOrderList()
    {
        tableOrder.getDataVector().removeAllElements();
            try {
                ResultSet rs= r.ReceiptReport();
                while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                    String rows[] = new String[3];
                    rows[0] = rs.getString(1); // ID
                    rows[1] = rs.getString(2); // Date
                    rows[2] = rs.getString(3); // Total
                    tableOrder.addRow(rows); // 
                }
            }
            catch (SQLException e) {
            }
    }
        
    private void ShowDetail(String ml) {
        tableDetail.getDataVector().removeAllElements();
        try {
            ResultSet rs = d.ShowDetail(ml);
            while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[4];
                rows[0] = rs.getString(1); // ID
                rows[1] = rs.getString(4); // Nme
                rows[2] = rs.getString(2); // Quantity
                rows[3] = rs.getString(3); ///total
                tableDetail.addRow(rows); 
            }
        }
            catch (SQLException e) {
            }
    }
    
    public void SaveExcel(File file, JTable table, DefaultTableModel model)
    {
        try {
            FileWriter out = new FileWriter(file + ".xls");
            BufferedWriter bwrite = new BufferedWriter(out);
            //DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            // ten Cot
            for (int j = 0; j < table.getColumnCount(); j++) {
                bwrite.write(model.getColumnName(j) + "\t");
            }
            bwrite.write("\n");
            // Lay du lieu dong
            for (int j = 0; j < table.getRowCount(); j++) {
                for (int k = 0; k < table.getColumnCount(); k++) {
                    bwrite.write(model.getValueAt(j, k).toString() + "\t");
                }
                bwrite.write("\n");
            }
            bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
           } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
        }
    }
    
    public void GetFileLocation() throws IOException, SQLException
    {
        JFileChooser fs = new JFileChooser(new File("c:\\"));
        fs.setDialogTitle("Save report");
        fs.setFileFilter(new FileTypeFilter(".xlsx", "Excel file"));
        int result = fs.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file = fs.getSelectedFile();
            ExportExcel(file);
        } 
    }
    
    public void ExportExcel(File file) throws SQLException
    {
        
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");
 
            writeHeaderLine(sheet);
 
            ResultSet rs= r.ReceiptReport();
            writeDataLines(rs, workbook, sheet);
 
            FileOutputStream outputStream;
            outputStream = new FileOutputStream(file + ".xlsx");
            
            workbook.write(outputStream);
            workbook.close();   
            
            JOptionPane.showMessageDialog(null, "Lưu file thành công!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmReport_Order.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
        } catch (IOException ex) {
            Logger.getLogger(frmReport_Order.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
        }
    }
    
    public void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Order ID");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Date");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Total");
 
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            String id = result.getString(1);
            long total = result.getLong(3);
            java.sql.Timestamp timestamp = result.getTimestamp(2);
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id); //id
  
            cell = row.createCell(columnCount++);
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(timestamp);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(total);
 
 
        }
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        DishSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        DishSearch();
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
            // TODO add your handling code here:
            GetFileLocation();
        } catch (IOException ex) {
            Logger.getLogger(frmReport_Order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmReport_Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void tbOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrderMouseClicked
        // TODO add your handling code here:
        int row =this.tbOrder.getSelectedRow();
        String ml=(this.tbOrder.getModel().getValueAt(row,0)).toString();
        ShowDetail(ml);
    }//GEN-LAST:event_tbOrderMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbDetail;
    private javax.swing.JTable tbOrder;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
