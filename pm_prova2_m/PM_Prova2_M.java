/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author glbra
 */
public class PM_Prova2_M {

    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Aluguel> alugueis = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        carregarDados();

        int opcao;
        do {
            System.out.println("\n===== LOCADORA =====");
            System.out.println("1 - Associar veículo a um aluguel");
            System.out.println("2 - Exibir todos os veículos");
            System.out.println("3 - Exibir todos os aluguéis");
            System.out.println("4 - Exibir veículos disponíveis");
            System.out.println("5 - Avaliar");
            System.out.println("6 - Realizar inspeção");
            System.out.println("7 - Remover veículos em manutenção");
            System.out.println("0 - Sair");
            opcao = lerInteiro("Escolha: ");

            switch (opcao) {
                case 1 -> associarVeiculo();
                case 2 -> exibirVeiculos();
                case 3 -> exibirAlugueis();
                case 4 -> exibirDisponiveis();
                case 5 -> avaliar();
                case 6 -> inspecionar();
                case 7 -> removerEmManutencao();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private static void carregarDados() {
        veiculos.add(new Carro("ABC1D23", "Fiat Argo", 2022, 120, 35000, StatusVeiculo.DISPONIVEL, 4));
        veiculos.add(new Moto("DEF4G56", "Honda CB 500", 2021, 90, 62000, StatusVeiculo.DISPONIVEL, 500));
        veiculos.add(new Van("HIJ7K89", "Renault Master", 2020, 250, 80000, StatusVeiculo.DISPONIVEL, 15));

        alugueis.add(new AluguelBasico("Ana Souza", 3, 0, StatusAluguel.ATIVO));
        alugueis.add(new AluguelExecutivo("Bruno Lima", 5, 0, StatusAluguel.ATIVO, "Carlos"));
    }

    private static void associarVeiculo() {
        for (int i = 0; i < alugueis.size(); i++) {
            System.out.println(i + " - " + alugueis.get(i).getClass().getSimpleName()
                    + " de " + alugueis.get(i).getNomeCliente());
        }
        int indice = lerInteiro("Número do aluguel: ");
        if (indice < 0 || indice >= alugueis.size()) {
            System.out.println("Aluguel não encontrado");
            return;
        }

        exibirDisponiveis();
        System.out.print("Placa do veículo: ");
        Veiculo veiculo = buscarPorPlaca(sc.nextLine());
        if (veiculo == null) {
            System.out.println("Veículo não encontrado");
        } else if (veiculo.getStatus() != StatusVeiculo.DISPONIVEL) {
            System.out.println("Veículo não está disponível");
        } else {
            alugueis.get(indice).adicionarVeiculo(veiculo);
            System.out.println("Veículo associado ao aluguel");
        }
    }

    private static void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado");
        }
        for (Veiculo v : veiculos) {
            v.exibirDetalhes();
        }
    }

    private static void exibirAlugueis() {
        for (Aluguel a : alugueis) {
            a.exibirDetalhes();
        }
    }

    private static void exibirDisponiveis() {
        boolean achou = false;
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                v.exibirDetalhes();
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum veículo disponível");
        }
    }

    private static void avaliar() {
        List<Avaliavel> avaliaveis = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v instanceof Avaliavel) {
                avaliaveis.add((Avaliavel) v);
            }
        }
        for (Aluguel a : alugueis) {
            if (a instanceof Avaliavel) {
                avaliaveis.add((Avaliavel) a);
            }
        }

        if (avaliaveis.isEmpty()) {
            System.out.println("Nada para avaliar");
            return;
        }
        for (int i = 0; i < avaliaveis.size(); i++) {
            System.out.print(i + " - ");
            Object item = avaliaveis.get(i);
            if (item instanceof Veiculo v) {
                System.out.println(v.getClass().getSimpleName() + " " + v.getModelo() + " (" + v.getPlaca() + ")");
            } else if (item instanceof Aluguel a) {
                System.out.println(a.getClass().getSimpleName() + " de " + a.getNomeCliente());
            }
        }
        int indice = lerInteiro("Número do item: ");
        if (indice < 0 || indice >= avaliaveis.size()) {
            System.out.println("Item não encontrado");
            return;
        }
        int nota = lerInteiro("Nota (1 a 5): ");
        avaliaveis.get(indice).avaliar(nota);
    }

    private static void inspecionar() {
        boolean achou = false;
        for (Veiculo v : veiculos) {
            if (v instanceof Inspecionavel) {
                ((Inspecionavel) v).realizarInspecao();
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum veículo inspecionável");
        }
    }

    private static void removerEmManutencao() {
        int antes = veiculos.size();
        veiculos.removeIf(v -> v.getStatus() == StatusVeiculo.MANUTENCAO);
        for (Aluguel a : alugueis) {
            a.getVeiculos().removeIf(v -> v.getStatus() == StatusVeiculo.MANUTENCAO);
        }
        System.out.println((antes - veiculos.size()) + " veículo(s) removido(s)");
    }

    private static Veiculo buscarPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa.trim())) {
                return v;
            }
        }
        return null;
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido");
            }
        }
    }
}
