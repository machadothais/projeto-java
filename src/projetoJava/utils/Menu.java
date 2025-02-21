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
        Produto produto4 = new Produto("Areia Higiênica", 54.32, 7, 509);
        Produto produto5 = new Produto("Escova Pet", 23.00, 12, 800);
        Produto produto6 = new Produto("Kit laços para pet", 5.99, 18, 45);
        Produto produto7 = new Produto("Kit Banho pet", 77.90, 14, 52);
        Produto produto8 = new Produto("Bebedouro e comedouro", 31.32, 4, 89);
        Produto produto9 = new Produto("Anti pugas", 15.30, 122, 150);
        Produto produto10 = new Produto("Colírio Cpirovet", 144.90, 5, 65);

        List<Produto> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(produto1);
        produtosDisponiveis.add(produto2);
        produtosDisponiveis.add(produto3);
        produtosDisponiveis.add(produto4);
        produtosDisponiveis.add(produto5);
        produtosDisponiveis.add(produto6);
        produtosDisponiveis.add(produto7);
        produtosDisponiveis.add(produto8);
        produtosDisponiveis.add(produto9);
        produtosDisponiveis.add(produto10);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite o endereço do cliente: ");
        String enderecoCliente = scanner.nextLine();
        
        Cliente cliente = new Cliente(nomeCliente, emailCliente, enderecoCliente);

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
            scanner.nextLine(); 

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
                scanner.nextLine(); 
                pedido.adicionarProduto(produtoEscolhido, quantidade);
            }
        }

        pedido.getProdutos();

        Map<Integer, String> metodoPagamento = new HashMap<>();
        metodoPagamento.put(1, "Cartão de Crédito");
        metodoPagamento.put(2, "Boleto");

        System.out.println("\n=== Escolha o método de pagamento ===");
        for (Map.Entry<Integer, String> entry : metodoPagamento.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }

        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine(); 

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
            pedido.finalizarPedido(pagamento); 
        }
    }


    private static Pagamento processarPagamentoCartaoCredito(Scanner scanner) {
        
        scanner.nextLine(); 

        System.out.print("Digite o número do cartão de crédito: ");
        String numeroCartao = scanner.nextLine();
        
        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        
        System.out.print("Digite o mês de validade (MM): ");
        int mesValidade = scanner.nextInt();
        
        System.out.print("Digite o ano de validade (AAAA): ");
        int anoValidade = scanner.nextInt();
        
        
        return new PagamentoCartaoCredito(125.0, numeroCartao, nomeTitular, mesValidade, anoValidade);
    }

    
    private static Pagamento processarPagamentoBoleto(Scanner scanner) {
       
        scanner.nextLine(); 

        System.out.print("Digite o código do boleto: ");
        String codigoBoleto = scanner.nextLine();
        
        
        return new PagamentoBoleto(125.0, codigoBoleto);
    }
    

    public static void sobre() {
        System.out.println("\n************************************************");
        System.out.println("Projeto desenvolvido por Thais Cristiane Machado");
        System.out.println("Generation Brasil - generation@generation.org");
        System.out.println("************************************************");
    }
}
