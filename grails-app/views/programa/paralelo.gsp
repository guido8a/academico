<%@ page import="tutor.Periodo" %>
<!DOCTYPE html>
<html>
<head>
    %{--<meta name="layout" content="login">--}%
    <meta name="layout" content="main">
    <title>Horario paralelo</title>

    <style type="text/css">
    .gestion > td {
        background-color: #ff8080;
        color: #0c0460;
    }

    .normal > td {
        background-color: #d7dff9;
        color: #0c3440;
    }
    .usado {
        text-align: center !important;
        background-color: #91caef;
    }
    .otro {
        text-align: center !important;
        background-color: #d7bec8;
    }
    .libre {
    //background-color: #dadada;
        color: #606060;
    }
    .horas {
        text-align: center !important;
    }

    .titl {
        font-family: 'open sans condensed';
        font-weight: bold;
        text-shadow: -2px 2px 1px rgba(0, 0, 0, 0.25);
        color: #0070B0;
        margin-top: 15px;
        text-align: center;
    }
    </style>

</head>

<body>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>


<div class="col-md-12">
    <div class="btn-group">
        <g:link controller="asignatura" action="list" class="btn btn-primary">
            <i class="fa fa-arrow-left"></i> Regresar
        </g:link>
    </div>
    <h3 class="titl" style="margin-top: -35px">Horario del paralelo</h3>
</div>
<!-- botones -->
<div class="container" style="width: 1200px">
    <div class="btn-toolbar toolbar" style="margin-top: 10px">

        <div class="col-md-1">
            <label for="periodo" class="col-md-1 control-label" style="text-align: right">
                Período
            </label>
        </div>
        <div class="col-md-2">
            <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                      class="form-control input-sm required" optionValue="descripcion" optionKey="id"
            />
        </div>

        <div class="col-md-1">
            <label for="nivel" class="col-md-1 control-label" style="text-align: right">
                Nivel
            </label>
        </div>
        <div class="col-md-2">
            <g:select name="nivel" from="${tutor.Nivel.list([sort: 'numero'])}"
                      class="form-control input-sm required" optionValue="descripcion" optionKey="id"
            />
        </div>

        <div class="col-md-5" id="divParalelo">

        </div>

    </div>


    <div id="divTabla">

    </div>

</div>


