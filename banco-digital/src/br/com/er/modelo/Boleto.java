package br.com.er.modelo;

import br.com.er.modelo.enums.TipoOperacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Boleto extends Operacao {

    private String linhaDigitavel;
    private String agenciaBeneficiario;
    private String contaBeneficiario;
    private LocalDate dataVencimento;

    public Boleto(String descricao, Conta conta, String numeroContaDestino, String linhaDigitavel) {
        super(descricao, conta, BigDecimal.ZERO, numeroContaDestino);
        this.linhaDigitavel = linhaDigitavel;
        String[] linha = linhaDigitavel.split("\\.");
        this.agenciaBeneficiario = linha[0];
        this.contaBeneficiario = linha[1];
        this.dataVencimento = LocalDate.parse(linha[3], DateTimeFormatter.ofPattern("ddMMyyyy"));
        this.definirConta(conta);
        this.definirValor(new BigDecimal(linha[2]).movePointLeft(2));
        this.definirTipoOperacao(TipoOperacao.PAGAMENTO);
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "descricao='" + this.buscarDescricao() + '\'' +
                ", dataHora='" + this.buscarDataHora().format(DateTimeFormatter.ofPattern("ddMMyyyy HH:mm:ss")) + '\'' +
                ", status='" + (this.buscarStatus().equals(true) ? "Sucesso" : "Falha")  + '\'' +
                ", tipoOperacao='" + this.buscarTipoOperacao() + '\'' +
                ", contaOrigem='" + this.buscarConta().buscarNumero() + '\'' +
                ", linhaDigitavel='" + linhaDigitavel + '\'' +
                ", agenciaBeneficiario='" + agenciaBeneficiario + '\'' +
                ", contaBeneficiario='" + contaBeneficiario + '\'' +
                ", dataVencimento=" + dataVencimento + '\'' +
                ", valor=" + this.buscarValor() + '\'' +
                '}';
    }
}
