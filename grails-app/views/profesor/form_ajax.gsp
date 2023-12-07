<div class="modal-contenido">
    <g:form class="form-horizontal" name="frmProfesor" role="form" action="saveProfesor_ajax" method="POST">
        <g:hiddenField name="id" value="${profesor?.id}"/>

        <div class="form-group keeptogether ${hasErrors(bean: profesor, field: 'nombre', 'error')}">
            <div class="row">
                <label for="nombre" class="col-md-2 control-label">
                    Nombre
                </label>

                <div class="col-md-9">
                    <g:textField name="nombre" maxlength="61" class="form-control input-sm required"
                                 value="${profesor?.nombre}"/>
                </div>

            </div>
            <br>
            <div class="row">
                <label for="apellido" class="col-md-2 control-label">
                    Apellido
                </label>

                <div class="col-md-8">
                    <g:textField name="apellido" maxlength="61" class="form-control input-sm required"
                                 value="${profesor?.apellido}"/>
                </div>
            </div>
            <br>
            <div class="row">
                <label for="mail" class="col-md-2 control-label">
                    Email
                </label>

                <div class="col-md-8">
                    <g:textField name="mail" maxlength="61" class="form-control input-sm required"
                                 value="${profesor?.mail}"/>
                </div>
            </div>
            <br>
            <div class="row">
                <label for="extension" class="col-md-2 control-label">
                    Extension
                </label>

                <div class="col-md-8">
                    <g:textField name="extension" maxlength="10" class="form-control input-sm required"
                                 value="${profesor?.extension}"/>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="row">
                    <label for="sexo" class="col-md-4 control-label">
                        Sexo
                    </label>
                    <div class="col-md-6">
                        <g:select name="sexo" from="${['M', 'F']}" style="border:solid 2px black;" class="form-control input-sm required"
                                value="${profesor?.sexo}"/>
                    </div>
                </div>
            <br>
            </div>
            <br>
            <div class="row">
                <!-- Agrega un combo para seleccionar el tipo de profesor -->
                <label for="tipoProfesor" class="col-md-4 control-label">
                    Tipo de Profesor
                </label>

                <div class="col-md-6">
                    <g:select name="tipoProfesor" from="${tiposProfesor}" optionKey="id" optionValue="descripcion" class="form-control input-sm" required="required"
                              value="${profesor?.tipoProfesor?.id}"/>
                </div>
            </div>
        </div>
    </g:form>
    <div class="col-md-12" style="text-align: end">
        <button id="cerrar" class="btn btn-primary">Cancelar</button>
        <button id="grabar" class="btn btn-info">Grabar</button>
    </div>
</div>

<script type="text/javascript">
    $(".form-control").keydown(function (ev) {
        if (ev.keyCode == 13) {
            console.log("Llama a validar");
            $("#grabar").click();
            return false;
        }
        return true;
    });

    $("#grabar").click(function () {
        var nombre = $("#nombre").val();
        var url = "${createLink(controller: 'profesor', action:'list')}";
        console.log("Validando...");

        if (nombre === '') {
            bootbox.alert("<i class='fa fa-exclamation-triangle fa-3x pull-left text-warning text-shadow'></i>" +
                " Ingrese el nombre del Profesor");
        }else{
                submitForm();
                //$(".modal-dialog").hide()
                setTimeout(function () {

                    location.reload(true)
                }, 300);
                //location.reload(true)
            }
    });

    $("#cerrar").click(function () {
        location.reload(true);
    });
</script>
