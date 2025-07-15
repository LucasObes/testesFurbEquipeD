package br.furb;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoTesteBanco {
    Banco banco;
    ArrayList<ContaBancaria> contas;

    @BeforeEach
    public void setUp() {
        contas = new ArrayList<ContaBancaria>();
        criarContas();
        banco = Mockito.spy(new Banco(contas));
    }

    private void criarContas() {
        var conta = new ContaBancaria("João da Silva", "123.456.789-00");
        conta.depositar(500);
        contas.add(conta);
        
        var conta2 = new ContaBancaria("João da Silva", "123.456.789-00");
        conta2.depositar(700);
        contas.add(conta2);
    }

    @Test
    public void Test_SaldoTotal() {
        // Stub
        when(banco.getContas()).thenReturn(contas);
    
        // Act
        float balanco = banco.calcularBalanco();
    
        // Assert
        assertEquals(1200f, balanco, 0.001);
        verify(banco, times(1)).calcularBalanco();
    }
}
