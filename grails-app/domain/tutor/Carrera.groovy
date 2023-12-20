package tutor

class Carrera {
    Facultad facultad;
    String nombre
    String codigo

    static mapping = {
        table 'carr'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'carr__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'carr__id'
            facultad column: 'facl__id'
            nombre column: 'carrnmbr'
            codigo column: 'carrcdgo'
        }
    }
    static constraints = {
        facultad(blank: true, nullable: true, attributes: [mensaje: 'Carrera pertenece a facultad'])
        nombre(size: 1..63, blank: false, nullable: false, attributes: [title: 'nombre  de la Carrera'])
        codigo(size: 1..7, blank: false, nullable: false, attributes: [title: 'código de la Carrera'])
    }

    String toString() {
        "${this.nombre}"
    }
}
