<div class="modal-contenido">
    <g:form class="form-horizontal" name="frmCarrera" role="form" action="saveCarrera_ajax" method="POST">
        <g:hiddenField name="id" value="${carrera?.id}"/>
        <div class="form-group keeptogether ${hasErrors(bean: carrera, field: 'nombre', 'error')}">
        </div>
        <div class="form-group keeptogether ${hasErrors(bean: carrera, field: 'nombre', 'error')}">
            <span class="grupo">
                <label for="nombre" class="col-md-2 control-label">
                    Nombre
                </label>
                <div class="col-md-8">
                    <g:textField name="nombre" maxlength="61" class="form-control input-sm required" value="${carrera?.nombre}"/>
                </div>
            </span>
            <div class="row" style="margin-top: 15px">
                <label for="facultad" class="col-md-4 control-label">
                    Facultad
                </label>
                <div class="col-md-6">
                        <g:select name="facultad" from="${facultades}" optionKey="id" optionValue="nombre" class="form-control input-sm required" value="${carrera?.facultad?.id}" />
                </div>
            </div>
        </div>

    </g:form>
    <div class="col-md-12" style="text-align: end">
        <button id="cerrar" class="btn btn-primary"> Cancelar</button>
        <button id="grabar" class="btn btn-info"> Grabar</button>
    </div>
</div>

<script type="text/javascript">
    $(".form-control").keydown(function (ev) {
        if (ev.keyCode == 13) {
            console.log("Llama a validar")
            $("#grabar").click()
            // Para no hacer que the enter haga algo adicional return false
            return false;
        }
        return true;
    });

    $("#grabar").click(function () {
        var nombre = $("#nombre").val();
        var url = "${createLink(controller: 'carrera', action:'list')}"
        console.log("validando...")

        if(nombre == ''){
            bootbox.alert("<i class='fa fa-exclamation-triangle fa-3x pull-left text-warning text-shadow'></i>" +
                " Ingrese el nombre de la carrera y el numero")
        } else {
            submitForm();
            //$(".modal-dialog").hide()
            setTimeout(function () {
                location.reload(true)
            }, 300);
            //location.reload(true)
        }
    });

    $("#cerrar").click(function () {
        //location.href("${createLink(controller: 'facultad', action:'list')}")
        //true para que no haya intervalos de espera
        location.reload(true)
    });
</script>