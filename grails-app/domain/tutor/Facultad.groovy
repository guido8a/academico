package tutor

class Facultad {
    String nombre;

    static mapping = {
        table 'facl'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'facl__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'facl__id'
            nombre column: 'faclnmbr'
        }
    }
    static constraints = {
        nombre(size: 1..127, blank: false, nullable: false, attributes: [title: 'nombre  de la facultad'])
    }
}
