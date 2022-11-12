package br.com.er.modelo;

public class Administrador extends Usuario {

    private String nome;
    private String codigoId;

    public Administrador(String login, String senha, String nome, String codigoId) {
        super(login, senha);
        this.nome = nome;
        this.codigoId = codigoId;
    }

    public String buscarNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", codigoId='" + codigoId + '\'' +
                '}';
    }
}
