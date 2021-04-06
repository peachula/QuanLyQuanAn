/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.sql.ResultSet;
import java.sql.SQLException;
import Process.Category;//Lớp Category trong Proccess đã thực hiện
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieef
 */
public class frmCate extends javax.swing.JInternalFrame {
    
     // Xử lý hiện thị dữ liệu khi Form được mở
   
    private final Category lsp = new Category();
    private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel();
         //Ham do du lieu vao tableModel
    public void ShowData() throws SQLException{
    ResultSet result= lsp.Category();
    try {
            while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[2];
            rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
            tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
            //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        }
    catch (SQLException e) {
        }
    } 

        //Ham xoa du lieu trong tableModel
    public void XoaDuLieu() throws SQLException{
        //Lay chi so dong cuoi cung
        int n=tabelCate.getRowCount()-1;
        for(int i=n;i>=0;i--)
        tabelCate.remove(i);//Remove tung dong
    } 
    //Ham xoa cac TextField
    private void setNull(){ 
        //Xoa trang cac JtextField
        this.txtID.setText(null);
        this.txtName.setText(null);
        this.txtID.requestFocus();
    }
    //Ham khoa cac TextField
    private void setKhoa(boolean a)
    {
        //Khoa hoac mo khoa cho Cac JTextField
        this.txtID. setEnabled (!a);
        this.txtName. setEnabled (!a);
    } 
    //Ham khoa cac Button
    private void setButton(boolean a){
        //Vo hieu hoac co hieu luc cho cac JButton
        this.btnAdd. setEnabled (a);
        this.btnDelete. setEnabled (a);
        this.btnEdit. setEnabled (a);
        this.btnSave. setEnabled (!a);
        this.btnClear. setEnabled (!a);
        this.btnSearch. setEnabled (a);
    }
//    public frmCate() throws SQLException, SQLException, SQLException{
//        initComponents(); // Khởi tạo các components trên JFrame
//        
//        String []colsName = {"ID", "Name"};
////         đặt tiêu đề cột cho tableModel
//        tableModel.setColumnIdentifiers(colsName);
//        
//        
//        // kết nối jtable với tableModel
//        tabelCate.setModel(tableModel);
//        //gọi hàm ShowData để đưa dữ liệu vào tableModel
//        ShowData();
//        //goi Ham xoa trang cac TextField
//        setNull();
//        //Goi ham Khoa cac TextField
//        setKhoa(true);
//        //Goi vo hieu 2 button Luu, K.Luu. Mo khoa 4 button con lao
//        setButton(true);
//        }
    
    
   

    /**
     * Creates new form frmStaff
     */
    public frmCate() throws SQLException {
        initComponents();
        setTitle("STAFF PAGE");
        
        String []colsName = {"ID", "Name"};
//         đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        
        
        // kết nối jtable với tableModel
        tabelCate.setModel(tableModel);
        //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowData();
        //goi Ham xoa trang cac TextField
        setNull();
        //Goi ham Khoa cac TextField
        setKhoa(true);
        //Goi vo hieu 2 button Luu, K.Luu. Mo khoa 4 button con lao
        setButton(true);
        
        BasicInternalFrameUI bs = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener l: bs.getNorthPane().getMouseListeners()){
            bs.getNorthPane().removeMouseListener(l);
        }      
    }
    public static void main(String args[]) throws SQLException {

        frmCate f = new frmCate();
        f.setVisible(true);
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelCate = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setMaximumSize(new java.awt.Dimension(100, 563));
        setMinimumSize(new java.awt.Dimension(100, 563));
        setNextFocusableComponent(this);
        setPreferredSize(new java.awt.Dimension(809, 536));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

        jPanel9.setBackground(new java.awt.Color(207, 244, 210));
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(207, 244, 210));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INFORMATION"));

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel10.setBackground(new java.awt.Color(207, 244, 210));
        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel10.setLayout(new java.awt.BorderLayout());

        tabelCate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        tabelCate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCateMouseClicked(evt);
            }
        });
        tabelCate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelCateKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelCate);

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(207, 244, 210));
        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel8.setPreferredSize(new java.awt.Dimension(807, 90));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(207, 244, 210));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnAdd.setBackground(new java.awt.Color(32, 80, 114));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.setBorderPainted(false);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

        btnEdit.setBackground(new java.awt.Color(32, 80, 114));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("EDIT");
        btnEdit.setBorderPainted(false);
        jPanel2.add(btnEdit);

        btnSave.setBackground(new java.awt.Color(32, 80, 114));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.setBorderPainted(false);
        jPanel2.add(btnSave);

        btnDelete.setBackground(new java.awt.Color(32, 80, 114));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.setBorderPainted(false);
        jPanel2.add(btnDelete);

        btnClear.setBackground(new java.awt.Color(32, 80, 114));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setBorderPainted(false);
        jPanel2.add(btnClear);

        jPanel8.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(207, 244, 210));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        btnSearch.setBackground(new java.awt.Color(32, 80, 114));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("SEARCH");
        btnSearch.setBorderPainted(false);
        jPanel3.add(btnSearch, java.awt.BorderLayout.LINE_END);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(jTextField1, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelCateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelCateKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabelCateKeyReleased

    private void tabelCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCateMouseClicked
        // TODO add your handling code here:
       try{
        //Lay chi so dong dang chon
        int row =this.tabelCate.getSelectedRow();
        int ml=Integer.parseInt((this.tabelCate.getModel().getValueAt(row,0)).toString());
        ResultSet rs= lsp.Category_ID(ml);//Goi ham lay du lieu theo ma loai
        if(rs.next())//Neu co du lieu
        {
            this.txtID.setText(rs.getString("ID"));
            this.txtName.setText(rs.getString("Name"));
        }
        }
        catch (SQLException e) {
        } 
    }//GEN-LAST:event_tabelCateMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        setNull();//Xoa trang TextField
        setKhoa(false);//Mo khoa TextField
        setButton(false);//Goi ham khoa cac Button
        cothem=true;//Gan cothem = true de ghi nhan trang thai them moi
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAddActionPerformed
    
   
     

        

    
       //Code tu sinh khi thiet ke giao dien va cac code khac ở đây…….
      
   
       

   
    
   
     

 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelCate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}