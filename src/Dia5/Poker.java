package Dia5;

import java.util.Arrays;
import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("**********************************************");
        System.out.println("****Bienvenido al juego Poker****");
        System.out.println("**********************************************");
        System.out.println("");
        System.out.println("");


        Cartas[] mano = new Cartas[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese valor de la carta #" + (i + 1) + ": ");
            int valor = (scanner.nextInt());

            System.out.println("");
            System.out.print("Ingrese palo de la carta #" + (i + 1) + ": ");
            char palo = scanner.next().charAt(0);
            mano[i] = new Cartas(valor, palo);

            System.out.println("");

        }

            PokerDos pokerDos = new PokerDos(mano);
            pokerDos.identificarJugada();





    }



}
