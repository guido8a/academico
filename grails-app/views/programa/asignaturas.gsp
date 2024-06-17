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
        <div class="col-md-1">
            Buscar Asignatura
        </div>
        <div class="col-md-2">
            <g:textField name="buscar" class="form-control" style="margin-left: -30px"/>
        </div>
        <div class="btn-group">
            <a href="#" class="btn btn-success btnBuscar">
                <i class="fa fa-search"></i> Buscar
            </a>
            <a href="#" class="btn btn-info btnLimpiar">
                <i class="fa fa-eraser"></i> Limpiar
            </a>
        </div>
        <label class="col-md-1 control-label text-info" style="text-align: right">
            Asignaturas dictadas
        </label>
        <div class="col-md-3" id="divComboAsignaturas">

        </div>

    </div>
</div>


<table class="table table-condensed table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th style="width: 10%">Período</th>
        <th style="width: 25%">Asignatura</th>
        <th style="width: 6%">Nivel</th>
        <th style="width: 5%">Par.</th>
        <th style="width: 15%">Apellido</th>
        <th style="width: 15%">Nombre</th>
        <th style="width: 8%">Horas</th>
        <th style="width: 8%">Factor</th>
        <th style="width: 8%">Total</th>
    </tr>
    </thead>
</table>

<div id="divAsignaturas">

</div>


<script type="text/javascript">

    cargarAsignatura($("#periodo option:selected").val(), $("#buscar").val());

    function cargarAsignatura(periodo, texto){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'comboAsignatura_ajax')}",
            data: {
                periodo: periodo,
                texto: texto
            },
            success: function (msg) {
                $("#divComboAsignaturas").html(msg);
            } //success
        });
    }

    $(".btnBuscar").click(function () {
        cargarAsignatura($("#periodo option:selected").val(), $("#buscar").val());
    });

    $(".btnLimpiar").click(function () {
        $("#buscar").val('');
        cargarAsignatura($("#periodo option:selected").val(), '');
    });

    $("#periodo").change(function () {
        var periodo = $(this).val();
        cargarAsignatura(periodo, $("#buscar").val());
    });


</script>

</body>
</html>
