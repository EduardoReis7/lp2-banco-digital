package br.com.er.modelo;

public class Agencia {

    private String numeroAgencia;
    private Endereco endereco;

    public Agencia(String numeroAgencia, Endereco endereco) {
        this.numeroAgencia = numeroAgencia;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "numeroAgencia='" + numeroAgencia + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
