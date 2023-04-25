/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia9_extra2;

import Entidades.Ahorcado;
import Service.AhorcadoService;
import java.util.Scanner;

/**
 *
 * @author santi
 */
public class Guia9_Extra2 {

    /**
     * Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá
     * contener como atributos, un vector con la palabra a buscar, la cantidad
     * de letras encontradas y la cantidad jugadas máximas que puede realizar el
     * usuario. Definir los siguientes métodos en AhorcadoService: Metodo
     * crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima.
     * Con la palabra del usuario, pone la longitud de la palabra, como la
     * longitud del vector. Después ingresa la palabra en el vector, letra por
     * letra, quedando cada letra de la palabra en un índice del vector. Y
     * también, guarda la cantidad de jugadas máximas y el valor que ingresó el
     * usuario. Método longitud(): muestra la longitud de la palabra que se debe
     * encontrar. Nota: buscar como se usa el vector.length. Método
     * buscar(letra): este método recibe una letra dada por el usuario y busca
     * si la letra ingresada es parte de la palabra o no. También informará si
     * la letra estaba o no. Método encontradas(letra): que reciba una letra
     * ingresada por el usuario y muestre cuantas letras han sido encontradas y
     * cuántas le faltan. Este método además deberá devolver true si la letra
     * estaba y false si la letra no estaba, ya que, cada vez que se busque una
     * letra que no esté, se le restará uno a sus oportunidades. Método
     * intentos(): para mostrar cuántas oportunidades le queda al jugador.
     * Método juego(): el método juego se encargará de llamar todos los métodos
     * previamente mencionados e informará cuando el usuario descubra toda la
     * palabra o se quede sin intentos. Este método se llamará en el main. Un
     * ejemplo de salida puede ser así: Ingrese una letra: a Longitud de la
     * palabra: 6 Mensaje: La letra pertenece a la palabra Número de letras
     * (encontradas, faltantes): (3,4) Número de oportunidades restantes: 4
     * ---------------------------------------------- Ingrese una letra: z
     * Longitud de la palabra: 6 Mensaje: La letra no pertenece a la palabra
     * Número de letras (encontradas, faltantes): (3,4) Número de oportunidades
     * restantes: 3 --------------------------------------------- Ingrese una
     * letra: b Longitud de la palabra: 6 Mensaje: La letra no pertenece a la
     * palabra Número de letras (encontradas, faltantes): (4,3) Número de
     * oportunidades restantes: 2 ----------------------------------------------
     * Ingrese una letra: u Longitud de la palabra: 6 Mensaje: La letra no
     * pertenece a la palabra Número de letras (encontradas, faltantes): (4,3)
     * Número de oportunidades restantes: 1
     * ---------------------------------------------- Ingrese una letra: q
     * Longitud de la palabra: 6 Mensaje: La letra no pertenece a la palabra
     * Mensaje: Lo sentimos, no hay más oportunidades
     *
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AhorcadoService juego1 = new AhorcadoService();
        Ahorcado juego2 = new Ahorcado();
        juego1.crearJuego(juego2);
        juego1.juego(juego2);

    }

}
