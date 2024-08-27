/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import Modelo.area;
import Modelo.employee;
import Dao.DaoArea;
import Dao.DaoEmployee;
//import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Menu extends javax.swing.JFrame {
    
   // area ar=new area();
    DaoArea daoA=new DaoArea();
    DefaultTableModel modeloArea=new DefaultTableModel();
    DaoEmployee daoE=new DaoEmployee();
    DefaultTableModel modeloEmployee=new DefaultTableModel();

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);//esto hace que la ventana se situe en el centro de la pantalla
        
        Listar();//inicializar la lista cada vez que retorne al menu 
        
        ListarEmployee();
        
        
    }
    
    private void Listar(){
    
    List<area> list =daoA.Listar();
    modeloArea=(DefaultTableModel) tablearea.getModel();
    Object[] ob=new Object[2];
    for (int i=0;i<list.size();i++){
        ob[0]=list.get(i).getCode();
        ob[1]=list.get(i).getName();
        modeloArea.addRow(ob);
    }tablearea.setModel(modeloArea);
    }
    
   
        
    private void ListarEmployee(){
    
    List<employee> list =daoE.Listar();
    modeloEmployee=(DefaultTableModel) tableEmployee.getModel();
   
    Object[] ob=new Object[3];
    for (int i=0;i<list.size();i++){
        ob[0]=list.get(i).getId();
        ob[1]=list.get(i).getName();
        ob[2]=list.get(i).getPost();
        modeloEmployee.addRow(ob);
        
    }tableEmployee.setModel(modeloEmployee);
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JTabbedPane();
        pemployee = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        pusers = new javax.swing.JPanel();
        ppost = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        parea = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablearea = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pemployee.setBackground(new java.awt.Color(255, 255, 255));

        tableEmployee = new javax.swing.JTable(){
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        tableEmployee.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Identificación", "Nombre", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableEmployee.setShowGrid(true);
        tableEmployee.setShowHorizontalLines(true);
        tableEmployee.setShowVerticalLines(true);
        tableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableEmployee);

        javax.swing.GroupLayout pemployeeLayout = new javax.swing.GroupLayout(pemployee);
        pemployee.setLayout(pemployeeLayout);
        pemployeeLayout.setHorizontalGroup(
            pemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pemployeeLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        pemployeeLayout.setVerticalGroup(
            pemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pemployeeLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        panel.addTab("Empleados", pemployee);

        pusers.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pusersLayout = new javax.swing.GroupLayout(pusers);
        pusers.setLayout(pusersLayout);
        pusersLayout.setHorizontalGroup(
            pusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        pusersLayout.setVerticalGroup(
            pusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        panel.addTab("Usuarios", pusers);

        ppost.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout ppostLayout = new javax.swing.GroupLayout(ppost);
        ppost.setLayout(ppostLayout);
        ppostLayout.setHorizontalGroup(
            ppostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppostLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        ppostLayout.setVerticalGroup(
            ppostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppostLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panel.addTab("Cargo", ppost);

        parea.setBackground(new java.awt.Color(255, 255, 255));

        tablearea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablearea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Area"
            }
        ));
        tablearea.setCellSelectionEnabled(true);
        jScrollPane2.setViewportView(tablearea);

        javax.swing.GroupLayout pareaLayout = new javax.swing.GroupLayout(parea);
        parea.setLayout(pareaLayout);
        pareaLayout.setHorizontalGroup(
            pareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pareaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pareaLayout.setVerticalGroup(
            pareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pareaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        panel.addTab("Area", parea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
       
    private void tableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseClicked
          
        // TODO add your handling code here:
        //obtener la fila
        int row = tableEmployee.getSelectedRow();
        //obtener la columna
        int column = tableEmployee.getSelectedColumn();
        //si la columna es la 1era
        if (column == 0) {
            DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
            Object value = model.getValueAt(row, column);
            String nro_registro = (value != null) ? value.toString() : null; //se convierte el valor a string
            //JOptionPane.showMessageDialog(null, nro_registro);
            if (nro_registro != null && !nro_registro.isEmpty()) {
                // Crear y mostrar la ventana emergente con la información del empleado
                infoEmployee infoEmployee = new infoEmployee(nro_registro);
                infoEmployee.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No hay información disponible para este registro.");
            }
        }
    }//GEN-LAST:event_tableEmployeeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    void clearTableArea(){
        for (int i=0;i<modeloArea.getRowCount();i++){
            modeloArea.removeRow(i);
            i=0-1;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JPanel parea;
    private javax.swing.JPanel pemployee;
    private javax.swing.JPanel ppost;
    private javax.swing.JPanel pusers;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTable tablearea;
    // End of variables declaration//GEN-END:variables
}
