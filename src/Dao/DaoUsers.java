
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.users;
import javax.swing.JOptionPane;

/*import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalDate;*/


public class DaoUsers {

    Connection con;
    connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public DaoUsers() {
        this.cn = new connection();
    }
    
    public users login (String user, String pass){
        users us=new users();
        String sql="select * from use_users where usec_code='"+user+"' and usec_password='"+pass+"'";
        try{
        con=cn.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
            while (rs.next()) {
                us.setCode(rs.getString(1));
                us.setName(rs.getString(2));
                us.setPassword(rs.getString(3));
                us.setEmail(rs.getString(4));
                us.setState(rs.getString(5));
                //Timestamp sqlTimestamp = rs.getTimestamp(6);
                //LocalDateTime localDateTime = sqlTimestamp.toLocalDateTime();
                //us.setEntry_date(localDateTime);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return us;
    }
    
}
