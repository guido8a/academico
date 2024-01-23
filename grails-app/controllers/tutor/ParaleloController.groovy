package tutor


class ParaleloController {

    def list (){
        def paralelos = Paralelo.list().sort{it.numero}
        return[paralelos:paralelos]
    }

    def tablaParalelos_ajax(){
        def periodo = Periodo.get(params.periodo)
        def carrera = Carrera.get(params.carrera)
        def nivel
        def paralelos

        if(params.nivel != 'null'){
            nivel = Nivel.get(params.nivel)
            paralelos = Paralelo.findAllByPeriodoAndCarreraAndNivel(periodo, carrera, nivel)
        }else{
            paralelos = Paralelo.findAllByPeriodoAndCarrera(periodo, carrera)
        }

        return[paralelos: paralelos]
    }

    def form_ajax(){
        def paralelo

        if(params.id){
            paralelo = Paralelo.get(params.id)
        }else{
            paralelo = new Paralelo()
        }

        return [paralelo: paralelo]
    }

    def saveParalelo_ajax() {
        def paralelo

        if(params.id){
            paralelo = Paralelo.get(params.id)
        }else{
            paralelo = new Paralelo()
        }

        paralelo.properties = params

        if(!paralelo.save(flush: true)){
            println("error al gaurdar el paralelo " + paralelo.errors)
            render "no_Error al guardar el paralelo"
        }else{
            render "ok_Paralelo guardado correctamente"
        }
    }

    def delete_ajax(){

        def paralelo = Paralelo.get(params.id)

        if(paralelo){

            try{
                paralelo.delete(flush:true)
                render "ok_Borrado correctamente"
            }catch(e){
                println("error al borrar el paralelo")
                render "no_Error al borrar el paralelo"
            }

        }else{
            render "no_Error al borrar el paralelo"
        }
    }


}
