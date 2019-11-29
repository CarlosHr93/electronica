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
public class vercliente extends javax.swing.JFrame {

    /**
     * Creates new form usuario
     */
    public vercliente() {

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
        jttelefono.setText("");
        

    }
 public void Escribir()
    {
        try{
     PreparedStatement pst = cn.prepareStatement("INSERT INTO `cliente` (`idCliente`, `nombre`, `apellido`, `telefono`, `direccion`, `tipo`) VALUES (?,?,?,?,?,?)");
     pst.setString(1, jtid.getText());
     pst.setString(2, jtnombre.getText());
     pst.setString(3, jtapellido.getText());
     
     pst.setString(4, jtdireccion.getText());
     pst.setString(5, jttelefono.getText());
     int seleccionado = cbTcliente.getSelectedIndex();
     pst.setString(6, cbTcliente.getItemAt(seleccionado));
     pst.executeUpdate();
     JOptionPane.showMessageDialog(null,"Guardado exitoso");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"error"+ e.getMessage());

        }
    }
public void MostrarDatos()
{
    String [] titulos= {"idCliente", "nombre", "apellido", "direccion", "telefono", "tipo"};
    String [] registros = new String [7];
    DefaultTableModel modelo = new DefaultTableModel(null,titulos);
    String SQL = "select * from cliente";

    try{
        java.sql.Statement st = cn.createStatement();
        java.sql.ResultSet rs = st.executeQuery(SQL);
        while(rs.next())
        {
            registros[0]=rs.getString("idCliente");
            registros[1]=rs.getString("nombre");
            registros[2]=rs.getString("apellido");
            registros[3]=rs.getString("direccion");
            registros[4]=rs.getString("telefono"); 
            registros[5]=rs.getString("tipo");

            modelo.addRow(registros);
            tablacliente.setModel(modelo);
        }
    }
    catch(Exception e)
    {
       JOptionPane.showMessageDialog(null,"error"+ e.getMessage());
       //JOptionPane.showMessageDialog(null,"mostrar");

    }
}
public void Actualizar()
{
     try {

            PreparedStatement pst = cn.prepareStatement("UPDATE cliente set nombre=? , apellido=?, telefono=? ,direccion=?, tipo=? where idCliente=?" );
            int filaSeleccionada = tablacliente.getSelectedRow();
            String dao = (String)tablacliente.getValueAt(filaSeleccionada,0);


            pst.setString(1, jtnombre.getText());
            pst.setString(2, jtapellido.getText());
            pst.setString(3, jttelefono.getText());
            pst.setString(4, jtdireccion.getText());
            int seleccionado = cbTcliente.getSelectedIndex();
            pst.setString(5, cbTcliente.getItemAt(seleccionado));
     
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
            int filaSeleccionada = tablacliente.getSelectedRow();
            String SQL = "delete from cliente where idcliente="+tablacliente.getValueAt(filaSeleccionada,0);
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
        tablacliente = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtapellido = new javax.swing.JTextField();
        jtid = new javax.swing.JTextField();
        jtdireccion = new javax.swing.JTextField();
        jttelefono = new javax.swing.JTextField();
        jtnombre = new javax.swing.JTextField();
        btNuevo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        btGuardar1 = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        cbTcliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jlTitulo.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jlTitulo.setText("Cliente");
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

        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablacliente);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 27, -1, -1));

        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 56, -1, -1));

        jLabel4.setText("APELLIDO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 96, -1, -1));

        jLabel5.setText("TIPO DE CLIENTE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 181, -1, -1));

        jLabel6.setText("DIRECCION");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 156, -1, -1));

        jLabel7.setText("TELEFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 124, -1, -1));

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

        jttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jttelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(jttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 124, 169, -1));

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

        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        btnregresar.setForeground(new java.awt.Color(255, 0, 0));
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        btGuardar1.setForeground(new java.awt.Color(255, 0, 0));
        btGuardar1.setText("Guardar");
        btGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        btnBorrar.setForeground(new java.awt.Color(255, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        cbTcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAYORISTE", "MINORISTA" }));
        jPanel1.add(cbTcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 170, -1));

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

    private void tablaclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclienteMouseClicked

        int filaSeleccionada = tablacliente.rowAtPoint(evt.getPoint());

     jtid.setText(tablacliente.getValueAt(filaSeleccionada, 0).toString());
     jtnombre.setText(tablacliente.getValueAt(filaSeleccionada, 1).toString());
     jtapellido.setText(tablacliente.getValueAt(filaSeleccionada, 2).toString());
     jttelefono.setText(tablacliente.getValueAt(filaSeleccionada, 3).toString());
     jtdireccion.setText(tablacliente.getValueAt(filaSeleccionada, 4).toString());
     cbTcliente.setSelectedItem(tablacliente.getValueAt(filaSeleccionada, 5).toString());;
     


    }//GEN-LAST:event_tablaclienteMouseClicked

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

    private void jtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtnombreActionPerformed

    private void jtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtnombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtnombreKeyTyped

    private void btGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardar1ActionPerformed
        // TODO add your handling code here:
        Escribir();
        borrar();
        MostrarDatos();
    }//GEN-LAST:event_btGuardar1ActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        this.setVisible(false);
        menu o = new menu();
        o.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        // TODO add your handling code here:
        borrar();
    }//GEN-LAST:event_btNuevoActionPerformed

    private void jtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtidActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Actualizar();
        borrar();
        MostrarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        EliminarDatos();
        MostrarDatos();
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jttelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(c<'0' || c>'9')
        {
            evt.consume();
        }
    }//GEN-LAST:event_jttelefonoKeyTyped

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
    private javax.swing.JButton btGuardar1;
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> cbTcliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtapellido;
    private javax.swing.JTextField jtdireccion;
    private javax.swing.JTextField jtid;
    private javax.swing.JTextField jtnombre;
    private javax.swing.JTextField jttelefono;
    private javax.swing.JTable tablacliente;
    // End of variables declaration//GEN-END:variables

    conexionSQL cc = new conexionSQL();
    Connection cn= cc.conexion();

}
