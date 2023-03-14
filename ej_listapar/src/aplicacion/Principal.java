package aplicacion;
import matematicas.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero para hacer los ejercicios: ");
        int num = sc.nextInt();

        ArrayList<Integer> pares = Mates.elementosPares(num);

        System.out.println("los elementos pares que pertenecen a 9 es: "+pares);
        System.out.println("La suma dek elemento es "+Mates.sumaDeElemntos(num));

    }
}
