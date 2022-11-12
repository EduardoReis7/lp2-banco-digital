package br.com.er.service;

import br.com.er.db.BancoDeDados;
import br.com.er.modelo.Administrador;
import br.com.er.modelo.Cliente;

public class LoginService {

    private final BancoDeDados db;

    public LoginService(BancoDeDados db) {
        this.db = db;
    }

    /*
    Recebe como parâmetro o login e senha de um cliente.
    Caso os valores informados sejam iguais aos de algum cliente no banco de dados, o acesso é permitido.
    Por fim, é retornado um objeto contendo as informações do cliente que está acessando o sistema.
     */
    public Cliente fazerLoginCliente(String login, String senha) {

        for (Cliente c: db.buscarClientesComConta(db.buscarContas())) {
            if (login.equalsIgnoreCase(c.buscarLogin()) && senha.equalsIgnoreCase(c.buscarSenha())) {
                System.out.println("Login bem-sucedido!");
                return c;
            } else {
                throw new RuntimeException("Usuário ou senha incorretos.");
            }
        }

        throw new RuntimeException("Não foi possível realizar o login.");
    }

    /*
    Recebe como parâmetro o login e senha de um administrador
    Caso os valores informados sejam iguais aos de algum administrador no banco de dados, o acesso é permitido.
    Por fim, é retornado um objeto contendo as informações do administrador que está acessando o sistema.
     */
    public Administrador fazerLoginAdministrador(String login, String senha) {
        for (Administrador adm: db.buscarAdministradores()) {
            if (login.equalsIgnoreCase(adm.buscarLogin()) && senha.equalsIgnoreCase(adm.buscarSenha())) {
                return adm;
            } else {
                throw new RuntimeException("Usuário ou senha incorretos.");
            }
        }

        throw new RuntimeException("Não foi possível realizar o login.");
    }
}
