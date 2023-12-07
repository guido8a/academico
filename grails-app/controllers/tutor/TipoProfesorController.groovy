package tutor

class TipoProfesorController {
    def list(){
        def tipoProfesores = TipoProfesor.list().sort{it.descripcion}
        return[tipoProfesores: tipoProfesores]
    }

    def form_ajax(){

        def tipoProfesor

        if(params.id){
            tipoProfesor = TipoProfesor.get(params.id)
        }else{
            tipoProfesor = new TipoProfesor()
        }

        return[tipoProfesor:tipoProfesor]
    }   

    def savetipoProfesor_ajax(){
        println "guarda TipoProfesor. Paràmetros: $params"
        def tipoProfesor

        if(params.id){
            tipoProfesor = TipoProfesor.get(params.id)
        }else{
            tipoProfesor = new TipoProfesor()
        }

        tipoProfesor.properties = params
        if(!tipoProfesor.save(flush:true)){
            println("error al guardar la dias " + tipoProfesor.errors)
            render "no"
        }else{
            println "errores: ${tipoProfesor.errors}"
            render "ok"
        }
    }
    def delete_ajax(){
        def tipoProfesor = TipoProfesor.get(params.id)

        try{
            // con el lazy tiene algo q ver
            tipoProfesor.delete(flush:true)
            render "ok"
        }catch(e){
            println("error al borrar el dia " + tipoProfesor.errors)
            render "no"
        }
    }
    
    def show_ajax() {
        def tipoProfesor = TipoProfesor.get(params.id)
        return [tipoProfesor: tipoProfesor]
    }


}
