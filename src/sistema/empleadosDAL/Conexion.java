/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleadosDAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;  
import javax.swing.JOptionPane;

/**
 *
 * @author giron
 */
public class Conexion {
    String strConexion = "jdbc:sqlite:C:/Users/giron/OneDrive/Documents/NetBeansProjects/CRUDJavaNetbeansAppJavaconDB/CRUDJavaNetbeansAppJavaconDB.s3db";
    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexion);
            System.out.println("Conexion Establecida...");
        } catch (Exception e) {
            System.out.println("Error de conexion: "+e);
        }
    }
    //
    public int ejecutarInsertSql(String senteciaSql){
        try {
            PreparedStatement pstm = conn.prepareStatement(senteciaSql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Registro modificado con éxito.");
            //System.out.println("Registro ingresado con exito...");
            return 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error mostrando los registros: "+e);
            return 0;
        }
    }//
    //
    public ResultSet consultarRegistros(String senteciaSql){
        //Obtener la informacion y devolverla
        try {
            PreparedStatement pstm = conn.prepareStatement(senteciaSql);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error mostrando los registros: "+e);
            return null;
        }
    }//
    
}
