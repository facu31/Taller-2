
	//Invoco al servidor solo para pedir la porciï¿½n de la pï¿½gina que contiene las 
	//preguntas filtradas segï¿½n el criterio del usuario 
	
	function cargarFragmentoVerdaderoFalso() {
		$(".nav-link").removeClass('active');
		$("#tabFV").addClass('active');
		
		$("#seccion-crear-opciones").load(
				'/prueba/crearPregunta/verdaderoFalso'); //llamada axaj
	}

	function cargarFragmentoMultipleOpcion() {
		$(".nav-link").removeClass('active');
		$("#tabMO").addClass('active');
		
		$("#seccion-crear-opciones").load(
				'/prueba/crearPregunta/multipleOpcion'); //llamada axaj
	}
	
	
	
	

	//Elimina fila al apretar el boton Quitar
	function quitar(boton) {
		var p = boton.parentNode.parentNode;
		p.parentNode.removeChild(p);
	}

	function marcarCorrecta(boton) {
		var t = document.getElementById('tabla-opciones');
		var totalRowCount = t.rows.length;
		console.log(totalRowCount);
		

	}



	//realizo una invocacion http para enviar al servidor en formato json las opciones creadas
	function enviarPreguntas() {
		var data = $('#tabla-opciones').tableToJSON();
		var url = '/prueba/guardarPreguntaMultipleOpcion';

		fetch(url, {
			method : "POST",
			body : JSON.stringify(data),
			headers : {
				"Content-type" : "application/json; charset=UTF-8"
			}
		})

	}

	function agregarOpcion() {
		var enunciado = document.getElementById('tituloOpcion').value;
		var colEnunciado = '<td>' + enunciado + '</td>';
		
		var idRadio ='id="' +  enunciado+'"';
		var valueRadio = 'value="' + enunciado +'"';
		
		var radio = '<input type="radio" name="radio" '  + idRadio + valueRadio + ' onclick="marcarCorrecta(this)"/>';
	
		var colCorrecta = '<td> <div> ' + radio + ' </div> </td>';

		var botonBorrar = '<td><a class="btn btn-warning btn-sm" id="botonBorrar" onclick="quitar(this)">Quitar</a></td>'

		var fila = '<tr>' + colEnunciado + colCorrecta + botonBorrar + '</tr>';

		//agrega fila a la tabla
		$('#tabla-opciones tr:last').after(fila);
	}

	function guardarPregunta() {
			var data = $('#tabla-opciones').tableToJSON();
			var url = '/prueba/guardarPreguntaMultipleOpcion';
		
			var opcionSeleccionada = obtenerOpcionCorrecta();
			
			var infoGrilla = {};
			infoGrilla.enunciado = document.getElementById('enunciado').value
			infoGrilla.idTema = document.getElementById('temasCombo').value;
			infoGrilla.opciones = data;
			infoGrilla.opcionCorrecta = opcionSeleccionada;
			
			fetch(url, {
				method: "POST",
				body: JSON.stringify(infoGrilla),
				headers: { "Content-type": "application/json; charset=UTF-8" }
			})
	}
	
	//recorro la tabla y obtenfo el valor del radio button que esta seleccionado
	function obtenerOpcionCorrecta() {
		const radioButtons = document.querySelectorAll('input[name="radio"]');
		for (const radioButton of radioButtons) {
                if (radioButton.checked) {
                    return radioButton.value;
                    break;
                }
            }
	}
	
	$( document ).ready(function() {
		!function(a){"use strict";a.fn.tableToJSON=function(b){var c={ignoreColumns:[],onlyColumns:null,ignoreHiddenRows:!0,ignoreEmptyRows:!1,headings:null,allowHTML:!1,includeRowId:!1,textDataOverride:"data-override",textExtractor:null};b=a.extend(c,b);var d=function(a){return void 0!==a&&null!==a},e=function(c){return d(b.onlyColumns)?-1===a.inArray(c,b.onlyColumns):-1!==a.inArray(c,b.ignoreColumns)},f=function(b,c){var e={},f=0;return a.each(c,function(a,c){f<b.length&&d(c)&&(e[b[f]]=c,f++)}),e},g=function(c,d,e){var f=a(d),g=b.textExtractor,h=f.attr(b.textDataOverride);return null===g||e?a.trim(h||(b.allowHTML?f.html():d.textContent||f.text())||""):a.isFunction(g)?a.trim(h||g(c,f)):"object"==typeof g&&a.isFunction(g[c])?a.trim(h||gc):a.trim(h||(b.allowHTML?f.html():d.textContent||f.text())||"")},h=function(c,d){var e=[],f=b.includeRowId,h="boolean"==typeof f?f:"string"==typeof f?!0:!1,i="string"==typeof f==!0?f:"rowId";return h&&"undefined"==typeof a(c).attr("id")&&e.push(i),a(c).children("td,th").each(function(a,b){e.push(g(a,b,d))}),e},i=function(a){var c=a.find("tr:first").first();return d(b.headings)?b.headings:h(c,!0)},j=function(c,h){var i,j,k,l,m,n,o,p=[],q=0,r=[];return c.children("tbody,*").children("tr").each(function(c,e){if(c>0||d(b.headings)){var f=b.includeRowId,h="boolean"==typeof f?f:"string"==typeof f?!0:!1;n=a(e);var r=n.find("td").length===n.find("td:empty").length?!0:!1;!n.is(":visible")&&b.ignoreHiddenRows||r&&b.ignoreEmptyRows||n.data("ignore")&&"false"!==n.data("ignore")||(q=0,p[c]||(p[c]=[]),h&&(q+=1,"undefined"!=typeof n.attr("id")?p[c].push(n.attr("id")):p[c].push("")),n.children().each(function(){for(o=a(this);p[c][q];)q++;if(o.filter("[rowspan]").length)for(k=parseInt(o.attr("rowspan"),10)-1,m=g(q,o),i=1;k>=i;i++)p[c+i]||(p[c+i]=[]),p[c+i][q]=m;if(o.filter("[colspan]").length)for(k=parseInt(o.attr("colspan"),10)-1,m=g(q,o),i=1;k>=i;i++)if(o.filter("[rowspan]").length)for(l=parseInt(o.attr("rowspan"),10),j=0;l>j;j++)p[c+j][q+i]=m;else p[c][q+i]=m;m=p[c][q]||g(q,o),d(m)&&(p[c][q]=m),q++}))}}),a.each(p,function(c,g){if(d(g)){var i=d(b.onlyColumns)||b.ignoreColumns.length?a.grep(g,function(a,b){return!e(b)}):g,j=d(b.headings)?h:a.grep(h,function(a,b){return!e(b)});m=f(j,i),r[r.length]=m}}),r},k=i(this);return j(this,k)}}(jQuery);

		});
	
