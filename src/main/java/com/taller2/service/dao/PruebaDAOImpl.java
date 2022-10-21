package com.taller2.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.taller2.model.Profesor;
import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Opcion;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Tema;

@Service
public class PruebaDAOImpl implements PruebaDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
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
		                rs.getString("descripcion"),
		                rs.getInt("publicada"),
		                new Profesor(rs.getInt("idProfesor")
		        )));
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
		                rs.getString("descripcion"),
		                rs.getInt("publicada"),
		                new Profesor(rs.getInt("idProfesor"))
		        ));
	}
	
	@Override
	public List<Prueba> obtenerPruebasPublicadas() {
		String sql = "select * from taller2.pruebas where publicada = 1;";
		
		return namejdbcTemplate.query(
				sql, 
				(rs, rowNum) ->
						new Prueba(
		                rs.getInt("id"),
		                rs.getString("titulo"),
		                rs.getString("descripcion"),
		                rs.getInt("publicada"),
		                new Profesor(rs.getInt("idProfesor"))
		        ));
	}
	
	@Override
	public List<Pregunta> obtenerPreguntas(int idPrueba) {
		String sql = "SELECT p.id, p.enunciado, p.idOpcionCorrecta, p.idTema, p.tipo, pp.puntaje "
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
						rs.getInt("idOpcionCorrecta"),
						rs.getInt("idTema"),
						rs.getInt("tipo"),
						rs.getInt("puntaje")));

	}

	@Override
	public List<Opcion> obtenerOpciones(int idPregunta) {
		String sql = "SELECT idOpcion, idPregunta, descripcion, valorCorrecto from taller2.opcionesPreguntas "
				+ "where idPregunta=:idPregunta";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idPregunta", idPregunta);
		
		return namejdbcTemplate.query(sql,
				param,
				(rs, rowNum)-> 
						new Opcion(
						rs.getInt("idOpcion"),
						rs.getString("descripcion"),
						rs.getString("valorCorrecto")
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
	public List<Pregunta> filtrarPreguntasPorMateriaTema(int materia, int tema) {
		String sql = "SELECT id, enunciado, idOpcionCorrecta, t.idTema as idTema, tipo "
				+ " from taller2.preguntas as p, taller2.materias as m, taller2.temas as t "
				+ "where p.idTema = t.idTema and t.idMateria = m.idMateria "
				+ "and m.idMateria =:idMateria and t.idTema =:idTema order by p.id";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idMateria", materia);
		param.addValue("idTema", tema);
		
		
		return namejdbcTemplate.query(sql,
				param,
				(rs, rowNum)-> 
					new Pregunta(
							rs.getInt("id"),
							rs.getString("enunciado"), 
							rs.getInt("idOpcionCorrecta"),
							rs.getInt("idTema"),
							rs.getInt("tipo")));
	}

	@Override
	public List<Pregunta> filtrarPreguntasPorMateria(int materia) {
		String sql = "SELECT id, enunciado, idOpcionCorrecta, t.idTema as idTema, tipo "
				+ " from taller2.preguntas as p, taller2.materias as m, taller2.temas as t "
				+ "where p.idTema = t.idTema and t.idMateria = m.idMateria "
				+ "and m.idMateria =:idMateria order by p.id";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idMateria", materia);
		
		
		return namejdbcTemplate.query(sql,
				param,
				(rs, rowNum)-> 
					new Pregunta(
							rs.getInt("id"),
							rs.getString("enunciado"), 
							rs.getInt("idOpcionCorrecta"),
							rs.getInt("idTema"),
							rs.getInt("tipo")));
	}

	@Override
	public List<Pregunta> filtrarPreguntasPorTema(int tema) {
		String sql = "SELECT id, enunciado, idOpcionCorrecta, t.idTema as idTema, tipo "
				+ " from taller2.preguntas as p, taller2.materias as m, taller2.temas as t "
				+ "where p.idTema = t.idTema and t.idMateria = m.idMateria "
				+ "and t.idTema =:idTema order by p.id";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idTema", tema);
		
		
		return namejdbcTemplate.query(sql,
				param,
				(rs, rowNum)-> 
					new Pregunta(
							rs.getInt("id"),
							rs.getString("enunciado"), 
							rs.getInt("idOpcionCorrecta"),
							rs.getInt("idTema"),
							rs.getInt("tipo")));
	}

	@Override
	public List<Pregunta> obtenerTodasLasPreguntas() {
		String sql = "SELECT id, enunciado, idOpcionCorrecta, t.idTema as idTema, tipo "
				+ " from taller2.preguntas as p, taller2.materias as m, taller2.temas as t "
				+ "where p.idTema = t.idTema and t.idMateria = m.idMateria order by p.id ";
	
		
		return namejdbcTemplate.query(sql,
				(rs, rowNum)-> 
					new Pregunta(
							rs.getInt("id"),
							rs.getString("enunciado"), 
							rs.getInt("idOpcionCorrecta"),
							rs.getInt("idTema"),
							rs.getInt("tipo")));
	}

	@Override
	public void altaPruebaPreguntas(int idPrueba, int idPregunta, int puntos) {
		jdbcTemplate.update("INSERT INTO taller2.pruebaPreguntas (idPrueba, idPregunta, puntaje) values (?,?, ?)",
				idPrueba,
				idPregunta,
				puntos);
	}

	@Override
	public void altaPrueba(Prueba prueba) {
		jdbcTemplate.update("INSERT INTO taller2.pruebas (id, titulo, descripcion, publicada, idProfesor) values (?,?,?,?,?)",
				prueba.getId(),
				prueba.getTitulo(),
				prueba.getDesc(),
				prueba.getPublicada(),
				prueba.getProfesor().getId());
	}

	@Override
	public int obtenerIdPrueba() {
		 String sql = "select max(id)+1 from taller2.pruebas;";

		 return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Pregunta> obtenerPreguntasAleatoriamente(int cantPreguntas, int idTema) {
		String sql = "select id from taller2.preguntas where idTema = :idTema order by rand() limit " + cantPreguntas;
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idTema", idTema);
		
		
		return namejdbcTemplate.query(sql,
				param,
				(rs, rowNum)-> 
					new Pregunta(
							rs.getInt("id"))
					);

	}
	

	@Override
	public void altaPregunta(Pregunta pregunta) {
		jdbcTemplate.update("INSERT INTO taller2.preguntas (id, enunciado, idOpcionCorrecta, idTema, tipo) values (?,?,?,?,?)",
				pregunta.getId(),
				pregunta.getEnunciado(),
				pregunta.getIdOpcionCorrecta(),
				pregunta.getIdTema(),
				pregunta.getTipo());
	}
	@Override
	public void altaOpcion(Opcion opcion) {
		jdbcTemplate.update("INSERT INTO taller2.opcionesPreguntas (idOpcion, idPregunta, descripcion, valorCorrecto) values (?,?,?,?)",
				opcion.getId(),
				opcion.getIdPregunta(),
				opcion.getDescOpcion(),
				opcion.getValorCorrecto());
	}
	
	@Override
	public int obtenerIdPregunta() {
		 String sql = "select max(id)+1 from taller2.preguntas;";

		 return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void borrarPregunta(int idPregunta) {
		
		jdbcTemplate.update("delete from taller2.opcionesPreguntas where idPregunta = ?", idPregunta);
		jdbcTemplate.update("delete from taller2.preguntas where id = ?", idPregunta);
	}

	@Override
	public Pregunta obtenerPregunta(int idPregunta) {
		String sql = "SELECT id, enunciado, idOpcionCorrecta, t.idTema as idTema, tipo "
				+ " from taller2.preguntas as p, taller2.materias as m, taller2.temas as t "
				+ "where p.idTema = t.idTema and t.idMateria = m.idMateria and p.id = :idPregunta";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idPregunta", idPregunta);
		
		
		return namejdbcTemplate.queryForObject(
				sql,
				param,
				(rs, rowNum)-> 
					new Pregunta(
							rs.getInt("id"),
							rs.getString("enunciado"), 
							rs.getInt("idOpcionCorrecta"),
							rs.getInt("idTema"),
							rs.getInt("tipo")));
	}

	@Override
	public void borrarPrueba(int id) {
		jdbcTemplate.update("delete from taller2.pruebaPreguntas where idPrueba = ?", id);
		jdbcTemplate.update("delete from taller2.pruebas where id = ?", id);
	}

	
	@Override
	public void publicarPrueba(int id) {
		jdbcTemplate.update("update taller2.pruebas set publicada = 1 where id = ?",
				id);
	}
	

	
	
}
