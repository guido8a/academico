package tutor

class Asignatura {

    Carrera carrera
    Nivel nivel
    TipoActividad tipoActividad
    String codigo
    String nombre
    int creditos
    int horasTeoria
    int horasPractica
    int factorPreparacion = 0.5
    int horasGestion

    /**
     * Define el mapeo entre los campos del dominio y las columnas de la base de datos
     */
    static mapping = {
        table 'asig'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'asig__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'asig__id'
            carrera column: 'carr__id'
            nivel column: 'nvel__id'
            tipoActividad column: 'tpac__id'
            nombre column: 'asignmbr'
            codigo column: 'asigcdgo'
            creditos column: 'asigcred'
            horasTeoria column: 'asighrte'
            horasPractica column: 'asighrpr'
            factorPreparacion column: 'asigfcpr'
            horasGestion column: 'asighrgs'
        }
    }

    /**
     * Define las restricciones de cada uno de los campos
     */
    static constraints = {
        carrera(nullable: true, attributes: [mensaje: 'Carrera a la que pertenece la asignatura'])
        nivel(nullable: true, attributes: [mensaje: 'Nivel de la asignatura'])
        tipoActividad(nullable: true, attributes: [mensaje: 'Tipo de actividad de la asignatura'])
        codigo(size: 1..15, blank: true, nullable: false, attributes: [mensaje: 'Código de la asignatura'])
        nombre(size: 1..63, blank: true, nullable: false, attributes: [mensaje: 'Nombre de la asignatura'])
        creditos(nullable: true, attributes: [mensaje: 'Número de créditos de la asignatura'])
        horasTeoria(nullable: true, attributes: [mensaje: 'Horas teóricas de la asignatura'])
        horasPractica(nullable: true, attributes: [mensaje: 'Horas prácticas de la asignatura'])
        factorPreparacion(nullable: true, attributes: [mensaje: 'Factor de créditos de la asignatura'])
        horasGestion(nullable: true, attributes: [mensaje: 'Horas de gestión y supervisión de la asignatura'])
    }

    /**
     * Genera un string para mostrar
     */
    String toString() {
        return this.nombre
    }
}
