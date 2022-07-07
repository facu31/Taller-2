package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.prueba.Opcion;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;

@Service
public class PruebaDAOImpl implements PruebaDAO{
	
	@Autowired
	private NamedParameterJdbcTemplate namejdbcTemplate;

	@Override
	public Prueba obtenerPrueba(int idPrueba) {
		String sql = "select * from taller2.pruebas where id = :idPrueba";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idPrueba", idPrueba);
		 
		return namejdbcTemplate.queryForObject(
				sql, 
				param, 
				(rs, rowNum) ->
						new Prueba(
		                rs.getInt("id"),
		                rs.getString("titulo"),
		                rs.getString("descripcion")
		        ));
	}

	@Override
	public List<Prueba> obtenerPruebas() {
		String sql = "select * from taller2.pruebas";
		
		return namejdbcTemplate.query(
				sql, 
				(rs, rowNum) ->
						new Prueba(
		                rs.getInt("id"),
		                rs.getString("titulo"),
		                rs.getString("descripcion")
		        ));
	}
	
	
	@Override
	public List<Pregunta> obtenerPreguntas(int idPrueba) {
		String sql = "SELECT p.id, p.enunciado, p.idOpcionCorrecta"
				+ " FROM taller2.pruebaPreguntas as pp, taller2.preguntas as p "
				+ " WHERE pp.idPregunta = p.id and pp.idPrueba = :idPrueba";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idPrueba", idPrueba);

		return namejdbcTemplate.query(sql, 
				param, 
				(rs, rowNum) -> 
				new Pregunta(
						rs.getInt("id"),
						rs.getString("enunciado"), 
						rs.getInt("idOpcionCorrecta")));

	}

	@Override
	public List<Opcion> obtenerOpciones(int idPregunta) {
		String sql = "SELECT idOpcion, idPregunta, descripcion from taller2.opcionesPreguntas "
				+ "where idPregunta=:idPregunta";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idPregunta", idPregunta);
		
		return namejdbcTemplate.query(sql,
				param,
				(rs, rowNum)-> 
						new Opcion(
						rs.getInt("idOpcion"),
						rs.getString("descripcion")
						));
	}

	
}
