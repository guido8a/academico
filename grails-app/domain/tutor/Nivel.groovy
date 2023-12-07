package tutor

class Nivel {

    String descripcion
    int numero

    static mapping = {
        table 'nvel'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'nvel__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'nvel__id'
            descripcion column: 'nveldscr'
            numero column: 'nvelnmro'
        }
    }

    static constraints = {
        descripcion(size: 1..255, blank: false, nullable: false, attributes: [title: 'descripcion'])
    }


    String toString() {
        "${this.descripcion}"
    }
}
