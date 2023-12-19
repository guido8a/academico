package tutor

class TipoActividadController {
    def list(){
        def tipoActividades = TipoActividad.list().sort{it.descripcion}
        return[tipoActividades: tipoActividades]
    }

    def form_ajax(){

        def tipoActividad

        if(params.id){
            tipoActividad = TipoActividad.get(params.id)
        }else{
            tipoActividad = new TipoActividad()
        }

        return[tipoActividad: tipoActividad]
    }

    def saveTipoActividad_ajax(){
        println "guarda tipoActividad. Paràmetros: $params"
        def tipoActividad

        if(params.id){
            tipoActividad = TipoActividad.get(params.id)
        }else{
            tipoActividad = new TipoActividad()
        }

        tipoActividad.properties = params

        if(!tipoActividad.save(flush:true)){
            println("error al guardar el tipo de actividad " + tipoActividad.errors)
            render "no_Error al guardar el tipo de actividad"
        }else{
            render "ok_Tipo de actividad guardado correctamente"
        }
    }

    def delete_ajax(){
        def tipoActividad = TipoActividad.get(params.id)

        try{
            tipoActividad.delete(flush:true)
            render "ok"
        }catch(e){
            println("error al borrar la tipoActividad " + tipoActividad.errors)
            render "no"
        }
    }

    def show_ajax(){
        def tipoActividad = TipoActividad.get(params.id)
        return[tipoActividad: tipoActividad]
    }
}
