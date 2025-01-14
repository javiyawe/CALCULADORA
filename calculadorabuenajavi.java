import java.util.Scanner;

public class calculadorabuenajavi {

    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESETEO = "\u001B[0m";

    public static int elegirOperación(Scanner meter){
        System.out.println("Elige la operación que deseas realizar:");

        int numElegido = 0;

        while (numElegido > 5 || numElegido < 1) {
            System.out.println("1 - SUMAR");
            System.out.println("2 - RESTAR");
            System.out.println("3 - MULTIPLICAR");
            System.out.println("4 - DIVIDIR");
            System.out.println("5 - SALIR");

            numElegido = meter.nextInt();

            if (numElegido > 5 || numElegido < 1) {
                System.err.println(ROJO + "Elige una opcion válida" + RESETEO);
            }
        }
        return numElegido;
    }

    public static double[] añadirNumeros(Scanner meter){

        double[] numeros = new double[2];

        System.out.println("Elige el PRIMER número de la operación: ");
        numeros[0] = meter.nextDouble();

        System.out.println("Elige el SEGUNDO número de la operación: ");
        numeros[1] = meter.nextDouble();

        return numeros;
    }

    public static double calculo(int numElegido, double[] numeros){

        double resultado=0;

        switch (numElegido) {
            case 1:
                resultado = numeros[0] + numeros[1];
                break;
            case 2:
                resultado = numeros[0] - numeros[1];
                break;
            case 3:
                resultado = numeros[0] * numeros[1];
                break;
            case 4:
                resultado = numeros[0] / numeros[1];
                break;
        }

        return resultado;
    }

    public static void main(String[] args) {

        Scanner meter = new Scanner(System.in);

        while(true){

            int operación = elegirOperación(meter);

            if (operación == 5) {
                System.out.println(VERDE + "Saliendo de la calculadora :)" + RESETEO);
                break;
            }

            double[] numeros = añadirNumeros(meter);
            double resultado = calculo(operación, numeros);

            String operacionEnTexto = "";
            
            if (operación == 1) {
                operacionEnTexto = "suma";
            }
            else if (operación == 2) {
                operacionEnTexto = "resta";
            }
            else if (operación == 3) {
                operacionEnTexto = "multiplicación";
            }
            else if (operación == 4) {
                operacionEnTexto = "división";
            }

            System.out.printf(VERDE + "El resultado de la %s de %.2f y %.2f es %.2f\n\n" + RESETEO,operacionEnTexto, numeros[0], numeros[1],resultado);

        }

        meter.close();
        
    }

}
