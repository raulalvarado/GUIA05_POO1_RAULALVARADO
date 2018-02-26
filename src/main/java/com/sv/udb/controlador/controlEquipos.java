/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Estudiante
 */
public class controlEquipos {
    private final Connection conect;

    public controlEquipos() {
        
        this.conect=new Conexion().getConn();
    }
    
    public boolean guardar(String nombreEq, String descEq)
    {
        boolean resp= false;
        
        try 
        {
            PreparedStatement cmd= this.conect.prepareStatement("INSERT INTO equipos VALUES(NULL,?,?)");
            cmd.setString(1, nombreEq);
            cmd.setString(2, descEq);
            cmd.executeUpdate();
            resp=true;
            
        } 
        catch (Exception e) 
        {
            System.err.println("Error al guardar equipos: "+e.getMessage());
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
        catch (SQLException e) 
        {
            System.err.println("Error al cerrar la conexion: "+ e.getMessage());
        }
        }
    return resp;
    }
    
}
