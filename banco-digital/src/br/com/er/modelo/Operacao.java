package br.com.er.modelo;

import br.com.er.modelo.enums.TipoOperacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operacao {

    private String descricao;
    private LocalDateTime dataHora;
    private BigDecimal valor;
    private Boolean status;
    private TipoOperacao tipoOperacao;
    private Conta conta;
    private String numeroContaDestino;

    public Operacao(String descricao, Conta conta, BigDecimal valor, String numeroContaDestino) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.conta = conta;
        this.numeroContaDestino = numeroContaDestino;
    }

    public String buscarDescricao() {
        return descricao;
    }

    public LocalDateTime buscarDataHora() {
        return dataHora;
    }

    public Boolean buscarStatus() {
        return status;
    }

    public void definirStatus(Boolean status) {
        this.status = status;
    }

    public TipoOperacao buscarTipoOperacao() {
        return tipoOperacao;
    }

    public void definirConta(Conta conta) {
        this.conta = conta;
    }

    public Conta buscarConta() {
        return conta;
    }

    public BigDecimal buscarValor() {
        return valor;
    }

    public void definirValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void definirTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    @Override
    public String toString() {
        return "Operacao{" +
                "descricao='" + descricao + '\'' +
                ", dataHora=" + dataHora +
                ", valor=" + valor +
                ", status=" + (status.equals(true) ? "Sucesso" : "Falha")  +
                ", tipoOperacao=" + tipoOperacao +
                ", conta=" + conta.buscarNumero() +
                ", numeroContaDestino=" + numeroContaDestino +
                '}';
    }
}
