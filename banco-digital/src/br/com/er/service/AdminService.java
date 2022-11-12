package br.com.er.service;

import br.com.er.db.BancoDeDados;
import br.com.er.modelo.Cliente;
import br.com.er.modelo.ClienteForm;

import java.util.List;

public class AdminService {

    private final BancoDeDados db;

    public AdminService(BancoDeDados db) {
        this.db = db;
    }

    // Retorna uma lista com todos os clientes cadastrados no banco
    public List<Cliente> listarClientes() {
        return db.buscarClientesComConta(db.buscarContas());
    }

    /*
    Recebe um cpf como parâmetro e verifica se este cpf está associado à algum cliente no banco.
    Por fim, retorna um cliente caso seja bem-sucedida a consulta.
     */
    public Cliente buscarCliente(String cpf) {
        for (Cliente c: db.buscarClientesComConta(db.buscarContas())) {
            if (c.buscarCpf().equalsIgnoreCase(cpf)) {
                return c;
            }
        }
        throw new RuntimeException("Não foi possível encontrar o cliente pelo cpf especificado.");
    }

    /*
    Recebe um cpf como parâmetro e chama a função 'buscarCliente' que poderá trazer algum cliente associado ao cpf informado
    Recebe também um objeto novoCliente que é do tipo ClienteForm, com os campos telefone e renda.
    O método permite com que o Administrador realiza a atualização dos valores dos campos telefone e renda do cliente.
    Por fim, retorna um cliente em caso de sucesso.
    */
    public Cliente atualizarCliente(String cpf, ClienteForm novoCliente) {
        Cliente cliente = buscarCliente(cpf);

        cliente.definirTelefone(novoCliente.buscarTelefone());
        cliente.definirRenda(novoCliente.buscarRenda());

        return cliente;
    }


}
