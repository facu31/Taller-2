# Taller-2

Composición grupo de trabajo:

Gabriel Aramburu
Diego Gandaria
Facundo Olaizola


**MODELO ITERATIVOINCREMENTAL**

El incremental es un modelo de tipo evolutivo que está basado en varios ciclos Cascada realimentados aplicados repetidamente, con
una filosofía iterativa. El modelo incremental es útil sobre todo cuando el personal necesario para una implementación completa no esta disponible.

**Ventajas**

-Se reduce el tiempo de desarrollo inicial, ya que se implementa la funcionalidad parcial.

-Proporciona todas las ventajas del modelo en cascada
realimentado, reduciendo sus desventajas sólo al ámbito de
cada incremento.

-Los modelos iterativos e incrementales disminuyen riesgos. ya
que estos modelos se basan en la retroalimentación sobre los
avances.

-Resulta más sencillo acomodar cambios al acotar el tamaño
de los incrementos.

**Desventajas**

-El modelo Incremental no es recomendable para casos de sistemas de tiempo real, de alto nivel de seguridad, de procesamiento distribuido
y/o de alto índice de riesgos.

-Requiere de mucha planificación, tanto administrativa como técnica.

-Requiere de metas claras para conocer el estado del proyecto.

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

### Porque se elige.

La misma ofrece la posibilidad de realizar entregas parciales al cliente, cada entrega brindará información acerca del avance y permitirá realizar ajustes en los requerimientos definidos. 
Nos permite comenzar a trabajar con un nivel de requerimientos suficiente pero no necesariamente completos y definidos con detalle. 
Permite planificar los plazos de entregas, dividiendo la construcción en intervalos de tiempo tomando en cuenta la limitaciones de horas de trabajo y fecha límite de entrega. 
Estas características también las ofrece la metodología Scrum, sin embargo creemos que la iterativa incremental se adapta mejor a las característica del equipo y el cliente.
