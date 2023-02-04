package com.starblackdian.conversoralura.controller;

import java.math.BigDecimal;

import com.starblackdian.conversoralura.enums.DivisaEnum;
import com.starblackdian.conversoralura.model.ConversorDivisas;
import com.starblackdian.conversoralura.model.ConversorDolar;
import com.starblackdian.conversoralura.model.ConversorEuro;
import com.starblackdian.conversoralura.model.ConversorLibraEsterlina;
import com.starblackdian.conversoralura.model.ConversorMexico;
import com.starblackdian.conversoralura.model.ConversorWon;
import com.starblackdian.conversoralura.model.ConversorYen;

public class ConversionController {
	
	public BigDecimal convertir(String textoCantidad, DivisaEnum divisaOrigen, DivisaEnum divisaDestino) {
		final BigDecimal cantidad = new BigDecimal(textoCantidad);
		final ConversorDivisas conversor = obtenerConversor(divisaDestino);
		final BigDecimal resultado = conversor.convertir(cantidad, divisaOrigen);
		
		return resultado;
	}
	
	private ConversorDivisas obtenerConversor(DivisaEnum divisaDestino) {
		switch (divisaDestino) {
			case DOLAR:
				return new ConversorDolar();
				
			case MXN:
				return new ConversorMexico();
				
			case EURO:
				return new ConversorEuro();
			
			case LIBRA_ESTERLINA:
				return new ConversorLibraEsterlina();
				
			case YEN:
				return new ConversorYen();
			
			case WON:
				return new ConversorWon();
			
			default:
				return new ConversorMexico();
				
		}
	}
}
