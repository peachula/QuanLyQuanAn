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
 * @author kieef
 */
public class Staff {
    public Connect cn= new Connect();
    
    //Truy van tat ca du lieu trong Table 
    public ResultSet Staff() throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Staff";
        return cn.LoadData(sql);
    }
    
    //Kiem tra thong tin dang nhap
    public boolean Staff_LogIn(int s_id, String s_pass) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Staff where StaffID =" + s_id +" and Password =  '"+ s_pass +"'";
        if (cn.LoadData(sql).next()) return true;
        return false;
    }
    
    //Truy van du lieu trong Table theo ID
    public ResultSet Staff_ID(int s_id) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Staff where StaffID ='" + s_id +"'";
        return cn.LoadData(sql);
    }
    
    //Truy van du lieu trong Table theo ID
    public ResultSet Staff_Role(int role) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Staff where Role LIKE N'%"+ role +"%'";
        return cn.LoadData(sql);
    }
    
    //Truy van du lieu trong Table theo Name
    public ResultSet Staff_Name(String s_name) throws SQLException{
        cn.connectSQL();
        String sql = "SELECT * FROM Staff where StaffName LIKE N'%"+ s_name +"%'";
        return cn.LoadData(sql);
    }
    
    //Theo moi 1 dong du lieu vao table
    public void InsertStaff(String s_name, int s_role, String s_password) throws SQLException{
        String sql = "INSERT INTO Staff values(N'" + s_name +"'," + s_role + ", '"+ s_password +"')";
        cn.UpdateData(sql);
    }
    
    //Dieu chinh 1 dong du lieu vao table
    public void EditStaff(int s_id, String s_name, int s_role, String s_password) throws SQLException{
        String sql = "Update Staff set StaffName = N'"+ s_name +"', Role = "+ s_role +", Password = '"+
                s_password + "' where StaffID ='" + s_id +"'";
        cn.UpdateData(sql);
    }
    
    //Xoa 1 dong du lieu vao table 
    public void DeleteStaff(String s_id ) throws SQLException{
        String sql = "Delete from Staff where StaffID = '" + s_id +"'";
        cn.UpdateData(sql);
    }
}
