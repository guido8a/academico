package tutor

class Dicta {

    Curso curso
    Profesor profesor

    static mapping = {
        table 'dcta'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'dcta__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'dcta__id'
            curso column: 'crso__id'
            profesor column: 'prof__id'
        }
    }
/*
    Entender la lògica sobre los 'null' de Dicta
*/
    static constraints = {
        profesor(blank: true, nullable: true, attributes: [mensaje: 'Profesor que dicta'])
        curso(size: 1..63, blank: true, nullable: true, attributes: [mensaje: 'Paralelo donde se dicta'])
    }

}
