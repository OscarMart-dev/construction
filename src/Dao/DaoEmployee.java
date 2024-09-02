
package Dao;

import Modelo.area;
import Modelo.employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
         //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql="select empn_id, empc_name, empf_birthdate, empc_address, empn_phone, empn_years_experience, empc_email, empn_post, empc_state, empn_area from emp_employee where empn_id ='"+nro_registro+"'";
        try{
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                emp=new employee();
                emp.setName(rs.getString(1));
                emp.setId(rs.getInt(2));
                Date birthdate = rs.getDate(3);//se toma la fecha
                //emp.setFecha(dateFormat.format(birthdate));// se convierte la feaha a string
                emp.setAddress(rs.getString(4));
                emp.setPhone(rs.getInt(5));
                emp.setYear(rs.getInt(6));                
                emp.setEmail(rs.getString(7));
                emp.setPost(rs.getString(8));
                emp.setState(rs.getString(9));
                emp.setArea(rs.getString(10));
                System.out.println("la consulta es "+sql);
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

        
     public boolean registroExiste(int id) throws SQLException {
            String sql = "select COUNT(*) from emp_employee where empn_id = ?";
            boolean existe = false;

            try {
                con = cn.conectar(); // Establece la conexión con la base de datos
                ps = con.prepareStatement(sql);
                ps.setInt(1, id); // Establece el parámetro de la consulta
                rs = ps.executeQuery();

                if (rs.next()) {
                    int conteo = rs.getInt(1);
                    existe = (conteo > 0); // Si el conteo es mayor que 0, el registro existe
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e; // Lanzar la excepción para que el llamador pueda manejarla
            } finally {
                try {
                    if (con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return existe;
        }
     
     public List<area> obtenerCargo() {
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
     
     public employee createEmp (String name,int id,String date,String address,int phone,int year,String email,int post,String State,int area){
            employee modeloEmployee = null;
            String sql = "INSERT INTO emp_employee (empn_id, empc_name, empf_birthdate, empc_address, empn_phone, empn_years_experience, empc_email, empn_post, empc_state, empn_area) VALUES("+id+",'"+name+"','"+date+"','"+address+"',"+phone+","+year+", '"+email+"',"+post+",'"+State+"',"+area+")";
            try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 JOptionPane.showMessageDialog(null,"El empleado "+id+" fue creado");
                }catch(SQLException e)
                    {
                            JOptionPane.showMessageDialog(null,"Error crear usuario "+e);
                                    System.out.println("Error "+e);
                                        System.out.println("el script que se envio fue este"+sql);
                    }
                        return modeloEmployee;
                }
}
