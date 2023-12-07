package tutor

class Periodo {

    String descripcion

    static mapping = {
        table 'prdo'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'prdo__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'prdo__id'
            descripcion column: 'prdodscr'
        }
    }

    static constraints = {
        descripcion(size: 1..15, blank: false, nullable: false, attributes: [title: 'descripcion'])
    }

    String toString() {
        "${this.descripcion}"
    }
}
