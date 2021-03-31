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
public class ComboDetail {
    
     public Connect cn= new Connect();
    
    //Truy van tat ca du lieu trong Table 
    public ResultSet Combo(int d_id, int combo_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM ComboDetail WHERE DishID = '"+d_id+"' AND ComboID = '"+combo_id+"'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertComboDetail(int d_id, int combo_id,int quantity) throws SQLException{
        String sql = "INSERT INTO ComboDetail values(N'" + d_id +"'," + combo_id+"',"+quantity +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditComboDetail(int d_id, int combo_id,int quantity) throws SQLException{
        String sql = "Update ComboDetail set Quantity = N'"+ quantity +"' where DishID = '"+d_id+"' AND ComboID ='" + combo_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteComboDetail(int d_id,int combo_id ) throws SQLException{
        String sql = "Delete from ComboDetail where DishID = '"+d_id+"' AND ComboID='" + combo_id +"'";
        cn.UpdateData(sql);
    }
   
    
}
