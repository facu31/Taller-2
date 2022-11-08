package com.taller2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.model.prueba.Tema;
import com.taller2.service.dao.TemaDAO;

@Service
public class TemaServiciosImpl implements TemaServicios {

	@Autowired
	TemaDAO temaDAO;
	
	@Override
	public List<Tema> obtenerTemas() {
		return temaDAO.obtenerTemas();
	}

}
