/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.DaoCompra;
import controlador.DaoProveedor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.Proveedor;


/**
 *
 * @author User
 */
public class ProveedorCompra extends javax.swing.JPanel {

    Compra co = new Compra();
    DaoCompra daoCom = new DaoCompra();
    //
    //instanciar la clase Categorias
    Proveedor pr = new Proveedor();
    DaoProveedor daoPr = new DaoProveedor();
    // mostrar datos en la tabla compra
    DefaultTableModel modeloCompra = new DefaultTableModel();
    // tabla proveedor
    DefaultTableModel modeloProveedor = new DefaultTableModel();
    
    
    
    public ProveedorCompra() {
        initComponents();
        listarCompras();
        listarProveedor();
    }
    private void listarCompras(){
        List<Compra> listaCom = daoCom.Listar();
        modeloCompra = (DefaultTableModel) tblCom.getModel();
        Object[] ob = new Object[4];
        for(int i=0; i< listaCom.size(); i++){
            ob[0] = listaCom.get(i).getId_compra();
            ob[1] = listaCom.get(i).getId_proveedor();
            ob[2] = listaCom.get(i).getFecha_compra();
            ob[3] = listaCom.get(i).getNumero_documento();
            
            modeloCompra.addRow(ob);
        }
        tblCom.setModel(modeloCompra);
    }
    
    private void listarProveedor(){
        List<Proveedor> listaPr = daoPr.Listar();
        modeloProveedor = (DefaultTableModel) tblProveedor.getModel();
        Object[] ob = new Object[5];
        for(int i=0; i< listaPr.size(); i++){
            ob[0] = listaPr.get(i).getId_proveedor();
            ob[1] = listaPr.get(i).getNombre_comercial();
            ob[2] = listaPr.get(i).getRuc();
            ob[3] = listaPr.get(i).getDireccion();
            ob[4] = listaPr.get(i).getTelefono();
            
            modeloProveedor.addRow(ob);
        }
        tblProveedor.setModel(modeloProveedor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCom = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdPro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDoc = new javax.swing.JTextField();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnEditar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnEliminar = new RSMaterialComponent.RSButtonMaterialIconDos();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtIdP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        btnBuscarP = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNomC = new javax.swing.JTextField();
        btnEliminarP = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnGuardarP = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel9 = new javax.swing.JLabel();
        btnEditarP = new RSMaterialComponent.RSButtonMaterialIconDos();
        txtRuc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 243, 146));

