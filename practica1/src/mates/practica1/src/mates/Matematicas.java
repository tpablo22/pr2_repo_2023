package mates.practica1.src.mates;

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
}

