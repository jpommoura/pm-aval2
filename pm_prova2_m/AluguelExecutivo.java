package pm_prova2_m;

public class AluguelExecutivo extends Aluguel implements Avaliavel {

    private String nomeMotorista;
    private int nota;

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal,
                            StatusAluguel status, String nomeMotorista) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.nomeMotorista = nomeMotorista;
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota inválida. Use de 1 a 5.");
            return;
        }
        this.nota = nota;
        System.out.println("Aluguel executivo de " + getNomeCliente() + " avaliado com nota " + nota);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== Aluguel Executivo ===");
        System.out.println("Quilometragem ilimitada | Motorista particular: " + nomeMotorista
                + " | Nota: " + (nota == 0 ? "sem avaliação" : nota));
        exibirDadosBasicos();
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public int getNota() {
        return nota;
    }
}
