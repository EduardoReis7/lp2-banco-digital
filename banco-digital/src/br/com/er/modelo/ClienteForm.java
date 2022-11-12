package br.com.er.modelo;

import java.math.BigDecimal;

public class ClienteForm {

    private BigDecimal renda;
    private String telefone;

    public ClienteForm(BigDecimal renda, String telefone) {
        this.renda = renda;
        this.telefone = telefone;
    }

    public BigDecimal buscarRenda() {
        return renda;
    }

    public String buscarTelefone() {
        return telefone;
    }
}
