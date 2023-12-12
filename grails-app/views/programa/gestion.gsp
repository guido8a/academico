<%@ page import="tutor.TipoActividad; tutor.Periodo" %>
<!DOCTYPE html>
<html>
<head>
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
    <div class="btn-group col-md-2">
        <g:link controller="asignatura" action="list" class="btn btn-secondary">
            <i class="fa fa-arrow-left"></i> Regresar
        </g:link>
    </div>
    <h3 class="titl">Programación de Gestión </h3>
</div>
<!-- botones -->
<div class="container" style="width: 1000px">
    <div class="btn-toolbar toolbar" style="margin-top: 10px">



        <div class="col-md-12">
            <label for="nivel" class="col-md-1 control-label" style="text-align: right">
                Profesor
            </label>
            <div class="col-md-3">
            <g:select name="nivel" from="${tutor.Profesor.list([sort: 'apellido'])}"
                      class="form-control input-sm required" optionValue="apellido" optionKey="id"
                      />
            </div>
            <label for="nivel" class="col-md-1 control-label" style="text-align: right">
                Actividad de Gestión
            </label>
            <div class="col-md-4">
            <g:select name="nivel" from="${tutor.Asignatura.findAllByTipoActividad(tutor.TipoActividad.get(2) ,[sort: 'nombre'])}"
                      class="form-control input-sm required" optionValue="nombre" optionKey="id"
                      />
            </div>
            <label for="nivel" class="col-md-1 control-label" style="text-align: right">
                Horas
            </label>
            <div class="col-md-1">
                <g:textField name="horas" maxlength="2" class="form-control required text-uppercase"
                             style="border:solid 1px #ccc; width: 40px"
                             value="${gestion?.horas}"/>
            </div>

            <div class="col-md-1">
                <g:link controller="asignatura" action="list" class="btn btn-info">
                    <i class="fa fa-check"></i> Aceptar
                </g:link>
            </div>
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
                                                location.reload();
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


    function cargaTabla(id) {
        var asig = $("#asignatura option:selected").val();
        var data = {asig: asig, parl: id};

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

    // $(function () {

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


</script>

</body>
</html>
