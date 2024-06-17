<div style="overflow: hidden">
    <fieldset class="borde" style="border-radius: 4px; margin-bottom: 5px">
        <div class="row-fluid" style="margin-left: 10px">
            <span class="grupo">
                <span class="col-md-6">
                    <label class="control-label text-info">Nombre</label>
                    <g:textField name="criterioGestion" class="form-control"/>
                </span>
            </span>
            <div class="col-md-1" style="margin-top: 20px">
                <button class="btn btn-info" id="btnBuscarTablaGestion"><i class="fa fa-search"></i></button>
            </div>
            <div class="col-md-1" style="margin-top: 20px">
                <button class="btn btn-warning" id="btnLimpiarGestion" title="Limpiar Búsqueda"><i class="fa fa-eraser"></i></button>
            </div>
        </div>
    </fieldset>

    <fieldset class="borde" style="border-radius: 4px">
        <div id="divTablaGestion" >
        </div>
    </fieldset>

    <fieldset style="border-radius: 4px; margin-top: 5px">
        <div class="alert alert-warning">
            * Máxima cantidad de registros en pantalla 50
        </div>
    </fieldset>
</div>

<script type="text/javascript">

    cargarTablaGestion();

    $("#btnBuscarTablaGestion").click(function () {
        cargarTablaGestion();
    });

    $("#btnLimpiarGestion").click(function () {
        $("#criterioGestion").val('');
        cargarTablaGestion();
    });

    function cargarTablaGestion(){
        var e = cargarLoader("Cargando...");
        var nombre = $("#criterioGestion").val();
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'programa', action: 'tablaBuscarGestion_ajax')}',
            data:{
                nombre: nombre
            },
            success: function (msg){
                e.modal("hide");
                $("#divTablaGestion").html(msg)
            }
        })
    }

    $(".form-control").keydown(function (ev) {
        if (ev.keyCode === 13) {
            cargarTablaGestion();
            return false;
        }
        return true;
    })

</script>