/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Entidades.Ahorcado;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá
 * contener como atributos, un vector con la palabra a buscar, la cantidad de
 * letras encontradas y la cantidad jugadas máximas que puede realizar el
 * usuario. Definir los siguientes métodos en AhorcadoService: Metodo
 * crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima. Con
 * la palabra del usuario, pone la longitud de la palabra, como la longitud del
 * vector. Después ingresa la palabra en el vector, letra por letra, quedando
 * cada letra de la palabra en un índice del vector. Y también, guarda la
 * cantidad de jugadas máximas y el valor que ingresó el usuario. Método
 * longitud(): muestra la longitud de la palabra que se debe encontrar. Nota:
 * buscar como se usa el vector.length. Método buscar(letra): este método recibe
 * una letra dada por el usuario y busca si la letra ingresada es parte de la
 * palabra o no. También informará si la letra estaba o no. Método
 * encontradas(letra): que reciba una letra ingresada por el usuario y muestre
 * cuantas letras han sido encontradas y cuántas le faltan. Este método además
 * deberá devolver true si la letra estaba y false si la letra no estaba, ya
 * que, cada vez que se busque una letra que no esté, se le restará uno a sus
 * oportunidades. Método intentos(): para mostrar cuántas oportunidades le queda
 * al jugador. Método juego(): el método juego se encargará de llamar todos los
 * métodos previamente mencionados e informará cuando el usuario descubra toda
 * la palabra o se quede sin intentos. Este método se llamará en el main. Un
 * ejemplo de salida puede ser así: Ingrese una letra: a Longitud de la palabra:
 * 6 Mensaje: La letra pertenece a la palabra Número de letras (encontradas,
 * faltantes): (3,4) Número de oportunidades restantes: 4
 * ---------------------------------------------- Ingrese una letra: z Longitud
 * de la palabra: 6 Mensaje: La letra no pertenece a la palabra Número de letras
 * (encontradas, faltantes): (3,4) Número de oportunidades restantes: 3
 * --------------------------------------------- Ingrese una letra: b Longitud
 * de la palabra: 6 Mensaje: La letra no pertenece a la palabra Número de letras
 * (encontradas, faltantes): (4,3) Número de oportunidades restantes: 2
 * ---------------------------------------------- Ingrese una letra: u Longitud
 * de la palabra: 6 Mensaje: La letra no pertenece a la palabra Número de letras
 * (encontradas, faltantes): (4,3) Número de oportunidades restantes: 1 Ingrese
 * una letra: q Longitud de la palabra: 6 Mensaje: La letra no pertenece a la
 * palabra Mensaje: Lo sentimos, no hay más oportunidades
 */
public class AhorcadoService {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearJuego(Ahorcado juego) {
        System.out.println("Ingrese la palabra a adivinar");
        String palabra = leer.next();
        System.out.println("Ingrese la cantidad de intentos");
        juego.setJugadasMax(leer.nextInt());

        while (juego.getJugadasMax() < 1 && juego.getJugadasMax() > 10) {
            System.out.println("Los intentos tienen que estar entre 1 y 10");

        }

        juego.setPalabra(new String[palabra.length()]);
        juego.setPalabraAhor(new String[palabra.length()]);

        for (int i = 0; i < juego.getPalabra().length; i++) {
            juego.getPalabra()[i] = palabra.substring(i, i + 1).toUpperCase();
            juego.getPalabraAhor()[i] = "_ ";
        }
    }

    public int longitud(Ahorcado juego) {
        return juego.getPalabra().length;
    }

    public boolean buscar(Ahorcado juego) {

        boolean encuentra = true;

        System.out.println("Ingrese una letra");
        juego.setLetraIngresada(leer.next().toUpperCase());
        String letra = juego.getLetraIngresada();
        int contadorLetras = 0;

        for (int i = 0; i < juego.getPalabra().length; i++) {
            if (juego.getPalabra()[i].equalsIgnoreCase(letra)) {
                System.out.println("La letra se encuentra en la palabra");
                juego.getPalabraAhor()[i] = letra.toUpperCase();
                encuentra = true;
                contadorLetras += 1;

            } else if (contadorLetras == 0 && i == juego.getPalabra().length - 1) {
                encuentra = false;
                System.out.println("La letra no se cuenta en la palabra");
                juego.setJugadasMax(juego.getJugadasMax() - 1);
                System.out.println("Intentos restantes: " + juego.getJugadasMax());
            }
        }

        if (juego.getJugadasMax() < 1) {
            System.out.println("Te quedaste sin intentos");
            encuentra = false;

            System.out.println("La palabra era");
            for (int i = 0; i < juego.getPalabra().length; i++) {
                System.out.print(juego.getPalabra()[i]);
            }
            System.out.println(" ");
        }
        return encuentra;
    }

    public boolean encontradas(Ahorcado juego) {

        boolean adivina = true;

        for (int i = 0; i < juego.getPalabraAhor().length; i++) {
            System.out.print(juego.getPalabraAhor()[i]);
        }
        System.out.println(" ");

        if (juego.getJugadasMax() < 1) {
            System.out.println("Te quedaste sin intentos");
            adivina = false;
            System.out.println("La palabra era");
            for (int i = 0; i < juego.getPalabra().length; i++) {

                System.out.print(juego.getPalabra()[i]);
            }
            System.out.println(" ");
        } else {
            adivina = true;
        }
        return adivina;

    }

    public int intentos(Ahorcado juego) {
        return juego.getJugadasMax();
    }

    public void juego(Ahorcado juego) {
        System.out.println("La palabra tiene " + longitud(juego) + " letras");
        do {
            buscar(juego);
            encontradas(juego);
            if (Arrays.equals(juego.getPalabra(), juego.getPalabraAhor())) {
                System.out.println("Adivinaste ! Te sobraron " + juego.getJugadasMax() + " intentos.");
                break;
            }
        } while (juego.getJugadasMax() > 0 && !Arrays.equals(juego.getPalabra(), juego.getPalabraAhor()));

    }

}
