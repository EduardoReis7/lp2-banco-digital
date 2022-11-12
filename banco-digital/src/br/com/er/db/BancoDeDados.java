package br.com.er.db;

import br.com.er.modelo.*;
import br.com.er.modelo.enums.TipoConta;
import br.com.er.modelo.enums.Uf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BancoDeDados {

    private List<Endereco> enderecos = new ArrayList<>();
    private List<Agencia> agencias = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Administrador> administradores = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public BancoDeDados() {
        this.definirEnderecos();
        this.definirAgencias();
        this.definirClientes();
        this.definirContas();
        this.definirAdministradores();
    }

    public void definirEnderecos() {

        Endereco e1 = new Endereco("Rua Engenheiro Roberto Símonsen, 5231", "Petrópolis", "Porto Alegre", "90670070", "Brasil", Uf.RS);
        Endereco e2 = new Endereco("Avenida Eduardo Prado 2165, 125239", "Vila Nova", "Porto Alegre", "91751970", "Brasil", Uf.RS);
        Endereco e3 = new Endereco("Rua João Marchi, 102592", "Vila Iolanda(Lajeado)", "São Paulo", "08451070", "Brasil", Uf.SP);
        Endereco e4 = new Endereco("Rua Soldado Isidro Matoso, 25123", "Parque Novo Mundo", "São Paulo", "02147050", "Brasil", Uf.SP);
        Endereco e5 = new Endereco("Rua Arthur Bernardes Filho, 79567", "Xodó Marize", "Belo Horizonte", "31744415", "Brasil", Uf.MG);
        Endereco e6 = new Endereco("Rua Pastora Jacinta, 24", "Maria Helena", "Belo Horizonte", "31680280", "Brasil", Uf.MG);
        Endereco e7 = new Endereco("Rua C, 12", "Campo Grande", "Rio de Janeiro", "23090454", "Brasil", Uf.RJ);
        Endereco e8 = new Endereco("Escada Lucélia, 6785", "Joá", "Rio de Janeiro", "22611010", "Brasil", Uf.RJ);
        Endereco e9 = new Endereco("3ª Avenida Paulo Afonso de Pernambués, 521", "Pernambués", "Salvador", "41100242", "Brasil", Uf.BA);
        Endereco e10 = new Endereco("Travessa Paulista, 86", "Curuzu", "Salvador", "40365702", "Brasil", Uf.BA);

        this.enderecos.addAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));
    }

    public List<Endereco> buscarEnderecos() {
        return this.enderecos;
    }

    public void definirAgencias() {

        Agencia a1 = new Agencia("0241", buscarEnderecos().get(0));
        Agencia a2 = new Agencia("1523", buscarEnderecos().get(1));
        Agencia a3 = new Agencia("6442", buscarEnderecos().get(2));
        Agencia a4 = new Agencia("1886", buscarEnderecos().get(3));
        Agencia a5 = new Agencia("2574", buscarEnderecos().get(4));
        Agencia a6 = new Agencia("9654", buscarEnderecos().get(5));
        Agencia a7 = new Agencia("0723", buscarEnderecos().get(6));
        Agencia a8 = new Agencia("2561", buscarEnderecos().get(7));
        Agencia a9 = new Agencia("2468", buscarEnderecos().get(8));
        Agencia a10 = new Agencia("3245",buscarEnderecos().get(9));

        this.agencias = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }

    public List<Agencia> buscarAgencias() {
        return this.agencias;
    }

    public void definirClientes() {

        Cliente c1 = new Cliente("c1", "c1", "Jorge", "58457897020", "jorge@teste.com", "51925238123", new BigDecimal(1200), buscarEnderecos().get(0));
        Cliente c2 = new Cliente("c2", "c2", "Suelen", "19547938045", "suelen@teste.com", "54951423501", new BigDecimal(1200), buscarEnderecos().get(1));
        Cliente c3 = new Cliente("c3", "c3", "Marisa", "97356604078", "marisa@teste.com", "53925468951", new BigDecimal(1200), buscarEnderecos().get(2));
        Cliente c4 = new Cliente("c4", "c4", "Amiltom", "83271946078", "amiltom@teste.com", "55963528495", new BigDecimal(1200), buscarEnderecos().get(3));
        Cliente c5 = new Cliente("c5", "c5", "Sara", "46086584095", "sara@teste.com", "51988547120", new BigDecimal(1200), buscarEnderecos().get(4));
        Cliente c6 = new Cliente("c6", "c6", "Marcos", "31275092004", "marcos@teste.com", "21995217852", new BigDecimal(1200), buscarEnderecos().get(5));
        Cliente c7 = new Cliente("c7", "c7", "Pedro", "55891537001", "pedro@teste.com", "22954875210", new BigDecimal(1200), buscarEnderecos().get(6));
        Cliente c8 = new Cliente("c8", "c8", "João", "73590903007", "joao@teste.com", "71936524102", new BigDecimal(1200), buscarEnderecos().get(7));
        Cliente c9 = new Cliente("c9", "c9", "Maria", "91307593070", "maria@teste.com", "63958741023", new BigDecimal(1200), buscarEnderecos().get(8));
        Cliente c10 = new Cliente("c10", "c10", "Valter", "37470902066", "valter@teste.com", "64985623657", new BigDecimal(1200), buscarEnderecos().get(9));

        this.clientes.addAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
    }

    public List<Cliente> buscarClientes() {
        return this.clientes;
    }

    public void definirContas() {

        Conta c1 = new Conta(buscarAgencias().get(0), "5231523", new BigDecimal(50), TipoConta.CORRENTE, buscarClientes().get(0));
        Conta c2 = new Conta(buscarAgencias().get(1), "1452351", new BigDecimal(50), TipoConta.CORRENTE, buscarClientes().get(1));
        Conta c22 = new Conta(buscarAgencias().get(1), "1452351", new BigDecimal(50), TipoConta.CORRENTE,buscarClientes().get(1));
        Conta c3 = new Conta(buscarAgencias().get(2), "7345216", new BigDecimal(50), TipoConta.POUPANCA, buscarClientes().get(2));
        Conta c4 = new Conta(buscarAgencias().get(3), "7454563", new BigDecimal(50), TipoConta.POUPANCA, buscarClientes().get(3));
        Conta c5 = new Conta(buscarAgencias().get(4), "0678564", new BigDecimal(50), TipoConta.CORRENTE, buscarClientes().get(4));
        Conta c6 = new Conta(buscarAgencias().get(5), "8674212", new BigDecimal(50), TipoConta.CORRENTE, buscarClientes().get(5));
        Conta c7 = new Conta(buscarAgencias().get(6), "9654345", new BigDecimal(50), TipoConta.SALARIO, buscarClientes().get(6));
        Conta c8 = new Conta(buscarAgencias().get(7), "1445235", new BigDecimal(50), TipoConta.SALARIO, buscarClientes().get(7));
        Conta c9 = new Conta(buscarAgencias().get(8), "6534514", new BigDecimal(50), TipoConta.SALARIO, buscarClientes().get(8));
        Conta c10 = new Conta(buscarAgencias().get(9), "3352315", new BigDecimal(50), TipoConta.CORRENTE,buscarClientes().get(9));

        this.contas.addAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
    }

    public List<Conta> buscarContas() {
        return this.contas;
    }

    public List<Cliente> buscarClientesComConta(List<Conta> contas) {
        List<Cliente> clientes = this.buscarClientes();
        clientes.get(0).definirConta(contas.get(0));
        clientes.get(1).definirConta(contas.get(1));
        clientes.get(2).definirConta(contas.get(2));
        clientes.get(3).definirConta(contas.get(3));
        clientes.get(4).definirConta(contas.get(4));
        clientes.get(5).definirConta(contas.get(5));
        clientes.get(6).definirConta(contas.get(6));
        clientes.get(7).definirConta(contas.get(7));
        clientes.get(8).definirConta(contas.get(8));
        clientes.get(9).definirConta(contas.get(9));

        return clientes;
    }

    public void definirAdministradores() {
        Administrador adm1 = new Administrador("adm1", "adm1", "Wesley", "522315");
        Administrador adm2 = new Administrador("adm2", "adm2", "Priscila", "523162");

        this.administradores.addAll(Arrays.asList(adm1, adm2));
    }

    public List<Administrador> buscarAdministradores() {
        return this.administradores;
    }

}
