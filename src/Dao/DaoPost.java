
package Dao;

import Modelo.post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoPost {
    
    Connection con;
    connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public DaoPost() {
        this.cn = new connection();
    }
    
    
    public List ListarCargo(){
        List<post> list = new ArrayList<>();
        String sql="""
                   select posn_id,posc_name,arec_name,case posc_estado when 'A' then "Activo" else "Inactivo" end posc_estado  from pos_post, are_area 
                   where posn_are_id=aren_id """;
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
            post p=new post();
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setAreaName(rs.getString(3));
            p.setStateName(rs.getString(4));
            list.add(p);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return list;
    }
    
    
}
