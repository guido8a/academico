
<div class="modal-contenido">
    <g:form class="form-horizontal" name="frmParalelo" role="form" action="saveParalelo_ajax" method="POST">
        <g:hiddenField name="id" value="${paralelo?.id}"/>

        <div class="form-group keeptogether ${hasErrors(bean: paralelo, field: 'numero', 'error')}">
            <div class="row">
                <label for="numero" class="col-md-2 control-label">
                    Paralelo
                </label>

                <div class="col-md-8">
                    <g:textField name="numero" maxlength="10" class="form-control required"
                                 value="${paralelo?.numero}"/>
                </div>
            </div>
        </div>
    </g:form>
</div>

<script type="text/javascript">


    $("#frmParalelo").validate({
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
            submitFormParalelo();
            return false;
        }
        return true;
    });

</script>
