package br.com.er.modelo;

import br.com.er.modelo.enums.TipoChave;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private BigDecimal renda;
    private Endereco endereco;
    private List<Conta> contas;
    private List<Pix> chavesPix = new ArrayList<>();

    public Cliente(String login, String senha, String nome, String cpf, String email,
                   String telefone, BigDecimal renda, Endereco endereco) {
        super(login, senha);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.renda = renda;
        this.contas = new ArrayList<>();
        this.endereco = endereco;
    }

    public String buscarNome() {
        return this.nome;
    }

    public String buscarCpf() {
        return this.cpf;
    }

    public void definirTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void definirRenda(BigDecimal valor) {
        this.renda = valor;
    }

    public void definirConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<Conta> buscarContas() {
        return this.contas;
    }

    // Recebe uma lista de contas e extrai somente o número de cada conta
    public String extrairNumeroConta(List<Conta> contas) {
        for (Conta c: contas) {
            return c.buscarNumero();
        }
        return null;
    }

    /*
    Cadastra chaves pix para o cliente atual
    São permitidos os tipos de chave CPF, CELULAR e EMAIL
    Caso os valores de chave não forem iguais aos do cadastro do cliente uma exceção será jogada.
    Por fim é retornada a classe Pix.
     */
    public Pix cadastrarChave(String chave, TipoChave tipo) {
        if (tipo.equals(TipoChave.CPF) && !chave.equalsIgnoreCase(this.cpf)) {
            throw new RuntimeException("Não foi possível criar a chave pix, pois o cpf informado não é o mesmo do cliente atual.");
        }
        if (tipo.equals(TipoChave.CELULAR) && !chave.equalsIgnoreCase(this.telefone)) {
            throw new RuntimeException("Não foi possível criar a chave pix, pois o celular informado não é o mesmo do cliente atual.");
        }
        if (tipo.equals(TipoChave.EMAIL) && !chave.equalsIgnoreCase(this.email)) {
            throw new RuntimeException("Não foi possível criar a chave pix, pois o email informado não é o mesmo do cliente atual.");
        }

        System.out.println("Chave pix cadastrada com sucesso!");
        Pix pix = new Pix(chave, tipo);
        this.chavesPix.add(pix);

        return pix;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", renda=" + renda +
                ", endereco=" + endereco +
                ", contas=" + extrairNumeroConta(this.contas) +
                ", chavesPix=" + chavesPix +
                '}';
    }
}
