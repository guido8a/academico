<div class="col-md-3">
    <label for="paralelo" class="col-md-1 control-label" style="text-align: right">
        Paralelo
    </label>
    <g:select name="paralelo" from="${paralelos}"
              class="form-control input-sm required" optionValue="${{it.nivel.descripcion + " - " + it.numero}}"
              optionKey="id" />
</div>

<div id="divAsignatura">

</div>



<script type="text/javascript">

    cargarAsignatura($("#paralelo option:selected").val());

    function cargarAsignatura(idParalelo){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'asignatura_ajax')}",
            data: {
                paralelo: idParalelo
            },
            success: function (msg1) {
                $("#divAsignatura").html(msg1);
            } //success
        });
    }

    $("#paralelo").change(function () {
        var paralelo = $(this).val();
        if(paralelo) {
            cargarAsignatura(paralelo)
        }
    });


</script>