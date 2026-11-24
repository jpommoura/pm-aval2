/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glbra
 */
public abstract class Aluguel {

    private String nomeCliente;
    private int quantidadeDias;
    private double valorTotal;
    private StatusAluguel status;
    private List<Veiculo> veiculos = new ArrayList<>();

    public Aluguel(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {

        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
        valorTotal += veiculo.getValorDiaria() * quantidadeDias;
    }

    protected void exibirDadosBasicos() {
        System.out.println("Cliente: " + nomeCliente + " | Dias: " + quantidadeDias
                + " | Valor total: R$ " + String.format("%.2f", valorTotal) + " | Status: " + status);
        System.out.println("Seguro incluso: " + (possuiSeguroIncluso() ? "sim" : "não"));
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo associado");
        } else {
            System.out.println("Veículos:");
            for (Veiculo v : veiculos) {
                System.out.println("  - " + v.getModelo() + " (" + v.getPlaca() + ")");
            }
        }
    }

    public abstract void exibirDetalhes();

    public abstract boolean possuiSeguroIncluso();
    
}
