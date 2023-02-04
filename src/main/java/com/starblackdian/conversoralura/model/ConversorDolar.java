package com.starblackdian.conversoralura.model;

import java.math.BigDecimal;

import com.starblackdian.conversoralura.enums.DivisaEnum;

public class ConversorDolar implements ConversorDivisas {

	@Override
	public BigDecimal convertir(BigDecimal cantidad, DivisaEnum divisaOrigen) {
		switch (divisaOrigen) {
			case MXN:
				return cantidad.multiply(BigDecimal.valueOf(0.053));
			
			case EURO:
				return cantidad.multiply(BigDecimal.valueOf(1.09));
				
			case LIBRA_ESTERLINA:
				return cantidad.multiply(BigDecimal.valueOf(1.22));
				
			case YEN:
				return cantidad.multiply(BigDecimal.valueOf(128.63));
				
			case WON:
				return cantidad.multiply(BigDecimal.valueOf(1225.61));
				
			default:
				return cantidad;
		}
	}
}
