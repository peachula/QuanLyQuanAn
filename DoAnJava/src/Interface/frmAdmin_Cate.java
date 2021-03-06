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
public class frmAdmin_Cate extends javax.swing.JInternalFrame {
    
     // Xử lý hiện thị dữ liệu khi Form được mở
    private final Category lsp = new Category();
    private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel();
         
//Ham do du lieu vao tableModel
    public void ShowData() throws SQLException{
        
        tableModel.getDataVector().removeAllElements(); ///refresh lại model
        tableModel.fireTableDataChanged();
        
        ResultSet result= lsp.Category();
        try {
                while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[3];
                rows[0] = result.getString(1); // id
                rows[1] = result.getString(2); // lộn form :)))
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
                }
            }
        catch (SQLException e) {
            }
    } 
    
    ///showw search data 
    public void ShowSearchData(String s) throws SQLException{
        
        tableModel.getDataVector().removeAllElements(); ///refresh lại model
        tableModel.fireTableDataChanged();
        System.out.println("delete table");
        ResultSet result= lsp.Category_Search(s);
        try {
                while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[3];
                rows[0] = result.getString(1); // id
                rows[1] = result.getString(2); // lộn form :)))
                    System.out.println(rows[0]);
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
                }
            }
        catch (SQLException e) {
            }
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
        //this.txtID. setEnabled (!a);
        this.txtName.setEnabled (!a);
    } 
    //Ham khoa cac Button
    private void setButton(boolean a){
        //Vo hieu hoac co hieu luc cho cac JButton
        this.btnAdd. setEnabled (a);
        this.btnDelete. setEnabled (a);
        this.btnEdit. setEnabled (a);
        this.btnSave. setEnabled (!a);
        this.btnClear. setEnabled (!a);
    }

    public frmAdmin_Cate() throws SQLException {
        initComponents();
        setTitle("CATEGORY PAGE");
        
        String []colsName = {"ID", "Name"};
//         đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        
        
        // kết nối jtable với tableModel
        tableCate.setModel(tableModel);
        tableCate.setDefaultEditor(Object.class, null);
        
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

        frmAdmin_Cate f = new frmAdmin_Cate();
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
        tableCate = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setMaximumSize(new java.awt.Dimension(100, 563));
        setMinimumSize(new java.awt.Dimension(100, 563));
        setNextFocusableComponent(this);
        setPreferredSize(new java.awt.Dimension(809, 536));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INFORMATION"));

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        txtID.setEnabled(false);

        txtName.setEnabled(false);

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

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel10.setLayout(new java.awt.BorderLayout());

        tableCate.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCateMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCate);

        jPanel10.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel8.setPreferredSize(new java.awt.Dimension(807, 90));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnAdd.setBackground(new java.awt.Color(237, 163, 35));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.setBorderPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

        btnEdit.setBackground(new java.awt.Color(237, 163, 35));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("EDIT");
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit);

        btnSave.setBackground(new java.awt.Color(237, 163, 35));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.setBorderPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        btnDelete.setBackground(new java.awt.Color(237, 163, 35));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);

        btnClear.setBackground(new java.awt.Color(237, 163, 35));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setBorderPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear);

        jPanel8.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("SEARCH"));
        jPanel3.setLayout(new java.awt.BorderLayout());

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
        jPanel3.add(btnSearch, java.awt.BorderLayout.LINE_END);

        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });
        jPanel3.add(txtSearch, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCateMouseClicked
        // TODO add your handling code here:
       try{
        //Lay chi so dong dang chon
        int row =this.tableCate.getSelectedRow();
        int ml=Integer.parseInt((this.tableCate.getModel().getValueAt(row,0)).toString());
        
        ResultSet rs= lsp.Category_ID(ml);//Goi ham lay du lieu theo ma loai
        if(rs.next())//Neu co du lieu
        {
            txtID.setText(rs.getString(1));
            this.txtName.setText(rs.getString(2)); ///name nằm ở vị trí 2 trong kết quả trả về của sqlok
        }
        }
        catch (SQLException e) {
        } 
    }//GEN-LAST:event_tableCateMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        setNull();//Xoa trang TextField
        setKhoa(false);//Mo khoa TextField
        setButton(false);//Goi ham khoa cac Button
        cothem=true;//Gan cothem = true de ghi nhan trang thai them moi
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String ml=txtID.getText();
        if(ml.length()==0) //Chua chon Ma loai
        JOptionPane.showMessageDialog(null,"Please select a category to edit","Thong bao",1);
        else
        {
        setKhoa(false);//Mo khoa cac TextField
        this.txtID.enable(false);
        setButton(false); //Khoa cac Button
        cothem=false; //Gan cothem=false de ghi nhan trang thai la sua
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String tl=txtName.getText();
        if(tl.length()==0)
        JOptionPane.showMessageDialog(null, "Please fill out the blank","Empty fields",1);
        else
        { 
//            if(ml>2 || tl.length()>30)
//            JOptionPane.showMessageDialog(null,"Ma loai chi 2 ky tu, ten loai la 20","Thong bao",1);
//            else
//            {
            try {
            if(cothem==true) //Luu cho tthem moi
                lsp.InsertCategory(tl);
            else //Luu cho sua
            {
                int ml= Integer.parseInt(txtID.getText());
                lsp.EditCategory(ml, tl);
            }
            ShowData(); //Do lai du lieu vao Table Model
            }
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cap nhat that bai","Thong bao",1);
            }
            setNull();
            setKhoa(true);
            setButton(true);
//            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String ml=txtID.getText();
//        int ml= Integer.parseInt(txtID.getText());
        try {
        if(ml.length()==0)
            JOptionPane.showMessageDialog(null,"Chon 1 loai SP de xoa","Thong bao",1);
        else
        {
            if(JOptionPane.showConfirmDialog(null, "Ban muon xoa ma " + ml + " nay hay khong?","Thong bao",2)==0)
            {
                int bien = Integer.parseInt(ml);
                lsp.DeleteCategory(bien);//goi ham xoa du lieu theo ma loai
                //ClearData();//Xoa du lieu trong tableModel
                ShowData();//Do du lieu vao table Model ủa nó nè :))))
                setNull();//Xoa trang Textfield
            }
            
        }
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Xóa thất bại","Thong bao",1);
 }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtID.setText("");
        txtName.setText("");
        txtSearch.setText("");
        
        setNull();
        setKhoa(true);
        setButton(true);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String i = txtSearch.getText();
        if (i.trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Nothing to be search");
        }
        else
        {
            try {
                ShowSearchData(i);

            } catch (SQLException ex) {
                Logger.getLogger(frmAdmin_Dish.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        String i = txtSearch.getText();
        try {
            ShowSearchData(i);

        } catch (SQLException ex) {
            Logger.getLogger(frmAdmin_Dish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

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
    private javax.swing.JTable tableCate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}