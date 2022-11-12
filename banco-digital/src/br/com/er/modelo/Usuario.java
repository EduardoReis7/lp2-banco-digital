package br.com.er.modelo;

public class Usuario {

    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String buscarLogin() {
        return login;
    }

    public String buscarSenha() {
        return senha;
    }

}
