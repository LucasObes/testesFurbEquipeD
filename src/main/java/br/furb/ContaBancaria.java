package br.furb;

public class ContaBancaria {
    private String nomeTitular;
    private String documento;
    private float saldo;

    public ContaBancaria() {

    }

    public ContaBancaria(
        String nomeTitular,
        String documento
    ) {
        this.setDocumento(documento);
        this.setNomeTitular(nomeTitular);
    }

    public String getNomeTitular() {
        return this.nomeTitular;
    }

    public void setNomeTitular(String nome) {
        this.nomeTitular = nome;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void depositar(float valorDeposito) {
        this.setSaldo(valorDeposito + this.getSaldo());
    }

    public void sacar(float valorSaque) {
        this.setSaldo(this.getSaldo() - valorSaque);
    }

    public void transferir(
        float valorTransferencia, 
        ContaBancaria contaDestino
    ) {
        contaDestino.depositar(valorTransferencia);
        this.sacar(valorTransferencia);
    }

    private void setSaldo(float valor) {
        this.saldo = valor;
    }
}
