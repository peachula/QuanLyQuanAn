/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import java.sql.*;
import Database.Connect;
/**
 *
 * @author huynh
 */
public class Dish {
    public Connect cn= new Connect();
     //Truy van tat ca du lieu trong Table 
    public ResultSet Dish() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Dish";
        return cn.LoadData(sql);
    }
    
       //Truy van du lieu trong Table theo id
    public ResultSet Dish_ID(int d_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Dish where DishID ='" + d_id +"'";
        return cn.LoadData(sql);
    }
    
    //Truy van du lieu trong Table theo cate id
    public ResultSet DishFromCate(int c_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Dish where CateID ='" + c_id +"'";
        return cn.LoadData(sql);
    }
    
       //Truy van du lieu trong Table theo name
    public ResultSet Dish_Name(String d_name) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Dish where DishName LIKE N'%"+ d_name+"%'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertDish(String d_name, long d_price, int cate_id) throws SQLException{
        String sql = "INSERT INTO Dish values(N'" + d_name +"'," + d_price + ", '"+ cate_id +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditDish(int d_id, String d_name, long d_price, int cate_id) throws SQLException{
        String sql = "Update Dish set DishName = N'"+ d_name +"', DishPrice = "+ d_price +", CateID = '"+
                cate_id + "' where DishID ='" + d_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteDish(int d_id ) throws SQLException{
        String sql = "Delete from Dish where DishID='" + d_id +"'";
        cn.UpdateData(sql);
    }
    
    ///report most used dish
    public ResultSet DishSold(String date, int sort) throws SQLException{
        cn.connectSQL();
        String sql = "";
        if (sort == 0) ///0 là giảm dần
        {
            sql = "select B.DishID, sum(B.Quantity), DishName from (select DishName, Quantity, Dish.DishID, receipt.ReceiptID, Date " +
                " from ReceiptDetail inner join Receipt on receipt.ReceiptID = ReceiptDetail.ReceiptID" +
                " inner join dish on dish.DishID = ReceiptDetail.DishID where date > '"+date+"') as B" +
                " group by B.DishID, DishName order by sum(B.Quantity) DESC";
        }
        else ///1 là tăng dần
        {
            sql = " select B.DishID, sum(B.Quantity), DishName from (select DishName, Quantity, Dish.DishID, receipt.ReceiptID, Date" +
                " from ReceiptDetail inner join Receipt on receipt.ReceiptID = ReceiptDetail.ReceiptID" +
                " inner join dish on dish.DishID = ReceiptDetail.DishID where date > '"+date+"') as B" +
                " group by B.DishID, DishName order by sum(B.Quantity) ASC";
        }
        return cn.LoadData(sql);
    }
    
    ///search by name and id
    public ResultSet DishSearch(String search, String date) throws SQLException{
        cn.connectSQL();
        
        String sql = "select B.DishID, sum(B.Quantity), DishName from (select DishName, Quantity, Dish.DishID, receipt.ReceiptID, Date " +
                " from ReceiptDetail inner join Receipt on receipt.ReceiptID = ReceiptDetail.ReceiptID" +
                " inner join dish on dish.DishID = ReceiptDetail.DishID where date > '"+date+"') as B" +
                " where DishID  like '%" + search +"%'or DishName like '%"+ search+"%'" +
                " group by B.DishID, DishName order by sum(B.Quantity)";
        return cn.LoadData(sql);
    }
    
}
