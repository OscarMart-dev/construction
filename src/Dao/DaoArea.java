
package Dao;

import Modelo.area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DaoArea {
    
    Connection con;
    connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public DaoArea() {
        this.cn = new connection();
    }
    
    
    public List Listar(){
    List<area> list =new ArrayList<>();
    String sql="select * from are_area where arec_estado ='A'";
    try{
        con=cn.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
        area a=new area();
        a.setCode(rs.getInt(1));
        a.setName(rs.getString(2));
        list.add(a);
        }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null,e);
    }
    return list;
    
       
    }

}
