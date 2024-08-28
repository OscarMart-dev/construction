
package Dao;

import Modelo.area;
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
        String sql="select empc_name,empn_id,empf_birthdate,empc_address,empn_years_experience,empc_email,empn_post,empc_state,empn_area from emp_employee where empn_id ='"+nro_registro+"'";
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
                emp.setArea(rs.getString(9));
            }
               
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,"por aca esta entrando");
        }
        return emp;
    }
    
        public List<area> obtenerAreas() {
        List<area> areas = new ArrayList<>();
        String sql = "SELECT aren_id, arec_name, arec_estado FROM are_area WHERE arec_estado = 'A'";

        try {
            con = cn.conectar();  // Método para conectar a la base de datos
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int code = rs.getInt("aren_id");
                String name = rs.getString("arec_name");
                char state = rs.getString("arec_estado").charAt(0);
                areas.add(new area(code, name, state));
            }
        } catch (Exception e) {
            System.out.println("no encontro areas");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("cierra conexion");
            }
        }
        return areas;
    }

}
