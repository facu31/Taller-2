package com.taller2.sesion;

public class UsuarioActivo {
	public static final int USUARIO_ESTUDIANTE = 0;
	public static final int USUARIO_PROFESOR = 1;
	public static final int USUARIO_ADMIN = 2;
	
	public static final String ADMIN_USR = "admin";
	public static final String ADMIN_PASS = "admin";
	
	private String identificador;
	private int tipo;
	
	public UsuarioActivo(String identificador, int tipo) {
		this.identificador =  identificador;
		this.tipo = tipo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
