package br.furb;

import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas;

    public Banco(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }

    public ArrayList<ContaBancaria> getContas() {
        return this.contas;
    }

    public float calcularBalanco() {
        if (this.contas == null) {
            throw new IllegalArgumentException("Não tem contas");
        }

        float balanco = 0;

        for (var conta : contas) {
            balanco += conta.getSaldo();
        }

        return balanco;
    }
}
