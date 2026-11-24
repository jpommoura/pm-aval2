package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

    private int quantidadePortas;
    private int nota;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria,
                 double quilometragem, StatusVeiculo status, int quantidadePortas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota inválida. Use de 1 a 5.");
            return;
        }
        this.nota = nota;
        System.out.println("Carro " + getModelo() + " avaliado com nota " + nota);
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Carro] " + getModelo() + " | Placa: " + getPlaca() + " | Ano: " + getAnoFabricacao()
                + " | Diária: R$ " + String.format("%.2f", getValorDiaria()) + " | Km: " + getQuilometragem()
                + " | Portas: " + quantidadePortas + " | Status: " + getStatus()
                + " | Nota: " + (nota == 0 ? "sem avaliação" : nota));
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public int getNota() {
        return nota;
    }
}
