/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructuradatos;

/**
 *
 * @author raulb
 */
public class PilaDinamica {
    
    private NodoPilas cima;       // Referencia al elemento de la cima de la pila.

    public PilaDinamica() {
        cima = null;        // inicializa la cima en null para indicar que la pila está vacía.
    }

    public NodoPilas getCima() {
        return cima;
    }

    public void setCima(NodoPilas cima) {
        this.cima = cima;
    }
    
    // Iniciar la construcción de los métodos que componen 
    // la definición formal de Pilas.
    
    // Método apilar o push. Permite insertar un elemento en la pila.
    public void apilar(int valor){
        // Creamos el dato.
        Dato miDato = new Dato(valor);
        // Creamos el nodo.
        NodoPilas miNodo = new NodoPilas(miDato);
        //Nodo miNodo2 = new Nodo(new Dato(valor)); Otra forma de crear el nodo.
        
        if (esVacia()){  // La pila está vacía.
            cima = miNodo;
        }       
        else{ // Si la pila no está vacía.
            miNodo.setAbajo(cima);  // Amarro el nuevo nodo al resto de la pila
            cima = miNodo;          // Mover la cima al nuevo nodo (nueva cima)
        }    
    }
    
    // Método desapilar , permite sacar un elemento de la pila (pop).
    public Dato desapilar(){
        if (esVacia()){
            System.out.println("Pila está vacía");
            return null;
        }else{  // Si la pila tiene elementos.
           // 1. Guardar en una variable temporl lo que está en la cima.
           Dato cimaTemp = cima.getMiDato();
           // 2. Mover la cima al que está abajo.
           cima = cima.getAbajo();
           return cimaTemp;
        }
    }

// Método devuelveCima , retorna el elemento de la cima SIN eliminarlo
    public Dato devuelveCima(){
        if (esVacia()){
            System.out.println("Pila está vacía");
            return null;
        }else{  // Si la pila tiene elementos.
            return cima.getMiDato();
        }
    }    
    
    public boolean esVacia(){
        if (cima == null)
            return true;
        else
            return false;
    }
    
    public int retornaTamaño(){
       NodoPilas temp = cima; // Crea una variable temporal para recorrer la EEDD
                         // Sin alterar.
       int tamaño = 0;
       while (temp != null){
           tamaño = tamaño + 1; //tamaño++;
           temp = temp.getAbajo();
       }
       return tamaño;
    }
    
    public void imprimePila(){
       NodoPilas temp = cima; // Crea una variable temporal para recorrer la EEDD
                         // Sin alterar.
       while (temp != null){
           System.out.println(temp.getMiDato().getValor());
           temp = temp.getAbajo();
       }
    }
    
    
}
