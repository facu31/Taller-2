package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Opcion;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;

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

	@Override
	public List<Materia> obtenerMaterias() {
		String sql = "SELECT idMateria, descripcion from taller2.materias order by descripcion asc";
		
		return namejdbcTemplate.query(sql,
				(rs, rowNum)-> 
						new Materia(
						rs.getInt("idMateria"),
						rs.getString("descripcion")
						));
	}

	@Override
	public List<Tema> obtenerTemas() {
		String sql = "SELECT idTema, descripcion from taller2.temas order by descripcion asc";
		
		return namejdbcTemplate.query(sql,
				(rs, rowNum)-> 
						new Tema(
						rs.getInt("idTema"),
						rs.getString("descripcion")
						));
	}

	@Override
	public List<Pregunta> filtrarPreguntas(int materia, int tema) {
		String sql = "SELECT id, enunciado, idOpcionCorrecta "
				+ " from taller2.preguntas as p, taller2.materias as m, taller2.temas as t "
				+ "where p.idTema = t.idTema and t.idMateria = m.idMateria "
				+ "and m.idMateria =:idMateria and t.idTema =:idTema ";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idMateria", materia);
		param.addValue("idTema", tema);
		
		
		return namejdbcTemplate.query(sql,
				param,
				(rs, rowNum)-> 
					new Pregunta(
							rs.getInt("id"),
							rs.getString("enunciado"), 
							rs.getInt("idOpcionCorrecta"))
					);
	}

	
}
