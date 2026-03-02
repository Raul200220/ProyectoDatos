/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructuradatos;

/**
 *
 * @author raulb
 */
public class NodoPilas {
    
    private Dato miDato;        // Información a almacenar en la pila.
    private NodoPilas abajo;         // Puntero (referencia) al sgt elemento de la pila.

    public NodoPilas() {
    }

    public NodoPilas(Dato miDato) {
        this.miDato = miDato;
        this.abajo = null;
    }

    public void setMiDato(Dato miDato) {
        this.miDato = miDato;
    }

    public void setAbajo(NodoPilas abajo) {
        this.abajo = abajo;
    }

    public Dato getMiDato() {
        return miDato;
    }

    public NodoPilas getAbajo() {
        return abajo;
    }
    
    
}
