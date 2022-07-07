package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.Profesor;

@Service
public class ProfesorDAOImpl implements ProfesorDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int altaProfesor(Profesor prof) {
		int id = jdbcTemplate.update("INSERT INTO taller2.profesores (nombre, apellido,email,direccion) values (?,?,?,?)",
				prof.getNombre(),
				prof.getApellido(),
				prof.getEmail(),
				prof.getDireccion());
		
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
	                        rs.getString("direccion")
	                ));
		
	}

}
