# Taller 2

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

Elaboración del cronograma.

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

### Cuestionarios 

Si bien el cliente dio algunas caracteristicas empleadas, en base a lo recavado se plantean algunas cuestiones insiertas:

**Prueba:**

- Es Creada por el docente.
- Es Creada de manera aleatoria por la página.

**Preguntas:**

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

## Estudio de factibilidad.

En la siguiente sección se describe los apectos tomados en cuenta para determinar la factibilidad del proyecto.

### Factibilidad técnica.

En este aspecto la tecnología de desarrollo a utilizar forma parte del estándar de la industria. Cada herramienta utilizada (lenguaje, frameworks, librerías, IDE, bade de datos) es de código abierto o de libre uso. Cada una de ellas cuenta con una comunidad de desarrollo que da soporte en foros de libre acceso. Esto permite subsanar posibles inconvenientes técnicos que surjan, por lo que se concidera que en el aspecto técnico el sistema es factible.

### Factibilidad económica.

Se cuenta con un presupuesto limitado de horas de trabajo, las cuales se pueden descriminar de la siguiente forma: un promedio de 6 horas semanales por cada integrante del equipo (4 personas) durante un período de 4 a 5 meses. Este paquete de horas se utilizará para implementar los requerimientos planteados por el cliente. Si bien las características o funcionalidades completasd del producto que se construirá puese exceder el presupesto con el que se cuenta, si será posible entregar una versión funcional que conforme al cliente.

### Factibilidad operativa.

Respecto a este punto, el sistema requerirá un mínimo de mantenimiento operativo por lo que no se detectan problemas de factibilidad en este aspecto. Se planea contar con la figura de Administrador, el cual realizará el mantenimiento de usuarios (alta, baja y modificaciones). Fuera de esta tarea el sistio no requiere de más operativa para funcionar ya que cada profesor será el encargado de crear sus pruebas. Respecto al mantenimiento del hardware (servidor), realización de respaldos y administración de base de datos, el sistema requerirá un mínimo esfuerzo.


## Requerimientos Iteración I.

Como alumno debo poder realizar pruebas donde el tipo de pregunta sea de tipo verdadero o falso. El sistema deberá mostrar al finalizar la misma la corrección de la prueba realizada.

### Caso de uso.

