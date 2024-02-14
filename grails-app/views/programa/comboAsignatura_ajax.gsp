<g:select name="asignatura" from="${resp}" optionKey="id" optionValue="nombre" class="form-control" />

<script type="text/javascript">

    cargarTablaAsignaturas( $("#periodo option:selected").val(), $("#asignatura option:selected").val());

    function cargarTablaAsignaturas(periodo, asignatura){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'tablaAsignaturas_ajax')}",
            data: {
                periodo: periodo,
                asignatura: asignatura
            },
            success: function (msg) {
                $("#divAsignaturas").html(msg);
            } //success
        });
    }

    $("#asignatura").change(function () {
        var asignatura = $(this).val();
        var periodo = $("#periodo option:selected").val();
        cargarTablaAsignaturas(periodo, asignatura)
    });


</script>