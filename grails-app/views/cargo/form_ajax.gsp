<g:form class="form-horizontal" name="frmCargo" action="saveCargo_ajax">
    <g:hiddenField name="id" value="${cargoInstance?.id}"/>

    <div class="form-group ${hasErrors(bean: cargoInstance, field: 'descripcion', 'error')} ">
        <span class="grupo">
            <label for="descripcion" class="col-md-2 control-label text-info">
                Descripción
            </label>
            <span class="col-md-8">
                <g:textField name="descripcion" maxlength="50" class="form-control required" value="${cargoInstance?.descripcion}"/>
                <p class="help-block ui-helper-hidden"></p>
            </span>
        </span>
    </div>

</g:form>

<script type="text/javascript">
    var validator = $("#frmCargo").validate({
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
            submitFormCargo();
            return false;
        }
        return true;
    });
</script>