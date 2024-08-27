
package Dao;

import Modelo.employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DaoEmployee {
    
    Connection con;
    connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public DaoEmployee() {
        this.cn = new connection() ;
    }
    
    public List Listar(){
        List<employee> list =new ArrayList<>();
        String sql="select empn_id,empc_name,posc_name from emp_employee join pos_post on (empn_post=posn_id)order by empc_name asc";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                employee e=new employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPost(rs.getString(3));
                list.add(e);
            }
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,e);
        }
        return list;
    }
    
    public employee consultar(String nro_registro){
        employee emp = null;
        String sql="select empc_name,empn_id,empf_birthdate,empc_address,empn_years_experience,empc_email,empn_post,empc_state from emp_employee where empn_id ='"+nro_registro+"'";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                emp=new employee();
                emp.setName(rs.getString(1));
                emp.setId(rs.getInt(2));
                //emp.setBirthdate(rs.getString(3));
                emp.setAddress(rs.getString(4));
                emp.setYear(rs.getInt(5));
                emp.setEmail(rs.getString(6));
                emp.setPost(rs.getString(7));
                emp.setState(rs.getString(8));
            }
               
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,"por aca esta entrando");
        }
        return emp;
    }
    
}
