package tutor

class Perfil {

    String codigo
    String nombre
    String descripcion

    // Configuración de mapeo
    static mapping = {
        table 'prfl'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'prfl__id'
        id generator: 'identity'
        version false
        columns{
            id column: 'prfl__id'
            codigo column: 'prflcdgo'
            nombre column: 'prflnmbr'
            descripcion column: 'prfldscr'
        }

    }

    // Restricciones
    static constraints = {
        codigo(size: 1..4, blank: false, nullable: false, attributes: [title: 'codigo'])
        nombre(size: 1..63, blank: false, nullable: false, attributes: [title: 'nombre'])
        descripcion(size: 1..63, blank: false, nullable: false, attributes: [title: 'descripcion'])
    }

    // Método toString para representación de texto
    String toString() {
        return this.nombre
    }
}
