package tutor


class PeriodoController {

    def list(){
        def periodos = Periodo.list().sort{it.descripcion}
        return [periodos: periodos]
    }

    def form_ajax(){
        def periodo

        if(params.id){
            periodo = Periodo.get(params.id)
        }else{
            periodo = new Periodo()
        }

        return[periodo:periodo]
    }

    def savePeriodo_ajax() {
        def periodo

        if(params.id){
            periodo = Periodo.get(params.id)
        }else{
            periodo = new Periodo()
        }

        periodo.properties = params

        if(!periodo.save(flush:true)){
            println("Error al guardar el período " + periodo.errors)
            render "no_Error al guardar el período"
        }else{
            render "ok_Período guardado correctamente"
        }
    }

    def delete_ajax(){
        def periodo = Periodo.get(params.id)

        if(periodo){

            try{
                periodo.delete(flush: true)
                render "ok_Período borrado correctamente"
            }catch(e){
                println("error al borrar el período")
                render "no_Error al borrar el período"
            }

        }else{
            render "no_No se encontró el período"
        }

    }

}


