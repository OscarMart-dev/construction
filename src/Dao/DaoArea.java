
package Dao;

import Modelo.area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<area> list = new ArrayList<>();
        String sql="select * from are_area";
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
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return list;
    }
    
    
    public List ListarAreaCargo(){
        List<area> list = new ArrayList<>();
        String sql="select * from are_area where arec_estado ='A'";//dentro del listado de cargos solo se veran estados activos
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
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return list;
    }
    public List ListarBuscarArea(String busqueda ){
        List<area> list = new ArrayList<>();
        String sql="select * from are_area where arec_name like '%"+busqueda+"%' or aren_id like '%"+busqueda+"%';";
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
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return list;
    }
    

        public void create(String area, char state) {
            String sql = "INSERT INTO construction.are_area (arec_name, arec_estado) VALUES (?, ?)";
            try {
                con = cn.conectar();
                ps = con.prepareStatement(sql);
                ps.setString(1, area);
                ps.setString(2, String.valueOf(state));
                int rowsAffected = ps.executeUpdate();//execute se utiliza para update , insert o delete 

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "El Área " + area + " fue agregada");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el área.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el área: " + e.getMessage());
            } finally {
                // Cerrar los recursos
                try {
                    if (ps != null) ps.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar los recursos: " + e.getMessage());
                }
            }
        }
        
        public area consultar(String nro_registro) throws SQLException {
            area modeloArea = null;
            String sql = "select aren_id,arec_name,arec_estado from are_area where aren_id='"+nro_registro+"'";
             try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 rs=ps.executeQuery();
                 while (rs.next()){
                 modeloArea=new area();
                 modeloArea.setCode(rs.getInt(1));
                 modeloArea.setName(rs.getString(2));
                 modeloArea.setState(rs.getString(3).charAt(0));
            }  
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,"read");
            }
                return modeloArea;
            }
        
        public area actualizar (int id,String name,char state){
               area modeloArea = null;
               String sql = "update are_area set arec_name='"+name+"',arec_estado='"+state+"' where aren_id ="+id;
               try {
                 System.out.println("update "+sql);
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();//execute se utiliza para update , insert o delete 
                 JOptionPane.showMessageDialog(null,"El area "+name+" fue actualizada");
             }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error update"+e);
                   System.out.println("Error"+e);
            }
                return modeloArea;
            }
        
        public String nombreArea (int id){
                String nombre=null;
            String sql = "select arec_name from are_area where aren_id='"+id+"'";
             try {
                 con=cn.conectar();
                 ps=con.prepareStatement(sql);
                 rs=ps.executeQuery();
                 while (rs.next()){
                 nombre=(rs.getString(1));
                    // System.out.println("obtenida el area ahora "+nombre);    
                 }  
            }catch(SQLException e){
                    JOptionPane.showConfirmDialog(null,"Error obteniendo el area "+rs);
            } finally {
        // Cierra los recursos para evitar fugas de memoria
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                return nombre;
        
        }
        
            public List ListarAreaEmp(){
            List<area> list = new ArrayList<>();
            String sql="select arec_name from are_area where arec_estado ='A'";//dentro del listado de cargos solo se veran estados activos
            try{
                con=cn.conectar();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){
                area a=new area();
                a.setName(rs.getString(1));
                list.add(a);
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e);
                }
                    return list;
                    }
        
        public int retornaAreaId(String name) throws SQLException {
            int id = 0;
            String sql = "select aren_id from are_area where arec_name ='"+name+"'";
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
 }




