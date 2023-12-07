<!DOCTYPE html>
<html>
<head>
    %{--<meta name="layout" content="login">--}%
    <meta name="layout" content="main">
    <title>Tipo Actividades</title>

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

<!-- botones -->
<div class="btn-toolbar toolbar">
    <div class="btn-group">
        <g:link controller="inicio" action="index" class="btn btn-secondary">
            <i class="fa fa-arrow-left"></i> Regresar
        </g:link>
    </div>

    <div class="btn-group">
        <a href="#" class="btn btn-primary btnCrear">
            <i class="fa fa-clipboard-list"></i> Nuevo Tipo Actividad
        </a>
    </div>
</div>

<table class="table table-condensed table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <g:if test="${tipoActividades.size() > 0}">
        <g:each in="${tipoActividades}" var="tipoActividad">
            <tr data-id="${tipoActividad?.id}">
                <td>${tipoActividad?.id}</td>
                <td>${tipoActividad?.descripcion}</td>
                <td>
                    <a href="#" data-id="${tipoActividad?.id}" class="btn btn-success btn-sm btn-edit btn-ajax" title="Editar">
                        <i class="fa fa-edit"></i>
                    </a>
                    <a href="#" data-id="${tipoActividad?.id}" class="btn btn-danger btn-sm btn-borrar btn-ajax" title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                    <a href="#" data-id="${tipoActividad?.id}" class="btn btn-info btn-sm btn-show btn-ajax" title="Ver">
                        <i class="fa fa-search"></i>
                    </a>
                </td>
            </tr>
        </g:each>
    </g:if>
    <g:else>
        <tr class="danger">
            <td class="text-center" colspan="2">
                No se encontraron registros que mostrar
            </td>
        </tr>
    </g:else>
    </tbody>
</table>

<script type="text/javascript">
    var id = null;
    function submitForm() {
        var $form = $("#frmTipoActividad");
        var $btn = $("#dlgCreateEdit").find("#btnSave");
        $.ajax({
            type: "POST",
            url: $form.attr("action"),
            data: $form.serialize(),
            success: function (msg) {
                if (msg == 'ok') {
                    log("Tipo Actividad guardada correctamente", "success");
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                } else {
                    log("Error al guardar el Tipo Actividad", "error")
                }
            }
        });
    }

    function deleteRow(itemId) {
        bootbox.dialog({
            title: "Alerta",
            message: "<i class='fa fa-trash fa-3x pull-left text-danger text-shadow'></i><p>" +
            "¿Está seguro que desea eliminar el Tipo Actividad seleccionada? Esta acción no se puede deshacer.</p>",
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
                            url: '${createLink(controller: 'tipoActividad', action:'delete_ajax')}',
                            data: {
                                id: itemId
                            },
                            success: function (msg) {
                                if (msg == 'ok') {
                                    setTimeout(function () {
                                        location.reload();
                                    }, 300);
                                } else {
                                    log("Error al borrar el Tipo Actividad", "error")
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
            url: "${createLink(controller: 'tipoActividad', action:'form_ajax')}",
            data: data,
            success: function (msg) {
                var b = bootbox.dialog({
                    title: title + " TipoActividad" ,
                    closeButton: false,
                    message: msg,
                }); //dialog
                setTimeout(function () {
                    b.find(".form-control").first().focus()
                }, 500);
            } //success
        });
        //location.reload()//ajax
    } //createEdit

    $(function () {

        $(".btnCrear").click(function () {
            createEditRow();
            return false;
        });

        $(".btn-edit").click(function () {
            var id = $(this).data("id");
            createEditRow(id);
        });
        $(".btn-borrar").click(function () {
            var id = $(this).data("id");
            deleteRow(id);
        });
        $(".btn-show").click(function () {
            var title = "Ver Tipo de Actividad";
            var id = $(this).data("id");
            $.ajax({
                type: "POST",
                url: "${createLink(controller: 'tipoActividad', action:'show_ajax')}",
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
