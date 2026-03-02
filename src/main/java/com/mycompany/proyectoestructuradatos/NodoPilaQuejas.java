/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructuradatos;

/**
 *
 * @author raulb
 */
public class NodoPilaQuejas{


    public Quejas getQuejas() {
        return quejas;
    }


    public void setQuejas(Quejas quejas) {
        this.quejas = quejas;
    }


    public NodoPilaQuejas getAbajo() {
        return abajo;
    }


    public void setAbajo(NodoPilaQuejas abajo) {
        this.abajo = abajo;
    }
    
    private Quejas quejas;
    private NodoPilaQuejas abajo;

    public NodoPilaQuejas() {
    }

    public NodoPilaQuejas(Quejas quejas) {
        this.quejas = quejas;
        this.abajo = null;
    }
    
    
    
    
    
    
    
    
}
