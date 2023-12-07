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
        println "guarda facultad. Paràmetros: $params"
        def facultad

        if(params.id){
            facultad = Facultad.get(params.id)
        }else{
            facultad = new Facultad()
        }

        facultad.properties = params
        if(!facultad.save(flush:true)){
            println("error al guardar la facultad " + facultad.errors)
            render "no"
        }else{
            println "errores: ${facultad.errors}"
            render "ok"
        }
    }

    def delete_ajax(){
        def facultad = Facultad.get(params.id)

        try{
            facultad.delete(flush:true)
            render "ok"
        }catch(e){
            println("error al borrar la facultad " + facultad.errors)
            render "no"
        }
    }

    def show_ajax(){
        println "show: $params"
        def facultad = Facultad.get(params.id)
        return [facultad: facultad]
    }

}
