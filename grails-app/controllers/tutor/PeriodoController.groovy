package tutor


class PeriodoController {

    def list(){
        def periodos = Periodo.list().sort{it.descripcion}
        return [periodos: periodos]
    }

    def form_ajax(){

    }

}


