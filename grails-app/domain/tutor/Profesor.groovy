package tutor

class Profesor {

    TipoProfesor tipoProfesor
    String nombre
    String apellido
    String mail
    String extension
    String sexo

    static mapping = {
        table 'prof'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'prof__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'prof__id'
            tipoProfesor column: 'tppr__id'
            nombre column: 'profnmbr'
            apellido column: 'profapll'
            mail column: 'profmail'
            extension column: 'profextn'
            sexo column: 'profsexo'
        }
    }

    static constraints = {
        nombre(size: 1..63, blank: false, nullable: false, attributes: [title: 'nombre'])
        apellido(size: 1..63, blank: false, nullable: false, attributes: [title: 'apellido'])
        mail(email: true, blank: false, nullable: false, maxSize: 255, attributes: [title: 'mail'])
        extension(maxSize: 255, blank: true, nullable: true, attributes: [title: 'extension'])
        sexo(inList: ["M", "F"], blank: false, nullable: false, maxSize: 15, attributes: [title: 'sexo'])
    }
}
