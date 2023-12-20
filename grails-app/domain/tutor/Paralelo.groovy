package tutor

class Paralelo {

    Periodo periodo
    Carrera carrera
    Nivel nivel
    String numero
    Integer numEstudiantes = 1
    Integer cupo = 1


    static mapping = {
        table 'parl'
        cache usage: 'read-write', include: 'non-lazy'
        id column: 'parl_id'
        id generator: 'identity'
        version false
        columns {
            id column: 'parl__id'
            periodo column: 'prdo__id'
            carrera column: 'carr__id'
            nivel column: 'nvel__id'
            numero column: 'parlnmro'
            numEstudiantes column: 'parlestd'
            cupo column: 'parlcupo'
        }
    }
    static constraints = {
        periodo(blank: false, nullable: false, attributes: [title:'Periodo académmico'])
        carrera(blank: false, nullable: false, attributes: [title:'Periodo académmico'])
        nivel(blank: false, nullable: false, attributes: [title:'nivel'])
        numero(blank: false, nullable: false, attributes: [title:'numero'])
        numEstudiantes(blank: true, nullable: true, attributes: [title:'numEstudiantes'])
        cupo(blank: true, nullable: true, attributes: [title:'cupo'])
    }

}