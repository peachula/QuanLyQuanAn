/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.Connect;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author huynh
 */
public class Receipt {
    
    public Connect cn= new Connect();
    
    //Truy van tat ca du lieu trong Table 
    public ResultSet ShowReceipt() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Receipt";
        return cn.LoadData(sql);
    }
    
    //Truy van du lieu trong Table theo ID 
    public ResultSet GetReceipt(String r_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Receipt WHERE ReceiptID ='" + r_id +"'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertReceipt(String date, String r_id) throws SQLException{
        String sql = "INSERT INTO Receipt (ReceiptID, Date, State, Total, CustomerID) values('" + r_id +"','" + date + "', 0, 0, 1)";  
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditReceipt(String r_id, Date date, String c_id, long total) throws SQLException{
        String sql = "Update Receipt set Date = N'"+ date +"', CustomerID = "+ c_id +", Total = '"+
                total + "' where ReceiptID ='" + r_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteReceipt(String r_id ) throws SQLException{
        String sql = "Delete from Receipt where ReceiptID='" + r_id +"'";
        cn.UpdateData(sql);
    }
    
    ///complete order
    public void CompleteReceipt(String r_id, long total) throws SQLException{
        String sql = "Update Receipt set Total = '"+
                total + "', State = '1' where ReceiptID ='" + r_id +"'";
        cn.UpdateData(sql);
    }
    
    //get all uncomplete order
    public ResultSet UncompleteReceipt() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Receipt where State = 0";
        return cn.LoadData(sql);
    }
    
}
