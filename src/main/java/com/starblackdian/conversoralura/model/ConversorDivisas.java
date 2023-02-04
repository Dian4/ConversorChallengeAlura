package com.starblackdian.conversoralura.model;

import java.math.BigDecimal;

import com.starblackdian.conversoralura.enums.DivisaEnum;

public interface ConversorDivisas {

	BigDecimal convertir(BigDecimal cantidad, DivisaEnum divisaOrigen);
}
