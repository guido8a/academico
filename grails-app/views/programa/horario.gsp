<!DOCTYPE html>
<html>
<head>
    %{--<meta name="layout" content="login">--}%
    <meta name="layout" content="main">
    <title>Programación</title>

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
        background-color: #71bacf;
    }
    .otro {
        text-align: center !important;
        background-color: #dfbacf;
    }
    .libre {
    //background-color: #dadada;
        color: #a0a0a0;
    }
    .horas {
        text-align: center !important;
    }
    </style>

</head>

<body>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>


<div class="col-md-12">
    <h3 style="text-align: center; margin-top: 10px">Programación de - ${asignatura.nombre} - Créditos: ${asignatura.creditos} </h3>
</div>
<!-- botones -->
<div class="container" style="width: 1000px">
    <div class="btn-toolbar toolbar" style="margin-top: 10px">
        <div class="btn-group">
            <g:link controller="asignatura" action="list" class="btn btn-secondary">
                <i class="fa fa-arrow-left"></i> Regresar a Asingaturas
            </g:link>
        </div>

        <div class="btn-group" style="margin-left: 40px">
            <a href="#" class="btn btn-primary" id="btnParalelo">
                <i class="fa fa-clipboard-list"></i> Crear paralelo
            </a>
        </div>
        <div class="col-md-1">
            <g:select name="paralelo" from="${tutor.Paralelo.findAllByAsignatura(asignatura, [sort: 'nrc'])}"
                      class="form-control input-sm required" optionValue="numero" optionKey="id"
                      value="${hora?.carrera}"/>
        </div>

        <div class="btn-group">
            <a href="#" class="btn btn-primary" id="btnEditar" title="Editar Paralelo">
                <i class="fa fa-edit"></i>
            </a>
        </div>
        <div class="btn-group">
            <a href="#" class="btn btn-danger" id="btnBorrar">
                <i class="fa fa-trash"></i>
            </a>
        </div>

        <div class="col-md-5 text-info" style="margin-top: 10px">
                <i class="fa fa-exclamation-triangle"></i> Debe crear un paralelo para definir su horario
        </div>
    </div>

    <div id="divTabla">

    </div>

</div>

%{--<elm:pagination total="${tipoElementoInstanceCount}" params="${params}"/>--}%

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
                if (msg == 'ok') {
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
                                if (msg == 'ok') {
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
                                if (msg == 'ok') {
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

    function creaHora(dia, hora) {
        var parl = $("#paralelo").val();

        console.log('dia:', dia, 'hora', hora)
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
                                        parl: parl,
                                        dia: dia,
                                        hora: hora
                                    },
                                    success: function (msg) {
                                        if (msg == 'ok') {
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
        var asig = "${asignatura?.id}"

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
                    class: "modal-lg",
                }); //dialog
                setTimeout(function () {
                    b.find(".form-control").first().focus()
                }, 500);
            } //success
        });
        //location.reload()//ajax
    }


    function cargaTabla(id) {
        var asig = "${asignatura?.id}"
        var data = {asig: asig, parl: id}

        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'programa', action:'tabla_ajax')}",
            data: data,
            success: function (msg) {
                $("#divTabla").html(msg);
            } //success
        });
        //location.reload()//ajax
    }// /createEdit

    $(function () {

        $( document ).ready(function() {
            //console.log( "ready!" );
            var asig = "${asignatura.id}"
            var parl = $("#paralelo").val()
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
            var id = $("#paralelo").val()
            console.log("id", id)
            createEditRow(id);
            return false;
        });

        $(".btn-edit").click(function () {
            var id = $(this).data("id");
            createEditRow(id);
        });
        $("#btnBorrar").click(function () {
            var id = $("#paralelo").val()
            deleteRow(id);
        });

        $("#paralelo").change(function () {
            var id = $(this).val();
            //console.log("id:", id)
            if(id) {
                cargaTabla(id)
            }
        });

    });
</script>

</body>
</html>
