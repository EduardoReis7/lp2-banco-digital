package br.com.er.telas;

import br.com.er.db.BancoDeDados;
import br.com.er.modelo.Administrador;
import br.com.er.modelo.Cliente;
import br.com.er.modelo.ClienteForm;
import br.com.er.modelo.enums.TipoChave;
import br.com.er.service.AdminService;
import br.com.er.service.LoginService;

import java.math.BigDecimal;
import java.util.Scanner;

public class TelaPrincipal {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Cliente loginCliente() {
        BancoDeDados db = new BancoDeDados();
        LoginService loginService = new LoginService(db);

        System.out.println("-------- Login Cliente --------");
        System.out.print("Digite seu login: ");
        String login = SCANNER.next();
        System.out.print("Digite sua senha: ");
        String senha = SCANNER.next();
        return loginService.fazerLoginCliente(login, senha);
    }

    public static Administrador loginAdministrador() {
        BancoDeDados db = new BancoDeDados();
        LoginService loginService = new LoginService(db);

        System.out.println("-------- Login Administrador --------");
        System.out.print("Digite seu login: ");
        String login = SCANNER.next();
        System.out.print("Digite sua senha: ");
        String senha = SCANNER.next();
        return loginService.fazerLoginAdministrador(login, senha);
    }

    public static void home() {
        System.out.println();
        System.out.println("------ BANCO DIGITAL ------");
        System.out.println("Bem-vindo ao seu Banco Digital!");
        System.out.println("Opçõe de acesso:");
        System.out.println("[1] - Cliente");
        System.out.println("[2] - Administrador");
        System.out.println("[3] - Sair");
        int op = SCANNER.nextInt();

        switch (op) {
            case 1:
                Cliente cliente = loginCliente();
                menuCliente(cliente);
                home();
                break;
            case 2:
                Administrador adm = loginAdministrador();
                menuAdministrador(adm);
                home();
                break;
            case 3:
                System.out.println("Sua sessão foi encerrada.");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

    }

    public static void menuCliente(Cliente cliente) {

        boolean continuar = true;

        while(continuar) {
            System.out.println();
            System.out.println("Bem-vindo(a) " + cliente.buscarNome());
            System.out.println("Operações realizáveis: ");
            System.out.println("[1] - Consultar seu saldo");
            System.out.println("[2] - Realizar transferência");
            System.out.println("[3] - Pagar boleto");
            System.out.println("[4] - Gerar extrato");
            System.out.println("[5] - Cadastrar chave Pix");
            System.out.println("[6] - Sair");
            System.out.println("O que você deseja fazer?");
            int op = SCANNER.nextInt();

            switch (op) {
                case 1:
                    if (cliente.buscarContas().size() == 1) {
                        System.out.println("Saldo: " + cliente.buscarContas().get(0).consultarSaldo());
                    } else {
                        System.out.println("Suas Contas: " + cliente.buscarContas());
                        System.out.println("Deseja consultar o saldo de qual das suas contas? ");
                        int conta = SCANNER.nextInt();

                        System.out.println("Saldo: " + cliente.buscarContas().get(conta));
                    }
                    break;

                case 2:
                    if (cliente.buscarContas().size() == 1) {
                        System.out.println("Qual o valor da transferência? ");
                        BigDecimal valor = SCANNER.nextBigDecimal();
                        System.out.println("Qual o número da conta de destino? ");
                        String numeroConta = SCANNER.next();
                        System.out.println(cliente.buscarContas().get(0).realizarTransferencia(numeroConta, valor));
                    } else {
                        System.out.println("Suas Contas: " + cliente.buscarContas());
                        System.out.println("Deseja realizar a transferência a partir de qual conta? ");
                        int conta = SCANNER.nextInt();

                        System.out.println("Qual o valor da transferência? ");
                        BigDecimal valor = SCANNER.nextBigDecimal();
                        System.out.println("Qual o número da conta de destino? ");
                        String numeroConta = SCANNER.next();

                        System.out.println(cliente.buscarContas().get(conta).realizarTransferencia(numeroConta, valor));
                    }
                    break;

                case 3:
                    System.out.println("Insira a linha digitável: ");
                    String linha = SCANNER.next();
                    if (cliente.buscarContas().size() == 1) {
                        System.out.println(cliente.buscarContas().get(0).pagarBoleto(linha));
                    } else {
                        System.out.println("Suas Contas: " + cliente.buscarContas());
                        System.out.println("Deseja realizar o pagamento do boleto a partir de qual conta? ");
                        int conta = SCANNER.nextInt();

                        System.out.println(cliente.buscarContas().get(conta).pagarBoleto(linha));
                    }
                    break;

                case 4:
                    if (cliente.buscarContas().size() == 1) {
                        System.out.println(cliente.buscarContas().get(0).gerarExtrato());
                    } else {
                        System.out.println("Suas Contas: " + cliente.buscarContas());
                        System.out.println("Deseja realizar o pagamento do boleto a partir de qual conta? ");
                        int conta = SCANNER.nextInt();

                        System.out.println(cliente.buscarContas().get(conta).gerarExtrato());
                    }
                    break;

                case 5:
                    System.out.println("---- Cadastro de Chaves Pix ----");
                    System.out.println("[1] - CPF");
                    System.out.println("[2] - CELULAR");
                    System.out.println("[3] - EMAIL");
                    System.out.println("Qual o tipo de chave que você deseja cadastrar?");
                    int opTipoChave = SCANNER.nextInt();
                    System.out.println("Insira o valor da chave:");
                    String chave = SCANNER.next();

                    switch (opTipoChave) {
                        case 1:
                            cliente.cadastrarChave(chave, TipoChave.CPF);
                            break;
                        case 2:
                            cliente.cadastrarChave(chave, TipoChave.CELULAR);
                            break;
                        case 3:
                            cliente.cadastrarChave(chave, TipoChave.EMAIL);
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;
                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public static void menuAdministrador(Administrador adm) {

        BancoDeDados db = new BancoDeDados();
        AdminService adminService = new AdminService(db);

        boolean continuar = true;
        while(continuar) {
            System.out.println();
            System.out.println("Bem-vindo(a) " + adm.buscarNome());
            System.out.println("[1] - Listar todos clientes");
            System.out.println("[2] - Buscar um cliente");
            System.out.println("[3] - Atualizar um cliente");
            System.out.println("[4] - Sair");
            System.out.println("Qual das operações acima você deseja fazer? ");
            int op = SCANNER.nextInt();

            switch (op) {
                case 1:
                    System.out.println(adminService.listarClientes());
                    break;
                case 2:
                    System.out.println("Digite o cpf do cliente que você deseja buscar: ");
                    String cpf = SCANNER.next();
                    System.out.println(adminService.buscarCliente(cpf));
                    break;
                case 3:
                    System.out.println("Digite o cpf do cliente que você deseja atualizar: ");
                    String cpfCliente = SCANNER.next();
                    System.out.println("[1] - Alterar o telefone");
                    System.out.println("[2] - Alterar a renda");
                    System.out.println("[3] - Alterar todas as opções");
                    System.out.println("Quais informações você deseja alterar?");
                    int opAlt = SCANNER.nextInt();

                    switch (opAlt) {
                        case 1:
                            System.out.println("Digite o novo telefone do cliente: ");
                            String novoTelefone = SCANNER.next();
                            System.out.println(adminService.atualizarCliente(cpfCliente, new ClienteForm(null, novoTelefone)));
                            break;

                        case 2:
                            System.out.println("Digite a nova renda do cliente: ");
                            BigDecimal novaRenda = SCANNER.nextBigDecimal();
                            System.out.println(adminService.atualizarCliente(cpfCliente, new ClienteForm(novaRenda, null)));
                            break;

                        case 3:
                            System.out.println("Digite a nova renda do cliente: ");
                            BigDecimal nRenda = SCANNER.nextBigDecimal();
                            System.out.println("Digite o novo telefone do cliente: ");
                            String nTelefone = SCANNER.next();

                            System.out.println(adminService.atualizarCliente(cpfCliente, new ClienteForm(nRenda, nTelefone)));
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;

                case 4:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        home();
    }
}
