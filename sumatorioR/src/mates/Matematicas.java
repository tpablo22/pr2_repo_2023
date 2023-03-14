package mates;

public class Matematicas {
    
    public static int sumatorio(int numero) {
        if (numero == 0) {
            return 0;
        } else {

           return numero + sumatorio(numero-1);
        }

    }
}

