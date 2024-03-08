
<div class="container">
    <g:form class="form-horizontal" name="frmCurso" role="form" action="saveCurso_ajax" method="POST">
        <g:hiddenField name="id" value="${curso?.id}"/>

        <div class="form-group keeptogether ${hasErrors(bean: curso, field: 'nrc', 'error')}">
            <div class="row">
                <label for="nrc" class="col-md-1 control-label" >
                    NRC
                </label>

                <div class="col-md-2">
                    <g:textField name="nrc" class="form-control" value="${curso?.nrc}"/>
                </div>
            </div>
        </div>

        <div class="form-group keeptogether ${hasErrors(bean: curso, field: 'numEstudiantes', 'error')}">
            <div class="row">
                <label for="numEstudiantes" class="col-md-1 control-label" >
                    Estudiantes
                </label>

                <div class="col-md-2">
                    <g:textField name="numEstudiantes" class="form-control" value="${curso?.numEstudiantes}"/>
                </div>
            </div>
        </div>

        <div class="form-group keeptogether ${hasErrors(bean: curso, field: 'cupo', 'error')}">
            <div class="row">
                <label for="cupo" class="col-md-1 control-label">
                    Cupo
                </label>

                <div class="col-md-2">
                    <g:textField name="cupo" class="form-control" value="${curso?.cupo}"/>
                </div>
            </div>
        </div>

        <div class="form-group keeptogether ${hasErrors(bean: curso, field: 'aula', 'error')}">
            <div class="row">
                <label for="aula" class="col-md-1 control-label">
                    Aula
                </label>

                <div class="col-md-2">
                    <g:textField name="aula" class="form-control" value="${curso?.aula}"/>
                </div>
            </div>
        </div>
    </g:form>
</div>

<script type="text/javascript">

    $("#frmCurso").validate({
        errorClass     : "help-block",
        errorPlacement : function (error, element) {
            if (element.parent().hasClass("input-group")) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
            element.parents(".grupo").addClass('has-error');
        },
        success        : function (label) {
            label.parents(".grupo").removeClass('has-error');
        }
    });

    $(".form-control").keydown(function (ev) {
        if (ev.keyCode === 13) {
            submitFormCurso();
            return false;
        }
        return true;
    });

    function validarNum(ev) {
        /*
         48-57      -> numeros
         96-105     -> teclado numerico
         188        -> , (coma)
         190        -> . (punto) teclado
         110        -> . (punto) teclado numerico
         8          -> backspace
         46         -> delete
         9          -> tab
         37         -> flecha izq
         39         -> flecha der
         */
        return ((ev.keyCode >= 48 && ev.keyCode <= 57) ||
            (ev.keyCode >= 96 && ev.keyCode <= 105) ||
            // ev.keyCode === 190 || ev.keyCode === 110 ||
            ev.keyCode === 8 || ev.keyCode === 46 || ev.keyCode === 9 ||
            ev.keyCode === 37 || ev.keyCode === 39);
    }

    $("#nrc, #aula, #cupo, #numEstudiantes").keydown(function (ev) {
        return validarNum(ev);
    });


</script>
