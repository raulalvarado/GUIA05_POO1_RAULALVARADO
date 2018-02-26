/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Mauricio González
 */
public class Jugadores {
    private int codigojug;
    private String nomb;
    private int edad, altu, peso;

    public Jugadores() {
    }

    public Jugadores(String nomb, int edad, int altura, int peso) {
        this.nomb = nomb;
        this.edad = edad;
        this.altu = altura;
        this.peso = peso;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altu;
    }

    public void setAltu(int altu) {
        this.altu = altu;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCodigojug() {
        return codigojug;
    }

    public void setCodigojug(int codigojug) {
        this.codigojug = codigojug;
    }
    

    @Override
    public String toString() {
        return this.nomb;
    }
    
}
