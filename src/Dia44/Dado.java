package Dia44;

import java.util.Arrays;
import java.util.Scanner;

public class Dado {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.println("**********************************************");
        System.out.println("*Bienvenido al sistema Generala*");
        System.out.println("**********************************************");
        System.out.println("");
        System.out.println("");

        System.out.print("Introduce los resultados de los cinco dados porfavor  : ");
        int[] dados = new int[5];
      for (int    i = 0; i < 5; i++) {
          dados[i] = 1;
          //dados[i] = scanner.nextInt();

        }

        if (esGenerala(dados)) {
            System.out.println("¡Generalaaa!");
        } else if (esPoker(dados)) {
            System.out.println("¡Poooooooooooker!");
        } else if (esFull(dados)) {
            System.out.println("¡Full!");
        } else if (esEscalera(dados)) {
            System.out.println("¡Escaleraaa!");
        } else {
            System.out.println("No se escuentra esta jugada.");
        }

        scanner.close();
    }

    private static boolean esGenerala(int[] dados) {
        int primerDado = dados[0]; //Obtener el valor del 0 elemento del array//
        return Arrays.stream(dados).allMatch(dado -> dado == primerDado); //si todos los elementos en el flujo cumplen con la condición especificada//
    } //Devuelve el resultado de la operación allMatch. Si todos los dados son iguales al primer dado, la función devuelve true; de lo contrario, devuelve false.//

    private static boolean esPoker(int[] dados) {
        Arrays.sort(dados);
        return dados[1] == dados[0] && dados[2] == dados[0] && dados[3] == dados[0];// función verifica si los elementos en las posiciones 1, 2 y 3 del arreglo son iguales al elemento en la posición 0. //
    }

    private static boolean esFull(int[] dados) {
        Arrays.sort(dados);//ordena el arreglo dados en orden ascendente//
        return (dados[0] == dados[1] && dados[2] == dados[4]) || (dados[0] == dados[2] && dados[3] == dados[4]);
    }// //

    private static boolean esEscalera(int[] dados) {
        Arrays.sort(dados);
        return (dados[0] == 1 && dados[1] == 2 && dados[2] == 3 && dados[3] == 4 && dados[4] == 5) ||//erifica si los dados forman una secuencia del 1 al 5.//
                (dados[0] == 2 && dados[1] == 3 && dados[2] == 4 && dados[3] == 5 && dados[4] == 6);// verifica si los dados forman una secuencia del 2 al 6.//

    }
}