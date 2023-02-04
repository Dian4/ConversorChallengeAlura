package com.starblackdian.conversoralura.model;
import java.math.BigDecimal;

import com.starblackdian.conversoralura.enums.DivisaEnum;

public class ConversorYen implements ConversorDivisas {
	
	@Override
	public BigDecimal convertir(BigDecimal cantidad, DivisaEnum divisaOrigen) {
		switch(divisaOrigen) {
		
		case MXN:
			return cantidad.multiply(BigDecimal.valueOf(6.92));
		
		case DOLAR:
			return cantidad.multiply(BigDecimal.valueOf(131.20));	
			
		case LIBRA_ESTERLINA:
			return cantidad.multiply(BigDecimal.valueOf(158.08));
			
		case EURO:
			return cantidad.multiply(BigDecimal.valueOf(142.06));
			
		case WON:
			return cantidad.multiply(BigDecimal.valueOf(0.11));
			
		default:
			return cantidad;
		}
	}

}
