						                    
README
								
activity/fragment <-> viewModel <-> repository <-> DataSource | Model
                                        	


data
    local:	 componentes relacionados al almacenamiento a través de Room
    model:	 data class y entidades de la solución
    remote: clases encargadas de acceder y obtener la información desde el servicio web
    repository: crea una acceso entre el viewmodel y las fuentes de datos (web service y base de datos)

di
    AppModule: provee acceso a funciones reutilizables por medio de inyección de dependencias a través de Hilt

util
    Resource: clase base para encapsular las respuestas recibidas desde el repositorio de acuerdo a su estado
    DataAccessStrategy: Establece una clase base para acceder tanto a la fuente de datos local y remota a través de corrutinas
    AutoClearedValue: clase de ayuda para remover los valores asociados al fragmento al destruirse por medio de delegación de propiedades

feature
    activity / fragment: Interfaces gráficas de la aplicación
    viewModel: se encarga de mantener y manejar el flujo de datos recibido desde el repositorio y exponerlo a la UI


Patrones de diseño

Corrutinas:  Patron de simultaneidad integrado a Kotlin para ejecutar bloques de codigo de forma asincrona

Repositorio: Patron encargado de desacoplar la logica manejada en el viewModel de las capas de persitencia y flujo de datos

Inyeccion de dependencias: Se encarga de la creacion de instancias y reutilizacion de los componentes a traves de Hilt

Singleton: Creacion de una unica instancia en tiempo de ejecucion de la aplicacion de un componente o funcionalidad realizado a traves de Hilt
