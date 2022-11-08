package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.prueba.Tema;

@Service
public class TemaDAOImpl implements TemaDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Tema> obtenerTemas() {
		 String sql = "SELECT * FROM taller2.temas order by idTema";

		    return jdbcTemplate.query(
		    		sql, 
		    		(rs, rowNum) ->
		                new Tema(
		                        rs.getInt("idTema"),
		                        rs.getString("descripcion"),
		                        rs.getInt("idMateria")
		                ));
			
	}


	
}
