
package Dao;

import Modelo.employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null,e);
    }
    return list;
}
    
}
