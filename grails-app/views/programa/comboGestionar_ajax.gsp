<g:select name="gestion" from="${resp}" optionKey="${id}" optionValue="${nombre}" class="form-control" />

<script type="text/javascript">

    cargarTablaGestionar( $("#periodo option:selected").val(), $("#gestion option:selected").val());

    function cargarTablaGestionar(periodo, gestion){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'tablaGestionar_ajax')}",
            data: {
                periodo: periodo,
                gestion: gestion
            },
            success: function (msg) {
                $("#divGestion").html(msg);
            } //success
        });
    }

    $("#gestion").change(function () {
        var gestion = $(this).val();
        var periodo = $("#periodo option:selected").val();
        cargarTablaGestionar(periodo, gestion)
    });


</script>