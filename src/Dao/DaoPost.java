
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
    
    public List ListarBuscarCargo(String busqueda){
        List<post> list = new ArrayList<>();
        String sql="select * from (select posn_id,posc_name,arec_name,case posc_estado when 'A' then 'Activo' else 'Inactivo' end posc_estado  from pos_post, are_area where posn_are_id=aren_id) post where  posn_id like '%"+busqueda+"%' or  lower(posc_name) like '%"+busqueda+"%' or lower(arec_name) like '%"+busqueda+"%' or  lower(posc_estado) like '%"+busqueda+"%'";
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
    
    
    public post actualizar (int id,String name,int stateArea,char state){
               post modeloPost = null;
               String sql = "update pos_post set posc_name='"+name+"',posn_are_id='"+stateArea+"' ,posc_estado='"+state+"' where posn_id ="+id;
               try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 JOptionPane.showMessageDialog(null,"El Cargo "+name+" fue actualizado");
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error update cargo"+e);
                   System.out.println("Error"+e);
            }
                return modeloPost;
            }
    
            public post createCargo (String name,int stateArea,char state){
               post modeloPost = null;
               String sql = "INSERT INTO pos_post (posc_name, posn_are_id, posc_estado) VALUES('"+name+"',"+stateArea+",'"+state+"');";
               try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 JOptionPane.showMessageDialog(null,"El Cargo "+name+" fue creado");
             }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error crear cargo"+e);
                   System.out.println("Error "+e);
                   System.out.println("el script que se envio fue este"+sql);
                    }
                        return modeloPost;
                    }
            
            
    public post consultarCargo(String nro_registro) throws SQLException {
            post modeloPost = null;
            String sql = "select posn_id,posc_name,posn_are_id,posc_estado from pos_post where posn_id ='"+nro_registro+"'";
             try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 rs=ps.executeQuery();
                 while (rs.next()){
                 modeloPost=new post();
                 modeloPost.setId(rs.getInt(1));
                 modeloPost.setName(rs.getString(2));
                 modeloPost.setArea(rs.getInt(3));
                 modeloPost.setState(rs.getString(4).charAt(0));
            }  
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,"read");
            }
                return modeloPost;
            }
    
    public int retornaCargoId(String name) throws SQLException {
            int id = 0;
            String sql = "select posn_id from pos_post where posc_name='"+name+"'";
             try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 rs=ps.executeQuery();
                 while (rs.next()){
                 id=(rs.getInt(1));
            }  
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,"read");
            }finally {
        // Cierra los recursos para evitar fugas de memoria
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                return id ;
            }
    
    public String retornaCargoNombre(int id) throws SQLException {
            String name = null;
            String sql = "select posc_name from pos_post where posn_id ='"+id+"'";
             try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 rs=ps.executeQuery();
                 while (rs.next()){
                 name=(rs.getString(1));
            }  
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,"read");
            }finally {
        // Cierra los recursos para evitar fugas de memoria
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                return name ;
            }
    
        public boolean nombreExiste(String name, int idActual) throws SQLException {
            String sql = "SELECT COUNT(*) FROM pos_post WHERE LOWER(posc_name) = ? and posn_id != ?"; //se mira si existe un nombre igual en otro registro no se cuenta el que estamos usando
            boolean existe = false;
                
            try {
                con = cn.conectar();
                ps = con.prepareStatement(sql);
                ps.setString(1, name.toLowerCase());
                ps.setInt(2, idActual);
                rs = ps.executeQuery();
        
                if (rs.next()) {
                int conteo = rs.getInt(1);
                existe = (conteo > 0); // Si el conteo es mayor que 0, el registro existe
            }
                } catch (SQLException e) {
                // Manejo de la excepción
                e.printStackTrace();
                 throw e; // Lanzar la excepción para que el llamador pueda manejarla
                    } finally {
                        // Cierre de recursos en el bloque finally
                        try {
                            if (con != null) con.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
            return existe;
            }
        
            public boolean registroExiste(String name) throws SQLException {
            String sql = "SELECT COUNT(*) FROM pos_post WHERE lower(posc_name) = ?";
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

            public List ListarCargoEmpl(int area){
           List<post> list = new ArrayList<>();
           String sql="select posc_name from pos_post where posn_are_id ="+area+" and posc_estado ='A'";
                try{
                    con=cn.conectar();
                    ps=con.prepareStatement(sql);
                    rs=ps.executeQuery();
                    while (rs.next()){
                    post p=new post();
                    p.setAreaName(rs.getString(1));
                    list.add(p);
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,e);
                }
                return list;
            }
            
            public boolean registroVinculado(int id) throws SQLException {
            String sql = "SELECT COUNT(*) FROM emp_employee  WHERE empn_post = ?";
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
               
               public post DeleteCargo (int id){
               post modeloPost = null;
               String sql = "delete from pos_post where posn_id="+id;
               try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 JOptionPane.showMessageDialog(null,"El Cargo fue Eliminado");
             }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error crear cargo"+e);
                   System.out.println("Error "+e);
                   System.out.println("el script que se envio fue este"+sql);
                    }
                        return modeloPost;
                    }
}
