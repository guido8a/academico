package tutor

class Carrera {
    Facultad facultad;
    String nombre;

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
        }
    }
    static constraints = {
        facultad(blank: true, nullable: true, attributes: [mensaje: 'Carrera pertenece a facultad'])
        nombre(size: 1..63, blank: false, nullable: false, attributes: [title: 'nombre  de la Carrera'])
    }

    String toString() {
        "${this.nombre}"
    }
}
