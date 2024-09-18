package primeirob.segundaAtv;

import java.util.Scanner;

public class contadorRomanos {

    public static String converterParaRomano(int numero) {
       
        StringBuilder romano = new StringBuilder();

        do {
            if (numero >= 1000) {
                romano.append("M");
                numero -= 1000;
            } else if (numero >= 900) {
                romano.append("CM");
                numero -= 900;
            } else if (numero >= 500) {
                romano.append("D");
                numero -= 500;
            } else if (numero >= 400) {
                romano.append("CD");
                numero -= 400;
            } else if (numero >= 100) {
                romano.append("C");
                numero -= 100;
            } else if (numero >= 90) {
                romano.append("XC");
                numero -= 90;
            } else if (numero >= 50) {
                romano.append("L");
                numero -= 50;
            } else if (numero >= 40) {
                romano.append("XL");
                numero -= 40;
            } else if (numero >= 10) {
                romano.append("X");
                numero -= 10;
            } else if (numero >= 9) {
                romano.append("IX");
                numero -= 9;
            } else if (numero >= 5) {
                romano.append("V");
                numero -= 5;
            } else if (numero >= 4) {
                romano.append("IV");
                numero -= 4;
            } else if (numero >= 1) {
                romano.append("I");
                numero -= 1;
            }
        } while (numero > 0);

        return romano.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        try {
            String numeroRomano = converterParaRomano(numero);
            System.out.println("Número em algarismos romanos: " + numeroRomano);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
