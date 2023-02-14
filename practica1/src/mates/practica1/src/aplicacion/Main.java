package mates.practica1.src.aplicacion;
import mates.practica1.src.mates.Matematicas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija un numero para calcular pi por momtecarlo: ");
        double montecar = sc.nextDouble();

        System.out.println("El número PI es "+ Matematicas.generarNumeroPiIterativo(montecar));
    }
}