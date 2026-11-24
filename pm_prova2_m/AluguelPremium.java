public class AluguelPremium {
    public int KmPorDia;
    public boolean Seguro;

    public Aluguel (int KmPorDia, boolean Seguro) {
        this.KmPorDia = KmPorDia;
        this.Seguro = Seguro;
    }

    public void ExibirDetalhes() {
        if (this.Seguro == true) {
            String possuiSeguroExecutivo = "Possui o seguro executivo";
        }
        else {
            String possuiSeguroExecutivo = "Não possui o seguro executivo";
        }
        String texto = "Esse aluguel possui " + KmPorDia + "km por dia e " + possuiSeguro();
    }

    public boolean possuiSeguro() {
        return this.Seguro;
    }
}
