//Invoco al servidor solo para pedir la porción de la página que contiene las 
		//preguntas filtradas según el criterio del usuario 
		function filtrarPreguntas() {
			var url = '/prueba/filtrarPreguntas';
			url = url + '/materia/' + $('#materias-combo').val();
			url = url + '/tema/' + $('#temas-combo').val();

			$("#preguntas-filtradas").load(url); //llamada axaj
		}

		//Construye a mano el html que representa una fila de la tabla
		function agregarPregunta(idPreg, enunciado) {
			var colId = '<td>' + idPreg + '</td>';
			var colEnunciado = '<td>' + enunciado + '</td>';
			var colNotas = '<td> <input type="text" size="2" value="1"></td>';
			var botonBorrar = '<td><a class="btn btn-danger btn-sm" id="botonBorrar" onclick="quitar(this)">Quitar</a></td>'

			var fila = '<tr>' + colId + colEnunciado + colNotas + botonBorrar + '</tr>';

			//agrega fila a la tabla
			$('#tabla-preguntas tr:last').after(fila);
		}

		//Elimina fila al apretar el boton Quitar
		function quitar(boton) {
			var p = boton.parentNode.parentNode;
			p.parentNode.removeChild(p);
		}

		//realizo una invocación http para enviar al servidor en formato json las preguntas seleccionadas
		function enviarPreguntas() {
			var preguntasTabla = $('#tabla-preguntas').tableToJSON();
		
			var datosPrueba = {};
			datosPrueba.titulo = document.getElementById('titulo').value
			datosPrueba.desc = document.getElementById('desc').value
			datosPrueba.preguntas = preguntasTabla;
		
			var url = '/prueba/guardarPrueba';
		
			if (document.getElementById('titulo').value.length < 2) {
				todo_correcto = false;
				alert('Algunos campos no están correctos, vuelva a revisarlos');
		
			}
			else {
		
		
				fetch(url, {
					method: "POST",
					body: JSON.stringify(datosPrueba),
					headers: { "Content-type": "application/json; charset=UTF-8" }
				})
		
				alert("se guardo la prueba");
			}
		
		}
	
		
;
