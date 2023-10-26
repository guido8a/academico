<div style="overflow: hidden">
    <fieldset class="borde" style="border-radius: 4px; margin-bottom: 5px">
        <div class="row-fluid" style="margin-left: 10px">
            <span class="grupo">
                <span class="col-md-4">
                    <label class="control-label text-info">Buscar Por</label>
                    <g:select name="buscarPorDiagnostico" class="buscarPorDiagnostico col-md-12 form-control" from="${[1: 'Descripción', 2: 'Código']}" optionKey="key"
                              optionValue="value"/>
                </span>
                <span class="col-md-5">
                    <label class="control-label text-info">Criterio</label>
                    <g:textField name="criterioDiagnostico" id="criterioDiagnostico" class="form-control"/>
                </span>
            </span>
            <div class="col-md-1" style="margin-top: 20px">
                <button class="btn btn-info" id="btnBuscarListaDiagnostico"><i class="fa fa-search"></i></button>
            </div>
            <div class="col-md-1" style="margin-top: 20px">
                <button class="btn btn-warning" id="btnLimpiarDiagnostico" title="Limpiar Búsqueda"><i class="fa fa-eraser"></i></button>
            </div>
        </div>
    </fieldset>

    <fieldset class="borde" style="border-radius: 4px">
        <div id="divTablaDiagnosticos" >
        </div>
    </fieldset>

    <fieldset style="border-radius: 4px; margin-top: 5px">
        <div class="alert alert-warning">
            * Máxima cantidad de registros en pantalla 100
        </div>
    </fieldset>
</div>

<script type="text/javascript">

    $("#btnBuscarListaDiagnostico").click(function () {
        cargarDiagnosticos();
    });

    cargarDiagnosticos();

    function cargarDiagnosticos(){
        var e = cargarLoader("Cargando...");
        var buscarPor = $("#buscarPorDiagnostico option:selected").val();
        var criterio = $("#criterioDiagnostico").val();
        $.ajax({
            type: 'POST',
            url: '${createLink(controller: 'historial', action: 'tablaBuscarDiagnostico_ajax')}',
            data:{
                buscarPor: buscarPor,
                criterio: criterio
            },
            success: function (msg){
                e.modal("hide");
                $("#divTablaDiagnosticos").html(msg)
            }
        })
    }


</script>