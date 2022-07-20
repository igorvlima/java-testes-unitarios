package br.com.alura.tdd;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void mustBeZeroForHighSalaries(){
        BonusService service = new BonusService();
        Funcionario func = new Funcionario("Igor", LocalDate.now(), new BigDecimal("25000"));

       assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(func));

         /* try{
            service.calcularBonus(func);
            fail("Não houve a exceção");
        } catch (Exception e){
            assertEquals("Funcinário com salário Maior que R$10000,00 não pode receber bônus", e.getMessage());
        } */

    }

    @Test
    void mustBeTenPercentForLowSalaries(){
        BonusService service = new BonusService();
        Funcionario func = new Funcionario("Igor", LocalDate.now(), new BigDecimal("2500"));
        BigDecimal bonus =  service.calcularBonus(func);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void mustBeTenPercentForSalariesEqualToOneThousand(){
        BonusService service = new BonusService();
        Funcionario func = new Funcionario("Igor", LocalDate.now(), new BigDecimal("10000"));
        BigDecimal bonus =  service.calcularBonus(func);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}