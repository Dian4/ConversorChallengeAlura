package com.starblackdian.conversoralura.enums;

public enum DivisaEnum {

	MXN("Peso Mexicano"),
	DOLAR("Dólar Estadounidense"),
	EURO("Euro"),
	LIBRA_ESTERLINA("Libra Esterlina"),
	YEN ("Yen Japonés"),
	WON ("Won Surcoreano");
	
	DivisaEnum(String string) {
		descripcion = string;
	}

	private String descripcion;
	
	@Override
	public String toString() {
		return descripcion;
	}
}
