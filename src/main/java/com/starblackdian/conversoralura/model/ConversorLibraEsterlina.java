package com.starblackdian.conversoralura.model;

import java.math.BigDecimal;

import com.starblackdian.conversoralura.enums.DivisaEnum;

	public class ConversorLibraEsterlina implements ConversorDivisas {

		@Override
		public BigDecimal convertir(BigDecimal cantidad, DivisaEnum divisaOrigen) {
			switch(divisaOrigen) {
			
			case MXN:
				return cantidad.multiply(BigDecimal.valueOf(0.044));
			
			case DOLAR:
				return cantidad.multiply(BigDecimal.valueOf(0.83));	
				
			case EURO:
				return cantidad.multiply(BigDecimal.valueOf(0.90));
				
			case YEN:
				return cantidad.multiply(BigDecimal.valueOf(0.0063));
				
			case WON:
				return cantidad.multiply(BigDecimal.valueOf(0.00067));
				
			default:
				return cantidad;
			}
		}
}
