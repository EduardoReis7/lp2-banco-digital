package br.com.er.modelo;

import br.com.er.modelo.enums.Uf;

public class Endereco {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String cep;
    private String pais;
    private Uf uf;

    public Endereco(String logradouro, String bairro, String cidade, String cep, String pais, Uf uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.pais = pais;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", pais='" + pais + '\'' +
                ", uf=" + uf +
                '}';
    }
}
