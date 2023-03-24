package dominio;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Pablo Torres
 * The class Tablero
 */
public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual = new int[DIMENSION+2][DIMENSION+2];
    private int[][] estadoSiguiente= new int[DIMENSION+2][DIMENSION+2];




    /**
     *
     * Leer estado actual
     *
     */
    public void leerEstadoActual() {

        try {
            File fichero = new File("matriz");
            Scanner scanner = new Scanner(fichero);
            for (int i = 1; i <= DIMENSION; i++) {
                String linea = scanner.nextLine();
                for (int j = 1; j <= DIMENSION; j++) {
                    estadoActual[i][j] = Character.getNumericValue(linea.charAt(j-1));
                }
            }

            for (int i = 1; i <= DIMENSION; i++) {
                for (int j = 1; j <= DIMENSION; j++) {
                    int vecinasVivas = contarVecinasVivas(i, j);

                    if ((estadoActual[i][j] == 1 && vecinasVivas == 2) || vecinasVivas == 3) {
                        estadoSiguiente[i][j] = 1;
                    } else {
                        estadoSiguiente[i][j] = 0;
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * Contar vecinas vivas
     *
     * @param fila  the fila
     * @param columna  the columna
     * @return int
     */
    public int contarVecinasVivas(int fila, int columna) {

        int contador = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (!(i == fila && j == columna)) { // No contamos la celda actual
                    contador += estadoActual[i][j];
                }
            }
        }
        return contador;
    }

    /**
     *
     * Generar estado actual por montecarlo
     *
     */
    public void generarEstadoActualPorMontecarlo() {


        for (int i = 1; i < DIMENSION+1; i++) {
            for (int j = 1; j < DIMENSION+1; j++) {
                estadoActual[i][j] = (int) Math.round(Math.random());
            }
        }

        for (int i = 1; i < DIMENSION+1; i++) {
            for (int j = 1; j < DIMENSION+1; j++) {
                int vecinasVivas = estadoActual[i - 1][j - 1] + estadoActual[i - 1][j] + estadoActual[i - 1][j + 1]
                        + estadoActual[i][j - 1] + estadoActual[i][j + 1] + estadoActual[i + 1][j - 1] +
                        estadoActual[i + 1][j] + estadoActual[i + 1][j + 1];
                if (estadoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) {
                    estadoSiguiente[i][j] = 1;
                } else if (estadoActual[i][j] == 0 && vecinasVivas == 3) {
                    estadoSiguiente[i][j] = 1;
                } else {
                    estadoSiguiente[i][j] = 0;
                }
            }
        }
    }




    /**
     *
     * Transitar al estado siguiente
     *
     */
    public void transitarAlEstadoSiguiente () {

        int[][] estadoAnterior = estadoActual;
        estadoActual = estadoSiguiente;
        estadoSiguiente = estadoAnterior;
        for (int i = 1; i <= DIMENSION; i++) {
            for (int j = 1; j <= DIMENSION; j++) {
                int vecinasVivas = estadoActual[i - 1][j - 1] + estadoActual[i - 1][j] + estadoActual[i - 1][j + 1]
                        + estadoActual[i][j - 1] + estadoActual[i][j + 1] + estadoActual[i + 1][j - 1] +
                        estadoActual[i + 1][j] + estadoActual[i + 1][j + 1];
                estadoSiguiente[i][j] = (estadoActual[i][j] == 1 && (vecinasVivas == 2 || vecinasVivas == 3)) ||
                        (estadoActual[i][j] == 0 && vecinasVivas == 3) ? 1 : 0;
            }
        }
    }

    @Override

/**
 *
 * To string
 *
 * @return String
 */
    public String toString() {

        StringBuilder cadena = new StringBuilder();
        for (int i = 1; i < DIMENSION+1; i++) {
            for (int j = 1; j < DIMENSION+1; j++) {
                cadena.append(estadoActual[i][j] == 0 ? " " : "x");
            }
            cadena.append("\n");
        }
        return cadena.toString();
    }
}
