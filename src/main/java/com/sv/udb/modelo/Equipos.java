/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio González
 */
public class Equipos {
    private int codigoeq;
    private String nomb;
    private String desc;
    private ArrayList<Jugadores> listJuga;

    /**
    * Constructor, no olvidar crear el objeto de las listas
    * en ambos constructores
    *
    * @param nomb El nombre del equipo
    */
    public Equipos(int codigoeq, String nomb, String desc) {
        this.codigoeq= codigoeq;
        this.nomb = nomb;
        this.desc=desc;
    }

    public Equipos() {
        this.listJuga = new ArrayList<>();
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }
    
    public ArrayList<Jugadores> getListJuga() {
        return listJuga;
    }

    public void setListJuga(ArrayList<Jugadores> listJuga) {
        this.listJuga = listJuga;
    }


    public int getCodigoeq() {
        return codigoeq;
    }

    public void setCodigoeq(int codigoeq) {
        this.codigoeq = codigoeq;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
    

    @Override
    public String toString() {
        return nomb;
    }    
}
