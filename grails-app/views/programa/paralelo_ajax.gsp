<div class="col-md-4">
    <label for="paralelo" class="col-md-1 control-label" style="text-align: right">
        Paralelo
    </label>
    <g:select name="paralelo" from="${paralelo}"
              class="form-control input-sm required" optionValue="${{it.nivel.descripcion + " - " + it.numero}}" optionKey="id"
    />
</div>


<div class="col-md-8">
    <label for="asignatura" class="col-md-1 control-label" style="text-align: right">
        Asignatura
    </label>
    <g:select name="asignatura" from="${asignatura}"
              class="form-control input-sm required" optionValue="${{it.nivel.descripcion + " - " + it.nombre}}" optionKey="id"
    />
</div>

<script type="text/javascript">

    cargaTabla($("#paralelo option:selected").val());

    $("#paralelo").change(function () {
        var id = $(this).val();
        if(id) {
            cargaTabla(id)
        }
    });

</script>