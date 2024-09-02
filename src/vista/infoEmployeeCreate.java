/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import Dao.DaoEmployee;
import Dao.DaoArea;
import Dao.DaoPost;
import Modelo.area;
import Modelo.employee;
import Modelo.post;
import java.util.List;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Menu;
public class infoEmployeeCreate extends javax.swing.JFrame {

    
    DaoEmployee daoE=new DaoEmployee();
    DaoArea     darea=new DaoArea();
    DaoPost     daoP=new DaoPost();
    
    private Menu menu;
    /**
     * Creates new form infoEmployee
     * @return 
     */
    
     public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public infoEmployeeCreate() {

    }

    public infoEmployeeCreate(Menu menu) {
        initComponents();
        this.setLocationRelativeTo(null);//esto hace que la ventana se situe en el centro de la pantalla
        //listado de area
        this.menu = menu;
        List<area> areas = daoE.obtenerAreas();
        for (area areaObj : areas) {
        String areaName =(areaObj.getName());//se almacena en una variable para evitar Dise�o
        cmbarea.addItem(areaName);
        }
         // Agregar un ActionListener para recalcular los posts al cambiar el área
            cmbarea.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    recalcularPosts();
                }
            });

            // Cálculo inicial
            recalcularPosts();
    }

            private void recalcularPosts() {
            String areaName = (String) cmbarea.getSelectedItem();
            int idArea = 0;

            try {
                idArea = darea.retornaAreaId(areaName);
                        } catch (SQLException ex) {
                            Logger.getLogger(infoEmployeeCreate.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    if (idArea > 0) {
                        cmbpost.removeAllItems();  // Limpiar la lista de cargos  antes de agregar nuevos cargos

                        List<post> posts = daoP.ListarCargoEmpl(idArea);
                        for (post postObj : posts) {
                            String postName = postObj.getAreaName();
                            cmbpost.addItem(postName);
                        }
                    } else {
                        System.out.println("ID de área no válido");
                    }
            }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtdocumento = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtyear = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        cmbarea = new javax.swing.JComboBox<>();
        cmbpost = new javax.swing.JComboBox<>();
        cmbstate = new javax.swing.JComboBox<>();
        btnaCrearEmployee = new javax.swing.JButton();
        DateFecha = new com.toedter.calendar.JDateChooser();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setText("Nombre:");

        jLabel3.setText("N° Documento:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Años de experiencia:");

        jLabel8.setText("Correo");

        jLabel9.setText("Area");

        jLabel10.setText("Cargo");

        jLabel11.setText("Estado");

        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnameKeyTyped(evt);
            }
        });

        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyTyped(evt);
            }
        });

        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphoneKeyTyped(evt);
            }
        });

        txtyear.setToolTipText("");
        txtyear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtyearKeyTyped(evt);
            }
        });

        cmbarea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbareaPropertyChange(evt);
            }
        });

        cmbstate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        btnaCrearEmployee.setText("Crear");
        btnaCrearEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaCrearEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txtphone, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbarea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbpost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbstate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnaCrearEmployee, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtaddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6))
                                            .addComponent(txtphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7))
                                    .addComponent(txtyear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6))
                    .addComponent(cmbarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(cmbstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnaCrearEmployee)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaCrearEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaCrearEmployeeActionPerformed
        String name=txtname.getText();
        //se toma a fecha//
        //se obtiene el año de nac
        String address=txtaddress.getText();
        int phone=0;
        if (txtphone.getText() != null && !txtphone.getText().trim().isEmpty()){
            phone=Integer.parseInt(txtphone.getText());
        }
        //se obtiene el nombre del area
        String areaName = (String) cmbarea.getSelectedItem();
        //se retortna el id del area
        int idArea=0;
        try {
            idArea = darea.retornaAreaId(areaName);
        } catch (SQLException ex) {
            Logger.getLogger(infoEmployeeCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("el id area es "+idArea);
        //se retorna el nombre del cargo
        String cargoName=(String) cmbpost.getSelectedItem();
        //se retorna el id del cargo
        int idCargo=0;
        try {
            idCargo=daoP.retornaCargoId(cargoName);
        } catch (SQLException ex) {
            Logger.getLogger(infoEmployeeCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
        String email=txtemail.getText();
        char stateUsuario;
                if (cmbstate.getSelectedItem()=="Activo"){
                        stateUsuario='A';
                    }else {
                        stateUsuario='I';
                    }
        String stateUsu = Character.toString(stateUsuario);
        //validaciones//
        if (name != null && !name.trim().isEmpty()) { //se verifica que no este vacio el primer campo
            if (txtdocumento.getText() != null && !txtdocumento.getText().trim().isEmpty()){
                        int id=Integer.parseInt(txtdocumento.getText());
                if (DateFecha.getDate() != null && !DateFecha.getDate().equals(new Date(0))){
                                        Date fechaSeleccionada=DateFecha.getDate();
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        SimpleDateFormat dateyear = new SimpleDateFormat("yyyy");
                                        String fechaNac = dateFormat.format(fechaSeleccionada);
                                        String anonac = dateyear.format(fechaSeleccionada);
                                        int ano = Integer.parseInt(anonac);
                                        // se obtiene el año actual
                                        Calendar hoy = Calendar.getInstance();
                                        int anio = hoy.get(Calendar.YEAR);
                                        //se obtiene la edad
                                         int edad =anio-ano;
                    if (address != null && !address.trim().isEmpty()){
                        if (txtyear.getText() != null && !txtyear.getText().trim().isEmpty()){
                                 int year=Integer.parseInt(txtyear.getText());
                                    if (year<3){
                                            JOptionPane.showMessageDialog(null,"El personal debe tener al menos 3 años de \n" +
                                            "experiencia");}
                                            if (email != null && !email.trim().isEmpty()){
                                if (idArea == 1){
                                    if (edad >= 25 && edad <= 60){
                                        daoE.createEmp(name, id, fechaNac, address, phone, year, email, idCargo, stateUsu, idArea);
                                        this.getMenu().ListarEmployee();// Asumiendo que esto actualiza la lista de áreas
                                        dispose();
                                    }else{
                                     JOptionPane.showMessageDialog(null,"La edad para aplicar al area de "+areaName+" debe ser entre 25 y 60 años");    
                                    }
                            }else { 
                                    if (idArea == 2){
                                        if (edad >= 20 && edad <= 70){
                                                daoE.createEmp(name, id, fechaNac, address, phone, year, email, idCargo, stateUsu, idArea);
                                                this.getMenu().ListarEmployee();// Asumiendo que esto actualiza la lista de áreas
                                                dispose();
                                            }else{
                                                JOptionPane.showMessageDialog(null,"La edad para aplicar al area de "+areaName+" debe ser entre 20 y 70 años");    
                                            }
                                    }else {
                                    daoE.createEmp(name, id, fechaNac, address, phone, year, email, idCargo, stateUsu, idArea);
                                    this.getMenu().ListarEmployee();// Asumiendo que esto actualiza la lista de áreas
                                    dispose();
                                    }
                            } 
                            }else{
                                JOptionPane.showMessageDialog(null,"El campo Email debe estar lleno");    
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"El campo Edad debe estar lleno");    
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"El campo Dirección debe estar lleno");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"El campo Fecha de Nacimiento debe estar lleno");
                }
            }else{
                JOptionPane.showMessageDialog(null,"El campo Documento debe estar lleno");
            }
        }else{
                JOptionPane.showMessageDialog(null,"El campo Nombre debe estar lleno");
        }
    }//GEN-LAST:event_btnaCrearEmployeeActionPerformed

    private void cmbareaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbareaPropertyChange
            cmbpost.removeAllItems();
    }//GEN-LAST:event_cmbareaPropertyChange

    private void txtnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyTyped
        char c = evt.getKeyChar();
            if (!Character.isLetter(c) && c != ' ') {
                evt.consume(); // Consume el evento si el carácter no es una letra ni un espacio
                }
    }//GEN-LAST:event_txtnameKeyTyped

    private void txtdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_txtdocumentoKeyTyped

    private void txtphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_txtphoneKeyTyped

    private void txtyearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyearKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_txtyearKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(infoEmployeeCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(infoEmployeeCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(infoEmployeeCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(infoEmployeeCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new infoEmployeeCreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFecha;
    private javax.swing.JButton btnaCrearEmployee;
    private javax.swing.JComboBox<String> cmbarea;
    private javax.swing.JComboBox<String> cmbpost;
    private javax.swing.JComboBox<String> cmbstate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
