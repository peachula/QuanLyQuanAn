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
public class ReceiptDetail {
      public Connect cn= new Connect();
      
    //Truy van tat ca du lieu trong Table 
    public ResultSet ReceiptDishDetail(int r_id, int d_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM ReceiptDetail WHERE ReceiptID = '"+r_id+"' AND DishID = '"+d_id+"'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertReceiptDetail(String r_id, int d_id,int quantity, long total) throws SQLException{
        String sql = "INSERT INTO ReceiptDetail values(N'" + r_id +"','" + d_id+"',"+quantity+","+total +")";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditReceiptDetail(String r_id, int d_id,int quantity, long total) throws SQLException{
        String sql = "Update ReceiptDetail set Quantity = N'"+ quantity +
                   "', Total_ReceiptDetail = '"+total+"' where ReceiptID = '"+r_id+"' AND DishID ='" + d_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteReceiptDetail(String r_id,int d_id ) throws SQLException{
        String sql = "Delete from ReceiptDetail where ReceiptID = '"+r_id+"' AND DishID='" + d_id +"'";
        cn.UpdateData(sql);
    }
    
    //Truy van cac detail duoc chon
    public ResultSet ShowDetail(String r_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT Dish.DishID, Quantity, ReceiptDetail.Total_ReceiptDetail, DishName " +
            "FROM ReceiptDetail " +
            "inner join Dish on Dish.DishID = ReceiptDetail.DishID " +
            "WHERE ReceiptID = '"+r_id+"'";
        return cn.LoadData(sql);
    }
   
}
