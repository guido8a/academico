package tutor

import geografia.Canton
import geografia.Parroquia

class AsignaturaController {

    def list(){
//        println "parametros: $params"
//        def asignaturas
//        if(params.carrera){
//            def carrera = Carrera.get(params.carrera)
//            def nivel = Nivel.get(params.nivel)
//            asignaturas = Asignatura.findAllByCarreraAndNivel(carrera,nivel)
//
//        }
//        else if(params.criterio?.size() > 0){
//            println "... no gestión"
//            asignaturas = Asignatura.findAllByNombreIlike("%${params.criterioGes}%",[sort: "nombre"])
//        }
//        else if(params.criterioGes?.size() > 1){
//            println "... gestión"
//            asignaturas = Asignatura.findAllByNombreIlikeAndTipoActividad("%${params.criterioGes}%", TipoActividad.get(2),
//                    [sort: "nombre"])
//        }
//        else if(params.criterioGes?.size() == 0){
//            println "solo gestión"
//            asignaturas = Asignatura.findAllByTipoActividad(TipoActividad.get(2), [sort: "nombre"])
//        }
//
//        println "asignaturas: $asignaturas"
//        params.criterio = params.criterio ? params.criterio: params.criterioGes
//
//        return[asignaturas: asignaturas]

        /* pruebas de código findAll si funciona pero sin relaciones **/
//        def cn = Parroquia.findAll{ it?.canton?.id == 1}  /* si funciona */
//        def cn = Parroquia.findAll{ it?.canton?.provincia?.id == 1}  /* no funciona */
//        def pp = Canton.findAllByProvinciaId
//        println "pp: $cn"

    }


    def form_ajax(){
        def asignatura
        println "form_ajax id: ${params.id}"

        if(params.id){
            asignatura = Asignatura.get(params.id)
        }else{
            asignatura = new Asignatura()
            asignatura.creditos = 5
            asignatura.horasTeoria = 3
            asignatura.horasPractica = 2
        }

        return[asignatura: asignatura]
    }

    def save_ajax(){
        println "guarda asignatura. Parámetros: $params"
        
        def asignatura
        if(params.id){
            asignatura = Asignatura.get(params.id)
        }else{
            asignatura = new Asignatura()
        }

        asignatura.properties = params
        asignatura.codigo = params.codigo.toUpperCase()
        asignatura.factorPreparacion = params.factorPreparacion.toDouble()
        asignatura.creditos = params.creditos.toDouble()
        asignatura.horasTeoria = params.horasTeoria.toDouble()
        asignatura.horasPractica = params.horasPractica.toDouble()
        asignatura.horasGestion = params.horasGestion.toDouble()

        if(!asignatura.save(flush:true)){
            println("error al guardar al asignatura " + asignatura.errors)
            render "no_Error al guardar la asignatura"
        }else{
            println "errores: ${asignatura.errors}"
            render "ok_Asignatura guardada correctamente"
        }
    }

    def delete_ajax(){
        def asignatura = Asignatura.get(params.id)

        try{
            asignatura.delete(flush:true)
            render "ok"
        }catch(e){
            println("error al borrar el asignatura " + asignatura.errors)
            render "no"
        }
    }

    def show_ajax(){
        def asignatura = Asignatura.get(params.id)
        return[asignatura:asignatura]
    }

    def tablaAsignaturas_ajax(){

        println "parametros: $params"

        def carrera = Carrera.get(params.carrera)
        def nivel = Nivel.get(params.nivel)
        def asignaturas

        if(params.tipo == '1'){
            if(params.criterio){
                asignaturas = Asignatura.findAllByNombreIlike("%${params.criterio}%",[sort: "nombre"])
            }else{
                if(params.carrera){
                    asignaturas = Asignatura.findAllByCarreraAndNivel(carrera,nivel,[sort: "nombre"])
                }else{
                    asignaturas = Asignatura.findAllByTipoActividad(TipoActividad.get(1), [sort: "nombre"])
                }
            }
        }else{
            if(params.criterio){
                asignaturas = Asignatura.findAllByNombreIlikeAndTipoActividad("%${params.criterio}%", TipoActividad.get(2))
            }else{
                asignaturas = Asignatura.findAllByTipoActividad(TipoActividad.get(2), [sort: "nombre"])
//                asignaturas = Asignatura.findAllByTipoActividadAndCarreraAndNivel(TipoActividad.get(2), carrera, nivel,  [sort: "nombre"])
            }
        }




//        if(params.carrera){
//            def carrera = Carrera.get(params.carrera)
//            def nivel = Nivel.get(params.nivel)
//            asignaturas = Asignatura.findAllByCarreraAndNivel(carrera,nivel)
//
//        }
//        else if(params.criterio?.size() > 0){
//            println "... no gestión"
//            asignaturas = Asignatura.findAllByNombreIlike("%${params.criterioGes}%",[sort: "nombre"])
//        }
//        else if(params.criterioGes?.size() > 1){
//            println "... gestión"
//            asignaturas = Asignatura.findAllByNombreIlikeAndTipoActividad("%${params.criterioGes}%", TipoActividad.get(2),
//                    [sort: "nombre"])
//        }
//        else if(params.criterioGes?.size() == 0){
//            println "solo gestión"
//            asignaturas = Asignatura.findAllByTipoActividad(TipoActividad.get(2), [sort: "nombre"])
//        }

//        println "asignaturas: $asignaturas"
//        params.criterio = params.criterio ? params.criterio: params.criterioGes

        return[asignaturas: asignaturas]

    }

}
