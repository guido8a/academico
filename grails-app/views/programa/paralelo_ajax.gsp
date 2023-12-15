<div class="col-md-3">
    <label for="paralelo" class="col-md-1 control-label" style="text-align: right">
        Paralelo
    </label>
    <g:select name="paralelo" from="${paralelo}"
              class="form-control input-sm required" optionValue="${{it.nivel.descripcion + " - " + it.numero}}"
              optionKey="id" value="params.parl"
    />
</div>

<div class="col-md-8">
    <label for="asignatura" class="col-md-1 control-label" style="text-align: right">
        Asignatura
    </label>
    <g:select name="asignatura" from="${asignatura}"
              class="form-control input-sm required" optionValue="${{it.nivel.descripcion + " - " + it.nombre}}"
              optionKey="id" value="params.asig"
    />
</div>

<div class="col-md-1" style="margin-top: 19px">
    <div class="btn-group">
        <a href="#" id="btnVerProfesor" class="btn btn-info">
            <i class="fa fa-user"></i> Profesor
        </a>
    </div>
</div>

<script type="text/javascript">

    cargaTabla($("#paralelo option:selected").val(), $("#asignatura option:selected").val());

    $("#paralelo").change(function () {
        var paralelo = $(this).val();
        var asignatura = $("#asignatura option:selected").val();
        if(paralelo) {
            cargaTabla(paralelo, asignatura)
        }
    });

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

</script>