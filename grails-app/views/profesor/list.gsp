<!DOCTYPE html>
<html>
<head>
    %{--<meta name="layout" content="login">--}%
    <meta name="layout" content="main">
    <title>Profesores</title>

    <style type="text/css">
    input:invalid {
        border: 2px dashed red; !important;
    }

    input:invalid:required {
        background-image: linear-gradient(to right, pink, lightgreen);
    }

    input:valid {
        border: 2px solid black;
    }
    </style>

</head>

<body>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>

<!-- Botones -->
<div class="btn-toolbar toolbar">
    <div class="btn-group">
        <g:link controller="inicio" action="index" class="btn btn-secondary">
            <i class="fa fa-arrow-left"></i> Regresar
        </g:link>
    </div>

    <div class="btn-group">
    <a href="${createLink(controller: 'profesor', action: 'form_ajax')}" class="btn btn-primary" id="btnCrearFacultad">
        <i class="fa fa-user-plus"></i> Nuevo Profesor
    </a>
    </div>
</div>

<table class="table table-condensed table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Email</th>
        <th>Extension</th>
        <th>Sexo</th>
        <th>Tipo de Profesor</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <g:if test="${profesores.size() > 0}">
        <g:each in="${profesores}" var="profesor">
            <tr data-id="${profesor?.id}">
                <td>${profesor?.nombre}</td>
                <td>${profesor?.apellido}</td>
                <td>${profesor?.mail}</td>
                <td>${profesor?.extension}</td>
                <td>${profesor?.sexo}</td>
                <td>${profesor?.tipoProfesor?.descripcion}</td>
                <td>
                    <a href="#" data-id="${profesor?.id}" class="btn btn-success btn-sm btn-edit btn-ajax" title="Editar">
                        <i class="fa fa-edit"></i>
                    </a>
                    <a href="#" data-id="${profesor?.id}" class="btn btn-danger btn-sm btn-borrar btn-ajax" title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                    <a href="#" data-id="${profesor?.id}" class="btn btn-info btn-sm btn-show btn-ajax" title="Ver">
                        <i class="fa fa-search"></i>
                    </a>
                </td>
            </tr>
        </g:each>
    </g:if>
    <g:else>
        <tr class="danger">
            <td class="text-center" colspan="8">
                No se encontraron registros que mostrar
            </td>
        </tr>
    </g:else>
    </tbody>
</table>

<script type="text/javascript">
    var id = null;
    function submitForm() {
        var $form = $("#frmProfesor");
        var $btn = $("#dlgCreateEdit").find("#btnSave");
        $.ajax({
            type: "POST",
            url: $form.attr("action"),
            data: $form.serialize(),
            success: function (msg) {
                if (msg == 'ok') {
                    log("Profesor guardado correctamente", "success");
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                } else {
                    log("Error al guardar al profesor", "error")
                }
            }
        });
    }

    function deleteRow(itemId) {
        bootbox.dialog({
            title: "Alerta",
            message: "<i class='fa fa-trash fa-3x pull-left text-danger text-shadow'></i><p>" +
            "¿Está seguro de que desea eliminar al profesor seleccionado? Esta acción no se puede deshacer.</p>",
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
                            url: '${createLink(controller: 'profesor', action:'delete_ajax')}',
                            data: {
                                id: itemId
                            },
                            success: function (msg) {
                                if (msg == 'ok') {
                                    setTimeout(function () {
                                        location.reload();
                                    }, 300);
                                } else {
                                    log("Error al borrar al profesor", "error")
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    function createEditRow(id) {
        var title = id ? "Editar" : "Crear";
        var data = id ? {id: id} : {};
        $.ajax({
            type: "POST",
            url: "${createLink(controller: 'profesor', action:'form_ajax')}",
            data: data,
            success: function (msg) {
                var b = bootbox.dialog({
                    title: title + " Profesor",
                    closeButton: false,
                    message: msg,
                });
                setTimeout(function () {
                    b.find(".form-control").first().focus()
                }, 500);
            }
        });
    }

    $(function () {
    $("#btnCrearFacultad").on('click', function () {
        createEditRow();
        return false;
    });

    $(".btn-edit").on('click', function () {
        var id = $(this).data("id");
        createEditRow(id);
    });

    $(".btn-borrar").on('click', function () {
        var id = $(this).data("id");
        deleteRow(id);
    });
     $(".btn-show").click(function () {
            var title = "Ver Profesor";
            var id = $(this).data("id");
            $.ajax({
                type: "POST",
                url: "${createLink(controller: 'profesor', action:'show_ajax')}",
                data: {id: id},
                success: function (msg) {
                    var b = bootbox.dialog({
                        title: title,
                        closeButton: false,
                        message: msg,
                        buttons: {
                            aceptar: {
                                label: "Aceptar",
                                className: "btn-primary",
                                callback: function () {
                                }
                            }
                        },
                    }); //dialog
                    setTimeout(function () {
                        b.find(".form-control").first().focus()
                    }, 500);
                } //successJava
            });
            //location.reload()//ajax
        });
});

</script>

</body>
</html>
