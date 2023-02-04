package com.starblackdian.conversoralura.model;
import java.math.BigDecimal;

import com.starblackdian.conversoralura.enums.DivisaEnum;

public class ConversorEuro implements ConversorDivisas {

	@Override
	public BigDecimal convertir(BigDecimal cantidad, DivisaEnum divisaOrigen) {
		switch(divisaOrigen) {
		
		case MXN:
			return cantidad.multiply(BigDecimal.valueOf(0.049));
		
		case DOLAR:
			return cantidad.multiply(BigDecimal.valueOf(0.92));	
			
		case LIBRA_ESTERLINA:
			return cantidad.multiply(BigDecimal.valueOf(1.11));
			
		case YEN:
			return cantidad.multiply(BigDecimal.valueOf(0.0070));
			
		case WON:
			return cantidad.multiply(BigDecimal.valueOf(0.00074));
			
		default:
			return cantidad;
		}
	}
}
