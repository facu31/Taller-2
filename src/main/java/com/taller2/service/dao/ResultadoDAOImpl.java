package com.taller2.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.taller2.model.prueba.Resultado;

public class ResultadoDAOImpl implements ResultadoDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void grabarResultado(Resultado resultado) {
		String sql = "INSERT INTO taller2.resultados "
				+ "(idAlumno, fecha, idPrueba, cantPreguntas, cantRespuestasBien) values (?,?,?,?,?)";
		jdbcTemplate.update(sql,
				resultado.getAlumno().getId(),
				resultado.getFecha(),
				resultado.getPrueba().getId(),
				resultado.getCantPreguntas(),
				resultado.getCantPregunasBien());
	}

}
