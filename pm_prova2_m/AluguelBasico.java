package pm_prova2_m;

public class AluguelBasico extends Aluguel {

    private int limiteKmPorDia = 100;

    public AluguelBasico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== Aluguel Básico ===");
        System.out.println("Limite: " + limiteKmPorDia + " km por dia");
        exibirDadosBasicos();
    }

    public int getLimiteKmPorDia() {
        return limiteKmPorDia;
    }
}
