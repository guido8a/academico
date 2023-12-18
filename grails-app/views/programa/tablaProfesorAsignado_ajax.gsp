<g:if test="${dicta}">
    <div role="main" style="margin-top: 10px;">
        <table class="table table-bordered table-striped table-condensed table-hover">
            <thead>
            <tr>
                <th style="width: 20%">Apellido</th>
                <th style="width: 20%">Nombre</th>
                <th style="width: 20%">Acciones</th>
            </tr>
            </thead>

            <tbody>
            <tr >
                <td style="width: 20%">${dicta?.profesor?.apellido}</td>
                <td style="width: 30%">${dicta?.profesor?.nombre}</td>
                <td style="width: 10%;">
                    <a href="#" class="btn btn-danger btn-xs btnBorrarGestion" data-id="${dicta.id}" title="Borrar">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</g:if>
<g:else>
    <div class="alert alert-warning" style="text-align: center; font-size: 14px"><i class="fa fa-exclamation-triangle fa-3x text-info"></i> No existe profesor asignado para: <br> <strong>${paralelo?.nivel?.descripcion + " - " + paralelo?.numero + " , "  + asignatura?.nombre}</strong> </div>
</g:else>
