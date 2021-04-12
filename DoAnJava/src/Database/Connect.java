/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author kieef
 */
public class Connect {
//    SSLParameters sslParameters = new SSLParameters();
//    sslParameters.setProtocols(new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"});
    public Connection conn = null;
    
    public void connectSQL() throws SQLException{
    try {
        String userName ="sa";
        String password = "123";
        
        
        String url = "jdbc:sqlserver://DESKTOP-BH0CK03;databaseName=QuanLyQuanAn;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = java.sql.DriverManager.getConnection(url,userName,password);
        }
        catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null,"Ket noi CSDL that bai","Thong bao",1);
        }
    }
    
    ///thực hiện truy vấn
    public ResultSet LoadData(String sql){
        ResultSet result = null;
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(sql);
            } catch (SQLException e) {
            e.printStackTrace();
            return null ;
        }
    }
    
    ///thực hiện thêm sửa xóa
    public void UpdateData(String sql)
    {
        try 
        {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        }
            catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Truy van cac dong du lieu trong Table LoaiSP theo Maloai


}
