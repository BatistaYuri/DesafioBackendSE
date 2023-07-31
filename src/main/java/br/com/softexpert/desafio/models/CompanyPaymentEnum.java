package br.com.softexpert.desafio.models;

public enum CompanyPaymentEnum {
	MERCADO_PAGO("mercado_pago");
	
	private String name;

	CompanyPaymentEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static CompanyPaymentEnum fromString(String name){
	    for(CompanyPaymentEnum v : values()){
	        if( v.getName().equals(name)){
	            return v;
	        }
	    }
	    return null;
	}
}
