
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
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null,e);
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
                int rowsAffected = ps.executeUpdate();

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
 }




