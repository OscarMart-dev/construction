
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.users;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



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
        String passhash=hashPassword(pass);
        String sql="select * from use_users where usec_code='"+user+"' and usec_password='"+passhash+"'";
        System.out.println("sql");
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
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return us;
    }
    
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
     public users createUser (String userCod,String username,String userEmail,char userState){
            users modeloUser = null;
            String password=hashPassword(userCod);
            String sql = "INSERT INTO use_users (usec_code, usec_name, usec_password, usec_email, usec_state, usef_entry_date) VALUES('"+userCod+"', '"+username+"','"+password+"', '"+userEmail+"', '"+userState+"', null);";
            try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 JOptionPane.showMessageDialog(null,"El Usuario "+userCod+" fue creado al ingresar al sistema ingrese como contraseña el username y cree una nueva contraseña");
                }catch(SQLException e)
                    {
                            JOptionPane.showMessageDialog(null,"Error crear usuario "+e);
                                    System.out.println("Error "+e);
                                        System.out.println("el script que se envio fue este"+sql);
                    }
                        return modeloUser;
                }
     
     public users updateUser (String userCod,String username,String userEmail,char userState){
            users modeloUser = null;
            String sql = "update use_users set usec_name='"+username+"',usec_email='"+userEmail+"',usec_state='"+userState+"' where usec_code ='"+userCod+"'";
            try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 JOptionPane.showMessageDialog(null,"El Usuario "+userCod+" fue actualizado");
                }catch(SQLException e)
                    {
                            JOptionPane.showMessageDialog(null,"Error actualizar usuario "+e);
                                    System.out.println("Error "+e);
                                        System.out.println("el script que se envio fue este"+sql);
                    }
                        return modeloUser;
                }
     
        public users deleteUser (String userCod){
            users modeloUser = null;
            String sql = "delete from use_users where usec_code ='"+userCod+"'";
            try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 //JOptionPane.showMessageDialog(null,"El Usuario "+userCod+" fue Eliminado");
                }catch(SQLException e)
                    {
                            JOptionPane.showMessageDialog(null,"Error eliminar usuario "+e);
                                    System.out.println("Error "+e);
                                        System.out.println("el script que se envio fue este"+sql);
                    }
                        return modeloUser;
                }
     
        public List ListarUsuarioBuscado(String name){
           List<users> list = new ArrayList<>();
           String sql="select usec_code,usec_name,usec_state from (select usec_code,usec_name, case usec_state when 'A' then 'Activo' else 'Inactivo' end usec_state from use_users) user where usec_code like '%"+name+"%' or usec_name like '%"+name+"%' or usec_state like '%"+name+"%'";
           try{
               con=cn.conectar();
               ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               while (rs.next()){
               users u=new users();
               u.setCode(rs.getString(1));
               u.setName(rs.getString(2));
               u.setState(rs.getString(3));
               list.add(u);
               }
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e);
           }
           return list;
       }
        
        public List ListarUsuario(){
           List<users> list = new ArrayList<>();
           String sql="select usec_code,usec_name, case usec_state when 'A' then 'Activo' else 'Inactivo' end usec_state,usec_email,usef_entry_date from use_users";
           try{
               con=cn.conectar();
               ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               while (rs.next()){
               users u=new users();
               u.setCode(rs.getString(1));
               u.setName(rs.getString(2));
               u.setState(rs.getString(3));
               list.add(u);
               }
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e);
           }
           return list;
       }
        
        public users consultarUsuario(String nro_registro) throws SQLException {
            users modeloUsers = null;
            String sql = "select usec_code,usec_name,usec_email, usec_state ,usef_entry_date from use_users where usec_code='"+nro_registro+"'";
             try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 rs=ps.executeQuery();
                 while (rs.next()){
                 modeloUsers=new users();
                 modeloUsers.setCode(rs.getString(1));
                 modeloUsers.setName(rs.getString(2));
                 modeloUsers.setEmail(rs.getString(3));
                 modeloUsers.setState(rs.getString(4));
                 modeloUsers.setDate(rs.getString(5));
            }  
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,"read");
            }
                return modeloUsers;
            }
    

     public boolean registroExiste(String name) throws SQLException {
            String sql = "SELECT COUNT(*) FROM use_users WHERE lower(usec_code) = ?";
            boolean existe = false;

            try {
                con = cn.conectar(); // Establece la conexión con la base de datos
                ps = con.prepareStatement(sql);
                ps.setString(1, name.toLowerCase()); // Establece el parámetro de la consulta
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

     public boolean verificaEstadoActivo(String name) throws SQLException {
            String sql = "SELECT COUNT(*) FROM use_users WHERE lower(usec_code) =? and usec_state='A'";
            boolean estadoActivo = false;
            try {
                con = cn.conectar(); // Establece la conexión con la base de datos
                ps = con.prepareStatement(sql);
                ps.setString(1, name.toLowerCase()); // Establece el parámetro de la consulta
                rs = ps.executeQuery();

                if (rs.next()) {
                    int conteo = rs.getInt(1);
                    estadoActivo = (conteo > 0); // Si el conteo es mayor que 0, el registro existe
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

            return estadoActivo;
        }

        public boolean registro(String name) throws SQLException {
            String sql = "SELECT COUNT(*) FROM use_users WHERE lower(usec_code) =? and usef_entry_date is not null";
            boolean validaFecha = false;
            try {
                con = cn.conectar(); // Establece la conexión con la base de datos
                ps = con.prepareStatement(sql);
                ps.setString(1, name.toLowerCase()); // Establece el parámetro de la consulta
                rs = ps.executeQuery();

                if (rs.next()) {
                    int conteo = rs.getInt(1);
                    validaFecha = (conteo > 0); // Si el conteo es mayor que 0, el registro existe
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

            return validaFecha;
        }
        
        public users asignaContraseña (String name,String pass){
               users modeloPass = null;
               String hashedPass = hashPassword(pass);//se llama la funion que codifica
               String sql = "update use_users set usec_password ='"+hashedPass+"' ,usef_entry_date=CURDATE() where usec_code ='"+name+"'";
               try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 //JOptionPane.showMessageDialog(null,"El contraseña "+name+" fue actualizado");
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error update contraseña"+e);
                   System.out.println("Error"+e);
            }
                return modeloPass;
            }
        
        public users asignaFecha (String name){
               users modeloFecha = null;
               String sql = "update use_users set usef_entry_date=CURDATE() where usec_code ='"+name+"'";
               try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                   System.out.println("La fecha ultimo ingreso "+name+" fue actualizado");
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error update fecha"+e);
                   System.out.println("Error"+e);
            }
                return modeloFecha;
            }
}
