package tutor

class TipoProfesor {
    String descripcion
    //    static auditable = false
    /**
     * Define el mapeo entre los campos del dominio y las columnas de la base de datos
     */
    static mapping = {
        table 'tppr'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'tppr__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'tppr__id'
            descripcion column: 'tpprdscr'
        }
    }
    /**
     * Define las restricciones de cada uno de los campos
     */
    static constraints = {
        descripcion(size: 3..31, blank: true, nullable: true, attributes: [mensaje: 'DescripciÃ³n de profesor'])
    }
}