package tutor

import groovy.sql.Sql

class ProgramaController {

    def dataSource

    def getConnection(){
        Sql sql = new Sql(dataSource)
        return sql
    }


    def index() { }

    def horario() {
//        def asignatura = Asignatura.get(params.id)
//        def horas = Hora.list([sort: 'numero'])
//        def dias  = Dias.list([sort: 'numero'])

//        def horario = Horario.findAllByParalelo( Paralelo.get(1))

//        println "horario: ${horario}"
//        println "dias: ${ horario.dias }, horas: ${horario.hora.id} --> ${ horario.dias.id.contains( 1.toLong() )}"
//        println " --> ${ horario.dias.id[0].class}"

    }

    def creaParalelo(){
        println "creaParalelo $params"
        def paralelo
        def asignatura = Asignatura.get(params.asig)

        if(params.id){
            paralelo = Paralelo.get(params.id)
        }else{
            paralelo = new Paralelo()
        }
        return[paralelo: paralelo, asignatura: asignatura]
    }

    def grabaParalelo(){
        println "creaParalelo $params"
        def paralelo

        if(params.id){
            paralelo = Paralelo.get(params.id)
        }else{
            paralelo = new Paralelo()
        }
        paralelo.properties = params
        paralelo.asignatura = Asignatura.get(params.asig)

        if(!paralelo.save(flush:true)){
            println("error al guardar el paralelo " + paralelo.errors)
            render "no"
        }else{
            println "errores: ${paralelo.errors}"
            flash.message = "Datos del paralelo ${paralelo?.id} actualizados"
            render "ok"
        }
    }

    def delete_ajax(){
        println "delete ajax"
        def paralelo = Paralelo.get(params.id)

        try {
            paralelo.delete(flush: true)
            render "ok"
        } catch (e) {
            println("error al borrar la paralelo " + paralelo.errors)
            render "no"
        }
    }

    def borra_ajax(){
        println "borra_ajax"
        def horario = Horario.get(params.id)

        try {
            horario.delete(flush: true)
            render "ok"
        } catch (e) {
            println("error al borrar la hora " + horario.errors)
            render "no"
        }
    }

    def creaHora(){
        println "creaHora $params"
        def horario = new Horario()
        def asignatura = Asignatura.get(params.asig)

        horario.properties = params
        render "<h3 style='text-align: center'>Crear hora</h3>"
    }

    def tabla_ajax(){
        def cn = getConnection()
        println("tabla_ajax " + params)
        def asignatura = Asignatura.get(params.asig)
        def paralelo   = Paralelo.get(params.parl)
        def horas = Hora.list([sort: 'numero'])
        def dias  = Dias.list([sort: 'numero'])
        def clases = []

        def curso = Curso.findAllByAsignaturaAndParalelo(asignatura, paralelo)
//        def horario = Horario.findAllByParalelo( Paralelo.get(params.parl))


        def sql = "select * from horario(${asignatura.nivel.id}, ${params.parl}, ${params.asig})"
        def resp = cn.rows(sql.toString())
        println "sql --> $sql"

//        println "horario: ${horario}"
//        println "dias: ${ horario.dias }, horas: ${horario.hora.id} --> ${ horario.dias.id.contains( 1.toLong() )}"
//        println "**dias: ${dias}, horas: ${horas}"
        //println " --> ${ horario?.dias?.id[0].class}"

        println "horario: $resp"

        //return[asignatura: asignatura, horas: horas, dias: dias, horario: horario,
        return[asignatura: asignatura, horas: horas, dias: dias, horario: resp,
               clases: clases]
    }


    def crea_ajax() {
        println "crea_ajax: $params"
        def asig = Asignatura.get(params.asig)
        def parl = Paralelo.get(params.parl)
        def crso = Curso.findByAsignaturaAndParalelo(asig, parl)
        def horario = new Horario()

        if(!crso){
            crso = new Curso()
            crso.paralelo = parl
            crso.asignatura = asig
            crso.nrc = '0'
            crso.numEstudiantes = 22
            crso.cupo = 22
        }

        try {
            crso.save(flush: true)
        } catch (e) {
            println("error al crear el horario " + horario.errors)
        }


        horario.curso = crso
        horario.dias = Dias.get(params.dia)
        horario.hora = Hora.get(params.hora)

        try {
            horario.save(flush: true)
            println "creado horario"
            render "ok"
        } catch (e) {
            println("error al crear el horario " + horario.errors)
            render "no"
        }
    }



}
