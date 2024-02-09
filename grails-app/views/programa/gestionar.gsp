<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Lista de Gestión</title>
</head>

<body>


<div class="btn-toolbar toolbar" style="margin-top: 10px">
    <div class="col-md-12">
        <label for="periodo" class="col-md-1 control-label text-info" style="text-align: right">
            Período
        </label>
        <div class="col-md-2">
            <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                      class="form-control input-sm" optionValue="descripcion" optionKey="id"
            />
        </div>
        <label class="col-md-1 control-label text-info" style="text-align: right">
            Gestión
        </label>
        <div class="col-md-4" id="divComboGestion">

        </div>

    </div>
</div>


<table class="table table-condensed table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th style="width: 10%">Período</th>
        <th style="width: 32%">Gestión</th>
        <th style="width: 15%">Apellido</th>
        <th style="width: 15%">Nombre</th>
        <th style="width: 8%">Horas</th>
        <th style="width: 20%">Observaciones</th>
    </tr>
    </thead>
</table>

<div id="divGestion">

</div>


<script type="text/javascript">

    cargarGestion($("#periodo option:selected").val());

    function cargarGestion(periodo){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'comboGestionar_ajax')}",
            data: {
                periodo: periodo
            },
            success: function (msg) {
                $("#divComboGestion").html(msg);
            } //success
        });
    }

    $("#periodo").change(function () {
        var periodo = $(this).val();
        cargarGestion(periodo);
    });


    %{--function createEditRowParalelo(id) {--}%
    %{--    var title = id ? "Editar" : "Crear";--}%
    %{--    var data = id ? {id: id} : {};--}%
    %{--    $.ajax({--}%
    %{--        type    : "POST",--}%
    %{--        url: "${createLink(controller: 'paralelo', action:'form_ajax')}",--}%
    %{--        data    : data,--}%
    %{--        success : function (msg) {--}%
    %{--            var b = bootbox.dialog({--}%
    %{--                id      : "dlgCreateEdit",--}%
    %{--                title   : title + " Paralelo",--}%
    %{--                message : msg,--}%
    %{--                buttons : {--}%
    %{--                    cancelar : {--}%
    %{--                        label     : "Cancelar",--}%
    %{--                        className : "btn-primary",--}%
    %{--                        callback  : function () {--}%
    %{--                        }--}%
    %{--                    },--}%
    %{--                    guardar  : {--}%
    %{--                        id        : "btnSave",--}%
    %{--                        label     : "<i class='fa fa-save'></i> Guardar",--}%
    %{--                        className : "btn-success",--}%
    %{--                        callback  : function () {--}%
    %{--                            return submitFormParalelo();--}%
    %{--                        } //callback--}%
    %{--                    } //guardar--}%
    %{--                } //buttons--}%
    %{--            }); //dialog--}%
    %{--        } //success--}%
    %{--    }); //ajax--}%
    %{--} //createEdit--}%

    // function submitFormParalelo() {
    //     var $form = $("#frmParalelo");
    //     if ($form.valid()) {
    //         var data = $form.serialize();
    //         var dialog = cargarLoader("Guardando...");
    //         $.ajax({
    //             type    : "POST",
    //             url     : $form.attr("action"),
    //             data    : data,
    //             success : function (msg) {
    //                 dialog.modal('hide');
    //                 var parts = msg.split("_");
    //                 if(parts[0] === 'ok'){
    //                     log(parts[1], "success");
    //                     cargarTablaParalelos( $("#periodo option:selected").val());
    //                 }else{
    //                     bootbox.alert('<i class="fa fa-exclamation-triangle text-danger fa-3x"></i> ' + '<strong style="font-size: 14px">' + parts[1] + '</strong>');
    //                     return false;
    //                 }
    //             }
    //         });
    //     } else {
    //         return false;
    //     }
    // }

    %{--function deleteRow(itemId) {--}%
    %{--    bootbox.dialog({--}%
    %{--        title: "Alerta",--}%
    %{--        message: "<i class='fa fa-trash fa-3x pull-left text-danger text-shadow'></i><p style='font-size: 14px; font-weight: bold'>" +--}%
    %{--            "¿Está seguro que desea eliminar el paralelo ? Esta acción no se puede deshacer.</p>",--}%
    %{--        closeButton: false,--}%
    %{--        buttons: {--}%
    %{--            cancelar: {--}%
    %{--                label: "Cancelar",--}%
    %{--                className: "btn-primary",--}%
    %{--                callback: function () {--}%
    %{--                }--}%
    %{--            },--}%
    %{--            eliminar: {--}%
    %{--                label: "<i class='fa fa-trash'></i> Eliminar",--}%
    %{--                className: "btn-danger",--}%
    %{--                callback: function () {--}%
    %{--                    var db= cargarLoader("Borrando...");--}%
    %{--                    $.ajax({--}%
    %{--                        type: "POST",--}%
    %{--                        url: '${createLink(controller: 'paralelo', action:'delete_ajax')}',--}%
    %{--                        data: {--}%
    %{--                            id: itemId--}%
    %{--                        },--}%
    %{--                        success: function (msg) {--}%
    %{--                            db.modal("hide");--}%
    %{--                            var parts = msg.split("_");--}%
    %{--                            if (parts[0] === 'ok') {--}%
    %{--                                log(parts[1], "success");--}%
    %{--                                cargarTablaParalelos( $("#periodo option:selected").val());--}%
    %{--                            } else {--}%
    %{--                                bootbox.alert('<i class="fa fa-exclamation-triangle text-danger fa-3x"></i> ' + '<strong style="font-size: 14px">' + parts[1] + '</strong>');--}%
    %{--                            }--}%
    %{--                        }--}%
    %{--                    });--}%
    %{--                }--}%
    %{--            }--}%
    %{--        }--}%
    %{--    });--}%
    %{--}--}%

//    $(".btnCrear").click(function () {
//        createEditRowParalelo();
//        return false;
//    });

</script>

</body>
</html>
