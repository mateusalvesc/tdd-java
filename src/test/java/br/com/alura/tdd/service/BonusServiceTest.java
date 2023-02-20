package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	private BonusService service;


	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		service = new BonusService();
		
		//assertThrows(IllegalArgumentException.class, 
			//	() -> service.calcularBonus(new Funcionario("Livia", LocalDate.now(), new BigDecimal("12000"))));
		
		try {
			service.calcularBonus(new Funcionario("Livia", LocalDate.now(), new BigDecimal("12000")));
			fail("Não lançou a exception esperada!");
		} catch (Exception e) {
			assertEquals("Funcionário com salário maior do que R$10.000 não pode receber bônus!", e.getMessage());
		}
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Mateus", LocalDate.now(), new BigDecimal("2500")));
	
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Thamires", LocalDate.now(), new BigDecimal("10000")));
	
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
