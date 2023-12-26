package tutor


class ParaleloController {

    def list (){
        def paralelos = Paralelo.list().sort{it.numero}
        return[paralelos:paralelos]
    }

    def tablaParalelos_ajax(){
        def periodo = Periodo.get(params.periodo)
        def paralelos = Paralelo.findAllByPeriodo(periodo)
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


}
