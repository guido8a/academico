package tutor

class NivelController {

    def list(){
        def niveles = Nivel.list([sort: 'numero'])
        return [niveles: niveles]
    }

    def form_ajax(){
        def nivel

        if(params.id){
            nivel = Nivel.get(params.id)
        }else{
            nivel = new Nivel()
        }

        return [nivel: nivel]
    }

    def saveNivel_ajax(){
        def nivel

        if(params.id){
            nivel = Nivel.get(params.id)
        }else{
            nivel = new Nivel()
        }

        nivel.properties = params

        if(!nivel.save(flush: true)){
            println("error al gaurdar el nivel " + nivel.errors)
            render "no_Error al guardar el nivel"
        }else{
            render "ok_Nivel guardada correctamente"
        }
    }

    def delete_ajax(){

        def nivel = Nivel.get(params.id)

        if(nivel){

            try{
                nivel.delete(flush:true)
                render "ok_Borrado correctamente"
            }catch(e){
                println("error al borrar el nivel")
                render "no_Error al borrar el nivel"
            }

        }else{
            render "no_Error al borrar el nivel"
        }
    }

}
