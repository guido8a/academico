<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Asignaturas</title>
</head>

<body>


<div class="btn-toolbar toolbar" style="margin-top: 10px">
    <div class="col-md-12">
        <label for="periodo" class="col-md-1 control-label text-info" style="text-align: right">
            Período
        </label>
        <div class="col-md-2">
            <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                      class="form-control input-sm" optionValue="descripcion" optionKey="id"
            />
        </div>
        <label class="col-md-1 control-label text-info" style="text-align: right">
            Asignaturas
        </label>
        <div class="col-md-6" id="divComboAsignaturas">

        </div>

    </div>
</div>


<table class="table table-condensed table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th style="width: 10%">Período</th>
        <th style="width: 44%">Gestión</th>
        <th style="width: 15%">Apellido</th>
        <th style="width: 15%">Nombre</th>
        <th style="width: 8%">Horas</th>
        <th style="width: 8%">Factor</th>
    </tr>
    </thead>
</table>

<div id="divAsignaturas">

</div>


<script type="text/javascript">

    cargarAsignatura($("#periodo option:selected").val());

    function cargarAsignatura(periodo){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'comboAsignatura_ajax')}",
            data: {
                periodo: periodo
            },
            success: function (msg) {
                $("#divComboAsignaturas").html(msg);
            } //success
        });
    }

    $("#periodo").change(function () {
        var periodo = $(this).val();
        cargarAsignatura(periodo);
    });


</script>

</body>
</html>
