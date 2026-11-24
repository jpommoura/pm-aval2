public class AluguelExecutivo {
    public int KmPorDia;
    public boolean Motoista;
    public boolean Avaliavel;
    public veiculo veiculo;

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
