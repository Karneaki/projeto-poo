package primeirob.segundaAtv;

import java.util.Scanner;

public class conversor {

    // Arrays estáticos para os códigos das moedas e as taxas de câmbio em relação ao USD
    private static final String[] moedas = {"USD", "EUR", "JPY", "GBP", "BRL"};
    private static final double[] taxas = {1.0, 0.85, 110.0, 0.75, 5.4};

    // Método que encontra o índice de uma moeda no array
    public static int findCurrencyIndex(String currency) {
        for (int i = 0; i < moedas.length; i++) {
            if (moedas[i].equalsIgnoreCase(currency)) {
                return i;
            }
        }
        return -1; // Retorna -1 se a moeda não for encontrada
    }

    // Método para converter a quantidade de uma moeda para outra
    public static double convert(double amount, String fromCurrency, String toCurrency) {
        int fromIndex = findCurrencyIndex(fromCurrency);
        int toIndex = findCurrencyIndex(toCurrency);

        // Verifica se as moedas existem nos arrays
        if (fromIndex == -1) {
            throw new IllegalArgumentException("Moeda de origem não suportada: " + fromCurrency);
        }
        if (toIndex == -1) {
            throw new IllegalArgumentException("Moeda de destino não suportada: " + toCurrency);
        }

        // Conversão da moeda de origem para USD e depois de USD para a moeda de destino
        double amountInUSD = amount / taxas[fromIndex];
        return amountInUSD * taxas[toIndex];
    }

    // Método principal para testar a conversão
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Exemplo de conversão 1: BRL para USD
            double valor1 = convert(100.0, "BRL", "USD");
            System.out.println("100 BRL é equivalente a " + valor1 + " USD");

            // Exemplo de conversão 2: EUR para JPY
            double valor2 = convert(50.0, "EUR", "JPY");
            System.out.println("50 EUR é equivalente a " + valor2 + " JPY");

            // Exemplo de conversão 3: USD para GBP
            double valor3 = convert(200.0, "USD", "GBP");
            System.out.println("200 USD é equivalente a " + valor3 + " GBP");

            // Exemplo de conversão com entrada inválida
            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            System.out.print("Digite a moeda de origem (código): ");
            String fromCurrency = scanner.next();
            System.out.print("Digite a moeda de destino (código): ");
            String toCurrency = scanner.next();
            
            double resultado = convert(valor, fromCurrency, toCurrency);
            System.out.println(valor + " " + fromCurrency + " é equivalente a " + resultado + " " + toCurrency);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

