package com.taller2.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.dto.crearprueba.PreguntaDTO;
import com.taller2.model.Alumno;
import com.taller2.model.prueba.Materia;
import com.taller2.model.prueba.Opcion;
import com.taller2.model.prueba.Pregunta;
import com.taller2.model.prueba.Prueba;
import com.taller2.model.prueba.Resultado;
import com.taller2.model.prueba.Tema;
import com.taller2.service.dao.AlumnoDAO;
import com.taller2.service.dao.PruebaDAO;
import com.taller2.service.dao.ResultadoDAO;
import com.taller2.sesion.SesionActiva;

@Service
public class PruebaServiciosImpl implements PruebaServicios {
	@Autowired
	PruebaDAO pruebaDAO;
	
	@Autowired
	ResultadoDAO resultadoDAO;

	@Autowired
	AlumnoDAO alumnoDAO;
	
	@Autowired
	private SesionActiva sesion;  
	
	
	@Override
	public List<Prueba> obtenerPruebasExistentes() {
		return pruebaDAO.obtenerPruebas();
	}

	@Override
	public List<Prueba> obtenerPruebasPublicadas() {
		return pruebaDAO.obtenerPruebasPublicadas();
	}
	
	@Override
	public Prueba obtenerPrueba(int idPrueba) {
		Prueba prueba = pruebaDAO.obtenerPrueba(idPrueba);
		prueba.setPreguntas(pruebaDAO.obtenerPreguntas(idPrueba));
		
		for (Pregunta preg: prueba.getPreguntas()) {
			preg.setOpciones(pruebaDAO.obtenerOpciones(preg.getId()));
		}
		return prueba;
	}

	@Override
	public List<Materia> obtenerMaterias() {
		return pruebaDAO.obtenerMaterias();
	}

	@Override
	public List<Tema> obtenerTemas() {
		return pruebaDAO.obtenerTemas();
	}
	
	@Override
	public List<Pregunta> filtrarPreguntas(int idMateria, int idTema) {
		if (idMateria != 0 && idTema !=0) return pruebaDAO.filtrarPreguntasPorMateriaTema(idMateria,idTema);
		if (idMateria != 0 && idTema ==0) return pruebaDAO.filtrarPreguntasPorMateria(idMateria);
		if (idMateria == 0 && idTema !=0) return pruebaDAO.filtrarPreguntasPorTema(idTema);
		return pruebaDAO.obtenerTodasLasPreguntas();
	}

	@Override
	public void guardarPrueba(Prueba prueba, List<PreguntaDTO> preguntas) {
		//guardar registro en tabla prueba
		prueba.setId(pruebaDAO.obtenerIdPrueba());
		pruebaDAO.altaPrueba(prueba);
		
		//guardar registros en relación
		for(PreguntaDTO pregunta: preguntas) {
			pruebaDAO.altaPruebaPreguntas(prueba.getId(), pregunta.getId());
		}
	}

	public List<Pregunta> obtenerPreguntasAleatoriamente(int cantPreguntas, int idTema) {
		return pruebaDAO.obtenerPreguntasAleatoriamente(cantPreguntas, idTema);
	}

	@Override
	public void altaPreguntaConOpciones(Pregunta pregunta) {
		pregunta.setId(pruebaDAO.obtenerIdPregunta());
		pruebaDAO.altaPregunta(pregunta);

		for (Opcion op: pregunta.getOpciones()) {
			op.setIdPregunta(pregunta.getId());
			pruebaDAO.altaOpcion(op);
		}
	}

	@Override
	public List<Pregunta> obtenerPreguntasExistentes() {
		return pruebaDAO.obtenerTodasLasPreguntas();
	}

	@Override
	public void borrarPregunta(int idPregunta) {
		pruebaDAO.borrarPregunta(idPregunta);
	}

	@Override
	public Pregunta obtenerPregunta(int idPregunta) {
		Pregunta pregunta = pruebaDAO.obtenerPregunta(idPregunta);
		pregunta.setOpciones(pruebaDAO.obtenerOpciones(idPregunta));
		return pregunta;
	}

	public void borrarPrueba(int id) {
		pruebaDAO.borrarPrueba(id);
	}

	public void publicarPrueba(int id) {
		pruebaDAO.publicarPrueba(id);
	}

	@Override
	public void guardarResultado(Resultado resultado) {
		resultadoDAO.grabarResultado(resultado);
	}

	@Override
	public Resultado calcularResultado(Prueba prueba) {
		
		Resultado resultado = prueba.calcularResultado();
		resultado.setAlumno(alumnoDAO.buncarAlumno(sesion.getUsuario().getIdentificador()));
		resultado.setPrueba(prueba);
		resultado.setFecha(new Date());
		
		guardarResultado(resultado);
		
		return resultado;
	}

	public List<Resultado> obtenerResultados() {
		Alumno alumno = alumnoDAO.buncarAlumno(sesion.getUsuario().getIdentificador());
		return resultadoDAO.obtenerResultados(alumno.getId());
	}



	
}
