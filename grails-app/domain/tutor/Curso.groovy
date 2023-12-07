package tutor

class Curso {

    Paralelo paralelo
    Asignatura asignatura
    String nrc

    static mapping = {
        table 'crso'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'crso_id'
        id generator: 'identity'
        version false
        columns {
            id column: 'crso__id'
            paralelo column: 'parl__id'
            asignatura column: 'asig__id'
            nrc column: 'crso_nrc'
        }
    }
    static constraints = {
        paralelo(blank: true, nullable: true, attributes: [title:'asignatura'])
        asignatura(blank: true, nullable: true, attributes: [title:'asignatura'])
        nrc(size: 1..7, blank: true, nullable: true, attributes: [title:'nrc'])
    }

}
