package tutor

class DiasController {

    def list(){
        def dias = Dias.list().sort{it.numero}
        return[dias: dias]
    }
     def form_ajax(){

        def dias

        if(params.id){
            dias = Dias.get(params.id)
        }else{
            dias = new Dias()
        }

        return[dias:dias]
    }

    def saveDia_ajax(){
        println "guarda Dia. Paràmetros: $params"
        def dias

        if(params.id){
            dias = Dias.get(params.id)
        }else{
            dias = new Dias()
        }

        dias.properties = params
        if(!dias.save(flush:true)){
            println("error al guardar la dias " + dias.errors)
            render "no"
        }else{
            println "errores: ${dias.errors}"
            render "ok"
        }
    }
    def delete_ajax(){
        def dias = Dias.get(params.id)

        try{
            // con el lazy tiene algo q ver
            dias.delete(flush:true)
            render "ok"
        }catch(e){
            println("error al borrar el dia " + dias.errors)
            render "no"
        }
    }

    def show_ajax() {
        def dia = Dias.get(params.id)
        return [dia: dia]
    }

}
