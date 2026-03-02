/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructuradatos;

/**
 *
 * @author raulb
 */
public class PilaQuejas extends PilaDinamica{
    
    private NodoPilaQuejas cimaQueja;

    public PilaQuejas() {
    }

    public PilaQuejas(NodoPilaQuejas cimaQueja) {
        super();
        this.cimaQueja = null;
    }
    
    public boolean esVaciaQuejas(){
        return cimaQueja == null;
    };
    
    
    public void apilarQueja(Quejas q){
        NodoPilaQuejas nuevo = new NodoPilaQuejas(q);
        if(esVaciaQuejas()){
            cimaQueja = nuevo;
        }else{
            nuevo.setAbajo(cimaQueja);
            cimaQueja = nuevo;
        }
        
    }
    
    public Quejas desapilarQueja(){
        if(esVaciaQuejas()){
            return null;
        }else{
            Quejas q = cimaQueja.getQuejas();
            cimaQueja = cimaQueja.getAbajo();
            return q;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
