/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pseudocfoch
 */
public class DBConexion {
    private static DBConexion instancia;
    private Connection conexion;
    private static final String SERVIDOR = "jdbc:mysql://localhost/mydb";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";
    
    private DBConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(SERVIDOR, USUARIO, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBConexion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized DBConexion getInstancia() {
        if (instancia == null)
            instancia = new DBConexion();
        return instancia;
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }
    
    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConexion.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        this.conexion = null;
    }
}
