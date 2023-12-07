package tutor

class Estudiante {

    String nombre
    String apellido
    String mail
    String sexo


    static mapping = {
        table 'estu'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'estu__id'
        id generator: 'identity'
        version false
        columns {
            id column: 'estu__id'
            nombre column: 'estunmbr'
            apellido column: 'estuapll'
            mail column: 'estumail'
            sexo column: 'estusexo'
        }
    }
    
    static constraints = {
        nombre(size: 1..63, blank: false, nullable: false, attributes: [title: 'nombre'])
        apellido(size: 1..63, blank: false, nullable: false, attributes: [title: 'apellido'])
        mail(size: 1..63, blank: false, nullable: false, attributes: [title: 'mail'])
        sexo(size: 1..2, blank: false, nullable: false, attributes: [title: 'sexo'])

    }
}
