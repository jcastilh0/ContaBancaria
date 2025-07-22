package org.aluraDesafioContaBancaria;

public class ContaBancaria {

    private String nome;
    private String tipoDeConta;
    private double saldoInicial;
    private double saldoAtualizado;

    public ContaBancaria(String nome, double saldoInicial, String tipoDeConta) {
        this.nome = nome;
        this.saldoInicial = saldoInicial;
        this.tipoDeConta = tipoDeConta;
        this.saldoAtualizado = saldoInicial;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public double getSaldoAtualizado() {
        return saldoAtualizado;
    }

    // Métodos principais
    public double consultarSaldo() {
        return saldoAtualizado;
    }

    public String receberValor(double deposito) {
        if (deposito <= 0) {
            return "Valor inválido para depósito.";
        }
        saldoAtualizado += deposito;
        return "Depósito realizado com sucesso. Saldo atualizado: R$" + saldoAtualizado;
    }

    public String transferirValor(double transferencia) {
        if (transferencia <= 0) {
            return "Valor inválido para transferência.";
        }
        if (saldoAtualizado < transferencia) {
            return "Não há saldo suficiente para fazer essa transferência.";
        }
        saldoAtualizado -= transferencia;
        return "Transferência realizada com sucesso. Saldo atualizado: R$" + saldoAtualizado;
    }
}
