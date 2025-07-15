package br.furb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bank system tests")
public class BankTests {
    ContaBancaria conta;
    ContaBancaria contaDestino;

    @BeforeEach
    public void setUp() {
        conta = new ContaBancaria("João da Silva", "123.456.789-00");
        contaDestino = new ContaBancaria("Maria Oliveira", "987.654.321-00");
    }

    @Test
    public void criacaoContaBancariaTest() {
        assertEquals("João da Silva", conta.getNomeTitular());
        assertEquals("123.456.789-00", conta.getDocumento());
        assertEquals(0f, conta.getSaldo());
    }

    @Test
    public void depositoTest() {
        conta.depositar(100f);
        conta.depositar(50f);
        assertEquals(150f, conta.getSaldo());
    }

    @Test
    public void saqueTest() {
        conta.depositar(1000f);
        conta.sacar(100f);
        assertEquals(900f, conta.getSaldo());
    }

    @Test
    public void transferirTest() {
        conta.depositar(1000f);
        contaDestino.depositar(1000f);
        conta.transferir(100f, contaDestino);
        assertEquals(900f, conta.getSaldo());
        assertEquals(1100f, contaDestino.getSaldo());
    }

    @Test
    public void consultaTest() {
        conta.depositar(420f);
        assertEquals(420f, conta.getSaldo());
    }
}
