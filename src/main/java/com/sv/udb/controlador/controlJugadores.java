/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Equipos;
import com.sv.udb.modelo.Jugadores;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class controlJugadores {
    private final Connection conect;

    public controlJugadores() {
        this.conect = new Conexion().getConn();
    }
    
    public boolean guardar(Equipos codigoEqui, String nombJuga, int edadJuga, int alturaJuga, int pesoJuga)
    {
        boolean resp= false;
        try
        {
            PreparedStatement cmd = this.conect.prepareStatement("INSERT INTO jugadores VALUES(NULL,?,?,?,?,?)");
            cmd.setInt(1, codigoEqui.getCodigoeq());
            cmd.setString(2, nombJuga);
            cmd.setInt(3, edadJuga);
            cmd.setInt(4, alturaJuga);
            cmd.setInt(5, pesoJuga);
            cmd.executeUpdate();
            resp=true;
        
        }
        catch(SQLException ex)
         {
             System.err.println("Ocurrio un error al guardar equipos: "+ ex.getMessage());
         }
        finally
        {
             try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
        }
    
     public List<Jugadores> consTodo()
    {
       List<Jugadores> resp = new ArrayList<>();
        try
        {
            PreparedStatement cmd = conect.prepareStatement("SELECT j.codi_juga, e.*, j.nomb_juga, j.edad_juga, j.altu_juga," +
                                            " j.peso_juga FROM jugadores j INNER JOIN equipos e ON j.codi_equi = e.codi_equi");
            //Vea la siguiente ayuda
            /*Una opción de query podría ser: 
                SELECT j.codi_juga, e.*, j.nomb_juga, j.edad_juga, j.altu_juga, 
                j.peso_juga FROM jugadores j INNER JOIN equipos e ON j.codi_equi = e.codi_equi;
            */
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
               resp.add(rs.getInt(1),new Equipos(rs.getInt(2),rs.getString(3),rs.getString(4)),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)); // <----- Hay que llenar con los objetos
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error al consultar Jugadores: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conect != null)
                {
                    if(!this.conect.isClosed())
                    {
                        this.conect.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
    }
    
    
    

