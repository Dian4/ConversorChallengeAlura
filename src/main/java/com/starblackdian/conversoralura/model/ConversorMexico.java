package com.starblackdian.conversoralura.model;
import java.math.BigDecimal;
import com.starblackdian.conversoralura.enums.DivisaEnum;

public class ConversorMexico implements ConversorDivisas {

	@Override
	public BigDecimal convertir(BigDecimal cantidad, DivisaEnum divisaOrigen) {
		switch(divisaOrigen) {
		
		case WON:
			return cantidad.multiply(BigDecimal.valueOf(0.015));
		
		case DOLAR:
			return cantidad.multiply(BigDecimal.valueOf(18.97));	
			
		case LIBRA_ESTERLINA:
			return cantidad.multiply(BigDecimal.valueOf(22.85));
			
		case EURO:
			return cantidad.multiply(BigDecimal.valueOf(20.48));
			
		case YEN:
			return cantidad.multiply(BigDecimal.valueOf(0.14));
			
		default:
			return cantidad;
		}
	}
}
