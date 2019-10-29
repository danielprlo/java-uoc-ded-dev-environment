package uoc.ded.tads;

import uoc.ei.tads.Pila;
import uoc.ei.tads.PilaVectorImpl;

public class EP1Stack {

        // Capacidad maxima de la secuencia. */
        public final int CAPACITY = 9;

        private Pila<Character> pila;

        public void newStack() {
            System.out.println("\nCrea una pila acotada para " + CAPACITY + " elementos ");
            pila = new PilaVectorImpl<Character>(CAPACITY);
        }


        public void fillStack() {
            System.out.println("Apila los digitos del '0' al '" + (CAPACITY-1) + "'");
            // Almacena los digitos del '0' al '8'
            for (char c = '0'; c < '9'; c++) {
                pila.apilar(Character.valueOf(c));
            }
        }

        public String clearAllStack() {
            String desapilar = "";
            while (! pila.estaVacio())
                desapilar += (pila.desapilar() + " ");
            System.out.println("Desapila todos los elementos: " + desapilar);
            return desapilar;
        }

    public Pila<Character> getStack() {
        return this.pila;
    }
}
