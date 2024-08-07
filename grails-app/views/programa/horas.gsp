<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Docencia</title>
</head>

<body>

<div class="btn-toolbar toolbar" style="margin-top: 10px">
    <div class="col-md-12">
        <label for="periodo" class="col-md-1 control-label text-info" style="text-align: right">
            Período
        </label>
        <div class="col-md-3">
            %{--<g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"--}%
                      %{--class="form-control input-sm" optionValue="descripcion" optionKey="id"--}%
            %{--/>--}%
            <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                      class="form-control input-sm required" optionValue="descripcion" optionKey="id"
                      value="${activo}" style="color: #2060A0; font-weight: bold; background-color: #eed; border-color: #0a6aa1"
            />

        </div>
        <label for="profesor" class="col-md-1 control-label text-info" style="text-align: right">
            Docente
        </label>
        <div class="col-md-4">
            <g:select name="profesor" from="${tutor.Profesor.list([sort: 'apellido'])}"
                      class="form-control input-sm" optionValue="${{it?.apellido + " " + it?.nombre}}" optionKey="id"
            />
        </div>
    </div>
</div>


<table class="table table-condensed table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th style="width: 20%">Carrera</th>
        <th style="width: 5%">Código</th>
        <th style="width: 25%">Asignatura</th>
        <th style="width: 8%">Nivel</th>
        <th style="width: 6%">Paralelo</th>
        <th style="width: 8%">Créditos</th>
        <th style="width: 10%">Factor prep.</th>
        <th style="width: 10%">Horas</th>
        <th style="width: 10%">Total horas</th>
    </tr>
    </thead>
</table>

<div id="divHoras">

</div>

<script type="text/javascript">

    cargarTablahoras( $("#periodo option:selected").val(), $("#profesor option:selected").val());

    function cargarTablahoras(periodo, profesor){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'tablaHoras_ajax')}",
            data: {
                periodo: periodo,
                profesor: profesor
            },
            success: function (msg) {
                $("#divHoras").html(msg);
            } //success
        });
    }

    $("#periodo").change(function () {
        var periodo = $(this).val();
        var profesor = $("#profesor option:selected").val();
        cargarTablahoras(periodo, profesor)
    });

    $("#profesor").change(function () {
        var profesor = $(this).val();
        var periodo = $("#periodo option:selected").val();
        cargarTablahoras(periodo, profesor)
    });

</script>

</body>
</html>
