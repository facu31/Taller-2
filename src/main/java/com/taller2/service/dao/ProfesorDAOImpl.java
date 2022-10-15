package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.Profesor;

@Service
public class ProfesorDAOImpl implements ProfesorDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namejdbcTemplate;
	
	@Override
	public int altaProfesor(Profesor prof) {
		int id = jdbcTemplate.update("INSERT INTO taller2.profesores (nombre, apellido,email,direccion, usuario, contrasenia) values (?,?,?,?,?,?)",
				prof.getNombre(),
				prof.getApellido(),
				prof.getEmail(),
				prof.getDireccion(),
				prof.getUsuario(),
				prof.getContrasenia());
		
		return id;
	}

	@Override
	public List<Profesor> obtenerProfesores() {
		 String sql = "SELECT * FROM taller2.profesores order by id";

	    return jdbcTemplate.query(
	    		sql, 
	    		(rs, rowNum) ->
	                new Profesor(
	                        rs.getInt("id"),
	                        rs.getString("nombre"),
	                        rs.getString("apellido"),
	                        rs.getString("email"),
	                        rs.getString("direccion"),
	                        rs.getString("usuario"),
	                        rs.getString("contrasenia")
	                ));
		
	}

	@Override
	public Object borrarProfesor(int id) {
		return  jdbcTemplate.update("DELETE FROM taller2.profesores where id = ?", id);
	}

	@Override
	public Profesor buncarProfesor(String usuario) {
		 String sql = "SELECT * FROM taller2.profesores where usuario = :usr";
		 
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("usr", usuario);
			
		    List<Profesor> profesores =  namejdbcTemplate.query(
		    		sql,
		    		param,
		    		(rs, rowNum) ->
		                new Profesor(
		                        rs.getInt("id"),
		                        rs.getString("nombre"),
		                        rs.getString("apellido"),
		                        rs.getString("email"),
		                        rs.getString("direccion"),
		                        rs.getString("usuario"),
		                        rs.getString("contrasenia")
		                ));
		    
		    if (profesores.isEmpty()) {
		    	return null;
		    } else {
		    	return profesores.get(0);
		    }
	}

}
