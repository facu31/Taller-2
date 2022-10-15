package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.Alumno;

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
	
}
