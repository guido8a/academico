package tutor

class CarreraController {

    def list(){

    }

    def form_ajax(){
        def carrera

        if(params.id){
            carrera = Carrera.get(params.id)
        }else{
            carrera = new Carrera()
        }

        return [carrera: carrera]
    }

    def tablaCarrera_ajax(){
        def facultad = Facultad.get(params.facultad)
        def carreras = Carrera.findAllByFacultad(facultad)
        return[carreras: carreras]
    }

    def saveCarrera_ajax(){
        def carrera

        if(params.id){
            carrera = Carrera.get(params.id)
        }else{
            carrera = new Carrera()
        }

        carrera.properties = params

        if(!carrera.save(flush: true)){
            println("error al gaurdar el carrera " + carrera.errors)
            render "no_Error al guardar la carrera"
        }else{
            render "ok_Carrera guardada correctamente"
        }
    }

    def delete_ajax(){

        def carrera = Carrera.get(params.id)

        if(carrera){

            try{
                carrera.delete(flush:true)
                render "ok_Carrera borrada correctamente"
            }catch(e){
                println("error al borrar la carrera")
                render "no_Error al borrar la carrera"
            }

        }else{
            render "no_Error al borrar la carrera"
        }
    }

}