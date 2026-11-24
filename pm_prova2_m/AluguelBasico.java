import pm_prova2_m.Aluguel;

public class AluguelBasico {
    public int KmPorDia;
    public boolean Seguro;

    public Aluguel (int KmPorDia, boolean Seguro) {
        this.KmPorDia = KmPorDia;
        this.Seguro = Seguro;
    }

    public void ExibirDetalhes() {
        if (this.Seguro == true) {
            String possuiSeguro = "Possui o seguro";
        }
        else {
            String possuiSeguro = "Não possui o seguro";
        }
        String texto = "Esse aluguel possui " + KmPorDia + "km por dia e " + possuiSeguro();
    }

    public boolean possuiSeguro() {
        return this.Seguro;
    }
}
