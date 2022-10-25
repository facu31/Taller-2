package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.Alumno;
import com.taller2.model.Profesor;

@Service
public class AlumnoDAOImpl implements AlumnoDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namejdbcTemplate;
	
	@Override
	public Alumno buncarAlumno(String usuario) {
		
			 String sql = "SELECT * FROM taller2.alumnos where usuario = :usr";
				MapSqlParameterSource param = new MapSqlParameterSource();
				param.addValue("usr", usuario);
				
				List<Alumno> alumnos =namejdbcTemplate.query(
			    		sql, 
			    		param,
			    		(rs, rowNum) ->
			                new Alumno(
			                        rs.getInt("id"),
			                        rs.getString("nombre"),
			                        rs.getString("apellido"),
			                        rs.getString("email"),
			                        rs.getString("direccion"),
			                        rs.getString("usuario"),
			                        rs.getString("contrasenia")
			                ));
			     
			     
				if (alumnos.isEmpty()) {
					return null;
				} else {
					return alumnos.get(0);
				}
		}
	
	@Override
	public int altaAlumno(Alumno alumno) {
		int id = jdbcTemplate.update("INSERT INTO taller2.alumnos (nombre, apellido,email,direccion, usuario, contrasenia) values (?,?,?,?,?,?)",
				alumno.getNombre(),
				alumno.getApellido(),
				alumno.getEmail(),
				alumno.getDireccion(),
				alumno.getUsuario(),
				alumno.getContrasenia());
		
		return id;
	}
	
	@Override
	public Object borrarAlumno(int id) {
		return  jdbcTemplate.update("DELETE FROM taller2.alumnos where id = ?", id);
	}

	@Override
	public List<Alumno> obtenerAlumnos() {
		 String sql = "SELECT * FROM taller2.alumnos order by id";

		    return jdbcTemplate.query(
		    		sql, 
		    		(rs, rowNum) ->
		                new Alumno(
		                        rs.getInt("id"),
		                        rs.getString("nombre"),
		                        rs.getString("apellido"),
		                        rs.getString("email"),
		                        rs.getString("direccion"),
		                        rs.getString("usuario"),
		                        rs.getString("contrasenia")
		                ));
			
	}


	
}
