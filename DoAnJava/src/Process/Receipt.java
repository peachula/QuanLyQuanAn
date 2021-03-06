/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.Connect;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
    public void CompleteReceipt(String r_id, long total, int cus_id) throws SQLException{
        String sql = "Update Receipt set Total = '"+
                total + "', State = '1', CustomerID = '"+cus_id+"' where ReceiptID ='" + r_id +"'";
        cn.UpdateData(sql);
    }
    
    //get all uncomplete order
    public ResultSet UncompleteReceipt() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Receipt where State = 0";
        return cn.LoadData(sql);
    }
    
    
    ///select for report
    public ResultSet ReceiptChart() throws SQLException{
        LocalDateTime now = LocalDateTime.now().minus(Period.ofDays( 30 ));  
        DateTimeFormatter date_f = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String date = date_f.format(now);
        
        cn.connectSQL();
        String sql = "select CONVERT(date, Receipt.Date, 105), sum(total) "
                + "from Receipt where Receipt.date > '"+date+"' "
                + "group by CONVERT(date, Receipt.Date, 105)";
        return cn.LoadData(sql);
    }
    
    ///update customer id
    public void UpdateCustomer(int c_id, String r_id) throws SQLException{
        String sql = "Update Receipt set CustomerID = "+ c_id +" where ReceiptID ='" + r_id +"'";
        cn.UpdateData(sql);
    }

    ///select for report month
    public ResultSet ReceiptReport(int month, int year) throws SQLException{
        
        cn.connectSQL();
        String sql = "select ReceiptID, Date, Total from Receipt where MONTH(Date) = '"+month+"' and YEAR(Date) = '"+year+"' and State = 1";
        return cn.LoadData(sql);
    }
    
    ///select for report all
    public ResultSet ReceiptReportAll() throws SQLException{
        cn.connectSQL();
        String sql = "select ReceiptID, Date, Total from Receipt where State = 1";
        return cn.LoadData(sql);
    }
    
    ///select for report search
    public ResultSet ReceiptSearch(String id, int month, int year) throws SQLException{
        String sql = "";
        if (year == 0 || month == 0)
        {
            sql = "select ReceiptID, Date, Total from Receipt where ReceiptID like '%"+id+"%' and State = 1";
        }
        else
        {
            sql = "select ReceiptID, Date, Total from Receipt where MONTH(Date) = '"+month+"' and YEAR(Date) = '"+year+"' and ReceiptID like '%"+id+"%' and State = 1";
        }
        
        cn.connectSQL();
        return cn.LoadData(sql);
    }
}
