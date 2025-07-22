package org.aluraDesafioContaBancaria;

import java.util.Scanner;

public class MenuDeOperacoes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nome;
        int respostaTipoDeConta;
        String tipoDeConta = "";
        double saldoinicial;

        String respostaCriarConta;

        do {
            System.out.println("Bem-vindo ao banco CAJU, vamos criar sua conta? (S/N)");
            respostaCriarConta = sc.next();
        } while (!respostaCriarConta.equalsIgnoreCase("S") && !respostaCriarConta.equalsIgnoreCase("N"));

        if (respostaCriarConta.equalsIgnoreCase("S")) {
            System.out.print("Digite seu nome: ");
            nome = sc.next();

            do {
                System.out.println("Qual o tipo de conta deseja criar?" +
                        "\nDigite (1) para conta poupança ou (2) para conta corrente: ");
                respostaTipoDeConta = sc.nextInt();
            } while (respostaTipoDeConta != 1 && respostaTipoDeConta != 2);

            if (respostaTipoDeConta == 1) {
                tipoDeConta = "Poupança";
            } else {
                tipoDeConta = "Corrente";
            }

            System.out.println("Deseja depositar um valor inicial? (S/N)");
            String respostaSaldoInicial = sc.next();

            if (respostaSaldoInicial.equalsIgnoreCase("S")) {
                System.out.print("Digite o valor (apenas números)\nR$ ");
                saldoinicial = sc.nextDouble();
            } else {
                saldoinicial = 0;
            }

            ContaBancaria conta = new ContaBancaria(nome, saldoinicial, tipoDeConta);

            System.out.println("Conta criada com sucesso!");
            informacoesDaConta(nome, tipoDeConta, saldoinicial);

            int opcao = -1;
            while (opcao != 4) {
                menuDeOperacoes();
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("\nO saldo atual é R$" + conta.consultarSaldo());
                        break;
                    case 2:
                        System.out.print("\nDigite o valor que deseja depositar: \nR$");
                        double deposito = sc.nextDouble();
                        System.out.println(conta.receberValor(deposito));
                        break;
                    case 3:
                        System.out.print("\nDigite o valor que deseja transferir: \nR$");
                        double transferencia = sc.nextDouble();
                        System.out.println(conta.transferirValor(transferencia));
                        break;
                    case 4:
                        System.out.println("Encerrando aplicação. Obrigado!");
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente.");
                }
            }

        } else {
            System.out.println("Até a próxima!");
        }

        sc.close();
    }

    static void informacoesDaConta(String nome, String tipoDeConta, double saldoinicial) {
        System.out.println("\n****************************************************");
        System.out.println("Dados iniciais do cliente: \n" +
                "\nNome: " + nome +
                "\nTipo conta: " + tipoDeConta +
                "\nSaldo inicial: R$" + saldoinicial);
        System.out.println("****************************************************\n");
    }

    static void menuDeOperacoes() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Operações ");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Receber valor");
        System.out.println("3 - Transferir valor");
        System.out.println("4 - Sair");
        System.out.print("Digite a opção desejada: ");
    }
}
