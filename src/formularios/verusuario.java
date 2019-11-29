/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;



import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Hidalgo
 */
public class verusuario extends javax.swing.JFrame {

    /**
     * Creates new form usuario
     */
    public verusuario() {

        initComponents();
        MostrarDatos();
        borrar();

    }
    public void borrar()
    {
        jtid.setText("");
        jtnombre.setText("");
        jtapellido.setText("");
        jtdireccion.setText("");
        jtnum.setText("");

    }
 
 
 public void InsertarDatos()
 {
        try{
     PreparedStatement pst = cn.prepareStatement("INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `puesto`,`direccion`, `telefono`) VALUES (?,?,?,?,?,?)");
     pst.setString(1, jtid.getText());
     pst.setString(2, jtnombre.getText());
     pst.setString(3, jtapellido.getText());
     int seleccionado = cbpuesto.getSelectedIndex();
     pst.setString(4, cbpuesto.getItemAt(seleccionado));
     
     pst.setString(5, jtdireccion.getText());
     pst.setString(6, jtnum.getText());
     pst.executeUpdate();
     JOptionPane.showMessageDialog(null,"Guardado exitoso");
        }catch(Exception e)
        {
                        JOptionPane.showMessageDialog(null,"error"+ e.getMessage());
        }
}
public void MostrarDatos()
{
    String [] titulos= {"idUsuario", "nombre", "apellido", "puesto", "direccion", "telefono"};
    String [] registros = new String [6];
    DefaultTableModel modelo = new DefaultTableModel(null,titulos);
    String SQL = "select * from usuario";

    try{
        java.sql.Statement st = cn.createStatement();
        java.sql.ResultSet rs = st.executeQuery(SQL);
        while(rs.next())
        {
            registros[0]=rs.getString("idusuario");
            registros[1]=rs.getString("nombre");
            registros[2]=rs.getString("apellido");
            registros[3]=rs.getString("puesto");
            registros[4]=rs.getString("direccion");
            registros[5]=rs.getString("telefono");

            modelo.addRow(registros);
            tablausuario.setModel(modelo);
        }
    }
    catch(Exception e)
    {
       JOptionPane.showMessageDialog(null,"error"+ e.getMessage());

    }
}
public void Actualizar()
{
     try {

            PreparedStatement pst = cn.prepareStatement("UPDATE usuario set nombre=? , apellido=?, puesto=?, direccion=?, telefono=? where idUsuario=?" );
            int filaSeleccionada = tablausuario.getSelectedRow();
            String dao = (String)tablausuario.getValueAt(filaSeleccionada,0);


            pst.setString(1, jtnombre.getText());
            pst.setString(2, jtapellido.getText());
            int seleccionado = cbpuesto.getSelectedIndex();
            pst.setString(3, cbpuesto.getItemAt(seleccionado));
     
            pst.setString(4, jtdireccion.getText());
            pst.setString(5, jtnum.getText());
             pst.setString(6, dao);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Modificado con exitoso");


        } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,"error"+ ex.getMessage());
        }
}
public void EliminarDatos()
{
    try{
            int filaSeleccionada = tablausuario.getSelectedRow();
            String SQL = "delete from usuario where idusuario="+tablausuario.getValueAt(filaSeleccionada,0);
           PreparedStatement pst = cn.prepareStatement(SQL);
            int n = pst.executeUpdate(SQL);
            if(n>=0)
            {
                        JOptionPane.showMessageDialog(null,"Eliminado con exitoso");
            }
    }catch(SQLException ex)
    {
       JOptionPane.showMessageDialog(null,"error"+ ex.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtapellido = new javax.swing.JTextField();
        jtid = new javax.swing.JTextField();
        jtdireccion = new javax.swing.JTextField();
        jtnum = new javax.swing.JTextField();
        jtnombre = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        cbpuesto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jlTitulo.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jlTitulo.setText("Usuarios");
        jlTitulo.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jlTitulo))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("ELECTRI-HOGAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablausuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablausuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablausuario);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 27, -1, -1));

        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 56, -1, -1));

        jLabel4.setText("APELLIDO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 96, -1, -1));

        jLabel5.setText("PUESTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel6.setText("DIRECCION");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 156, -1, -1));

        jtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtapellidoActionPerformed(evt);
            }
        });
        jtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtapellidoKeyTyped(evt);
            }
        });
        jPanel1.add(jtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 169, -1));

        jtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtidActionPerformed(evt);
            }
        });
        jtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtidKeyTyped(evt);
            }
        });
        jPanel1.add(jtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 22, 169, -1));
        jPanel1.add(jtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 152, 169, -1));

        jtnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtnumKeyTyped(evt);
            }
        });
        jPanel1.add(jtnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 183, 169, -1));

        jtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtnombreActionPerformed(evt);
            }
        });
        jtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtnombreKeyTyped(evt);
            }
        });
        jPanel1.add(jtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 53, 169, -1));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        btnRegresar.setForeground(new java.awt.Color(255, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        btGuardar.setForeground(new java.awt.Color(255, 0, 0));
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        btnBorrar.setForeground(new java.awt.Color(255, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        cbpuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "EMPLEADO", " " }));
        jPanel1.add(cbpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 170, -1));

        jLabel8.setText("NUMERO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 181, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 181, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablausuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuarioMouseClicked

        int filaSeleccionada = tablausuario.rowAtPoint(evt.getPoint());

     jtid.setText(tablausuario.getValueAt(filaSeleccionada, 0).toString());
     jtnombre.setText(tablausuario.getValueAt(filaSeleccionada, 1).toString());
     jtapellido.setText(tablausuario.getValueAt(filaSeleccionada, 2).toString());
     cbpuesto.setSelectedItem(tablausuario.getValueAt(filaSeleccionada, 3).toString());;
     jtdireccion.setText(tablausuario.getValueAt(filaSeleccionada, 4).toString());
     jtnum.setText(tablausuario.getValueAt(filaSeleccionada, 5).toString());


    }//GEN-LAST:event_tablausuarioMouseClicked

    private void jtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtapellidoActionPerformed

    private void jtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtapellidoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z')&& (c!=(char)KeyEvent.VK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtapellidoKeyTyped

    private void jtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtidKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0' || c>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtidKeyTyped

    private void jtnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtnumKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0' || c>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtnumKeyTyped

    private void jtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtnombreActionPerformed

    private void jtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtnombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtnombreKeyTyped

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        InsertarDatos();

        MostrarDatos();


    }//GEN-LAST:event_btGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        menu o = new menu();
        o.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        borrar();
       
       MostrarDatos();

       
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtidActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        Actualizar();
        borrar();
        MostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        EliminarDatos();
        MostrarDatos();
        
    }//GEN-LAST:event_btnBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(verusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verusuario().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtapellido;
    private javax.swing.JTextField jtdireccion;
    private javax.swing.JTextField jtid;
    private javax.swing.JTextField jtnombre;
    private javax.swing.JTextField jtnum;
    private javax.swing.JTable tablausuario;
    // End of variables declaration//GEN-END:variables

    conexionSQL cc = new conexionSQL();
    Connection cn= cc.conexion();

}
