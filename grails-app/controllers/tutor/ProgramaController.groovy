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
    }

    def profesor() {
    }

    def prof_ajax(){
        def cn = getConnection()
        println("prof_ajax " + params)

        if(params.prof){
            def horas = Hora.list([sort: 'numero'])
            def dias  = Dias.list([sort: 'numero'])
            def sql = "select * from profesor(${params.prof})"
            def resp = cn.rows(sql.toString())
            println "sql --> $sql"
            sql = "select count(*) cnta from profesor(${params.prof}) where length(coalesce(lun, '')||" +
                    "coalesce(mar, '')||coalesce(mie, '')||coalesce(jue, '')||coalesce(vie, '')||" +
                    "coalesce(sab, '')||coalesce(dom, '')) > 0"
            def existe = cn.rows(sql.toString())[0]?.cnta
            println "3existe: $existe"
            return[existe: existe, horas: horas, dias: dias, horario: resp]
        }else{
            return[existe: false]
        }
    }


    def paralelo() {
    }

    def parl_ajax(){
        def cn = getConnection()
        println("parl_ajax " + params)

        if(params.parl){
            def horas = Hora.list([sort: 'numero'])
            def dias  = Dias.list([sort: 'numero'])
            def sql = "select * from paralelo(${params.parl})"
            def resp = cn.rows(sql.toString())
            println "sql --> $sql"
//            sql = "select count(*) cnta from profesor(${params.prof}) where length(coalesce(lun, '')||" +
//                    "coalesce(mar, '')||coalesce(mie, '')||coalesce(jue, '')||coalesce(vie, '')||" +
//                    "coalesce(sab, '')||coalesce(dom, '')) > 0"
//            def existe = cn.rows(sql.toString())[0]?.cnta
            def existe = true
            println "Existe: $existe"
            return[existe: existe, horas: horas, dias: dias, horario: resp]
        }else{
            return[existe: false]
        }
    }

    def cursos_ajax(){
        println "cursos_ajax: $params"
        def periodo = Periodo.get(params.periodo)
        def nivel   = Nivel.get(params.nivel)
        def cursos = Paralelo.findAllByPeriodoAndNivel(periodo, nivel)
        return[cursos: cursos]
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
            def dicta = Dicta.findByCurso(curso)

            def sql = "select * from horario(${asignatura.nivel.id}, ${params.parl}, ${params.asig})"
            def resp = cn.rows(sql.toString())
            println "sql --> $sql"

            println " Dicta: --> ${ dicta?.profesor?.nombre}"

            println "horario: $resp"

            //return[asignatura: asignatura, horas: horas, dias: dias, horario: horario,
            return[asignatura: asignatura, horas: horas, dias: dias, horario: resp,
                   clases: clases, existe: true, profesor: dicta?.profesor]
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

    def dictan_ajax(){
        def periodo = Periodo.get(params.periodo)
        def paralelo = []
        def asignatura = []

        return[asignatura: asignatura]
    }

    def paralelo_ajax(){
        def periodo = Periodo.get(params.periodo)
        def nivel = Nivel.get(params.nivel)
        def paralelos = Paralelo.findAllByNivelAndPeriodo(nivel, periodo, [sort: 'numero'])
//        def asignatura = Asignatura.findAllByNivelAndTipoActividad(nivel, TipoActividad.get(1), [sort: 'nombre'])

//        return[nivel: nivel, paralelos: paralelos, asignatura: asignatura]
        return[nivel: nivel, paralelos: paralelos]
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

    def profesores_ajax(){
        def paralelo = Paralelo.get(params.paralelo)
        def asignatura = Asignatura.get(params.asignatura)
        return[asignatura: asignatura, paralelo: paralelo]
    }

    def tablaProfesorAsignado_ajax(){
        def paralelo = Paralelo.get(params.paralelo)
        def asignatura = Asignatura.get(params.asignatura)
        def curso = Curso.findByParaleloAndAsignatura(paralelo, asignatura)
        def dicta
        if(curso){
            dicta = Dicta.findByCurso(curso)
        }else{
            dicta = null
        }
        return[dicta:dicta, paralelo: paralelo, asignatura: asignatura]
    }

    def saveProfesor_ajax(){
        def paralelo = Paralelo.get(params.paralelo)
        def asignatura = Asignatura.get(params.asignatura)
        def curso = Curso.findByParaleloAndAsignatura(paralelo, asignatura)
        def profesor = Profesor.get(params.profesor)
        def dicta

        if(!curso){
            curso = new Curso()
            curso.paralelo = paralelo
            curso.asignatura = asignatura
            curso.nrc = '0'
            curso.numEstudiantes = 22
            curso.cupo = 22

            if(!curso.save(flush:true)){
                render "no_Error al crear el curso"
                return
            }
        }

        if(profesor){
            def existeProfesor = Dicta.findByCursoAndProfesor(curso, profesor)
            def existe = Dicta.findByCurso(curso)

            if(existeProfesor){
                render "no_El profesor seleccionado ya fue asignado al curso"
                return
            }else{
                if(existe?.profesor){
                    render "no_Ya existe un profesor asignado al curso"
                    return
                }else{
                    dicta = new Dicta()
                    dicta.profesor = profesor
                    dicta.curso = curso

                    if(!dicta.save(flush:true)){
                        println("error al guardar el profesor" + dicta.errors)
                        render "no_Error al guardar el profesor"
                    }else{
                        render "ok_Profesor asignado correctamente"
                    }
                }
            }

        }else{
            render "no_Seleccione un profesor"
            return
        }
    }

    def deleteProfesor_ajax(){

        def dicta = Dicta.get(params.id)

        try{
            dicta.delete(flush:true)
            render "ok_Borrado correctamente"
        }catch(e){
            println("error al borrar")
            render "no_Error al borrar"
        }
    }

    def asignatura_ajax(){
        def paralelo = Paralelo.get(params.paralelo)
        def asignaturas
        if(paralelo){
            asignaturas = Asignatura.findAllByCarreraAndNivel(paralelo.carrera, paralelo.nivel)
        }else{
            asignaturas = []
        }
        return [asignaturas: asignaturas]
    }

}
