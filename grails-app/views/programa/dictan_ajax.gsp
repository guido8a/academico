<div class="col-md-1">
    <label for="profesor" class="col-md-1 control-label" style="text-align: right; margin-left: -20px">
        Profesor
    </label>
</div>
<div class="col-md-8">
    <g:select name="profesor" from="${tutor.Profesor.list()}"
              class="form-control input-sm required" optionValue="${{it.nombre + " - " + it.apellido}}"
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

    cargaTabla($("#profesor option:selected").val());

    $("#profesor").change(function () {
        var prof = $(this).val();
        if(prof) {
            cargaTabla(prof)
        }
    });


</script>