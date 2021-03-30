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
public class Combo {
    
    public Connect cn= new Connect();
    
    //Truy van tat ca du lieu trong Table 
    public ResultSet Combo() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Combo";
        return cn.LoadData(sql);
    }
    
    //Truy van du lieu trong Table theo ID
    public ResultSet Combo_ID(int combo_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Combo where ComboID ='" + combo_id +"'";
        return cn.LoadData(sql);
    }
    //Truy van du lieu trong Table theo name
    public ResultSet Combo_NAME(String combo_name) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Combo where ComboName LIKE N'%"+ combo_name +"%'";
        return cn.LoadData(sql);
    }
    
    
    //Theo moi 1 dong du lieu vao table
    public void InsertCombo(String combo_name, long combo_price) throws SQLException{
        String sql = "INSERT INTO Combo values(N'" + combo_name +"'," + combo_price +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditCombo(int combo_id, String combo_name, long combo_price) throws SQLException{
        String sql = "Update Combo set ComboName = N'"+ combo_name +"', ComboPrice = "+ combo_price +
                            "' where ComboID ='" + combo_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteCombo(int combo_id ) throws SQLException{
        String sql = "Delete from Combo where ComboID='" + combo_id +"'";
        cn.UpdateData(sql);
    }
    
}
