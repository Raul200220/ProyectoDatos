/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructuradatos;

import java.util.Date;

/**
 *
 * @author raulb
 */
public class Quejas {
    
    private String numeroFicha, cedula, motivo;
    private Date fechaHoraSalida;

    public Quejas() {
    }

    public Quejas(String numeroFicha, String cedula, String motivo, Date fechaHoraSalida) {
        this.numeroFicha = numeroFicha;
        this.cedula = cedula;
        this.motivo = motivo;
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
    
    
    
    
    
    
    
}
