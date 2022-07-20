package br.com.alura.tdd;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario func;

    @BeforeEach
    public void incializar(){
        this.service = new ReajusteService();
        this.func = new Funcionario("Igor", LocalDate.now(), new BigDecimal("1000.00"));
    }

    /* @AfterEach
    public void finalizar(){
        System.out.println("Fim");
    } */

    @Test
    public void badPerformanceThreePercentReadjustment(){

        service.ReajustaSalario(func, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), func.getSalario());
    }

    @Test
    public void goodPerformanceFifteenPercentReadjustment(){

        service.ReajustaSalario(func, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), func.getSalario());
    }

    @Test
    public void greatPerformanceTwentyPercentReadjustment(){

        service.ReajustaSalario(func, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), func.getSalario());
    }

}
