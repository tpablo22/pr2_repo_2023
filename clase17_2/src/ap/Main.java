package ap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//import mates.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {

        System.out.print(lmbda(10));
        
        

        
        
    
    }
    public static int lmbda(int numero){
        return IntStream.iterate(0, x -> x+1).limit(numero).sum();
    }
}