        tblCom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_compra", "id_proveedor", "fecha_compra", "numero_doc"
            }
        ));
        tblCom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCom);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setText("Compra");

        jLabel3.setText("ID compra:");

        jLabel4.setText("ID proveedor:");

        jLabel5.setText("Fecha de compra:");

        jLabel6.setText("Numero de Doc.:");

        btnBuscar.setBackground(new java.awt.Color(0, 204, 51));
        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscar.setRound(25);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(204, 204, 0));
        btnEditar.setText("Editar");
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.setRound(25);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setRound(25);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_SWEEP);
        btnEliminar.setRound(25);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(txtIdPro)
                            .addComponent(txtIdCo)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFe)
                            .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_proveedor", "nombre_comercial", "RUC", "direccion", "telefono"
            }
        ));
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProveedor);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel2.setText("Lista de Proveedores");

        jLabel8.setText("Nombre comercial:");

        btnBuscarP.setBackground(new java.awt.Color(0, 204, 51));
        btnBuscarP.setText("Buscar");
        btnBuscarP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscarP.setRound(25);
        btnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPActionPerformed(evt);
            }
        });

        jLabel7.setText("ID proveedor:");

        jLabel10.setText("Direccion:");

        btnEliminarP.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarP.setText("Eliminar");
        btnEliminarP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_SWEEP);
        btnEliminarP.setRound(25);
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });

        btnGuardarP.setText("Guardar");
        btnGuardarP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardarP.setRound(25);
        btnGuardarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPActionPerformed(evt);
            }
        });

        jLabel9.setText("RUC:");

        btnEditarP.setBackground(new java.awt.Color(204, 204, 0));
        btnEditarP.setText("Editar");
        btnEditarP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarP.setRound(25);
        btnEditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPActionPerformed(evt);
            }
        });

        jLabel11.setText("Telefono:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel8)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtDir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                .addComponent(txtRuc, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNomC, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGap(22, 22, 22))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtIdP)
                                        .addGap(53, 53, 53)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnEditarP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnGuardarP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel2))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtIdP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(btnEditarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnGuardarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Validar que los campos no estén vacíos
        if (txtIdPro.getText().isEmpty() || txtFe.getText().isEmpty() || txtDoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            return;
        }

        // Validar que el ID de proveedor sea un numero
        int idProv;
       
        try {
            idProv = Integer.parseInt(txtIdPro.getText());            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID de proveedor debe ser un número.");
            return;
        }
        //validar la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate Fecha;
        try {            
            Fecha = LocalDate.parse(txtFe.getText(),formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "La fecha debe estar en formato dd/MM/yyyy.");
            return;
        }
        //
        co.setId_proveedor(Integer.parseInt(txtIdPro.getText()));
        co.setFecha_compra(LocalDate.parse(txtFe.getText(),formatter));
        co.setNumero_documento(Integer.parseInt(txtDoc.getText()));
        
        if(daoCom.insert(co)){
            //informar que el Id compra es autoasignado por el sistema
            if(!txtIdCo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No es necesario poner el ID de compra, el sistema lo asigna automáticamente");
            }
            JOptionPane.showMessageDialog(null, "Compra Registrada");
        }else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la compra");
        }
        limpiarCamposCom();
        limpiarTablaCompra();
        listarCompras();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPActionPerformed
        // Validar que los campos no estén vacíos
        if (txtNomC.getText().isEmpty() || txtRuc.getText().isEmpty() || txtDir.getText().isEmpty() || txtTel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            return;
        }

        //setiar
        pr.setNombre_comercial(txtNomC.getText());
        pr.setRuc(txtRuc.getText());
        pr.setDireccion(txtDir.getText());
        pr.setTelefono(txtTel.getText());
        
        if(daoPr.insert(pr)){
            //informar que el Id proveedor es autoasignado por el sistema
            if(!txtIdP.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No es necesario poner el ID del proveedor, el sistema lo asigna automáticamente");
            }
            JOptionPane.showMessageDialog(null, "Proveedor Registrado");
        }else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el proveedor");
        }
        limpiarCamposProv();
        limpiarTablaProveedor();
        listarProveedor();
    }//GEN-LAST:event_btnGuardarPActionPerformed

    private void tblComMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComMouseClicked
        int fila = tblCom.getSelectedRow();
        txtIdCo.setText(tblCom.getValueAt(fila, 0).toString());
        txtIdPro.setText(tblCom.getValueAt(fila, 1).toString());        
        txtFe.setText(tblCom.getValueAt(fila, 2).toString());
        txtDoc.setText(tblCom.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_tblComMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblCom.getSelectedRow();
        //validar la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }else{
            co.setId_compra(Integer.parseInt(txtIdCo.getText()));
            co.setId_proveedor(Integer.parseInt(txtIdPro.getText()));
            co.setFecha_compra(LocalDate.parse(txtFe.getText(),formatter));//original
            co.setNumero_documento(Integer.parseInt(txtDoc.getText()));
            if(daoCom.editar(co)){
                JOptionPane.showMessageDialog(null, "Se modifico con exito");
                limpiarCamposCom();
                limpiarTablaCompra();
                listarCompras();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        int fila = tblProveedor.getSelectedRow();
        txtIdP.setText(tblProveedor.getValueAt(fila, 0).toString());
        txtNomC.setText(tblProveedor.getValueAt(fila, 1).toString());
        txtRuc.setText(tblProveedor.getValueAt(fila, 2).toString());
        txtDir.setText(tblProveedor.getValueAt(fila, 3).toString());
        txtTel.setText(tblProveedor.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void btnEditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPActionPerformed
        int fila = tblProveedor.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor");
        }else{
            pr.setId_proveedor(Integer.parseInt(txtIdP.getText()));
            pr.setNombre_comercial(txtNomC.getText());
            pr.setRuc(txtRuc.getText());
            pr.setDireccion(txtDir.getText());
            pr.setTelefono(txtTel.getText());
            
            if(daoPr.editar(pr)){
                JOptionPane.showMessageDialog(null, "Se modifico con exito");
                limpiarCamposProv();
                limpiarTablaProveedor();
                listarProveedor();
            }
        }
    }//GEN-LAST:event_btnEditarPActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(!txtIdCo.getText().isEmpty()){
            int confirmacion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar la Compra","Confirmar",2);
            if(confirmacion == 0){
                co.setId_compra(Integer.parseInt(txtIdCo.getText()));
                daoCom.eliminar(co);
                limpiarCamposCom();
                limpiarTablaCompra();
                listarCompras();
                JOptionPane.showMessageDialog(null, "Se elimino la compra");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione el ID de Compra");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        if(!txtIdP.getText().isEmpty()){
            int confirmacion = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar al proveedor","Confirmar",2);
            if(confirmacion == 0){
                pr.setId_proveedor(Integer.parseInt(txtIdP.getText()));
                daoPr.eliminar(pr);
                limpiarCamposProv();
                limpiarTablaProveedor();
                listarProveedor();
                JOptionPane.showMessageDialog(null, "Se elimino al proveedor");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione el ID del proveedor");
        }
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        co.setId_compra(Integer.parseInt(txtIdCo.getText()));
        if(daoCom.buscar(co)){
            txtIdCo.setText(co.getId_compra()+"");
            txtIdPro.setText(co.getId_proveedor()+"");
            txtFe.setText(co.getFecha_compra()+"");
            txtDoc.setText(co.getNumero_documento()+"");
        }else{
            JOptionPane.showMessageDialog(null, "La categoria no existe");
            limpiarCamposCom();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPActionPerformed
        pr.setId_proveedor(Integer.parseInt(txtIdP.getText()));
        if(daoPr.buscar(pr)){
            txtIdP.setText(pr.getId_proveedor()+"");
            txtNomC.setText(pr.getNombre_comercial());
            txtRuc.setText(pr.getRuc());
            txtDir.setText(pr.getDireccion());
            txtTel.setText(pr.getTelefono());
        }else{
            JOptionPane.showMessageDialog(null, "El proveedor no existe");
            limpiarCamposProv();
        }
    }//GEN-LAST:event_btnBuscarPActionPerformed

    void limpiarCamposCom(){
        txtIdCo.setText("");
        txtIdPro.setText("");
        txtFe.setText("");
        txtDoc.setText("");
    }
    
    void limpiarCamposProv(){
        txtIdP.setText("");
        txtNomC.setText("");
        txtRuc.setText("");
        txtDir.setText("");
        txtTel.setText("");
    }
    void limpiarTablaCompra(){
        for(int i=0; i<modeloCompra.getRowCount();i++){
            modeloCompra.removeRow(i);
            i = 0-1;
        }
    }
    void limpiarTablaProveedor(){
        for(int i=0; i<modeloProveedor.getRowCount();i++){
            modeloProveedor.removeRow(i);
            i = 0-1;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnBuscarP;
    private RSMaterialComponent.RSButtonMaterialIconDos btnEditar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnEditarP;
    private RSMaterialComponent.RSButtonMaterialIconDos btnEliminar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnEliminarP;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardarP;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCom;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtDoc;
    private javax.swing.JTextField txtFe;
    private javax.swing.JTextField txtIdCo;
    private javax.swing.JTextField txtIdP;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtNomC;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
