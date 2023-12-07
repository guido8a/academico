package tutor

class CarreraController {

    def list() {
        def carreras = Carrera.list().sort{ it.nombre }
        return [carreras: carreras]
    }

    def form_ajax() {
        def carrera

        if (params.id) {
            carrera = Carrera.get(params.id)
        } else {
            carrera = new Carrera()
        }
        def facultades= Facultad.list().sort { it.nombre }

        return [carrera: carrera, facultades:facultades]
    }

    def saveCarrera_ajax() {
        println "guarda carrera. Paràmetros: $params"

        def carrera
        if (params.id) {
            carrera = Carrera.get(params.id)
        } else {
            carrera = new Carrera()
        }

        carrera.properties = params
        if (!carrera.save(flush: true)) {
            println("error al guardar la carrera " + carrera.errors)
            render "no"
        } else {
            println "errores: ${carrera.errors}"
            render "ok"
        }
    }

    def delete_ajax() {
        def carrera = Carrera.get(params.id)

        try {
            carrera.delete(flush: true)
            render "ok"
        } catch (e) {
            println("error al borrar la carrera " + carrera.errors)
            render "no"
        }
    }

    def show_ajax() {
        def carrera = Carrera.get(params.id)
        return [carrera: carrera]
    }
}