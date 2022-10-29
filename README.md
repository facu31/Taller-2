# Taller 2     🖥️🖱️📚


![GitHub Actions Status Badge](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
![GitHub Actions Status Badge](https://img.shields.io/badge/HTML-239120?style=for-the-badge&logo=html5&logoColor=white)
![GitHub Actions Status Badge](https://img.shields.io/badge/CSS-239120?&style=for-the-badge&logo=css3&logoColor=white)
![GitHub Actions Status Badge](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![GitHub Actions Status Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white=)
![GitHub Actions Status Badge](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


Composición grupo de trabajo:

-Gabriel Aramburu.
-Diego Gandaria.
-Facundo Olaizola.
-Javier Balado


# Justificación de metodología de desarrollo.

Para determinar la metodología de desarrollo a utilizar en este proyecto se evaluaron diferentes alternativas. 
A continuación se describen los puntos que consideramos.

## Metodología de cascada.

Tiene como principal característica que cada fase del desarrollo se ejecuta en orden, comenzando por el análisis y terminando por la puesta en producción del sistema. Antes de continuar con la siguiente fase, se tiene que haber terminado con la anterior. 
Es un enfoque poco adaptativo o flexible, que no se aplica exitosamente cuando los requerimientos cambian con frecuencia. Además el software funcionando se entrega al final del proceso.

### Porque se descarta.

Se descarta ya que el cliente necesita tener entregas parciales del producto para evaluar el funcionamiento y definir nuevos requerimientos en base a la versión presentada.

## Metodología Scrum.

Las metodologías ágiles se caracterizan por ofrecer la flexibilidad y adaptabilidad que la metodologías predictivas como la analizada anteriormente no ofrecen. Tiene como principal características el contacto extremadamente fluido con el cliente (product owner), el cual suele ser considerado un integrante más del equipo de desarrollo. La coordinación o mediación entre el equipo de desarrollo y el cliente la realiza una persona con el rol de Scrum Master. 
Diariamente el equipo se comunica dando un status de la situación actual del desarrollo. Aproximadamente cada dos semanas (sprint) se entrega una versión del software funcionando. La suma de las funcionalidades entregadas en cada sprint dan como resultado un sistema funcionando y útil para el cliente. 

### Porque se descarta.

Consideramos que la propuesta de trabajo ofrecida por la metodología no se adapta a las características del equipo de desarrollo. 
Tampoco vemos factible la posibilidad de tener un contacto tan fluido con el cliente.

## Metodología Kanban.

Esta metodología ágil, se utiliza cuando se hace imposible la planificación por adelantado de los pasos a seguir. 
Por ejemplo: dentro de la metodología Scrum es necesario poder anticipar un plan de trabajo que tenga como alcance por lo menos la duración del sprint. Cuando el plan de trabajo no se puede predecir pero sí se quiere ofrecer un resumen o sensación de avance al cliente se utiliza Kaban. 
Esta metodoloǵia ágil propone identificar un número determinado de tareas a realizar (backlog), cada integrante del equipo toma una tarea, comienza a trabajar con ella haciendo que la misma valla pasando por una serie de etapas previamente definidas (ejemplo: pendiente, en proceso, finalizada). 
Luego de pasado un período de tiempo es posible determinar la fuerza de trabajo en base al tamaño del backlog respecto al tamaño del conjunto de tareas terminadas.

### Porque se descarta.
Consideramos que la metodología no se adapta a las pautas entregadas por el cliente.
Los plazos de desarrollo están acotados y se conocen de antemano (4 a 5 meses), por lo que es necesario realizar una planificación que se adapte a estas limitaciones de tiempo.


## Metodología Iterativa Incremental

A medio camino entre las metodologías predictivas y las adaptativas se encuentra la metodología iterativa incremental.
El incremental es un modelo de tipo evolutivo que está basado en varios ciclos Cascada realimentados aplicados repetidamente, con
una filosofía iterativa. El modelo incremental es útil sobre todo cuando el personal necesario para una implementación completa no esta disponible.


### Porque se elige.

La misma ofrece la posibilidad de realizar entregas parciales al cliente, cada entrega brindará información acerca del avance y permitirá realizar ajustes en los requerimientos definidos. 
Nos permite comenzar a trabajar con un nivel de requerimientos suficiente pero no necesariamente completos y definidos con detalle. 
Permite planificar los plazos de entregas, dividiendo la construcción en intervalos de tiempo tomando en cuenta la limitaciones de horas de trabajo y fecha límite de entrega. 
Estas características también las ofrece la metodología Scrum, sin embargo creemos que la iterativa incremental se adapta mejor a las característica del equipo y el cliente.

### Ventajas

-Se reduce el tiempo de desarrollo inicial, ya que se implementa la funcionalidad parcial.

-Proporciona todas las ventajas del modelo en cascada
realimentado, reduciendo sus desventajas sólo al ámbito de
cada incremento.

-Los modelos iterativos e incrementales disminuyen riesgos. ya
que estos modelos se basan en la retroalimentación sobre los
avances.

-Resulta más sencillo acomodar cambios al acotar el tamaño
de los incrementos.

### Desventajas

-El modelo Incremental no es recomendable para casos de sistemas de tiempo real, de alto nivel de seguridad, de procesamiento distribuido
y/o de alto índice de riesgos.

-Requiere de mucha planificación, tanto administrativa como técnica.

-Requiere de metas claras para conocer el estado del proyecto.
# Análisis y justificación de la tecnología web a utilizar.

Como parte de los requerimientos no funcionales se pidió que el sistema a desarrollar sea Web, implementado en Java y que preferentemente se utilice el framework Spring.
Esto nos llevó a investigar el abanico de posibilidades que se ofrecen. La siguiente sección detalla los puntos relevantes que se investigaron, los cuales sirven para poder tomar una decisión  respecto a como se implementará la capa de presentación.

## Spring.

Es un framework de desarrollo Java que ofrece un abanico muy amplio de posibilidades. Este abanico va desde el desarrollo de aplicaciones Web, pasando por aplicaciones basadas en arquitectura de microservicios, hasta aplicaciones basadas en arquitecturas orientadas a eventos. Además de framework que definen la arquitectura general de una aplicación, Spring ofrece muchas framework menores que resuelven aspectos concretos, como ser como persistir datos, enviar mensajes asincrónicos, integrar sistemas, procesamiento por lotes y un largo etc.

### Spring MVC y Spring boot.

Dentro de ese universo nos encontramos con Spring MVC. Dicho proyecto ofrece una implementación del patrón MVC del estilo action-based MVC. Por medio de anotaciones y la filosofía “convention over configuration” es posible crear rápidamente una aplicación que actúe como controlador de  request originados en el browser. 
Spring Boot es otro proyecto que nos ayuda en este aspecto ya que evita realizar todos los pasos necesarios de configuración de la aplicación. Incluso provee un servidor Tomcat embebido.

### Desarrollo del lado del browser.

Spring MVC nos ofrece la solución para el desarrollo del lado del servidor, pero es totalmente agnóstico de la tecnología a utilizar en el browser.

El navegador solo entiende tres cosas: html, css y javascript. Esto podría hacer parecer que las opciones a seleccionar son limitadas, sin embargo existe otro amplio abanico de posibilidades para utilizar en la capa de presentación.


## Solo utilizar html, css y javascript

Con esta opción el desarrollo de la capa de presentación implica el uso exclusivo de estos tres lenguajes, sin incluir ningún tipo de librería/frameworks de terceros.
Todo el trabajo se realiza a mano, especialmente:
la implementación del comportamiento dinámico de la página. Esto es agregar programáticamente nuevos elementos html dependiendo de las acciones del usuario. Por ejemplo, no se conocen de antemano cuántas posibles respuestas tendrá una pregunta de múltiple opción por lo que no se puede armar una página estática con un número fijo de elementos html comunicación entre la página y el servidor. 
La información que el usuario ingresa en los controles html, debe ser parseada utilizando javascript para convertirla en un formato que pueda ser enviado  y procesado por el servidor por ejemplo json creación de resultados por parte del servidor. 
El servidor también deberá de construir dinámicamente páginas html dependiendo de la información devuelta. Esta construcción implica programar código Java que renderiza html.

## Utilizar librerías/frameworks como React, VueJs, Angular

Con los años se han desarrollado librerías javascript que ofrecen una nueva capa de abstracción ofreciendo la posibilidad de reutilizar comportamientos ya programados. Dicho comportamientos ofrecen funcionalidades que son utilizadas en páginas de uso masivo por ejemplo Facebook (React) y  Google (Angular). 
En estos casos el control de la capa de presentación lo tiene al 100% al browser. La tarea del servidor web es solo recibir los request y devolver la información solicitada a los componentes del browser que originaron los mismos.
Esta libertad permite la creación de paǵinas web muy potentes. Sin embargo tiene la contra de que además de un gran conocimiento de javascript se requiere conocer en profundidad, como trabajan dichas librerías.

## Utilizar template engines. (Thymeleaves)

A medio camino, existe la posibilidad de ofrecerle al servidor cierta responsabilidad en el armado de la capa de presentación. Para esto se utiliza un patrón de diseño llamado Template View. En este escenario el servidor web no solo procesa request sino que funciona como Templete Engine. Estuvimos viendo que Spring patrocina un proyecto denominado Thymeleaves que se integra bien con Spring MVC.
La curva de aprendizaje de Thymeleaves es mucho menor que las ofrecidas por las librerías mencionadas anteriormente. Utilizar un template engine resuelve mucho de los problemas que se plantearon en el primer punto (html/css/js puro).


## Utilizar el estándar de Java.

Java ofrece su propia tecnología de presentación llamada JSF. Es considerado el standar de la industria aunque como se puede observar en el siguiente gráfico obtenido de Google Trend no es la más popular. Esto se debe a que es utilizada principalmente para el desarrollo de aplicaciones empresariales (intranet)

![tren](https://user-images.githubusercontent.com/63823685/174145002-fac8fed7-dedd-456d-976a-577f2202ab28.png)


JSF ofrece la implementación del patrón MVC. A diferencia de una implementación action-based (mencionada anteriormente); JSF es una implementación component-based. La gran diferencia es que la generación de la capa de presentación pasa a estar del lado del servidor. A grandes rasgos esto implica:
no existe por parte del programador un control directo sobre como se manejan los request http generados en el cliente. Por medio de archivos de configuración y objetos java (managedBeans) el programador  le indica al servidor como gestionar/procesar dichos request
las páginas se renderizan completamente en el servidor, por lo tanto el mismo es el encargado de generar el html, css, js necesario

El rol del programador en estos casos, implica componer dentro de un archivo xhtml, una serie de componentes UI previamente definidos por terceros. No se requiere por lo tanto gran conocimiento de html, css y js, sin embargo sí es necesario conocer como funcionan los componentes que se insertan en la página. Los mismos siguen la especificación Java Facelest.

Esta tecnología permite un desarrollo inicial muy rápido, ya que para requisitos simples no se requiere interiorizarse en el ciclo de vida ofrecido por el framework, cosa que es imprescindible dominar cuando aparecen los “problemas” o requisitos complejos.

## Framework Vaadim.

Nos encontramos con este tipo de soluciones al explorar las posibilidades del framework Spring. Se menciona a Vaadim como una tecnología de presentación que se integra bien con Spring MVC. Se menciona aquí ya que el enfoque utilizado por este framework es completamente diferente a los descritos hasta el momento.

Al igual que JSF, con Vaadim toda la responsabilidad de la capa de presentación pasa al lado del servidor. Sin embargo, a diferencia de JSF, construir una página implica en este caso escribir 100% código Java; este código se ejecuta en el controlador de Spring MVC y genera como resultado html, css y js que son devueltos al browser. Es necesario por lo tanto conocer a fondo la API de programación ofrecida por Vaadim. 

# Resumen

La siguiente tabla muestra lo que consideramos un resumen de las principales características de las tecnologías evaluadas.
.

![image](https://user-images.githubusercontent.com/63823685/174140892-99048479-0387-4948-b115-f9f3c000ddd0.png)

Concideramos que la mejor opciòn será implementar el proyecto utilizando un template view, debido a su relativa simplicidad
y flexibilidad para adepaterse a los requerimientos del sistema.

# Cronograma

La realización del cronograma de trabajo esta condicionado por los siguientes factores:
metodología de desarrollo a utilizar (iterativo incremental), duración máxima (aprox 5 meses), carga horaria de dedicación semanal (6 horas) y conformación del equipo (4 integrantes)

A continuación se muestra un diagrama Gant con el detalle de las tareas a realizar y una descripción de las mismas.

![image](https://github.com/facu31/Taller-2/blob/8843a9b9483982f7432cea6d2ca550355b436b83/Cronogramma.PNG)

## Planificación.

Iteraciones:

##### Acta Reunion Inicial:

El día 25/06/2022 se realiza la primer reunion formal con el cliente, en la cual este brinda los 
requerimientos pretendidos para el sistema.
El equipo toma nota de ello y comienza a trabajar.

##### Acta N°02:

Se deja constancia que en el día 28/07/2022 fue realizada una reunión con el fin de
presentar al cliente Juan Pablo Sales el prototipo del software anteriormente solicitado. En
la reunión se encontraban presentes quienes conforman el equipo de desarrollo: Facundo
Olaizola, Nicolás Gandaria, Gabriel Aramburú y Javier Balado.
A continuación se realiza un planteamiento de los puntos hablados en dicha reunión.
¿Qué hablamos?
Se le mostró al cliente los requerimientos implementados en la Iteración I. El mismo
quedó conforme con lo implementado y el prototipo presentado.
Futuras iteraciones
Se priorizará para la siguiente iteración, la realización de la funcionalidad de ingreso
de pruebas. La misma debería estar lista dentro de un plazo de 2 o 3 semanas.


##### Acta N°03:
Se deja constancia que en el día 23/08/2022 fue realizada una reunión con el fin de
presentar al cliente Juan Pablo Sales el prototipo del software anteriormente solicitado. En
la reunión se encontraban presentes quienes conforman el equipo de desarrollo: Facundo
Olaizola, Diego Gandaria, Gabriel Aramburú y Javier Balado.
A continuación se realiza un planteamiento de los puntos hablados en dicha reunión.
¿Qué hablamos?
Se le mostró al cliente los requerimientos implementados en la Iteración II. El mismo
quedó conforme con lo implementado y el prototipo presentado.
Futuras iteraciones
Se priorizará para la siguiente iteración ,la creación aleatoria de pruebas, con una cantidad
configurable de preguntas por el usuario.
Se sugiere ver la implementación de alguno de los siguientes parámetros: Puntaje, tiempo
o resta puntos.
Próxima Iteración 7 -14 Septiembre.



## Análisis de requerimientos iniciales.

Se estudia la propuesta entregada y se comienza a elaborar una lista inicial de requerimientos funcionales. También se evalúan los requerimientos no funcionales disponibles hasta el momento. 

Esta lista de requerimientos no se muestran al cliente, solo son tomados como referencia para que el equipo comience a interiorizarse con las características del sistema a construir.


## Selección de metodología.

En base a la información presentada en la propuesta se estudian alternativas y se selecciona metodología a utilizar.

## Estudio alternativas para capa de Presentación.

Se realiza un estudio de las tecnologías disponibles para desarrollar la aplicación en especial las características que ofrece el framework Spring. También se evalúan las ventajas y desventajas de las alternativas para el código que se ejecuta en el browser. Esta etapa nos parece importante incluirla ya que es una decisión técnica que impactará en todo el proyecto.

## Capacitación.

En esta etapa se realizará la auto capacitación de cada integrante del equipo en las tecnologías httl, css y javascript. También se incluirá capacitación en la alternativa que se seleccione por ejemplo (Thymeleaf). Además es necesario aprender github como repositorio de código.

## 1era entrega documentación.

Requisito formal de entrega de documentación propuesta por el cliente.

## Iteraciones.
En concordancia con la metodología utilizada, el proceso de desarrollo constará de varias instancias de entrega de versiones del sistema. 

En cada instancia se realizarán las siguientes etapas de desarrollo:
- análisis de requerimientos, 
- diseño, 
- implementación 
- testeo de integración. 

El análisis de requerimientos considerará la retroalimentación que nos brinde el cliente. Como se menciona en la sección donde se justifica la metodología, se espera que cada versión ayude a identificar/priorizar nuevos requerimientos, los cuales será incluidos en la próxima iteración. 

Los documentos de diseño serán actualizados reflejando los cambios que la iteración realiza al sistema (modelo de clases, esquema de base de datos, etc)

## Nota sobre Iteración I
La iteración I se solapa en parte con el proceso de aprendizaje por lo tanto el número de funcionalidad entregada al finalizar de la misma se espera que sea reducido respecto a las futuras iteraciones. 
Además esta iteración tiene un componente de diseño más fuerte ya que se parte desde cero en este aspecto. Se suma que  hay tareas como el seteado del ambiente de desarrollo que se realizan en esta iteración pero no en las siguientes. 

## Migración a la nube.

En esta etapa se espera poder deployar la aplicación en algunos de los servicios que se ofrecen; por ejemplo Amazon WS. Esta migración requiere estudiar como realizar el proceso y eventualmente realizar alguna modificación en el código de la aplicación.

## Manual de usuario.

Realización de manual de usuario. Como se mencionó,  los documentos técnicos del sistema se irán realizando/actualizando en cada iteración. 

# Segunda Entrega de Documentación.


## Instrumentos a usar en la recolección de información con el cliente.

- Entrevistas:
En una primer instancia se pedira al cliente que plante todos sus deseos en la aplicación, este nos dara un modelo a grandes rasgos de los pretendidos.
En base a esto surgira el cuestionario utilizado.

### Primera reunión de requerimientos
Fecha: sábado 28 de Junio
<br/>
Modalidad: online

Si bien, en la primera reunión presencial donde se lanzó el proyecto el Cliente dio algunas caracteristicas de como debería funcionar el sistema, en esta reunión se plantean algunas cuestiones insiertas que aparecieron al analizar la consigna entregaga en la mencionada reunión.

#### Dudas a transmitir al Cliente.

**Prueba:**

- Es Creada por el docente.
- Es Creada de manera aleatoria por la página.

**Preguntas de la prueba:**

- Solo Verdadero o Falso
- Diferentes tipos (Ej: Multiple Choice - Verdadero y falso)
- ¿Cuantas preguntas de cada tipo? 

**Corrección:**

- Corrige el docente
- Corrige automáticamente el sistema

Segun lo recavado de información, el equipo de desarollo tiene gran libertad en el diseño del software, por ejemplo el modo de elaboración de la prueba y la creación de usuarios quedan a criterio de los desarolladores.<br>
Sin embargo en la variedad de preguntas el cliente sugiere que existan diversos tipos.<br>
Ademas de lo mencionado anteriormente, se dio a entender por parte del cliente que en una primer versión lo esperado es un prototipo del funcionamiento de las pruebas.


## Plan de Riesgos y Contingencias.

### Plan de riesgos

**Complejidad tecnológica**

- Desconocimiento de la tecnología base del proyecto.

**Equipo de trabajo**

- Falta de experiencia en el desarrollo web.
- Falta de claridad en los roles.
- Trabajo a distancia(no presencial)

**Planificación y control**

- Fecha límite de entrega.
- Planeación y compromisos de entrega sobre alcances sin mucho detalle.
- Presupuesto en horas limitado.

### Contingencias

La siguiente tabla contiene el plan de contingencia elaborado para los principales riesgos que se identifican en el proyecto.
 

![imagen](https://user-images.githubusercontent.com/63823685/177560421-7228855b-864c-4c20-9611-82a20bf73398.png)


## Estudio de factibilidad.

En la siguiente sección se describe los apectos tomados en cuenta para determinar la factibilidad del proyecto.

### Factibilidad técnica.

En este aspecto la tecnología de desarrollo a utilizar forma parte del estándar de la industria. Cada herramienta utilizada (lenguaje, frameworks, librerías, IDE, bade de datos) es de código abierto o de libre uso. Cada una de ellas cuenta con una comunidad de desarrollo que da soporte en foros de libre acceso. Esto permite subsanar posibles inconvenientes técnicos que surjan, por lo que se concidera que en el aspecto técnico el sistema es factible.

### Factibilidad económica.

Se cuenta con un presupuesto limitado de horas de trabajo, las cuales se pueden descriminar de la siguiente forma: un promedio de 6 horas semanales por cada integrante del equipo (4 personas) durante un período de 4 a 5 meses. Este paquete de horas se utilizará para implementar los requerimientos planteados por el cliente. Si bien las características o funcionalidades completas del producto que se construirá puede exceder el presupesto con el que se cuenta, si será posible entregar una versión funcional que conforme al cliente.

### Factibilidad operativa.

Respecto a este punto, el sistema requerirá un mínimo de mantenimiento operativo por lo que no se detectan problemas de factibilidad en este aspecto. Se planea contar con la figura de Administrador, el cual realizará el mantenimiento de usuarios (alta, baja y modificaciones). Fuera de esta tarea el sistio no requiere de más operativa para funcionar ya que cada profesor será el encargado de crear sus pruebas. 
Respecto al mantenimiento del hardware (servidor), realización de respaldos y administración de base de datos, el sistema requerirá un mínimo esfuerzo.


## Requerimientos Iteración I.

La siguiente lista de requerimientos surge de la reunión mantenida con el Cliente donde de analizaron y priorizaron los requerimientos que debería tener la primer versión del sistema.

1. Como alumno debo poder ver las pruebas existentes y selecccionar la que corresponda para poder realizarla.

2. Como alumno debo poder realizar pruebas donde el tipo de pregunta sea de tipo verdadero o falso.El sistema deberá de mostrar las preguntas y el estudiante seleccionar la opción correcta.

3. Como estudiante quiero ver la puntación recibida al finalizar la prueba indicando cuantas preguntas se contestaron correctamente.


## Casos de uso.

<br /> 


|Cu01 |Cu01- Ver Pruebas  | 
| -------------- | --------------|
|**Descripción** |El sistema deberá permitir listar las pruebas cuando el Usuario lo desee |
|**Actores** |Estudiante|
|**Precondiciones**| Login como estudiante.|
| | | 
|**Flujo Normal**|1-Usuario se loguea.|
| |2-Se solicita el listado.|
| |3-Sistema muestra listado de pruebas a realizar.|
|**Flujo Alternativo**|3.1) No se encuentran pruebas listados.|
|**Poscondiciones**|Listado de pruebas  |
|**Prioridad** |Alta|


![image](https://github.com/facu31/Taller-2/blob/ddbcf022dae10f18a570ddfa2a63e4e9d9207e01/Dise%C3%B1o/Cu01.svg)
<br />  


|Cu02 |Cu02- Realizar Pruebas Pendientes | 
| -------------- | --------------|
|**Descripción** |El sistema deberá permitir realizar las pruebas que el usuario tenga pendientes |
|**Actores** |Estudiante|
|**Precondiciones**| Login como estudiante. Las pruebas tienen que estar cargadas en el sistema|
| | | 
|**Flujo Normal**|1-Usuario selecciona prueba a realizar|
| |2-Sistema muestra prueba.|
| |3-Usuario realiza a prueba y preciosa finalizar.|
|**Flujo Alternativo**|2.1) No se encuentran pruebas.|
|**Poscondiciones**|Prueba Realizada Correctamente  |
|**Prioridad** |Alta|

![image](https://github.com/facu31/Taller-2/blob/3467575cd746f37ed9921ebc0ec35bd0984927b9/Dise%C3%B1o/Cu02.svg)
<br /> 

|Cu03 |Cu03- Mostrar Resultado de prueba. | 
| -------------- | --------------|
|**Descripción** |El sistema deberá mostrar los resultados de la prueba una vez sea realizada por el usuario. |
|**Actores** |Estudiante|
|**Precondiciones**| Prueba realizada por el usuario.|
| | | 
|**Flujo Normal**|1-Usuario realiza la prueba. |
| |2. Sistema corrobora de forma interna las respuestas.|
| |3-Sistema muestra la calificación al usuario.|
|**Flujo Alternativo**|2.1) No se encuentran pruebas realizadas.|
|**Poscondiciones**|Calificación del estudiante registrada. |
|**Prioridad** |Alta|


![image](https://github.com/facu31/Taller-2/blob/3467575cd746f37ed9921ebc0ec35bd0984927b9/Dise%C3%B1o/Cu03.svg)


## Requerimientos Iteración II.

1. Como profesor debo crear preguntas nuevas de tipo verdadero o falso, ingredando un enunciado y determinando la opción correcta.

2. Como profesor debo crear preguntas nuevas de tipo multiple opción, ingresando un enunciado para la pregunta y las diferentes opciones que se le ofrecerán al alumno. Debo indicaar cual de las opciones ingresadas es la correcta.

3. Como profesor debo crear pruebas indicando el titulo de la misma, una descripción y las preguntas que integran la misma. El sistema debe
asistir en la etapa de selección de preguntas ofreciendo un método fácil de búsqueda de preguntas.

## Requerimientos Iteración III.

1. Como profesor necesito que el sistema genere pruebas de forma automática a partir de ciertos criterios ingresados, como ser tema de la pregunta. 

|Cu04 |Cu04- Crear Prueba Aleatoria. | 
| -------------- | --------------|
|**Descripción** |El sistema deberá crear una prueba en base a las condiciones ingresadas por el usuario |
|**Actores** |Docente|
|**Precondiciones**| Prueba creada.|
| | | 
|**Flujo Normal**|1-Usuario ingresa al filtro de pruebas y lo completa. |
| |2. Sistema genera una prueba aleatoria|
| |3-Sistema guarda prueba para su realizacion|
|**Flujo Alternativo**|2.1) No se encuentran cantidad de preguntas necesarias.|
|**Poscondiciones**|Prueba creada correctamente.|
|**Prioridad** |Alta|

## Requerimientos Iteración IV.

1. Como profesor deseo realizar preguntas de tipo respuesta corta, donde se posible ingresar una frase corta como respuesta a una pregunta.

2. Como profesor deseo realizar preguntas de tipo correlación.

3. Como profesor necesito que las pruebas realizadas solo sean visibles por los alumnos cuando las mismas se publiquen.

4. Como profesor necesito ver las preguntas existentes y eliminar las que corresponda.

5. Como profesor necesito ver las pruebas existentes y eliminar las que no corerspondan.

6. Como administrador necesito realizar mantenimiento de Profesores y Alumnos.

7. Como alumno necesito ver los resultados de las pruebas realizadas.

# Documentación de Diseño

El siguiente diagrama describe la arquitectura general de la aplicación. La misma consiste en una arquitectura estándar de tres capas físicas las cuales ejecutan en máquinas separadas. La capa Cliente corresponde al browser y es la encargada de interactuar directamente con el usuario.
La capa de Aplicación es un servidor Web donde reside la lógica del negocio. Finalmente la tercer capa fìsica la integra el servidor de base de datos relacional.

Dentro de la capa física de Aplicación, podemos encontrar varias capas lógicas las cuales siguen patrones de diseño estándares. Podemos observar las 
siguientes capas lógicas:

- Vista: está formada por archivos html, javascript y css.
- Modelo: contine la lógica de la aplicación
- Controlador: implementa los puntos de entrada de las peticiones http, 
- Service: contiene la lógica de los casos de usos, es la encargada de usar las clases del modelo y gestionar su persistencia.
- DataAccesObject: encapsulan el acceso a la base de datos, en las misma se encuentran las sentencias SQL que se ejecutan

![imagen](https://user-images.githubusercontent.com/63823685/198401759-91c472b3-b39c-4513-9d46-af628c75a344.png)

## Diagrama de Clases 

Los diagramas de clases se presentan separados por capas lógicas para facilitar su interpretación.

## Diagrama de clases del Dominio

![imagen](https://user-images.githubusercontent.com/63823685/198405948-9202137b-2a58-4211-a883-56a42f9ec344.png)

Nota: para mejorar la legibilidad del mismo, solo se incluye la información más relevante de cada clase.

## Diagrama de clases Persistencia 

![imagen](https://user-images.githubusercontent.com/63823685/198406148-fec561d2-a177-4d69-a27f-06db2da6945f.png)


## Diagrama de capa de Servicios 

![imagen](https://user-images.githubusercontent.com/63823685/198406210-95461701-45de-427b-aca1-86ee40972ecb.png)


## Diagrama de clases de Controladores

![imagen](https://user-images.githubusercontent.com/63823685/198406857-c69da806-8169-41e0-be38-94bc28b2ded5.png)




## Base de Datos

 ## MER Solo entidades y relaciones.
![image](https://github.com/facu31/Taller-2/blob/a6e0c09e1002773fc133fb0aaef6f902d6eacff9/Recursos/Mer%20Sin%20Atributos.png)

## MER Completo

## En Proceso

### Normalización.

https://docs.google.com/document/d/15icsfiCMgK78Dn9lxBwymvwFUJBs4e7JnBscCCyprAA/edit?usp=sharing

Se cumple con la primera forma normal ya que:
- todos los atributos son atómicos

Se cumple con la segunda forma normal ya que:
- se cumple con la primer forma normal
- todos los atributos que no forman parte de ninguna clave dependen de forma completa a la clave principal.

Se cumple con la tercera forma normal ya que:
- se cumple con la primer y segunda forma normal
- no existen dependencias funcionales transitivas

Consideramos que la tercera formal normal se adapta a los requerimientos de normalización de los datos del sistema.

Tablas:

![imagen](https://github.com/facu31/Taller-2/blob/5e05849dcafd8f350ccc7dd62979590fbac6e01b/Recursos/TablasBdTaller2.PNG)
   ![imagen](https://github.com/facu31/Taller-2/blob/5e05849dcafd8f350ccc7dd62979590fbac6e01b/Recursos/Tablas2BdTaller2.PNG)
![imagen](https://github.com/facu31/Taller-2/blob/5e05849dcafd8f350ccc7dd62979590fbac6e01b/Recursos/Tablas3BdTaller2.PNG)


Manual de Usuario :

https://docs.google.com/document/d/1A3Sthpa5mIC7qDfgjxiA1djGgNb83jFpr3TVlC2wUHY/edit?usp=sharing


