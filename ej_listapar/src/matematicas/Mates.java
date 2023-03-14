package matematicas;

import java.util.ArrayList;
import java.util.Collection;

public class Mates {
    public static ArrayList<Integer> elementosPares(int par) {
        ArrayList<Integer> pares = new ArrayList<Integer>();

        if (par >= 0) {
            if ((par % 2) == 0) {
                pares.add(par);
            }
            pares.addAll(elementosPares(par - 1));
        }
        return pares;
    }
    public static int sumaDeElemntos(int numero){
        if(numero == 0){
            return 0;

        }
        if((numero % 2) == 0){
                return  numero+sumaDeElemntos(numero-2);

            } else {
                return  sumaDeElemntos(numero-1);

            }
        public static ArrayList<Integer> listaPar(int number) {
            ArrayList<Integer> numeros = new ArrayList<>();

            if(number >= 2){
                if((number%2)==0){
                    numeros.add(number);
                }
               return numeros.addAll(lintaNum(number-1));
            }

        }


    }


}

