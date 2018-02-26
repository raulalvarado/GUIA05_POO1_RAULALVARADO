/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Equipos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class controlEquipos {

    private final Connection conect;

    public controlEquipos() {

        this.conect = new Conexion().getConn();
    }

    public boolean guardar(String nombreEq, String descEq) {
        boolean resp = false;

        try {
            PreparedStatement cmd = this.conect.prepareStatement("INSERT INTO equipos VALUES(NULL,?,?)");
            cmd.setString(1, nombreEq);
            cmd.setString(2, descEq);
            cmd.executeUpdate();
            resp = true;

        } catch (Exception e) {
            System.err.println("Error al guardar equipos: " + e.getMessage());
        } finally {
            try {
                if (this.conect != null) {
                    if (!this.conect.isClosed()) {
                        this.conect.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return resp;
    }

    public ArrayList<Equipos> selectEquipos() {
        ArrayList<Equipos> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = conect.prepareStatement("SELECT * FROM equipos");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(new Equipos(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.err.println("Error al guardar equipo: " + e.getMessage());
        } finally {
            try {
                if (conect != null) {
                    if (!conect.isClosed()) {
                        conect.close();
                    }
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;
    }

    public boolean updateEqupos(int code, String nombreEq, String descEq) {
        boolean resp = false;
        try {
            PreparedStatement cmd = conect.prepareStatement("UPDATE equipos SET nomb_equi = ?, desc_equi = ? WHERE codi_equi = ?");
            cmd.setString(1, nombreEq);
            cmd.setString(2, descEq);
            cmd.setInt(3, code);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.err.println("Error al modificar equipo: " + e.getMessage());
        } finally {
            try {
                if (conect != null) {
                    if (!conect.isClosed()) {
                        conect.close();
                    }
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;
    }

    public boolean deleteEquipos(int code) {
        boolean resp = false;
        try {
            PreparedStatement cmd = conect.prepareStatement("DELETE FROM equipos WHERE codi_equi = ?");
            cmd.setInt(1, code);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.err.println("Error al guardar equipo: " + e.getMessage());
        } finally {
            try {
                if (conect != null) {
                    if (!conect.isClosed()) {
                        conect.close();
                    }
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;
    }

}
