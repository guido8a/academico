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
        println "Guarda nivel. Parámetros: $params"
        def nivel

        if(params.id){
            nivel = Nivel.get(params.id)
        }else{
            nivel = new Nivel()
        }

        nivel.properties = params
        if(!nivel.save(flush:true)){
            println("Error al guardar el nivel " + nivel.errors)
            render "no"
        }else{
            println "Errores: ${nivel.errors}"
            render "ok"
        }
    }

    def delete_ajax(){
        def nivel = Nivel.get(params.id)

        try{
            nivel.delete(flush:true)
            render "ok"
        }catch(e){
            println("Error al borrar el nivel " + nivel.errors)
            render "no"
        }
    }

    def show_ajax(){
        def nivel = Nivel.get(params.id)
        return [nivel: nivel]
    }
}
