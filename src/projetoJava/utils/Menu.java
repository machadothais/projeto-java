package projetoJava.utils;

import models.Produto;
import models.Cliente;
import models.Pedido;
import models.Cores;
import models.Pagamento;
import models.PagamentoCartaoCredito;
import models.PagamentoBoleto;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando a lista de produtos disponíveis
        Produto produto1 = new Produto("Ração", 50.0, 10, 14);
        Produto produto2 = new Produto("Brinquedo", 25.0, 5, 16);
        Produto produto3 = new Produto("Cama para cachorro", 120.0, 3, 55);

        List<Produto> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(produto1);
        produtosDisponiveis.add(produto2);
        produtosDisponiveis.add(produto3);

        // Criando o cliente
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String enderecoCliente = scanner.nextLine();
        
        Cliente cliente = new Cliente(nomeCliente, emailCliente, enderecoCliente);

        // Criando o pedido
        Pedido pedido = new Pedido(cliente);

        int opcao;
        do {
            System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND +
                               "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                 CARINHA DE BICHO                    ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Listar Produtos                      ");
            System.out.println("            2 - Fazer Pedido                         ");
            System.out.println("            3 - Sair                                 ");
            System.out.println("            4 - Sobre                                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     " + Cores.TEXT_RESET);
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome o newline após o nextInt()

            switch (opcao) {
                case 1:
                    listarProdutos(produtosDisponiveis);
                    break;

                case 2:
                    fazerPedido(scanner, produtosDisponiveis, pedido);
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                case 4:
                    sobre();
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close(); 
    }

    private static void listarProdutos(List<Produto> produtos) {
        System.out.println("\n=== Produtos Disponíveis ===");
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " - R$" + p.getPreco());
        }
    }

    private static void fazerPedido(Scanner scanner, List<Produto> produtosDisponiveis, Pedido pedido) {
        System.out.println("\n=== Selecione os produtos ===");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            Produto p = produtosDisponiveis.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " - R$" + p.getPreco());
        }

        System.out.println("Escolha os produtos (digite os números separados por espaço, por exemplo, '1 2'): ");
        String[] escolhas = scanner.nextLine().split(" ");

        // Adicionando produtos ao pedido
        for (String escolha : escolhas) {
            int index = Integer.parseInt(escolha) - 1;
            if (index >= 0 && index < produtosDisponiveis.size()) {
                Produto produtoEscolhido = produtosDisponiveis.get(index);
                System.out.print("Quantas unidades de " + produtoEscolhido.getNome() + " você deseja: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Consome o newline
                pedido.adicionarProduto(produtoEscolhido, quantidade);
            }
        }

        // Exibindo produtos no pedido
        pedido.getProdutos();

        // Escolher o método de pagamento
        Map<Integer, String> metodoPagamento = new HashMap<>();
        metodoPagamento.put(1, "Cartão de Crédito");
        metodoPagamento.put(2, "Boleto");

        System.out.println("\n=== Escolha o método de pagamento ===");
        for (Map.Entry<Integer, String> entry : metodoPagamento.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }

        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine(); // Consome o newline

        Pagamento pagamento = null;

        switch (opcaoPagamento) {
            case 1:
                pagamento = processarPagamentoCartaoCredito(scanner);
                break;
            case 2:
                pagamento = processarPagamentoBoleto(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        // Finalizando o pedido
        if (pagamento != null) {
            pedido.finalizarPedido(pagamento);  // Aqui é onde você imprime os detalhes do pedido.
        }
    }


    // Método para processar pagamento com Cartão de Crédito
    private static Pagamento processarPagamentoCartaoCredito(Scanner scanner) {
        // Consome a linha em excesso
        scanner.nextLine(); 

        System.out.print("Digite o número do cartão de crédito: ");
        String numeroCartao = scanner.nextLine();
        
        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        
        System.out.print("Digite o mês de validade (MM): ");
        int mesValidade = scanner.nextInt();
        
        System.out.print("Digite o ano de validade (AAAA): ");
        int anoValidade = scanner.nextInt();
        
        // Criação do objeto PagamentoCartaoCredito com os dados fornecidos
        return new PagamentoCartaoCredito(125.0, numeroCartao, nomeTitular, mesValidade, anoValidade);
    }

    // Método para processar pagamento com Boleto
    private static Pagamento processarPagamentoBoleto(Scanner scanner) {
        // Consome a linha em excesso
        scanner.nextLine(); 

        System.out.print("Digite o código do boleto: ");
        String codigoBoleto = scanner.nextLine();
        
        // Criação do objeto PagamentoBoleto com os dados fornecidos
        return new PagamentoBoleto(125.0, codigoBoleto);
    }
    

    public static void sobre() {
        System.out.println("\n************************************************");
        System.out.println("Projeto desenvolvido por Thais Cristiane Machado");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("************************************************");
    }
}
