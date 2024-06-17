
<div role="main" style="margin-top: 5px;">
    <table class="table table-bordered table-striped table-condensed table-hover" style="width: 100%">
        <thead>
        <tr>
            <th style="width: 75%;">Nombre</th>
            <th style="width: 15%;">Horas</th>
            <th style="width: 10%;">Seleccionar</th>
        </tr>
        </thead>
    </table>
</div>

<div class="" style="width: 99.7%;height: 400px; overflow-y: auto;float: right; margin-top: -20px">
    <table class="table-bordered table-striped table-condensed table-hover" style="width: 100%">
        <tbody>
        <g:if test="${datos}">
            <g:each in="${datos}" var="dato" status="i">
                <tr>
                    <td style="width: 75%;">${dato.asignmbr}</td>
                    <td style="width: 15%;">${dato.asighrgs}</td>
                    <td style="width: 10%; text-align: center">
                        <a href="#" class="btn btn-xs btn-success btnSelGestion" title="Seleccionar" data-id="${dato.asig__id}"
                           data-nombre="${dato.asignmbr}" data-hora="${dato.asighrgs}">
                            <i class="fa fa-check"></i>
                        </a>
                    </td>
                </tr>
            </g:each>
        </g:if>
        <g:else>
            <div class="alert alert-warning" style="margin-top: 0px; text-align: center; font-size: 14px; font-weight: bold"><i class="fa fa-exclamation-triangle fa-2x text-info"></i> No existen registros</div>
        </g:else>
        </tbody>
    </table>
</div>

<script type="text/javascript">

    $(".btnSelGestion").click(function () {
        var id = $(this).data("id");
        var nombre = $(this).data("nombre");
        var hora = $(this).data("hora");

        $("#asignatura").val(id);
        $("#asignaturaNombre").val(nombre);
        $("#hora").val(hora);

        cerrarBuscarGestion();

        return false;
    });

</script>
