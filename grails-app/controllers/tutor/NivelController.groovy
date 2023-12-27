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

}
