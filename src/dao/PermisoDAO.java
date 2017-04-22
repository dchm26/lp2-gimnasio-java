/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.IDAO;
import db.DBConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Permiso;

/**
 *
 * @author pseudocfoch
 */
public class PermisoDAO implements IDAO<Permiso> {
    private static final String SQL_INSERT = "INSERT INTO rol (nombre) VALUES (?)";
    private static final String SQL_DELETE = "DELETE FROM rol WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE libros SET nombre = ? WHERE nombre = ?";
    private static final String SQL_READ = "SELECT * FROM rol WHERE id = ?";
    private static final String SQL_READ_ALL = "SELECT * FROM rol";
    private static final DBConexion cn = DBConexion.getInstancia();
    
    @Override
    public boolean create(Permiso objeto) {
        try {
            int id;
            ResultSet ids;
            PreparedStatement ps;
            ps = cn.getConexion().prepareStatement(SQL_INSERT);
            ps.setString(1, objeto.getNombre());
                        
            if (ps.executeUpdate() > 0) {
                ids = ps.getGeneratedKeys();
                ids.next();
                id = ids.getInt(1);
                objeto.setId(id);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            cn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object id) {
        try {
            PreparedStatement ps;
            ps = cn.getConexion().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int) id);
            
            if (ps.executeUpdate() > 0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            cn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Permiso objeto) {
        try {
            PreparedStatement ps;
            ps = cn.getConexion().prepareStatement(SQL_UPDATE);
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, objeto.getId());

            if (ps.executeUpdate() > 0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            cn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Permiso read(Object id) {
        Permiso permiso = null;
        try {
            PreparedStatement ps;
            ResultSet res;
            
            ps = cn.getConexion().prepareStatement(SQL_READ);
            ps.setInt(1, (int) id);
            
            res = ps.executeQuery();
            while (res.next()) {
                permiso = new Permiso(res.getString(2));
                permiso.setId(res.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return permiso;
    }

    @Override
    public ArrayList<Permiso> readAll() {
        ArrayList<Permiso> permisos = new ArrayList<>();
        try {
            PreparedStatement ps;
            ResultSet res;
            
            ps = cn.getConexion().prepareStatement(SQL_READ_ALL);
            
            res = ps.executeQuery();
            while (res.next()) {
                Permiso permiso;
                permiso = new Permiso(res.getString(2));
                permiso.setId(res.getInt(1));
                permisos.add(permiso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return permisos;
    }
}
