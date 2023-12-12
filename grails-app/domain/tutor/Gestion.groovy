package tutor

class Gestion {

    Periodo periodo
    Asignatura asignatura
    Profesor profesor
    int hora
    String observaciones

    static mapping = {
        table 'gstn'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'gstn_id'
        id generator: 'identity'
        version false
        columns {
            id column: 'gstn__id'
            periodo column: 'prdo__id'
            asignatura column: 'asig__id'
            profesor column: 'prof__id'
            hora column: 'gstnhora'
            observaciones column: 'gstnobsr'
        }
    }
    static constraints = {
        periodo(blank: false, nullable: false, attributes: [title:'periodo'])
        profesor(blank: false, nullable: false, attributes: [title:'profesor'])
        asignatura(blank: false, nullable: false, attributes: [title:'asignatura'])
        hora(blank: false, nullable: false, attributes: [title:'hora'])
        observaciones(blank: true, nullable: true, attributes: [title:'observaciones'])
    }
}
