<%@ page import="tutor.Asignatura" %>
<!DOCTYPE html>
<html>
<head>
    %{--<meta name="layout" content="login">--}%
    <meta name="layout" content="main">
    <title>Asignaturas</title>

    <style type="text/css">
    .gestion > td {
        background-color: #e7ffe9;
        color: #0c5460;
    }

    .normal > td {
        background-color: #d7dff9;
        color: #0c3440;
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
            <i class="fa fa-clipboard-list"></i> Nueva Asignatura
        </a>
    </div>
</div>


<div class="btn-toolbar toolbar"style="margin-left: 10px; text-align: center">
    <div class="col-md-2" style="margin-left: 300px">
        <label class="control-label text-info">Carrera</label>
        <g:select name="buscarPor" class="buscarPor col-md-12 form-control" value="${params.carrera}"
                  from="${tutor.Carrera.list([sort: 'nombre'])}" optionKey="id" optionValue="nombre" />
    </div>
    <div class="col-md-2">
        <label class="control-label text-info">Nivel</label>
        <g:select name="nivel" class="estado form-control" from="${tutor.Nivel.list([sort: 'id'])}"
                  optionKey="id" optionValue="descripcion" value="${params.nivel}"/>
    </div>
    <div class="col-md-2">
        <label class="control-label text-info">Criterio</label>
        <g:textField name="buscarCriterio" id="criterioCriterio" class="form-control"/>
    </div>
    <div class="col-md-1" style="margin-top: 20px">
        <button class="btn btn-info" id="btnBuscar"><i class="fa fa-search"></i></button>
    </div>

    <div class="col-md-1" style="margin-top: 20px">
        <button class="btn btn-danger" id="btnBuscaGes"><i class="fa fa-search"></i>Gestión</button>
    </div>
</div>



<table class="table table-condensed table-bordered table-striped table-hover">
    <thead style="text-align: center">
    <tr>
        <th>Código</th>
        <th>Asignatura</th>
        <th>Carrera</th>
        <th>Nivel</th>
        <th>Créd.</th>
        <th>Práct.</th>
        <th>Teór.</th>
        <th>Gest.</th>
        <th>Paralelos</th>
        <th>Cupo</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <g:if test="${asignaturas?.size() > 0}">
        <g:each in="${asignaturas}" var="asignatura">
            <tr data-id="${asignatura?.id}">
                <td width="8%">${asignatura?.codigo}</td>
                <td width="20%">${asignatura?.nombre}</td>
                <td width="12%">${asignatura?.carrera?.nombre}</td>
                <td width="10%">${asignatura?.nivel?.descripcion}</td>
                <td width="6%">${asignatura?.creditos}</td>
                <td width="6%">${asignatura?.horasPractica}</td>
                <td width="6%">${asignatura?.horasTeoria}</td>
                <td width="6%">${asignatura?.horasGestion}</td>
                %{--<td width="6%">${tutor.Paralelo.countByAsignatura(tutor.Asignatura.get(asignatura.id))}</td>--}%
                %{--<td width="6%">${tutor.Paralelo.findAllByAsignatura(tutor.Asignatura.get(asignatura.id))?.numero?.join('-')}</td>--}%
                %{--<td width="6%">${tutor.Paralelo.findAllByAsignatura(tutor.Asignatura.get(asignatura.id)).cupo.sum()}</td>--}%

                <td width="14%">
                    <a href="#" data-id="${asignatura?.id}" class="btn btn-success btn-sm btn-edit btn-ajax"
                       title="Editar">
                        <i class="fa fa-edit"></i>
                    </a>
                    <a href="#" data-id="${asignatura?.id}" class="btn btn-danger btn-sm btn-borrar btn-ajax"
                       title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                    <a href="#" data-id="${asignatura?.id}" class="btn btn-info btn-sm btn-show btn-ajax" title="Ver">
                        <i class="fa fa-search"></i>
                    </a>
                    <g:if test="${asignatura?.tipoActividad.descripcion == 'Académica'}">
                        <a href="#" data-id="${asignatura?.id}" class="btn btn-info btn-sm btn-curso btn-ajax"
                           title="Programación académica">
                            <i class="fa fa-check"></i>
                        </a>
                    </g:if>
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
                    log("Error al guardar la asignatura", "error")
                }
            }
        });
    }

    function deleteRow(itemId) {
        bootbox.dialog({
            title: "Alerta",
            message: "<i class='fa fa-trash fa-3x pull-left text-danger text-shadow'></i><p>" +
            "¿Está seguro que desea eliminar la asignatura seleccionada? Esta acción no se puede deshacer.</p>",
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
                            url: '${createLink(controller: 'asignatura', action:'delete_ajax')}',
                            data: {
                                id: itemId
                            },
                            success: function (msg) {
                                if (msg == 'ok') {
                                    setTimeout(function () {
                                        location.reload();
                                    }, 300);
                                } else {
                                    log("Error al borrar la asignatura", "error")
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
            url: "${createLink(controller: 'asignatura', action:'form_ajax')}",
            data: data,
            success: function (msg) {
                var b = bootbox.dialog({
                    title: title + " Asignatura",
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
            var title = "Ver Asignatura";
            var id = $(this).data("id");
            $.ajax({
                type: "POST",
                url: "${createLink(controller: 'asignatura', action:'show_ajax')}",
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


        $(".btn-curso").click(function () {
            var id = $(this).data("id");
            location.href = "${createLink(controller: 'programa', action:'horario')}" + "?id=" + id
        });


        $("#btnBuscar").click(function () {
            var carrera = $('#buscarPor').val();
            var nivel = $('#nivel').val();
            var criterio = $('#criterioCriterio').val();
            console.log('Buscar', carrera, nivel, criterio)
            location.href = "${createLink(controller: 'asignatura', action:'list')}"
                + "?carrera=" + carrera + "&nivel=" + nivel + "&criterio=" + criterio
        });

        $("#btnBuscaGes").click(function () {
            var criterio = $('#criterioCriterio').val();
            console.log('BuscarGes', criterio)
            location.href = "${createLink(controller: 'asignatura', action:'list')}"
                + "?criterioGes=" + criterio
        });

    });
</script>

</body>
</html>
