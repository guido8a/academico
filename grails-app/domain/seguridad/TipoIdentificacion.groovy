package seguridad

class TipoIdentificacion implements Serializable {

    String codigo
    String descripcion
    String codigoSri

    static auditable = true

    static mapping = {
        table 'tpid'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'tpid__id'
        id generator: 'identity'
        version false
        columns {
            codigo column: 'tpidcdgo'
            descripcion column: 'tpiddscr'
            codigoSri column: 'tpidcdsr'
        }
    }
    static constraints = {
        codigo(size: 1..4, blank: false, attributes: [title: 'codigo'])
        descripcion(blank: false, maxSize: 63, attributes: [title: 'Identificción principal'])
        codigoSri(maxSize: 2, blank: true, nullable: true)
    }
}