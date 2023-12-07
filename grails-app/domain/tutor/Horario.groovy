package tutor

class Horario {

    Curso curso
    Dias dias
    Hora hora


    /**
     * Define el mapeo entre los campos del dominio y las columnas de la base de datos
     */
    static mapping = {
        table 'horr'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'horr__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'horr__id'
            curso column: 'crso__id'
            dias column: 'dias__id'
            hora column: 'hora__id'
        }
    }
    /**
     * Define las restricciones de cada uno de los campos
     */
    static constraints = {
        curso(blank: false, nullable: false, attributes: [mensaje: 'Paralelo al que pertenece el horario'])
        dias(blank: false, nullable: false, attributes: [mensaje: 'Dias que constan en el horario'])
        hora(blank: false, nullable: false, attributes: [mensaje: 'Hora de la clase'])

    }
}