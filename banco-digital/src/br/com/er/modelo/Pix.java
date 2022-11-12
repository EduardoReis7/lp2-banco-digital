package br.com.er.modelo;

import br.com.er.modelo.enums.TipoChave;

public class Pix {

    private String chave;
    private TipoChave tipoChave;

    public Pix(String chave, TipoChave tipoChave) {
        this.chave = chave;
        this.tipoChave = tipoChave;
    }

    @Override
    public String toString() {
        return "Pix{" +
                "chave='" + chave + '\'' +
                ", tipoChave=" + tipoChave +
                '}';
    }
}
