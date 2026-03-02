/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoestructuradatos;

import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author raulb
 * 1.	Avance 1: GRUPO_5_PFA1. En caso de no cumplir con esta instrucción se descontarán 2 puntos de su sumatoria final.
 * 2.	Avance 2: GRUPO_5_PFA2. En caso de no cumplir con esta instrucción se descontarán 2 puntos de su sumatoria final.
 * 3.	Presentación Final: GRUPO_5_PFAF. En caso de no cumplir con esta instrucción se descontarán 2 puntos de su sumatoria final.

 */
public class ProyectoEstructuraDatos {
    
private static Colas colaRegulares = new Colas();
private static Colas colaPreferenciales = new Colas();

private static int contadorR = 0;
private static int contadorP = 0;
private static int contadorPrefAtendidos = 0;
private static PilaQuejas pilaQuejas = new PilaQuejas();


    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "Bienvenido al MVP de su salud.");
        
        int opcionPrincipal = 0;
        
        while(opcionPrincipal != 3){
            opcionPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion "
                    + "\n1. Gestionar Llegada de Pacientes"
                    + "\n2. Ayuda"
                    + "\n3. Salir"));
            
            
            
            switch (opcionPrincipal){
                case 1:
                    gestionarLlegada();
                    break;
                case 2:
                    ayuda();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Hasta la proxima");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"opcion invalida");
                    break;
            }
            
            
            
            
        }
        
    }
    
    
    
    
    private static void ayuda(){
        JOptionPane.showMessageDialog(null,"HERRAMIENTA: Sistema de Gestión de Pacientes - Hospital Su Salud\n"
        + "Versión: Avance 1 V 1.2.4\n\n"
        + "Desarrollado por:\n"
        + "- Raul Brenes Muñoz\n"
        + "- Integrante 2\n"
        + "- Integrante 3\n"
        + "- Integrante 4\n");

}
    
    
    private static void gestionarLlegada(){
        
        
        int opcion = 0;
        
        while (opcion != 6){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Bienvenido al MVP de Su Salud.\n Porfavor"
                    + "seleccione una opcion:"
                    + "\n1. Seleccionar Ficha"
                    + "\n2. Atender Paciente"
                    + "\n3. Abandonar Cola"
                    + "\n4. Mostrar Fichas Pendientes"
                    + "\n5. Mostrar Quejas"
                    + "\n6. Menu principal"));
            
            switch (opcion){
                case 1:
                    seleccionarFicha();
                    break;
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    abandonarCola();
                    break;
                case 4:
                    mostrarFichasPendientes();
                    break;
                case 5:
                    mostrarQuejas();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,"Regresando al menu principal.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion invalida, intente de nuevo");
                    break;
            }
        }
    }
        
        private static void seleccionarFicha(){
            int tipoPaciente = Integer.parseInt(JOptionPane.showInputDialog("Seleccione"
                    + "el tipo de paciente:"
                    + "\n1. Paciente Regular"
                    + "\n2. Paciente Preferencial"));
            
            switch (tipoPaciente){
                case 1:
                    String cedulaR = JOptionPane.showInputDialog("Ingrese la cedula del paciente");
                    String nombreR = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
                    contadorR++;
                    String fichaR = "R" + contadorR;
                    
                    Paciente pacienteR = new Paciente(fichaR, cedulaR, nombreR, new Date());
                    colaRegulares.encolar(pacienteR);
                    
                    JOptionPane.showMessageDialog(null,"Su numero de ficha es: " + fichaR);
                    break;
                case 2:
                    String cedulaP = JOptionPane.showInputDialog("Ingrese la cedula del paciente");
                    String nombreP = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
                    contadorP++;
                    String fichaP = "P" + contadorP;
                    
                    Paciente pacienteP = new Paciente(fichaP, cedulaP, nombreP, new Date());
                    colaPreferenciales.encolar(pacienteP);
                    
                    JOptionPane.showMessageDialog(null,"Su numero de ficha es: " + fichaP);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
                    break;
            }
        }
        
        
        private static void atenderPaciente(){
            if(colaRegulares.estaVacia() && colaPreferenciales.estaVacia()){
                JOptionPane.showMessageDialog(null,"No hay pacientes en la cola");
                return;
            }
            Paciente pacienteAtendido = null;
            
            if(colaRegulares.estaVacia() && !colaPreferenciales.estaVacia()){
                pacienteAtendido = colaPreferenciales.desencolar();
                contadorPrefAtendidos++;
            }else if(!colaRegulares.estaVacia() && colaPreferenciales.estaVacia()){
                pacienteAtendido = colaRegulares.desencolar();
                contadorPrefAtendidos = 0;
            }else{
                if(contadorPrefAtendidos < 2) {
                    pacienteAtendido = colaPreferenciales.desencolar();
                    contadorPrefAtendidos++;
                }else{
                    if(!colaRegulares.estaVacia()){
                        pacienteAtendido = colaRegulares.desencolar();
                        contadorPrefAtendidos = 0;
                    }else{
                        pacienteAtendido = colaPreferenciales.desencolar();
                        contadorPrefAtendidos++;
                    }
                }
            }
            
            if (pacienteAtendido != null){
                JOptionPane.showMessageDialog(null,"Ficha #" + pacienteAtendido.getNumeroFicha() + ""
                        + " con cedula " + pacienteAtendido.getCedula() + ""
                                + " pasar a consulta medica.");
            }
            
            
        }
    
        
        
        
        
        private static void abandonarCola(){
            String ficha = JOptionPane.showInputDialog("Digite el numero"
                    + " de ficha que quiere abandonar la cola"
                    + " (Ejemplo: P5 o R20)");
            
            if(ficha == null){
                return;
            }
            
            if(ficha.equals("")){
                JOptionPane.showMessageDialog(null,"Debe de digitar el numero de la ficha.");
                return;
            }
            boolean tieneEspacio = false;
            for(int i = 0; i< ficha.length();i++){
                if(ficha.charAt(i) == ' '){
                    tieneEspacio = true;
                }
            }
            if(ficha.length() < 2) {
                JOptionPane.showMessageDialog(null,"Formato Invalido");
                return;
            }
            char letra = ficha.charAt(0);
            if(letra != 'R' && letra != 'r' && letra != 'P' && letra != 'p'){
                JOptionPane.showMessageDialog(null,"Formato Invalido");
                return;
            }
            
            Colas colaObjetivo = null;
            
            if (ficha.charAt(0) == 'R'){
                colaObjetivo = colaRegulares;
            }else if(ficha.charAt(0) == 'P'){
                colaObjetivo = colaPreferenciales;
            }else{
                JOptionPane.showMessageDialog(null,"La ficha debe empezar con R o P");
                return;
            }
            if(colaObjetivo.estaVacia()){
                JOptionPane.showMessageDialog(null,"No hay pacientes en esa cola");
                return;
            }
                
            Colas colaTemp = new Colas();
            boolean encontrado = false;
            Paciente pacienteFuera = null;
                
            while(!colaObjetivo.estaVacia()){
                 Paciente actual = colaObjetivo.desencolar();
                 
                 if(!encontrado && actual.getNumeroFicha().equalsIgnoreCase(ficha)){
                     encontrado = true;
                     pacienteFuera = actual;
                 }else{
                     colaTemp.encolar(actual);
                 }
            }
            
            while(!colaTemp.estaVacia()){
                colaObjetivo.encolar(colaTemp.desencolar());
            }
            
            if(!encontrado){
                JOptionPane.showMessageDialog(null,"No se encontro ningun paciente con la ficha: " + ficha);
            }else{
                String motivo = JOptionPane.showInputDialog("Digite el motivo");
                if(motivo == null || motivo.equals("")){
                    motivo="sin especificar";
                }
                
                Date fechaSalida = new Date();
                
                Quejas q = new Quejas(pacienteFuera.getNumeroFicha(), pacienteFuera.getCedula(), motivo, fechaSalida);
                
                
                pilaQuejas.apilarQueja(q);
                JOptionPane.showMessageDialog(null,"Ficha# " + pacienteFuera.getNumeroFicha() + " con cedula " + pacienteFuera.getCedula() + ""
                        + "abandono la cola sin ser atendido");
                
            }

            
            
            
            
            
            
            
        }
        
        
        
        
        private static void mostrarFichasPendientes(){
            if(colaRegulares.estaVacia() && colaPreferenciales.estaVacia()){
                JOptionPane.showMessageDialog(null,"No hay pacientes en cola");
                return;
                
            }
            
            
            String mensaje = "Pacientes en cola\n\n";
            
            if(!colaRegulares.estaVacia()){
                mensaje += "Pacientes Regulares(Con distintivo Verde)\n";
                
                Colas colaTempR = new Colas();
                while(!colaRegulares.estaVacia()){
                    Paciente actual = colaRegulares.desencolar();
                    mensaje += "[R Verde] Ficha" + actual.getNumeroFicha() + ""
                            + "| Cedula " + actual.getCedula() + ""
                            + "| Nombre " + actual.getNombre();
                    colaTempR.encolar(actual);
                }
                while(!colaTempR.estaVacia()){
                    colaRegulares.encolar(colaTempR.desencolar());
                    
                }
                
                mensaje += "\n";
            }
            

            
            
            
            if(!colaPreferenciales.estaVacia()){
                mensaje += "Pacientes Preferenciales(Con distintivo Naranja)\n";
                
                Colas colaTempP = new Colas();
                while(!colaPreferenciales.estaVacia()){
                    Paciente actual = colaPreferenciales.desencolar();
                    mensaje += "[R Verde] Ficha" + actual.getNumeroFicha() + ""
                            + "| Cedula " + actual.getCedula() + ""
                            + "| Nombre " + actual.getNombre();
                    colaTempP.encolar(actual);
                }
                while(!colaTempP.estaVacia()){
                    colaPreferenciales.encolar(colaTempP.desencolar());
                    
                }
                
                mensaje += "\n";
            }
            
            JOptionPane.showMessageDialog(null,mensaje);
            
            
            
            
            
        }
        
        
        
        
        private static void mostrarQuejas(){
            if(pilaQuejas.esVaciaQuejas()){
                JOptionPane.showMessageDialog(null,"No hay quejas");
                return;
            }
            
            String mensaje = "Quejas recibidas\n\n";
            PilaQuejas pilaTemp = new PilaQuejas();
            
            while(!pilaQuejas.esVaciaQuejas()){
                Quejas q = pilaQuejas.desapilarQueja();
                mensaje +="Ficha #" + q.getNumeroFicha() +""
                        + " Cedula " + q.getCedula() + ""
                        + " abandono la cola a las " + q.getFechaHoraSalida() + ""
                        + " por el motivo: " + q.getMotivo() + "\n\n";
                
                pilaTemp.apilarQueja(q);
            }
            
            while(!pilaTemp.esVaciaQuejas()){
                pilaQuejas.apilarQueja(pilaTemp.desapilarQueja());
                
            }
            
            JOptionPane.showMessageDialog(null, mensaje);
            
        }
        
        
        
}
        
        
        
        
        
        
    

