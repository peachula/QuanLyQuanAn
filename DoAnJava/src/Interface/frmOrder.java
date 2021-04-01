/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Process.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieef
 */


public class frmOrder extends javax.swing.JFrame {

    private final Receipt  main_order = new Receipt();
    private final ReceiptDetail main_detail = new ReceiptDetail();
    private final Category main_cate = new Category();
    private final Dish main_dish = new Dish();
    
    
    private long total;
    private String order_id = "";
    private int customerID;
    
    private int cateID = 0;
    
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private final DefaultTableModel tableModelDish = new DefaultTableModel();
    private final DefaultTableModel tableModelCate = new DefaultTableModel();
    private final DefaultTableModel tableModelDetail = new DefaultTableModel();
    /**
     * Creates new form frmOrder
     */
    public frmOrder() throws SQLException {
        initComponents();
        setSize(794,612);
        setLocationRelativeTo(null);
        
        
        ///setting for tbOrderID
        String []colsName_OrderID = {"ORDER NUM"};
        // đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName_OrderID);
        tbOrderID.setModel(tableModel);
        //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowUncompleteOrderData();
        
        ///setting for tbCate
        String []colsName_Cate = {"ID","Cate Name"};
        // đặt tiêu đề cột cho tableModel
        tableModelCate.setColumnIdentifiers(colsName_Cate);
        tbCate.setModel(tableModelCate);
        ShowCateList();
        
        ///setting for tbDish
        String []colsName_Dish = {"ID","Dish Name","Price"};
        // đặt tiêu đề cột cho tableModel
        tableModelDish.setColumnIdentifiers(colsName_Dish);
        tbDish.setModel(tableModelDish);
        ShowDishList();
        
        ///setting for tbDetail
        String []colsName_Detail = {"Dish Name","Quantity", "Total"};
        // đặt tiêu đề cột cho tableModel
        tableModelDetail.setColumnIdentifiers(colsName_Detail);
        tbOrderDetail.setModel(tableModelDetail);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrderID = new javax.swing.JTable();
        btnNewOrder = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbOrderDetail = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDateTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        btnDeleteOrder = new javax.swing.JButton();
        txtOrderID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnComplete = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCate = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        spQuantity = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbDish = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(794, 612));
        setMaximumSize(new java.awt.Dimension(794, 612));
        setMinimumSize(new java.awt.Dimension(794, 612));
        setPreferredSize(new java.awt.Dimension(794, 612));
        setSize(new java.awt.Dimension(794, 612));

