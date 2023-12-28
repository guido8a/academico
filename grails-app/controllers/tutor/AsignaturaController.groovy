package tutor

class AsignaturaController {

    def list(){
        println "parametros: $params"
        def asignaturas
        if(params.carrera){
            def carrera = Carrera.get(params.carrera)
            def nivel = Nivel.get(params.nivel)
            asignaturas = Asignatura.findAllByCarreraAndNivel(carrera,nivel)

        }
        else if(params.criterio?.size() > 0){
            println "... no gestión"
            asignaturas = Asignatura.findAllByNombreIlike("%${params.criterioGes}%",[sort: "nombre"])
        }
        else if(params.criterioGes?.size() > 1){
            println "... gestión"
            asignaturas = Asignatura.findAllByNombreIlikeAndTipoActividad("%${params.criterioGes}%", TipoActividad.get(2),
                    [sort: "nombre"])
        }
        else if(params.criterioGes?.size() == 0){
            println "solo gestión"
            asignaturas = Asignatura.findAllByTipoActividad(TipoActividad.get(2), [sort: "nombre"])
        }

        println "asignaturas: $asignaturas"
        params.criterio = params.criterio ? params.criterio: params.criterioGes

        return[asignaturas: asignaturas]
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

}
