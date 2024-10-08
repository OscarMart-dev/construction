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
import Dao.DaoPost;
import Modelo.post;
import Dao.DaoUsers;
import Modelo.users;
import java.sql.SQLException;
import java.text.ParseException;
//import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author oscar
 */
public class Menu extends javax.swing.JFrame {

   // area listado;
    private DaoArea area;
    DefaultTableModel modeloArea=new DefaultTableModel();
   // cargo listado; 
    private DaoPost post;
    DefaultTableModel modeloCargo=new DefaultTableModel();
    
    DaoEmployee daoE=new DaoEmployee();
    DefaultTableModel modeloEmployee=new DefaultTableModel();
    
    private DaoUsers users;
    DefaultTableModel modeloUsers=new DefaultTableModel();
    
    /**
     * @return the area
     */
    public DaoArea getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(DaoArea area) {
        this.area = area;
    }
    
    

    public DaoUsers getUsers() {
        return users;
    }

    /**
     * @param area the area to set
     */
    public void setUsers(DaoUsers users) {
        this.users = users;
    }
    
    /**
     * @param area the area to set
     */
    public void setPost(DaoPost post) {
        this.post = post;
    }
    
    public DaoPost getPost() {
        return post;
    }

    
    public Menu(String user) {
        initComponents();
        this.setLocationRelativeTo(null);//esto hace que la ventana se situe en el centro de la pantalla
        
        //inicializar la lista Area
        this.setArea(new DaoArea());
        this.ListarArea();
        this.setPost(new DaoPost());
        this.ListarCargo();
        //inicializar la lista empleado
        this.ListarEmployee();
        this.setUsers(new DaoUsers());
        this.ListarUser();
        txtUser.setText(user);
    }
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);//esto hace que la ventana se situe en el centro de la pantalla
        
        //inicializar la lista Area
        this.setArea(new DaoArea());
        this.ListarArea();
        this.setPost(new DaoPost());
        this.ListarCargo();
        //inicializar la lista empleado
        this.ListarEmployee();
        this.setUsers(new DaoUsers());
        this.ListarUser();
    }
    
    public void ListarUser(){
        List<users> list = this.getUsers().ListarUsuario();
        modeloUsers = (DefaultTableModel) tableUsers.getModel();
        clearTableUsers();
        
        Object[] ob = new Object[3];
        
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getCode();
            ob[1]=list.get(i).getName();
            ob[2]=list.get(i).getState();
            modeloUsers.addRow(ob);
        }
        
        tableUsers.setModel(modeloUsers);
    }
    
    public void ListarArea(){
        List<area> list = this.getArea().Listar();
        modeloArea = (DefaultTableModel) tablearea.getModel();
        clearTableArea();
        
        Object[] ob = new Object[2];
        
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getCode();
            ob[1]=list.get(i).getName();
            modeloArea.addRow(ob);
        }
        
        tablearea.setModel(modeloArea);
    }
    
    public void ListarAreaBuscar(String busqueda){
        List<area> list = this.getArea().ListarBuscarArea(busqueda);
        modeloArea = (DefaultTableModel) tablearea.getModel();
        clearTableArea();
        
        Object[] ob = new Object[2];
        
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getCode();
            ob[1]=list.get(i).getName();
            modeloArea.addRow(ob);
        }
        
        tablearea.setModel(modeloArea);
    }
    
     
    public void ListarEmployee(){

        List<employee> list =daoE.Listar();
        modeloEmployee=(DefaultTableModel) tableEmployee.getModel();
        clearTableEmployee();
        Object[] ob=new Object[3];
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getId();
            ob[1]=list.get(i).getName();
            ob[2]=list.get(i).getPost();
            modeloEmployee.addRow(ob);
        }
        tableEmployee.setModel(modeloEmployee);

    }
    
    public void ListarCargo(){
        List<post> list =this.getPost().ListarCargo();
        modeloCargo = (DefaultTableModel) tableCargo.getModel();
        clearTableCargo();
        
        Object[] ob = new Object[4];
        
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getId();
            ob[1]=list.get(i).getName();
            ob[2]=list.get(i).getAreaName();
            ob[3]=list.get(i).getStateName();
            modeloCargo.addRow(ob);
        }
        
        tableCargo.setModel(modeloCargo);
    }
    
    public void ListarCargoBuscar(String busqueda){
        List<post> list = this.getPost().ListarBuscarCargo(busqueda);
        modeloCargo = (DefaultTableModel) tableCargo.getModel();
        clearTableCargo();
        
        Object[] ob = new Object[4];
        
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getId();
            ob[1]=list.get(i).getName();
            ob[2]=list.get(i).getAreaName();
            ob[3]=list.get(i).getStateName();
            modeloCargo.addRow(ob);
        }
        
        tableCargo.setModel(modeloCargo);
    }
    
    public void ListarUsuarioBuscar(String busqueda){
        List<users> list = this.getUsers().ListarUsuarioBuscado(busqueda);
        modeloUsers = (DefaultTableModel) tableUsers.getModel();
        clearTableUsers();
        
        Object[] ob = new Object[3];
        
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getCode();
            ob[1]=list.get(i).getName();
            ob[2]=list.get(i).getState();
            modeloUsers.addRow(ob);
        }
        
        tableUsers.setModel(modeloUsers);
    }
    
    public void ListarEmployeeBuscar(String busqueda){

        List<employee> list =daoE.ListarEmpleadoBuscado(busqueda);
        modeloEmployee=(DefaultTableModel) tableEmployee.getModel();
        clearTableEmployee();
        
        Object[] ob=new Object[3];
        
        for (int i=0;i<list.size();i++){
            ob[0]=list.get(i).getId();
            ob[1]=list.get(i).getName();
            ob[2]=list.get(i).getPost();
            modeloEmployee.addRow(ob);
        }
        tableEmployee.setModel(modeloEmployee);

    }
    
    void clearTableArea(){
        for (int i=0;i<modeloArea.getRowCount();i++){
            modeloArea.removeRow(i);
            i=0-1;
        }
    }
    
    void clearTableEmployee(){
        for (int i=0;i<modeloEmployee.getRowCount();i++){
            modeloEmployee.removeRow(i);
            i=0-1;
        }
    }
    
    
    void clearTableCargo(){
        for (int i=0;i<modeloCargo.getRowCount();i++){
            modeloCargo.removeRow(i);
            i=0-1;
        }
    }
    
    void clearTableUsers(){
        for (int i=0;i<modeloUsers.getRowCount();i++){
            modeloUsers.removeRow(i);
            i=0-1;
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

        panel = new javax.swing.JTabbedPane();
        pemployee = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        btnAgregarEmpleado = new javax.swing.JButton();
        txtBuscarEmpleado = new javax.swing.JTextField();
        btnBuscarEmpleado = new javax.swing.JButton();
        pusers = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        txtBuscarUsuario = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnAgregarUsuario = new javax.swing.JButton();
        ppost = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCargo = new javax.swing.JTable();
        txtBuscarCargo = new javax.swing.JTextField();
        btnBuscarCargo = new javax.swing.JButton();
        btnAgregarCargo = new javax.swing.JButton();
        parea = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablearea = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscarArea = new javax.swing.JTextField();
        btnCerrarSesion = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        tableEmployee.setShowVerticalLines(true);
        tableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableEmployee);

        btnAgregarEmpleado.setText("+");
        btnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadoActionPerformed(evt);
            }
        });

        btnBuscarEmpleado.setText("Buscar");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pemployeeLayout = new javax.swing.GroupLayout(pemployee);
        pemployee.setLayout(pemployeeLayout);
        pemployeeLayout.setHorizontalGroup(
            pemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pemployeeLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(pemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregarEmpleado)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pemployeeLayout.createSequentialGroup()
                        .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarEmpleado)))
                .addGap(35, 35, 35))
        );
        pemployeeLayout.setVerticalGroup(
            pemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pemployeeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarEmpleado)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panel.addTab("Empleados", pemployee);

        pusers.setBackground(new java.awt.Color(255, 255, 255));

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Nombre", "Estado"
            }
        ));
        tableUsers.setShowGrid(true);
        tableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableUsers);

        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnAgregarUsuario.setText("+");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pusersLayout = new javax.swing.GroupLayout(pusers);
        pusers.setLayout(pusersLayout);
        pusersLayout.setHorizontalGroup(
            pusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pusersLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(pusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarUsuario)
                    .addGroup(pusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pusersLayout.createSequentialGroup()
                            .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscarUsuario))))
                .addGap(34, 34, 34))
        );
        pusersLayout.setVerticalGroup(
            pusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pusersLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarUsuario)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panel.addTab("Usuarios", pusers);

        ppost.setBackground(new java.awt.Color(255, 255, 255));

        tableCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Area", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCargo.setShowGrid(true);
        tableCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCargo);

        btnBuscarCargo.setText("Buscar");
        btnBuscarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCargoActionPerformed(evt);
            }
        });

        btnAgregarCargo.setText("+");
        btnAgregarCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarCargoMouseClicked(evt);
            }
        });
        btnAgregarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ppostLayout = new javax.swing.GroupLayout(ppost);
        ppost.setLayout(ppostLayout);
        ppostLayout.setHorizontalGroup(
            ppostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppostLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(ppostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarCargo)
                    .addGroup(ppostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ppostLayout.createSequentialGroup()
                            .addComponent(txtBuscarCargo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscarCargo))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        ppostLayout.setVerticalGroup(
            ppostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppostLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(ppostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarCargo)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panel.addTab("Cargo", ppost);

        parea.setBackground(new java.awt.Color(255, 255, 255));

        tablearea = new javax.swing.JTable(){
            public boolean isCellEditable (int row,int column){
                return false;
            }
        };
        tablearea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablearea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Area"
            }
        ));
        tablearea.setShowGrid(true);
        tablearea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableareaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablearea);

        btnAgregar.setText("+");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pareaLayout = new javax.swing.GroupLayout(parea);
        parea.setLayout(pareaLayout);
        pareaLayout.setHorizontalGroup(
            pareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pareaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar)
                    .addGroup(pareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pareaLayout.createSequentialGroup()
                            .addComponent(txtBuscarArea)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscar))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pareaLayout.setVerticalGroup(
            pareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pareaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        panel.addTab("Area", parea);

        btnCerrarSesion.setText("x");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        txtUser.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUser.setBorder(null);
        txtUser.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrarSesion))
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesion)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
       
    private void tableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseClicked
  //obtener la fila
        int row = tableEmployee.getSelectedRow();
        //obtener la columna
        int column = tableEmployee.getSelectedColumn();
        //si la columna es la 1era
        if (column == 0) {
            DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
            Object value = model.getValueAt(row, column);
            String nro_registro = (value != null) ? value.toString() : null; //se convierte el valor a string
            System.out.println("El registro es :"+nro_registro);
            if (nro_registro != null && !nro_registro.isEmpty()) {
                // Crear y mostrar la ventana emergente con la información del empleado
                infoEmployeeUpdate infoEmployeeupdate = null;
                try {
                    infoEmployeeupdate = new infoEmployeeUpdate(this,nro_registro);
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                infoEmployeeupdate.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No hay información disponible para este registro.");
            }
        }
    }//GEN-LAST:event_tableEmployeeMouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
                    
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
               
                areaVista ventanaAdicionarArea = new areaVista(this);
                ventanaAdicionarArea.setVisible(true);
                //dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tableareaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableareaMouseClicked
            int row = tablearea.getSelectedRow();
        //obtener la columna
        int column = tablearea.getSelectedColumn();
        //si la columna es la 1era
        if (column == 0) {
            DefaultTableModel model = (DefaultTableModel) tablearea.getModel();
            Object value = model.getValueAt(row, column);
            String nro_registro = (value != null) ? value.toString() : null; //se convierte el valor a string
            if (nro_registro != null && !nro_registro.isEmpty()) {
                // Crear y mostrar la ventana emergente con la información del empleado
                infoVista infoVista = null;
                try {
                    infoVista = new infoVista(this, nro_registro);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                infoVista.setVisible(true);
                System.out.println("vista.Menu.tableareaMouseClicked()"+nro_registro);
            } else {
                JOptionPane.showMessageDialog(null, "No hay información disponible para este registro.");
            }
        }
    }//GEN-LAST:event_tableareaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String busqueda =txtBuscarArea.getText();
        ListarAreaBuscar(busqueda);
        txtBuscarArea.setText("");
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCargoMouseClicked
        int row = tableCargo.getSelectedRow();
        //obtener la columna
        int column = tableCargo.getSelectedColumn();
        //si la columna es la 1era
        if (column == 0) {
            DefaultTableModel model = (DefaultTableModel) tableCargo.getModel();
            Object value = model.getValueAt(row, column);
            String nro_registro = (value != null) ? value.toString() : null; //se convierte el valor a string
            if (nro_registro != null && !nro_registro.isEmpty()) {
                // Crear y mostrar la ventana emergente con la información del empleado
                infoVistaCargo infoVistaCargo = null;
                try {
                    infoVistaCargo = new infoVistaCargo(this, nro_registro);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                infoVistaCargo.setVisible(true);
                System.out.println("vista.Menu.tableareaMouseClicked()"+nro_registro);
            } else {
                JOptionPane.showMessageDialog(null, "No hay información disponible para este registro.");
            }
        }

    }//GEN-LAST:event_tableCargoMouseClicked

    private void btnAgregarCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarCargoMouseClicked
            
    }//GEN-LAST:event_btnAgregarCargoMouseClicked

    private void btnAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCargoActionPerformed
                infoVistaCargoCreate ventanaAdicionarCargo = null;
        try {
            ventanaAdicionarCargo = new infoVistaCargoCreate(this);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
                ventanaAdicionarCargo.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCargoActionPerformed

    private void btnBuscarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCargoActionPerformed
            String busqueda =txtBuscarCargo.getText();
            ListarCargoBuscar(busqueda);
            txtBuscarCargo.setText("");
    }//GEN-LAST:event_btnBuscarCargoActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        infoVistaUsuarioCreate ventanaAdicionarUsuario = null;
        try {
            ventanaAdicionarUsuario = new infoVistaUsuarioCreate(this);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
                ventanaAdicionarUsuario.setVisible(true); 
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private void tableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsersMouseClicked
        int row = tableUsers.getSelectedRow();
        //obtener la columna
        int column = tableUsers.getSelectedColumn();
        //si la columna es la 1era
        if (column == 0) {
            DefaultTableModel model = (DefaultTableModel) tableUsers.getModel();
            Object value = model.getValueAt(row, column);
            String nro_registro = (value != null) ? value.toString() : null; //se convierte el valor a string
            if (nro_registro != null && !nro_registro.isEmpty()) {
                // Crear y mostrar la ventana emergente con la información del empleado
                infoVistaUsuarioUpdate infoVista = null;
                try {
                    infoVista = new infoVistaUsuarioUpdate(this, nro_registro);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                infoVista.setVisible(true);
                System.out.println("vista.Menu.tableareaMouseClicked()"+nro_registro);
            } else {
                JOptionPane.showMessageDialog(null, "No hay información disponible para este registro.");
            }
        }
    }//GEN-LAST:event_tableUsersMouseClicked

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
            String busqueda =txtBuscarUsuario.getText();
            ListarUsuarioBuscar(busqueda);
            txtBuscarUsuario.setText("");
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformed
                infoEmployeeCreate ventanaAdicionarEmpleado = null;
                ventanaAdicionarEmpleado = new infoEmployeeCreate(this);
                ventanaAdicionarEmpleado.setVisible(true);  
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
                String busqueda =txtBuscarEmpleado.getText();
                ListarEmployeeBuscar(busqueda);
                txtBuscarEmpleado.setText("");
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
                    dispose();
                    Login login = null;
                    login = new Login();
                    login.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarCargo;
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCargo;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JPanel parea;
    private javax.swing.JPanel pemployee;
    private javax.swing.JPanel ppost;
    private javax.swing.JPanel pusers;
    private javax.swing.JTable tableCargo;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTable tablearea;
    private javax.swing.JTextField txtBuscarArea;
    private javax.swing.JTextField txtBuscarCargo;
    private javax.swing.JTextField txtBuscarEmpleado;
    private javax.swing.JTextField txtBuscarUsuario;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
