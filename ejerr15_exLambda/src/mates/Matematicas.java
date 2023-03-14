package mates;

public class Matematicas {
    public static double generarNumeroPiIterativo(double pasos){
        double aciertos = 0;
        double areaCuadrado = 4;

        for(int i = 0; i<= pasos;i++){
            double x = Math.random();
            double y = Math.random();

            double distancia = ((x*x) + (y*y));
            if(distancia <= 1){
                aciertos += 1;
            }
        }return areaCuadrado*(aciertos/pasos);


    }
    public static int sumatorio(int numero) {
        if (numero == 0) {
            return 0;
        } else {

           return numero + sumatorio(numero-1);
        }

    }
}

