package tutor

class TipoActividad {

    String descripcion

    static mapping = {
        table 'tpaa'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'tpaa__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'tpaa__id'
            descripcion column: 'tpaadscr'
        }
    }

    static constraints = {
        descripcion(size: 1..255, blank: false, nullable: false, attributes: [title: 'descripcion'])
    }

    String toString() {
        "${this.descripcion}"
    }
}
