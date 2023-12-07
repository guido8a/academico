
    <div class="modal-contenido">
        <g:form class="form-horizontal" name="frmFacultad" role="form" action="saveFacultad_ajax" method="POST">
            <g:hiddenField name="id" value="${facultad?.id}"/>

            <div class="form-group keeptogether ${hasErrors(bean: facultad, field: 'nombre', 'error')}">
                <span class="grupo">
                    <label for="nombre" class="col-md-2 control-label">
                        Nombre
                    </label>

                    <div class="col-md-8">
                        <g:textField name="nombre" maxlength="61" class="form-control input-sm required"
                                     value="${facultad?.nombre}"/>
                    </div>
                </span>

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
                return false;
            }
            return true;
        });


        $("#grabar").click(function () {
            var nombre = $("#nombre").val();
            var url = "${createLink(controller: 'facultad', action:'list')}"
            console.log("validando...")

            if(numero == ''){
                bootbox.alert("<i class='fa fa-exclamation-triangle fa-3x pull-left text-warning text-shadow'></i>" +
                    " Ingrese el número del paralelo")
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
            //location.href("${createLink(controller: 'facultad', action:'list')}")
            location.reload(true)
        });
    </script>
