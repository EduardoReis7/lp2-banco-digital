package br.com.er.modelo;

import br.com.er.modelo.enums.TipoConta;
import br.com.er.modelo.enums.TipoOperacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Agencia agencia;
    private String numeroConta;
    private BigDecimal saldo;
    private TipoConta tipoConta;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Operacao> operacoes = new ArrayList<>();

    public Conta(Agencia agencia, String numeroConta, BigDecimal saldo, TipoConta tipoConta, Cliente cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.clientes.add(cliente);
    }

    // Retorna o saldo atual da conta
    public BigDecimal consultarSaldo() {
        return this.saldo;
    }

    // Retorna o numero da conta atual
    public String buscarNumero() {
        return this.numeroConta;
    }

    // Retorna o tipo da conta atual
    public TipoConta buscarTipoConta() {
        return this.tipoConta;
    }

    /*
    O método recebe como parâmetros o número da conta de destino e o valor a ser transferido.
    O valor será comparado com o saldo atual da conta para verificar se será possível efetivar a transferência.
    Por fim uma Operação é retornada.
     */
    public Operacao realizarTransferencia(String numeroContaDestino, BigDecimal valor) {
        BigDecimal saldo = this.consultarSaldo();
        Operacao opTransferencia = new Operacao("Operação de Transferência bancária", this, valor, numeroContaDestino);
        if (this.buscarTipoConta().equals(TipoConta.CORRENTE) || this.buscarTipoConta().equals(TipoConta.POUPANCA)) {
            if (saldo.compareTo(valor) >= 0) {
                this.saldo = this.saldo.subtract(valor);
                opTransferencia.definirConta(this);
                opTransferencia.definirStatus(Boolean.TRUE);
                opTransferencia.definirTipoOperacao(TipoOperacao.TRANSFERENCIA);
                this.operacoes.add(opTransferencia);

                return opTransferencia;
            } else {
                opTransferencia.definirStatus(Boolean.FALSE);
                throw new RuntimeException("O valor contido na conta é insuficiente para realizar a transferência.");
            }
        } else {
            throw new RuntimeException("Contas do Tipo Salário não podem realizar transferências.");
        }
    }

    /*
    Para realizar o pagamento de boleto, o cliente precisa informar a linha digitável do boleto.
    A linha digitável deverá seguir o seguinte padrão:
    [agenciaDestino].[contaDestino].[valor].[dataVencimento]
    O sistema irá considerar os 2 últimos dígitos do valor como decimais de um valor monetário
    À partir da linha digitável será feito um split, separando cada parte em um Array de String.
    Com isso, cada posição deste array irá alimentar a classe Boleto.
    Por fim, é retornado um Boleto com as informações.
     */
    public Operacao pagarBoleto(String linhaDigitavel) {

        String[] linha = linhaDigitavel.split("\\.");
        Operacao boleto = new Boleto("Pagamento de boleto", this, linha[1], linhaDigitavel);
        if (this.buscarTipoConta().equals(TipoConta.CORRENTE) || this.buscarTipoConta().equals(TipoConta.POUPANCA)) {
            if (this.saldo.compareTo(boleto.buscarValor()) >= 0) {
                this.saldo = this.saldo.subtract(boleto.buscarValor());
                boleto.definirStatus(Boolean.TRUE);
                this.operacoes.add(boleto);
                System.out.println("Boleto pago com sucesso. Detalhes da Operação: ");
                return boleto;
            } else {
                boleto.definirStatus(Boolean.FALSE);
                throw new RuntimeException("O saldo é insuficiente para pagar o boleto.");
            }
        } else {
            throw new RuntimeException("Contas do tipo Salário não podem realizar pagamento de boletos.");
        }
    }

    // Retorna uma lista com as últimas operações realizadas na conta.
    public List<Operacao> gerarExtrato() {
        return this.operacoes;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", tipoConta=" + tipoConta +
                ", clientes=" + clientes +
                '}';
    }
}
