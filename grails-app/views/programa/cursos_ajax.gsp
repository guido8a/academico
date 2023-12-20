<div class="col-md-2">
    <label for="curso" class="col-md-1 control-label" style="text-align: right; margin-left: -20px">
        Paralelo
    </label>
</div>
<div class="col-md-8">
    <g:select name="curso" from="${cursos}"
              class="form-control input-sm required" optionValue="${{it.nivel.descripcion + " - " + it.numero}}"
              optionKey="id" value="params.parl"
    />
</div>

%{--<div class="col-md-1">--}%
    %{--<div class="btn-group">--}%
        %{--<a href="#" id="btnVerProfesor" class="btn btn-info">--}%
            %{--<i class="fa fa-user"></i> Profesor--}%
        %{--</a>--}%
    %{--</div>--}%
%{--</div>--}%

<script type="text/javascript">

    cargaTabla($("#curso option:selected").val());

    $("#curso").change(function () {
        var parl = $(this).val();
        if(parl) {
            cargaTabla(parl)
        }
    });


</script>