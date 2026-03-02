/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructuradatos;

/**
 *
 * @author raulb
 */
public class Colas {
    
    private NodoColas primero;           
    private NodoColas ultimo;            

    public Colas() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    
    

    public NodoColas getPrimero() {
        return primero;
    }

    public NodoColas getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoColas primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoColas ultimo) {
        this.ultimo = ultimo;
    }
    
    
    

    public void encolar(Paciente paciente){
        NodoColas nuevo = new NodoColas(paciente);
        if (estaVacia()){ 
            primero = nuevo;
            ultimo = nuevo;
        }else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }
    
    public Paciente desencolar(){
        if (estaVacia()){
            System.out.println("No hay pacientes por desencolar");
            return null; 
            
        }else{          
            Paciente p = primero.getPaciente();  
                                                
            primero = primero.getSiguiente();     
            
            if (primero == null){
                ultimo = null;  
            }
            return p;
        }
    }
    
    
    public Paciente devuelvePrimero(){
        if (primero != null)
            return this.getPrimero().getPaciente();
        else{
            System.out.println("Cola vacía");
            return null;
        }
    }
    
    
    public void imprimeCola(){
        if (primero == null) {
            System.out.println("La cola está vacía.");
            return;
        }
        NodoColas actual = primero;
        System.out.println("Contenido de la cola:");
        while (actual != null) {
            System.out.println(actual.getPaciente());
            actual = actual.getSiguiente();
        }
    }
    
    public void abandonarCola(String paciente){
        
        
        return;
    } 
    
    
    
    
    
    
}
