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

    def gestion() {
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

        if(params.parl){
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
                   clases: clases, existe: true]
        }else{
            return[existe: false]
        }



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

    def paralelo_ajax(){
        def periodo = Periodo.get(params.periodo)
        def nivel = Nivel.get(params.nivel)
        def paralelo = Paralelo.findAllByNivelAndPeriodo(nivel, periodo, [sort: 'numero'])
        def asignatura = Asignatura.findAllByNivelAndTipoActividad(nivel, TipoActividad.get(1), [sort: 'nombre'])

        return[nivel: nivel, paralelo: paralelo, asignatura: asignatura]
    }

    def tablaGestion_ajax(){
        def periodo = Periodo.get(params.id)
        def gestiones = Gestion.findAllByPeriodo(periodo)

        return[gestiones: gestiones, periodo: periodo]
    }

    def guardarGestion_ajax(){
        println("params " + params)

        def periodo = Periodo.get(params.periodo)
        def profesor = Profesor.get(params.profesor)
        def asignatura = Asignatura.get(params.asignatura)

        def gestion
        def existe = Gestion.findByPeriodoAndAsignaturaAndProfesor(periodo, asignatura, profesor)

        if(params.id){
            gestion = Gestion.get(params.id)

            if(existe.id == gestion.id){
                gestion.asignatura = asignatura
                gestion.hora = params.hora.toInteger()
            }else{
                render "no_La asignatura seleccionada ya fue asignada al profesor"
                return
            }

        }else{

            if(existe){
                render "no_La asignatura seleccionada ya fue asignada al profesor"
                return
            }else{
                gestion = new Gestion()
                gestion.periodo = periodo
                gestion.asignatura = asignatura
                gestion.hora = params.hora.toInteger()
                gestion.profesor = profesor
            }
        }

        if(!gestion.save(flush:true)){
            println("error al guardar la gestion " + gestion.errors)
            render "no_Error al guardar"
        }else{
            render "ok_Guardado correctamente"
        }
    }

    def borrarGestion_ajax(){
        def gestion = Gestion.get(params.id)

        try{
            gestion.delete(flush:true)
            render "ok_Borrado correctamente"
        }catch(e){
            println("error al borrar " + gestion.errors)
            render "no_Error al borrar"
        }
    }

    def observaciones_ajax(){
        def gestion = Gestion.get(params.id)
        return[gestion: gestion]
    }

    def saveObservaciones_ajax(){
        def gestion = Gestion.get(params.id)

        if(gestion){
            gestion.observaciones = params.observaciones
        }else{
            render "no_Error al guardar las observaciones"
            return
        }

        if(!gestion.save(flush:true)){
            render "no_Error al guardar las observaciones"
            println("Error al guardar las observaciones " + gestion.errors)
        }else{
            render "ok_Guardado correctamente"
        }

    }


}
