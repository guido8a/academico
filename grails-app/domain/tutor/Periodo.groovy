package tutor

class Periodo {

    String descripcion
    Periodo padre
    String tipo
    int semanas
    String activo

    static mapping = {
        table 'prdo'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'prdo__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'prdo__id'
            padre column: 'prdopdre'
            descripcion column: 'prdodscr'
            tipo column: 'prdotipo'
            semanas column: 'prdosmna'
            activo column: 'prdoactv'
        }
    }

    static constraints = {
        padre(blank: true, nullable: true, attributes: [title: 'Periodo padre'])
        descripcion(size: 1..31, blank: false, nullable: false, attributes: [title: 'descripción'])
        tipo(size: 1..1, blank: false, nullable: false, attributes: [title: 'tipo'])
        semanas(blank: false, nullable: false, attributes: [title: 'semanas de duración'])
        activo(blank: true, nullable: true, attributes: [title: 'activo para programación'])
    }

    String toString() {
        "${this.descripcion}"
    }
}
