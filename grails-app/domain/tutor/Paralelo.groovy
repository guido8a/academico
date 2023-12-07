package tutor

class Paralelo {

    Periodo periodo
    Nivel nivel
    Integer numero
    Integer numEstudiantes
    Integer cupo


    static mapping = {
        table 'parl'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'parl_id'
        id generator: 'identity'
        version false
        columns {
            id column: 'parl__id'
            periodo column: 'prdo__id'
            nivel column: 'nvel__id'
            numero column: 'parlnmro'
            numEstudiantes column: 'parlestd'
            cupo column: 'parlcupo'
        }
    }
    static constraints = {
        periodo(blank: true, nullable: true, attributes: [title:'Periodo académmico'])
        nivel(blank: true, nullable: true, attributes: [title:'nivel'])
        numero(blank: true, nullable: true, attributes: [title:'numero'])
        numEstudiantes(blank: true, nullable: true, attributes: [title:'numEstudiantes'])
        cupo(blank: true, nullable: true, attributes: [title:'cupo'])
    }

}