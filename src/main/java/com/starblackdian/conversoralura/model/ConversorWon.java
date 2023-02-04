package com.starblackdian.conversoralura.model;
import java.math.BigDecimal;
import com.starblackdian.conversoralura.enums.DivisaEnum;

public class ConversorWon implements ConversorDivisas {
	
	@Override
	public BigDecimal convertir(BigDecimal cantidad, DivisaEnum divisaOrigen) {
		switch(divisaOrigen) {
		
		case MXN:
			return cantidad.multiply(BigDecimal.valueOf(65.79));
		
		case DOLAR:
			return cantidad.multiply(BigDecimal.valueOf(1247.85));	
			
		case LIBRA_ESTERLINA:
			return cantidad.multiply(BigDecimal.valueOf(1503.41));
			
		case EURO:
			return cantidad.multiply(BigDecimal.valueOf(1351.23));
			
		case YEN:
			return cantidad.multiply(BigDecimal.valueOf(9.51));
			
		default:
			return cantidad;
		}
	}

}
