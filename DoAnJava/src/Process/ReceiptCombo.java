/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huynh
 */
public class ReceiptCombo {
    
     public Connect cn= new Connect();
    //Truy van tat ca du lieu trong Table 
    public ResultSet ReceiptCombo(int r_id, int combo_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM ReceiptCombo WHERE ReceiptID = '"+r_id+"' AND ComboID = '"+combo_id+"'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertReceiptCombo(int r_id, int combo_id,int quantity, long total) throws SQLException{
        String sql = "INSERT INTO ReceiptCombo values(N'" + combo_id +"'," + r_id+"',"+quantity+"',"+total +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditReceiptCombo(int r_id, int combo_id,int quantity, long total) throws SQLException{
        String sql = "Update ReceiptCombo set Quantity = N'"+ quantity +
                   "', Total_ReceiptCombo = '"+total+"' where ReceiptID = '"+r_id+"' AND ComboID ='" + combo_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteReceiptCombo(int r_id,int combo_id ) throws SQLException{
        String sql = "Delete from ReceiptCombo where ReceiptID = '"+r_id+"' AND ComboID='" + combo_id +"'";
        cn.UpdateData(sql);
    }
   
    
}
