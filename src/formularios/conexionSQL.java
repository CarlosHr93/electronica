/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Hidalgo
 */
public class conexionSQL {
   Connection conectar=null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");
            JOptionPane.showMessageDialog(null,"coneccion exitosa");
        } catch (Exception e) {
            System.out.print(e.getMessage());
           JOptionPane.showMessageDialog(null,"error de conexion"+ e.getMessage());
        }
        return conectar;
    }
        
        
       
    }
