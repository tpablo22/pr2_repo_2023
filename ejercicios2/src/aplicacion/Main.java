package aplicacion;
import java.util.ArrayList;

import mates.Matematicas;


public class Main {
    public static void main(String[] args) {
        double numero = 10;
        double suma = Matematicas.aritsmetica(numero);
        System.out.println(suma/numero);

        System.out.println(Matematicas.sumaPar(20));

        
        
        ArrayList<Integer> par = elementosParLista(9);

        System.out.println("elemensots pares de una lista"+par);
    }

        public static ArrayList<Integer> elementosParLista(int pares){

            ArrayList<Integer> par = new ArrayList<Integer>();
    
            if(pares >= 0){
                if(pares%2 == 0){
                    par.add(pares);
                }
                par.addAll(elementosParLista(pares-1));
            }
            return par;
        }



    }

    
