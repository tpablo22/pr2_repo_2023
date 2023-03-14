package mates;
import java.util.ArrayList;

public class Matematicas {
    public static double aritsmetica(double numero){

        if(numero == 0){
            return 0;

        }else{
            
            return (numero+aritsmetica(numero-1));
            
        }      
        }
    public static int sumaPar(int valor){
        if(valor == 0){
            return 0;
        
        }else if((valor%2) == 0){
            return valor+sumaPar(valor-2);

        }else{
            return (sumaPar(valor-1));
        }
    }


    /*public static ArrayList<Integer> elementosParLista(int pares){

        ArrayList<Integer> par = new ArrayList<Integer>();

        if(pares >= 0){
            if(pares%2 == 0){
                par.add(pares);
            }
            par.addAll(elementosParLista(pares-1));
        }
        return par;
        */
    }
        


