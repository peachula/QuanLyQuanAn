/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author huynh
 */
public class Receipt {
    
    public Connect cn= new Connect();
    
    //Truy van tat ca du lieu trong Table 
    public ResultSet Receipt() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Receipt";
        return cn.LoadData(sql);
    }
    
    //Truy van du lieu trong Table theo ID 
    public ResultSet Receipt_ID(int r_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Receipt WHERE ReceiptID ='" + r_id +"'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertReceipt(Date date, int c_id, long total) throws SQLException{
        String sql = "INSERT INTO Receipt values(N'" + date +"'," + c_id + ", '"+ total +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditReceipt(int r_id, Date date, int c_id, long total) throws SQLException{
        String sql = "Update Receipt set Date = N'"+ date +"', CustomerID = "+ c_id +", Total = '"+
                total + "' where ReceiptID ='" + r_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteStaff(int r_id ) throws SQLException{
        String sql = "Delete from Receipt where StaffID='" + r_id +"'";
        cn.UpdateData(sql);
    }
    
}