        jPanel2.setMinimumSize(new java.awt.Dimension(612, 320));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 100));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel10.setMaximumSize(new java.awt.Dimension(300, 50));
        jPanel10.setMinimumSize(new java.awt.Dimension(300, 50));
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel10.setLayout(new java.awt.BorderLayout());

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel10.add(btnBack, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel10);

        tbOrderID.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "ORDER NUM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbOrderID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOrderIDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbOrderID);
        if (tbOrderID.getColumnModel().getColumnCount() > 0) {
            tbOrderID.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane1);

        btnNewOrder.setText("NEW");
        btnNewOrder.setMaximumSize(new java.awt.Dimension(300, 100));
        btnNewOrder.setMinimumSize(new java.awt.Dimension(300, 100));
        btnNewOrder.setPreferredSize(new java.awt.Dimension(300, 50));
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewOrder);

        jPanel2.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel3.setMinimumSize(new java.awt.Dimension(612, 320));
        jPanel3.setPreferredSize(new java.awt.Dimension(612, 612));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setMaximumSize(new java.awt.Dimension(569, 300));
        jPanel4.setMinimumSize(new java.awt.Dimension(569, 300));
        jPanel4.setPreferredSize(new java.awt.Dimension(569, 300));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("ORDER DETAILS"));
        jPanel7.setMinimumSize(new java.awt.Dimension(35, 300));
        jPanel7.setPreferredSize(new java.awt.Dimension(612, 300));
        jPanel7.setLayout(new java.awt.BorderLayout());

        tbOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dish Name", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbOrderDetail.setMinimumSize(new java.awt.Dimension(60, 280));
        tbOrderDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOrderDetailMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbOrderDetail);

        jPanel7.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel11.setPreferredSize(new java.awt.Dimension(0, 70));

        jLabel1.setText("Date Time");

        jLabel2.setText("Customer");

        btnDeleteOrder.setText("DELETE");
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        jLabel4.setText("Order ID");

        jLabel5.setText("Total");

        btnComplete.setText("COMPLETE");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel6.setMinimumSize(new java.awt.Dimension(35, 100));
        jPanel6.setPreferredSize(new java.awt.Dimension(612, 100));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("CATEGORY"));
        jPanel9.setMinimumSize(new java.awt.Dimension(35, 150));
        jPanel9.setPreferredSize(new java.awt.Dimension(464, 150));
        jPanel9.setLayout(new java.awt.BorderLayout());

        tbCate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Cate Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCateMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCate);
        if (tbCate.getColumnModel().getColumnCount() > 0) {
            tbCate.getColumnModel().getColumn(0).setResizable(false);
            tbCate.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel9.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel5.setMinimumSize(new java.awt.Dimension(612, 162));
        jPanel5.setPreferredSize(new java.awt.Dimension(612, 162));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("ADD DISH "));
        jPanel8.setMaximumSize(new java.awt.Dimension(2147483647, 150));
        jPanel8.setMinimumSize(new java.awt.Dimension(135, 150));
        jPanel8.setPreferredSize(new java.awt.Dimension(612, 150));
        jPanel8.setLayout(new java.awt.BorderLayout());

        spQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spQuantity.setEnabled(false);
        spQuantity.setMinimumSize(new java.awt.Dimension(32, 20));
        spQuantity.setPreferredSize(new java.awt.Dimension(32, 20));

        btnAdd.setText("ADD");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(spQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jPanel8.add(jPanel12, java.awt.BorderLayout.LINE_END);

        tbDish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Dish Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class
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
        tbDish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDishMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbDish);

        jPanel8.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ///show order uncomplte
    public void ShowUncompleteOrderData() throws SQLException{
        tableModel.getDataVector().removeAllElements();
        ResultSet result= main_order.UncompleteReceipt();
        try {
            while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[5];
            rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel
            //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
        }
        catch (SQLException e) {
        }
    }
    
    ///đưa ra cái list các order detail được chọn cho bảng tbDetail
    public void ShowDetailList() throws SQLException
    {
        tableModelDetail.setRowCount(0);
        tableModelDetail.getDataVector().removeAllElements();
        ResultSet result= main_detail.ShowDetail(order_id);
        try {
            while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[5];
            rows[0] = result.getString(2);
            rows[1] = result.getString(3);
            rows[2] = result.getString(4);
            tableModelDetail.addRow(rows); // đưa dòng dữ liệu vào tableModel
            //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update
            }
            
        }
        catch (SQLException e) {
        }
    }
        
    ///show selected order lên các txt
    public void ShowOrderDetail(String orderid) throws SQLException
    {
        ResultSet rs= main_order.GetReceipt(orderid);//Goi ham lay du lieu theo ma loai
            if(rs.next())//Neu co du lieu
            {
                order_id = rs.getString("ReceiptID");
                total = rs.getLong("Total");
                customerID = rs.getInt("CustomerID");
                
                this.txtCustomerID.setText(String.valueOf(customerID));
                this.txtDateTime.setText(rs.getString("Date"));
                this.txtTotal.setText(String.valueOf(total));
                this.txtOrderID.setText(order_id);
            }
    }
    
    ///show dish of the selected cate tbDish 
    public void ShowDishFromCate() throws SQLException
    {
        tableModelDish.getDataVector().removeAllElements();
        ResultSet rs= main_dish.DishFromCate(cateID);
        try {
            while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[4];
            rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            rows[1] = rs.getString(2); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            rows[2] = rs.getString(3); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            tableModelDish.addRow(rows); // đưa dòng dữ liệu vào tableModelDish
            //mỗi lần có sự thay đổi dữ liệu ở tableModelDish thì Jtable sẽ tự động update
            }
        }
        catch (SQLException e) {
        }
    }
    
    ///show dish tbDish
    public void ShowDishList() throws SQLException
    {
        tableModelDish.getDataVector().removeAllElements();
        ResultSet rs= main_dish.Dish();
        try {
            while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[4];
            rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            rows[1] = rs.getString(2); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            rows[2] = rs.getString(3); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            tableModelDish.addRow(rows); // đưa dòng dữ liệu vào tableModelDish
            //mỗi lần có sự thay đổi dữ liệu ở tableModelDish thì Jtable sẽ tự động update
            }
        }
        catch (SQLException e) {
        }
    }
    
    ///show cate list tbCate
    public void ShowCateList() throws SQLException
    {
        ResultSet rs= main_cate.Category();
        try {
            while(rs.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
            String rows[] = new String[2];
            rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            rows[1] = rs.getString(2); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
            tableModelCate.addRow(rows); // đưa dòng dữ liệu vào tableModelDish
            //mỗi lần có sự thay đổi dữ liệu ở tableModelDish thì Jtable sẽ tự động update
            }
        }
        catch (SQLException e) {
        }
    }
    
    ///adđ dish into order detail
    public void AddDishToOrder(int d_id, int qua, long pri) throws SQLException
    {
                
        ///kiểm tra xem đã chọn order chưa
        if (order_id.equals(""))
        {
            JOptionPane.showMessageDialog(this, "PLEASE ADD OR CHOOSE AN ORDER");
        }
        else 
        {
            ///kiểm tra xem đã tồn tại chưa, nếu đã tồn tại thì cộng dồn
            for (int i = 0; i < tbOrderDetail.getRowCount(); i++) {
                if (Integer.parseInt(tbOrderDetail.getModel().getValueAt(i, 0).toString()) == d_id)
                {
                    int pre_quan = Integer.parseInt(tbOrderDetail.getModel().getValueAt(i, 1).toString());
                    int new_quan = pre_quan + qua;
                    main_detail.EditReceiptDetail(order_id,d_id,new_quan ,new_quan*pri );
                    return;
                }
            }
            
            ///nếu k thì add mới vào
            main_detail.InsertReceiptDetail(order_id,d_id, qua,qua*pri);
        }
    }
    
    public void UpdateTotal()
    {
        long sum = 0;
        for (int i = 0; i < tbOrderDetail.getRowCount(); i++) 
        {
            sum = sum + Long.parseLong(tbOrderDetail.getModel().getValueAt(i, 2).toString());
        }
        txtTotal.setText(String.valueOf(sum));
    }
    
    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        // TODO add your handling code here:
        ///xóa order xuông và hiện thông báo
        try {
            main_order.DeleteReceipt(order_id);
            JOptionPane.showMessageDialog(this, "Delete completed");
            ShowUncompleteOrderData();
        } catch (SQLException ex) {
            Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        // TODO add your handling code here:
        ///tạo OrderID 
        Date rightNow = Calendar.getInstance().getTime();
        LocalDateTime now = LocalDateTime.now();  
        DateTimeFormatter id_new = DateTimeFormatter.ofPattern("yyMMddHHmmss");  
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");         
        String o_date = date.format(now);
        String o_id = id_new.format(now);
        
        try {
            ///thêm order vào csdl
            main_order.InsertReceipt(o_date, o_id);
            order_id = o_id;
            
            ShowUncompleteOrderData(); ///load lại table
            ShowOrderDetail(order_id); ///lấy cái id của order mới tạo qua bảng detail luôn
            ShowDetailList();
            UpdateTotal();
            
        } catch (SQLException ex) {
            Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void tbOrderIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrderIDMouseClicked
        // TODO add your handling code here:
            //Lay chi so dong dang chon
        int row =this.tbOrderID.getSelectedRow();
        String ml=(this.tbOrderID.getModel().getValueAt(row,0)).toString();
            
        try {
            ShowOrderDetail(ml);
            ShowDetailList();
            UpdateTotal();
            
        } catch (SQLException ex) {
            Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_tbOrderIDMouseClicked

    private void tbCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCateMouseClicked
        try {
            // TODO add your handling code here:
            ///hien thi cac dish thuoc cate do
            int row =this.tbCate.getSelectedRow();
            cateID = Integer.parseInt((this.tbCate.getModel().getValueAt(row,0)).toString());
            ShowDishFromCate();
        } catch (SQLException ex) {
            Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_tbCateMouseClicked

    private void tbDishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDishMouseClicked
        // TODO add your handling code here:
        ///co the add
        btnAdd.setEnabled(true);
        spQuantity.setValue(1);
        spQuantity.setEnabled(true);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_tbDishMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        ///lấy giá trị của dish được chọn
        int row =this.tbDish.getSelectedRow();
        int dish_id = Integer.parseInt((this.tbDish.getModel().getValueAt(row,0)).toString());
        long dish_price = Long.parseLong((this.tbDish.getModel().getValueAt(row,2)).toString());
        int quan = Integer.parseInt(spQuantity.getValue().toString());
        
        try {
            ///thêm vào detail
            AddDishToOrder(dish_id, quan, dish_price);
            UpdateTotal();
            ShowDetailList();
        } catch (SQLException ex) {
            Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /// nut add tro ve trang thai k the nhấn
        btnAdd.setEnabled(false);
        spQuantity.setEnabled(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int row =this.tbOrderDetail.getSelectedRow();
            int sel_dish= Integer.parseInt((this.tbOrderDetail.getModel().getValueAt(row,0)).toString());
            main_detail.DeleteReceiptDetail(order_id,sel_dish);
            ShowDetailList();
        } catch (SQLException ex) {
            Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        total = Long.parseLong(txtTotal.getText());
        order_id = txtOrderID.getText();
        customerID = Integer.parseInt(txtCustomerID.getText());
        
        ///luu order xuông và hiện thông báo
        try {
            main_order.CompleteReceipt(order_id, total);
            JOptionPane.showMessageDialog(this, "Order completed");
        } catch (SQLException ex) {
            Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void tbOrderDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrderDetailMouseClicked
        // TODO add your handling code here:
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tbOrderDetailMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new frmMenu().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmOrder().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTable tbCate;
    private javax.swing.JTable tbDish;
    private javax.swing.JTable tbOrderDetail;
    private javax.swing.JTable tbOrderID;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtDateTime;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