<script type="text/javascript">
    var id = null;

    function submitForm() {
        var $form = $("#frmAsignatura");
        var $btn = $("#dlgCreateEdit").find("#btnSave");
        $.ajax({
            type: "POST",
            url: $form.attr("action"),
            data: $form.serialize(),
            success: function (msg) {
                if (msg === 'ok') {
                    log("Asignatura guardada correctamente", "success");
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                } else {
                    log("Error al guardar la hora", "error")
                }
            }
        });
    }

    function deleteRow(itemId) {
        bootbox.dialog({
            title: "Alerta",
            message: "<i class='fa fa-trash fa-3x pull-left text-danger text-shadow'></i><p>" +
            "¿Está seguro que desea eliminar el paralelo seleccionado? Esta acción no se puede deshacer.</p>",
            closeButton: false,
            buttons: {
                cancelar: {
                    label: "Cancelar",
                    className: "btn-primary",
                    callback: function () {
                    }
                },
                eliminar: {
                    label: "<i class='fa fa-trash'></i> Eliminar",
                    className: "btn-danger",
                    callback: function () {
                        $.ajax({
                            type: "POST",
                            url: '${createLink(controller: 'programa', action:'delete_ajax')}',
                            data: {
                                id: itemId
                            },
                            success: function (msg) {
                                if (msg === 'ok') {
                                    setTimeout(function () {
                                        location.reload();
                                    }, 300);
                                } else {
                                    log("Error al borrar la hora", "error")
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    function borraHora(itemId) {
        bootbox.dialog({
            title: "Alerta",
            message: "<i class='fa fa-trash fa-3x pull-left text-danger text-shadow'></i><p>" +
            "¿Está seguro que desea eliminar la hora seleccionada? Esta acción no se puede deshacer.</p>",
            closeButton: false,
            buttons: {
                cancelar: {
                    label: "Cancelar",
                    className: "btn-primary",
                    callback: function () {
                    }
                },
                eliminar: {
                    label: "<i class='fa fa-trash'></i> Eliminar",
                    className: "btn-danger",
                    callback: function () {
                        $.ajax({
                            type: "POST",
                            url: '${createLink(controller: 'programa', action:'borra_ajax')}',
                            data: {
                                id: itemId
                            },
                            success: function (msg) {
                                if (msg === 'ok') {
                                    setTimeout(function () {
                                        // location.reload();
                                        cargaTabla($("#paralelo option:selected").val(), $("#asignatura option:selected").val());
                                    }, 300);
                                } else {
                                    log("Error al borrar la hora", "error")
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    function creaHora(dia, hora) {
        var parl = $("#paralelo").val();
        var asig = $("#asignatura").val();

        console.log('crea hora con dia:', dia, 'hora', hora)
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'creaHora')}",
            data: {},
            success: function (msg) {
                var b = bootbox.dialog({
                    title: "Crear la Hora de clases",
                    closeButton: false,
                    message: msg,
                    buttons: {
                        cancelar: {
                            label: "Cancelar",
                            className: "btn-default",
                            callback: function () {
                            }
                        },
                        crear: {
                            label: "<i class='fa fa-trash'></i> Asignar hora",
                            className: "btn-info",
                            callback: function () {
                                $.ajax({
                                    type: "POST",
                                    url: '${createLink(controller: 'programa', action:'crea_ajax')}',
                                    data: {
                                        asig: asig,
                                        parl: parl,
                                        dia: dia,
                                        hora: hora
                                    },
                                    success: function (msg) {
                                        console.log('retiorna:', msg);
                                        if (msg === 'ok') {
                                            setTimeout(function () {
                                                // location.reload();
                                                cargaTabla($("#paralelo option:selected").val(), $("#asignatura option:selected").val());
                                            }, 300);
                                            log("Horario creado exitosamente", "success")
                                        } else {
                                            log("Error al borrar la hora", "error")
                                        }
                                    }
                                });
                            }
                        }
                    }

                }); //dialog
                setTimeout(function () {
                    b.find(".form-control").first().focus()
                }, 500);
            } //success
        });
        //location.reload()//ajax
    } //cre


    function createEditRow(id) {
        var title = id ? "Editar" : "Crear";
        var asig = $("#asignatura").val();

        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'creaParalelo')}",
            data: {id: id,
            asig: asig},
            success: function (msg) {
                var b = bootbox.dialog({
                    title: title + " Paralelo",
                    closeButton: false,
                    message: msg,
                    class: "modal-lg"
                }); //dialog
                setTimeout(function () {
                    b.find(".form-control").first().focus()
                }, 500);
            } //success
        });
        //location.reload()//ajax
    }


    function cargaTabla(parl) {
        // var asig = $("#asignatura option:selected").val();
        var data = {parl: parl};
        console.log('cargaTabla', parl)
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'parl_ajax')}",
            data: data,
            success: function (msg) {
                $("#divTabla").html(msg);
            } //success
        });
        //location.reload()//ajax
    }// /createEdit



        $( document ).ready(function() {
            //console.log( "ready!" );
            var asig = $("#asignatura").val();
            var parl = $("#paralelo").val();
            $("#paralelo").change()
        });

        $("#btnParalelo").click(function () {
            createEditRow();
            return false;
        });


        $("#btnProgramar").click(function () {
            paralelo();
            return false;
        });


        $("#btnCrear").click(function () {
            createEditRow();
            return false;
        });

        $("#btnEditar").click(function () {
            var id = $("#paralelo").val();
            // console.log("id", id)
            createEditRow(id);
            return false;
        });

        $(".btn-edit").click(function () {
            var id = $(this).data("id");
            createEditRow(id);
        });
        $("#btnBorrar").click(function () {
            var id = $("#paralelo").val();
            deleteRow(id);
        });

    cargaParalelo( $("#periodo option:selected").val(), $("#nivel option:selected").val() );

    function cargaParalelo(periodo, nivel){
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'cursos_ajax')}",
            data: {
                periodo: periodo,
                nivel: nivel
            },
            success: function (msg) {
                $("#divParalelo").html(msg);
            } //success
        });
    }

    $("#nivel").change(function () {
        var idNivel = $(this).val();
        var idPeriodo = $("#periodo option:selected").val();
        cargaParalelo(idPeriodo, idNivel);
    });

    $("#periodo").change(function () {
        var idPeriodo = $(this).val();
        var idNivel = $("#nivel option:selected").val();
        cargaParalelo(idPeriodo, idNivel);
    })

</script>

</body>
</html>
