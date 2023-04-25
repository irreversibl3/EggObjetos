/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia9_4;

import java.util.Date;
import Servicios.FechaService;

/**
 *
 * @author santi
 */
public class Guia9_4 {

    /**
     * Vamos a usar la clase Date que ya existe en Java. Crearemos la clase
     * FechaService, en paquete Servicios, que tenga los siguientes métodos:
     * Método fechaNacimiento que pregunte al usuario día, mes y año de su
     * nacimiento. Luego los pase por parámetro a un nuevo objeto Date. El
     * método debe retornar el objeto Date. Ejemplo fecha: Date fecha = new
     * Date(anio, mes, dia); Método fechaActual que cree un objeto fecha con el
     * día actual. Para esto usaremos el constructor vacío de la clase Date.
     * Ejemplo: Date fechaActual = new Date(); El método debe retornar el objeto
     * Date. Método diferencia que reciba las dos fechas por parámetro y retorna
     * la diferencia de años entre una y otra (edad del usuario). Si necesiten
     * acá tienen más información en clase Date: Documentacion Oracle
     */
    public static void main(String[] args) {

        FechaService fecha = new FechaService();
        Date fecha1 = fecha.fechaNacimiento();
        Date fechaActual = fecha.fechaActual();
        System.out.println(fechaActual);
        System.out.println("Edad " + fecha.diferencia(fecha1, fechaActual));
    }

}
