package tutor

class EstudianteController {

    def list(){
        def estudiantes = Estudiante.list().sort{it.nombre}
        return[estudiantes: estudiantes]
    }

    def form_ajax(){

        def estudiante

        if(params.id){
            estudiante = Estudiante.get(params.id)
        }else{
            estudiante = new Estudiante()
        }

        return[estudiante:estudiante]
    }

    def saveEstudiante_ajax(){
        println "guarda estudiante. Paràmetros: $params"
        
        def estudiante
        if(params.id){
            estudiante = Estudiante.get(params.id)
        }else{
            estudiante = new Estudiante()
        }

        estudiante.properties = params
        if(!estudiante.save(flush:true)){
            println("error al guardar al estudiante " + estudiante.errors)
            render "no"
        }else{
            println "errores: ${estudiante.errors}"
            render "ok"
        }
    }

    def delete_ajax(){
        def estudiante = Estudiante.get(params.id)

        try{
            estudiante.delete(flush:true)
            render "ok"
        }catch(e){
            println("error al borrar el estudiante " + estudiante.errors)
            render "no"
        }
    }

    def show_ajax(){
        def estudiante = Estudiante.get(params.id)
        return[estudiante:estudiante]
    }

}
