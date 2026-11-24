public class Carro {
    public int nPortas;
    public boolean Inspecao; {

    }

    public Carro (int nPortas, boolean Inspecao) {

    }

    public abstract class Veiculo {
    
    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double valorDiaria;
    private double quilometragem;
    private StatusVeiculo status;

    public Veiculo(String placa, String modelo, int anoFabricacao, double valorDiaria,double quilometragem, StatusVeiculo status) {

        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorDiaria = valorDiaria;
        this.quilometragem = quilometragem;
        this.status = status;
    }
}}
