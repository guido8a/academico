<div class="col-md-6">
    <label for="asignatura" class="col-md-1 control-label">
        Asignatura
    </label>
    <g:select name="asignatura" from="${asignaturas}"
              class="form-control input-sm required" optionValue="${{it.nivel.descripcion + " - " + it.nombre + " (" +
            it.carrera.codigo + ")"}}"
              optionKey="${{it.id}}" />
</div>

<div class="col-md-3" style="margin-top: 19px; text-align: right">
    <div class="btn-group">
        <a href="#" id="btnVerProfesor" class="btn btn-info">
            <i class="fa fa-user"></i> Profesor
        </a>
        <a href="#" id="btnEditarCurso" class="btn btn-success hide" title="Editar curso">
            <i class="fa fa-edit"></i>
        </a>
    </div>
</div>

<script type="text/javascript">

    cargaTabla($("#paralelo option:selected").val(), $("#asignatura option:selected").val());

    $("#asignatura").change(function () {
        var asignatura = $(this).val();
        var paralelo = $("#paralelo option:selected").val();
        if(asignatura) {
            cargaTabla(paralelo, asignatura);
        }
    });

    $("#btnVerProfesor").click(function () {
        var asignatura = $("#asignatura option:selected").val();
        var paralelo = $("#paralelo option:selected").val();
        $.ajax({
            type    : "POST",
            url: "${createLink(action:'profesores_ajax')}",
            data    : {
                asignatura: asignatura,
                paralelo: paralelo
            },
            success : function (msg) {
                var b = bootbox.dialog({
                    id      : "dlgProfesor",
                    title   : "Profesor asignado",
                    message : msg,
                    buttons : {
                        cancelar : {
                            label     : "Cancelar",
                            className : "btn-primary",
                            callback  : function () {
                            }
                        }
                    } //buttons
                }); //dialog
            } //success
        }); //ajax
    });

    $("#btnEditarCurso").click(function () {
        var asignatura = $("#asignatura option:selected").val();
        var paralelo = $("#paralelo option:selected").val();
        createEditRowCurso(asignatura, paralelo);
    });

    function createEditRowCurso(asignatura, paralelo) {

        $.ajax({
            type    : "POST",
            url: "${createLink(controller: 'programa', action:'editarCurso_ajax')}",
            data    : {
                asignatura: asignatura,
                paralelo: paralelo
            },
            success : function (msg) {
                var b = bootbox.dialog({
                    id      : "dlgCreateEditCurso",
                    title   : "Editar Curso",
                    message : msg,
                    class: "modal-sm",
                    buttons : {
                        cancelar : {
                            label     : "Cancelar",
                            className : "btn-primary",
                            callback  : function () {
                            }
                        },
                        guardar  : {
                            id        : "btnSave",
                            label     : "<i class='fa fa-save'></i> Guardar",
                            className : "btn-success",
                            callback  : function () {
                                return submitFormCurso();
                            } //callback
                        } //guardar
                    } //buttons
                }); //dialog
            } //success
        }); //ajax
    } //createEdit

    function submitFormCurso() {
        var $form = $("#frmCurso");
        if ($form.valid()) {
            var data = $form.serialize();
            var dialog = cargarLoader("Guardando...");
            $.ajax({
                type    : "POST",
                url     : $form.attr("action"),
                data    : data,
                success : function (msg) {
                    dialog.modal('hide');
                    var parts = msg.split("_");
                    if(parts[0] === 'ok'){
                        log(parts[1], "success");
                        cargaTabla($("#paralelo option:selected").val(), $("#asignatura option:selected").val());
                    }else{
                        bootbox.alert('<i class="fa fa-exclamation-triangle text-danger fa-3x"></i> ' + '<strong style="font-size: 14px">' + parts[1] + '</strong>');
                        return false;
                    }
                }
            });
        } else {
            return false;
        }
    }


</script>