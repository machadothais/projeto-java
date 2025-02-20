package projetoJava.utils;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== E-Commerce de Pets ===");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Fazer Pedido");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Listando Produtos...");
                    break;
                    
                case 2:
                    System.out.println("Fazendo Pedido...");
                    break;
                    
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);

        scanner.close(); 
    }
}
