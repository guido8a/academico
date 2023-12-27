package tutor

class FacultadController {

    def list(){
        def facultades = Facultad.list().sort{it.nombre}
        return[facultades: facultades]
    }

    def form_ajax(){

        def facultad

        if(params.id){
            facultad = Facultad.get(params.id)
        }else{
            facultad = new Facultad()
        }

        return[facultad:facultad]
    }

    def saveFacultad_ajax(){
        def facultad

        if(params.id){
            facultad = Facultad.get(params.id)
        }else{
            facultad = new Facultad()
        }

        facultad.properties = params

        if(!facultad.save(flush: true)){
            println("error al gaurdar la facultad " + facultad.errors)
            render "no_Error al guardar la facultad"
        }else{
            render "ok_Facultad guardada correctamente"
        }
    }

    def delete_ajax(){

        def facultad = Facultad.get(params.id)

        if(facultad){

            try{
                facultad.delete(flush:true)
                render "ok_Borrado correctamente"
            }catch(e){
                println("error al borrar el facultad")
                render "no_Error al borrar la facultad"
            }

        }else{
            render "no_Error al borrar la facultad"
        }
    }

}
