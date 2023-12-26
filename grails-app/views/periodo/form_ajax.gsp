
<div class="modal-contenido">
    <g:form class="form-horizontal" name="frmPeriodo" role="form" action="savePeriodo_ajax" method="POST">
        <g:hiddenField name="id" value="${periodo?.id}"/>

        <div class="form-group keeptogether ${hasErrors(bean: periodo, field: 'descripcion', 'error')}">
            <div class="row">
                <label for="descripcion" class="col-md-2 control-label">
                    Descripcion
                </label>

                <div class="col-md-8">
                    <g:textField name="descripcion" maxlength="200" class="form-control required"
                                 value="${periodo?.descripcion}"/>
                </div>
            </div>
        </div>
    </g:form>
</div>

<script type="text/javascript">


    $("#frmPeriodo").validate({
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
            submitPeriodo();
            return false;
        }
        return true;
    });

</script>
