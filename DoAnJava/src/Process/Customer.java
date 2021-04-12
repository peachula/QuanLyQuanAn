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
public class Customer {
    public Connect cn= new Connect();
    
    //Truy van tat ca du lieu trong Table 
    public ResultSet Customer() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Customer";
        return cn.LoadData(sql);
    }
    
     //Truy van tat ca du lieu trong Table theo id
    public ResultSet Customer_ID(int c_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Customer where CustomerID ='" + c_id +"'";
        return cn.LoadData(sql);
    }
    
     //Truy van tat ca du lieu trong Table theo name
    public ResultSet Customer_Search(String search) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Customer where CustomerName LIKE N'%"+ search +"%' or CustomerID like '%"+search+"%'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertCustomer(String c_name, int phone) throws SQLException{
        String sql = "INSERT INTO Customer values(N'" + c_name +"'," + phone +")";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditCustomer(int c_id, String c_name, int phone) throws SQLException{
        String sql = "Update Customer set CustomerName = N'"+ c_name +"', Phone = "+ phone+
                        " where CustomerID ='" + c_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteCustomer(int c_id ) throws SQLException{
        String sql = "Delete from Customer where CustomerID='" + c_id +"'";
        cn.UpdateData(sql);
    }
    
     //Report customer
    public ResultSet CustomerReport(int sort) throws SQLException{
        cn.connectSQL();
        String sql = "select sum(total), customer.CustomerID, customerName, Phone " +
            "from Customer " +
            "inner join Receipt on Receipt.CustomerID = Customer.CustomerID " +
            "group by customer.CustomerID, customerName, Phone order by sum(total)";
        if (sort ==0)
        {
            sql = sql + " DESC";
        }
        else 
        {
            sql = sql + "ASC";
        }
        return cn.LoadData(sql);
    }
    
    ///search customer
    //Truy van tat ca du lieu trong Table theo id
    public ResultSet CustomerSearch(String search) throws SQLException{
        cn.connectSQL();
        String sql = "select sum(total), customer.CustomerID, customerName, Phone " +
            "from Customer " +
            "inner join Receipt on Receipt.CustomerID = Customer.CustomerID " +
            "where Customer.CustomerID like '%" + search +"%' or Customer.CustomerName like '%"+search+"%' or Phone like '%"+search+"%' " +
            "group by customer.CustomerID, customerName, Phone order by sum(total)";
        
        return cn.LoadData(sql);
    }
    
}
