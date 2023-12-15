<div class="modal-contenido">

    <div class="form-group keeptogether">
        <div class="col-md-12">
            <label class="col-md-2 control-label" style="text-align: right">
                Profesor
            </label>
            <div class="col-md-8">
                <g:select name="profesor" from="${tutor.Profesor.list([sort: 'apellido'])}"
                          class="form-control input-sm" optionValue="${{it.apellido + " " + it.nombre}}" optionKey="id"
                />
            </div>
            <div class="col-md-2">
                <div class="btn-group">
                    <a href="#" id="btnAsignarProfesor" class="btn btn-success">
                        <i class="fa fa-user"></i> Asignar
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div id="divTablaProfesor">

    </div>

</div>

<script type="text/javascript">

    cargarTablaProfesor();

    function cargarTablaProfesor(){
        var asignatura = '${asignatura?.id}';
        var paralelo = '${paralelo?.id}';
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'tablaProfesorAsignado_ajax')}",
            data: {
                asignatura: asignatura,
                paralelo: paralelo
            },
            success: function (msg) {
                $("#divTablaProfesor").html(msg);
            } //success
        });
    }

</script>