package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {

    private int maxPassageiros;
    private int nota;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria,
               double quilometragem, StatusVeiculo status, int maxPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.maxPassageiros = maxPassageiros;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota inválida. Use de 1 a 5.");
            return;
        }
        this.nota = nota;
        System.out.println("Van " + getModelo() + " avaliada com nota " + nota);
    }

    @Override
    public void realizarInspecao() {
        if (getQuilometragem() > 100000) {
            setStatus(StatusVeiculo.MANUTENCAO);
            System.out.println("Van " + getPlaca() + " reprovada: enviada para manutenção");
        } else {
            System.out.println("Van " + getPlaca() + " aprovada na inspeção");
        }
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return maxPassageiros > 12;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Van] " + getModelo() + " | Placa: " + getPlaca() + " | Ano: " + getAnoFabricacao()
                + " | Diária: R$ " + String.format("%.2f", getValorDiaria()) + " | Km: " + getQuilometragem()
                + " | Máx. passageiros: " + maxPassageiros + " | Status: " + getStatus()
                + " | Nota: " + (nota == 0 ? "sem avaliação" : nota));
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }

    public int getNota() {
        return nota;
    }
}
