/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.interfaces.IDAO;
import db.DBConexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author pseudocfoch
 */
public class PersonaDAO implements IDAO<Persona>{
    private static final String SQL_INSERT = "INSERT INTO persona "
            + "(dni, nombre, apellidoPaterno, apellidoMaterno, "
            + "direccion, email, distrito, fechaNacimiento, telefono, "
            + "sede_id, contrasena) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE =
            "DELETE FROM persona WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE persona "
            + "SET dni = ?, nombre = ?, apellidoPaterno = ?, "
            + "apellidoMaterno = ?, direccion = ?, email = ?, distrito = ? "
            + "fechaNacimiento = ?, telefono = ?, sede_id = ?, contrasena = ? "
            + "WHERE id = ?";
    private static final String SQL_READ = "SELECT * FROM persona WHERE id = ?";
    private static final String SQL_READ_ALL = "SELECT * FROM persona";
    private static final DBConexion cn = DBConexion.getInstancia();

    @Override
    public boolean create(Persona objeto) {
        try {
            int id;
            ResultSet ids;
            PreparedStatement ps;
            ps = cn.getConexion().prepareStatement(SQL_INSERT);
            ps.setInt(1, objeto.getDni());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getApellidoPaterno());
            ps.setString(4, objeto.getApellidoMaterno());
            ps.setString(5, objeto.getDireccion());
            ps.setString(6, objeto.getEmail());
            ps.setDate(7, (Date) objeto.getFechaNacimiento());
            ps.setString(8, objeto.getTelefono());
            ps.setInt(9,
                    objeto.getSede() == null ? objeto.getSede().getId() : null);
            ps.setString(10, objeto.getContrasena());

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
    public boolean update(Persona objeto) {
        try {
            PreparedStatement ps;
            ps = cn.getConexion().prepareStatement(SQL_UPDATE);
            ps.setInt(1, objeto.getDni());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getApellidoPaterno());
            ps.setString(4, objeto.getApellidoMaterno());
            ps.setString(5, objeto.getDireccion());
            ps.setString(6, objeto.getEmail());
            ps.setDate(7, (Date) objeto.getFechaNacimiento());
            ps.setString(8, objeto.getTelefono());
            ps.setInt(9,
                    objeto.getSede() == null ? objeto.getSede().getId() : null);
            ps.setString(10, objeto.getContrasena());
            ps.setInt(11, objeto.getId());
            
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
    public Persona read(Object id) {
        Persona persona = null;
        try {
            PreparedStatement ps;
            ResultSet res;
            
            ps = cn.getConexion().prepareStatement(SQL_READ);
            ps.setInt(1, (int) id);
            
            res = ps.executeQuery();
            while (res.next()) {
                persona = new Persona();
                persona.setId(res.getInt(1));
                persona.setDni(res.getInt(2));
                persona.setNombre(res.getString(3));
                persona.setApellidoPaterno(res.getString(4));
                persona.setApellidoMaterno(res.getString(5));
                persona.setDireccion(res.getString(6));
                persona.setEmail(res.getString(7));
                persona.setDistrito(res.getString(8));
                persona.setFechaNacimiento(res.getDate(9));
                persona.setTelefono(res.getString(10));
                // TODO
                // persona.setSede(sede);
                persona.setContrasenaEncriptada(res.getString(12));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return persona;
    }

    @Override
    public ArrayList<Persona> readAll() {
        ArrayList<Persona> personas;
        personas = new ArrayList<>();
        try {
            PreparedStatement ps;
            ResultSet res;
            
            ps = cn.getConexion().prepareStatement(SQL_READ_ALL);
            
            res = ps.executeQuery();
            while (res.next()) {
                Persona persona;
                persona = new Persona();
                persona.setId(res.getInt(1));
                persona.setDni(res.getInt(2));
                persona.setNombre(res.getString(3));
                persona.setApellidoPaterno(res.getString(4));
                persona.setApellidoMaterno(res.getString(5));
                persona.setDireccion(res.getString(6));
                persona.setEmail(res.getString(7));
                persona.setDistrito(res.getString(8));
                persona.setFechaNacimiento(res.getDate(9));
                persona.setTelefono(res.getString(10));
                // TODO
                // persona.setSede(sede);
                persona.setContrasenaEncriptada(res.getString(12));
                personas.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermisoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return personas;
    }
}
