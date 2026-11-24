package pm_prova2_m;

public class Moto extends Veiculo implements Inspecionavel {

    private int cilindrada;

    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria,
                double quilometragem, StatusVeiculo status, int cilindrada) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.cilindrada = cilindrada;
    }

    @Override
    public void realizarInspecao() {
        if (getQuilometragem() > 50000) {
            setStatus(StatusVeiculo.MANUTENCAO);
            System.out.println("Moto " + getPlaca() + " reprovada: enviada para manutenção");
        } else {
            System.out.println("Moto " + getPlaca() + " aprovada na inspeção");
        }
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return cilindrada > 500;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Moto] " + getModelo() + " | Placa: " + getPlaca() + " | Ano: " + getAnoFabricacao()
                + " | Diária: R$ " + String.format("%.2f", getValorDiaria()) + " | Km: " + getQuilometragem()
                + " | Cilindrada: " + cilindrada + " | Status: " + getStatus());
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
