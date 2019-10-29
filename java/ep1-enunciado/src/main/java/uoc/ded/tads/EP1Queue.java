package uoc.ded.tads;

import uoc.ei.tads.Cola;
import uoc.ei.tads.ColaVectorImpl;

public class EP1Queue {

        // Capacidad maxima de la secuencia
        public final int CAPACITY = 9;

        private Cola<Character> cola;

        public void newQueue() {
            System.out.println("\nCrea una cola acotada para " + CAPACITY + " elementos");
            cola = new ColaVectorImpl<Character>(CAPACITY);
        }

        public void fillQueue() {
            System.out.println("Encola los digitos del '0' al '" + (CAPACITY-1) + "'");
            // Almacena los digitos del '0' al '8'
            for (char c = '0'; c < '9'; c++) {
                cola.encolar(Character.valueOf(c));
            }
        }


        public String clearFullQueue() {
            String desencolar = "";
            while (! cola.estaVacio())
                desencolar += (cola.desencolar() + " ");
            System.out.println("Desencola todos los elementos: " + desencolar);
            return desencolar;
        }

        public Cola<Character> getQueue() {
            return this.cola;
        }

}
