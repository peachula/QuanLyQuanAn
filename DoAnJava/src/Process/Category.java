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
public class Category {
    
    public Connect cn= new Connect();
    
    //Truy van tat ca du lieu trong Table 
    public ResultSet Category() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Category";
        return cn.LoadData(sql);
    }
    
    //Truy van du lieu trong Table theo ID
    public ResultSet Category_ID(int cate_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Category where CateID ='" + cate_id +"'";
        return cn.LoadData(sql);
    }
    //Theo moi 1 dong du lieu vao table
    public void InsertCategory(String cate_name) throws SQLException{
        String sql = "INSERT INTO Category values(N'" + cate_name +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditCategory(int cate_id, String cate_name) throws SQLException{
        String sql = "Update Category set CateName = N'"+ cate_name 
                        + "' where CateID ='" + cate_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteCategory(int cate_id ) throws SQLException{
        String sql = "Delete from Category where CateID='" + cate_id +"'";
        cn.UpdateData(sql);
    }
    
    
}
