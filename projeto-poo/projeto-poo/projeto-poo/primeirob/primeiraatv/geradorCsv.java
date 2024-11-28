package primeirob.primeiraatv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface geradorCsv {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Receber as colunas do usuário
        System.out.println("Informe o número de colunas:");
        int numColunas = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        String[] colunas = new String[numColunas];
        for (int i = 0; i < numColunas; i++) {
            System.out.println("Informe o nome da coluna " + (i + 1) + ":");
            colunas[i] = scanner.nextLine();
        }

        // Receber os dados para as linhas
        System.out.println("Informe o número de linhas de dados:");
        int numLinhas = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        String[][] dados = new String[numLinhas][numColunas];
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColunas; j++) {
                System.out.println("Informe o dado da linha " + (i + 1) + ", coluna " + colunas[j] + ":");
                dados[i][j] = scanner.nextLine();
            }
        }

        // Criar e salvar o arquivo CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_usuario.csv"))) {

            // Escrever o cabeçalho (nomes das colunas)
            for (int i = 0; i < colunas.length; i++) {
                writer.write(colunas[i]);
                if (i < colunas.length - 1) {
                    writer.write(","); // Separar por vírgulas
                }
            }
            writer.newLine(); // Nova linha após o cabeçalho
            // Escrever os dados
            for (String[] dado : dados) {
                for (int j = 0; j < dado.length; j++) {
                    writer.write(dado[j]);
                    if (j < dado.length - 1) {
                        writer.write(","); // Separar por vírgulas
                    }
                }
                writer.newLine(); // Nova linha após cada linha de dados
            }

            System.out.println("Arquivo CSV 'dados_usuario.csv' criado com sucesso!");
        } catch (IOException e) {
        }
    }
}