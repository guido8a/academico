package tutor

class ProfesorController {

    def list() {
        def profesores = Profesor.list([sort: 'apellido'])
        def tiposProfesor = TipoProfesor.list() // Recupera los tipos de profesor desde la tabla tppr
        return [profesores: profesores, tiposProfesor: tiposProfesor]
    }

    def form_ajax() {
        def profesor

        if (params.id) {
            profesor = Profesor.get(params.id)
        } else {
            profesor = new Profesor()
        }

        // Recupera los tipos de profesor para mostrar en el combo
        def tiposProfesor = TipoProfesor.list()
        
        return [profesor: profesor, tiposProfesor: tiposProfesor]
    }

    def saveProfesor_ajax() {
        println "Guarda profesor. Parámetros: $params"
        def profesor

        if (params.id) {
            profesor = Profesor.get(params.id)
        } else {
            profesor = new Profesor()
        }

        profesor.properties = params
        if (!profesor.save(flush: true)) {
            println("Error al guardar el profesor: ${profesor.errors}")
            render "no"
        } else {
            println "Errores: ${profesor.errors}"
            render "ok"
        }
    }

    def delete_ajax() {
        def profesor = Profesor.get(params.id)

        try {
            profesor.delete(flush: true)
            render "ok"
        } catch (e) {
            println("Error al borrar el profesor: ${profesor.errors}")
            render "no"
        }
    }

    def show_ajax() {
        def profesor = Profesor.get(params.id)
        return [profesor: profesor]
    }
}
