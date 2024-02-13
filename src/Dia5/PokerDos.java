package Dia5;


import java.util.ArrayList;
import java.util.Arrays;

class Cartas {
    private int valor;
    private char palo;

    public Cartas(int valor, char palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public char getPalo() {
        return palo;
    }
}


public class PokerDos {

    private Cartas[] mano;

    public PokerDos(Cartas[] mano) {
        this.mano = mano;
    }

    public boolean esEscaleraColor() {
        char primerPalo = mano[0].getPalo();
        int valorEsperado = mano[0].getValor();

        for (int i = 1; i < mano.length; i++) {
            if (mano[i].getPalo() != primerPalo || mano[i].getValor() != ++valorEsperado) {
                return false;
            }
        }

        return true;
    }

    public boolean esPoker() {
        int[] conteoValores = new int[15];

        for (Cartas cartas : mano) {
            conteoValores[cartas.getValor()]++;
        }

        for (int conteo : conteoValores) {
            if (conteo == 4) {
                return true;
            }
        }

        return false;
    }

    public boolean esFull() {
        int[] conteoValores = new int[15];
        boolean tieneTrio = false;
        boolean tienePar = false;

        for (Cartas cartas : mano) {
            conteoValores[cartas.getValor()]++;
        }

        for (int conteo : conteoValores) {
            if (conteo == 3) {
                tieneTrio = true;
            } else if (conteo == 2) {
                tienePar = true;
            }
        }

        return tieneTrio && tienePar;
    }

    public boolean esColor() {
        char primerPalo = mano[0].getPalo();

        for (int i = 1; i < mano.length; i++) {
            if (mano[i].getPalo() != primerPalo) {
                return false;
            }
        }

        return true;
    }

    public boolean esEscalera() {
        int[] valores = new int[5];

        for (int i = 0; i < 5; i++) {
            valores[i] = mano[i].getValor();
        }

        Arrays.sort(valores);

        return (valores[0] == 1 && valores[1] == 10 && valores[2] == 11 && valores[3] == 12 && valores[4] == 13) ||
                (valores[4] - valores[0] == 4 && valores[0] != 1);
    }

    public boolean esTrío() {
        int[] conteoValores = new int[15];

        for (Cartas cartas : mano) {
            conteoValores[cartas.getValor()]++;
        }

        for (int conteo : conteoValores) {
            if (conteo == 3) {
                return true;
            }
        }

        return false;
    }

    public boolean esParDoble() {
        int[] conteoValores = new int[15];
        int pares = 0;

        for (Cartas cartas : mano) {
            conteoValores[cartas.getValor()]++;
        }

        for (int conteo : conteoValores) {
            if (conteo == 2) {
                pares++;
            }
        }

        return pares == 2;
    }

    public boolean esPar() {
        int[] conteoValores = new int[15];

        for (Cartas cartas : mano) {
            conteoValores[cartas.getValor()]++;
        }

        for (int conteo : conteoValores) {
            if (conteo == 2) {
                return true;
            }
        }

        return false;
    }

    public void identificarJugada() {
        if (esEscaleraColor()) {
            System.out.println("Escalera de Color");
        } else if (esPoker()) {
            System.out.println("Poker");
        } else if (esFull()) {
            System.out.println("Full");
        } else if (esColor()) {
            System.out.println("Color");
        } else if (esEscalera()) {
            System.out.println("Escalera");
        } else if (esTrío()) {
            System.out.println("Trío");
        } else if (esParDoble()) {
            System.out.println("Par Doble");
        } else if (esPar()) {
            System.out.println("Par");
        } else {
            System.out.println("Carta Alta");
        }
    }
}











