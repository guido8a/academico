package tutor

class Matricula   {

    Curso curso
    Estudiante estudiante
    Date fecha
    Double valor

    static mapping = {
        table 'matr'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'matr__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'matr__id'
            curso column: 'crso__id'
            estudiante column: 'estu__id'
            fecha column: 'matrfcha'
            valor column: 'matrvalr'
        }
    }

    /**
     * Define las restricciones de cada uno de los campos
     */
    static constraints = {
        curso(blank: true, nullable: true)
        estudiante(blank: true, nullable: true)
        fecha(blank: true, nullable: true)
    }

}
