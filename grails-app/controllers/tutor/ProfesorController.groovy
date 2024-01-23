package tutor

class ProfesorController {

   def list(){

   }

    def form_ajax(){

        def profesor

        if(params.id){
            profesor = Profesor.get(params.id)
        }else{
            profesor = new Profesor()
        }

        return[profesor: profesor]
    }

    def tablaProfesores_ajax(){
        def profesores

        if(params.nombre || params.apellido){
            profesores = Profesor.findAllByNombreIlikeAndApellidoIlike("%" + params.nombre + "%", "%" +  params.apellido + "%")
        }else{
           profesores = Profesor.list([sort: 'apellido'])
        }

        return[profesores: profesores]
    }

    def show_ajax() {
        def profesor = Profesor.get(params.id)
        return [profesor: profesor]
    }

    def saveProfesor_ajax(){
        def profesor

        if(params.id){
            profesor = Profesor.get(params.id)
        }else{
            profesor = new Profesor()
        }

        profesor.properties = params

        if(!profesor.save(flush: true)){
            println("error al gaurdar el profesor " + profesor.errors)
            render "no_Error al guardar el profesor"
        }else{
            render "ok_Profesor guardada correctamente"
        }
    }

    def delete_ajax(){

        def  profesor = Profesor.get(params.id)

        if(profesor){

            try{
                profesor.delete(flush:true)
                render "ok_Borrado correctamente"
            }catch(e){
                println("error al borrar el profesor")
                render "no_Error al borrar el profesor"
            }

        }else{
            render "no_Error al borrar el profesor"
        }
    }

}
