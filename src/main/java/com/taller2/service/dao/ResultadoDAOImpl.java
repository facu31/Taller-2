package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.Alumno;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Resultado;

@Service
public class ResultadoDAOImpl implements ResultadoDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namejdbcTemplate;
	
	@Override
	public void grabarResultado(Resultado resultado) {
		String sql = "INSERT INTO taller2.resultados "
				+ "(idAlumno, fecha, idPrueba, cantPreguntas, cantRespuestasBien, puntajeObtenido, puntajeMaximoPrueba) values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,
				resultado.getAlumno().getId(),
				resultado.getFecha(),
				resultado.getPrueba().getId(),
				resultado.getCantPreguntas(),
				resultado.getCantRespuestasBien(),
				resultado.getPuntajeObtenido(),
				resultado.getPuntajeMaximoPrueba());
	}

	@Override
	public List<Resultado> obtenerResultados(int id) {
		String sql = "SELECT r.idResultado, r.idAlumno, r.idPrueba, r.fecha, p.titulo, r.cantPreguntas, r.cantRespuestasBien, "
				+ " r.puntajeObtenido, r.puntajeMaximoPrueba "
				+ " FROM taller2.resultados as r, taller2.pruebas as p "
				+ " WHERE r.idPrueba= p.id and "
				+ " r.idAlumno= :idAlumno";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idAlumno", id);

		return namejdbcTemplate.query(sql, 
				param, 
				(rs, rowNum) -> 
				new Resultado(
						rs.getInt("idResultado"),
						new Alumno(rs.getInt("idAlumno")), 
						rs.getDate("fecha"),
						new Prueba(rs.getInt("idPrueba"), rs.getString("titulo")),
						rs.getInt("cantPreguntas"),
						rs.getInt("cantRespuestasBien"),
						rs.getInt("puntajeObtenido"),
						rs.getInt("puntajeMaximoPrueba")));

	}
	

}
