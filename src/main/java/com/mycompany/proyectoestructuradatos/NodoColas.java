/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructuradatos;

/**
 *
 * @author raulb
 */
public class NodoColas {
    
    private Paciente paciente;      
    private NodoColas siguiente;     

    public NodoColas() {
    }

    public NodoColas(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public NodoColas getSiguiente() {
        return siguiente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setSiguiente(NodoColas siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}
