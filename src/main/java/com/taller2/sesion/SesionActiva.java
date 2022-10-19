package com.taller2.sesion;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SesionActiva {
	private UsuarioActivo usuario;

	public UsuarioActivo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioActivo usuario) {
		this.usuario = usuario;
	}
	
	public boolean isEstudiante() {
		if (usuario == null) return false;
		
		return usuario.getTipo() == UsuarioActivo.USUARIO_ESTUDIANTE ? true:false;
	}
	
	public boolean isProfesor() {
		if (usuario == null) return false;
		
		return usuario.getTipo() == UsuarioActivo.USUARIO_PROFESOR ? true:false;
	}
	
	public boolean isAdmin() {
		if (usuario == null) return false;
		
		return usuario.getTipo() == UsuarioActivo.USUARIO_ADMIN? true:false;
	}
	
	
	public String obtenerIdentificadorUsuarioActivo() {
		if (this.usuario != null) {
			return this.getUsuario().getIdentificador();
		} else {
			throw new RuntimeException ("No hay sesion activa");
		}
	}
	
}
