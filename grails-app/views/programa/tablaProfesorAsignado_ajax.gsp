<g:if test="${dicta}">
    <div role="main" style="margin-top: 10px;">
        <table class="table table-bordered table-striped table-condensed table-hover">
            <thead>
            <tr>
                <th style="width: 20%">Nombre</th>
            </tr>
            </thead>

            <tbody>
            %{--            <g:each in="${gestiones}" status="i" var="gestion">--}%
            %{--                <tr data-id="${gestion.id}">--}%
            %{--                    <td style="width: 20%">${gestion?.periodo?.descripcion}</td>--}%
            %{--                    <td style="width: 30%">${gestion?.asignatura?.nombre}</td>--}%
            %{--                    <td style="width: 25%">${gestion?.profesor?.apellido + " " + gestion?.profesor?.nombre}</td>--}%
            %{--                    <td style="width: 10%">${gestion?.hora}</td>--}%
            %{--                    <td style="width: 10%;">--}%
            %{--                        <a href="#" class="btn btn-success btn-xs btnEditarGestion" title="Editar" data-id="${gestion.id}" data-prof="${gestion?.profesor?.id}" data-asig="${gestion?.asignatura?.id}" data-hora="${gestion?.hora}">--}%
            %{--                            <i class="fa fa-edit"></i>--}%
            %{--                        </a>--}%
            %{--                        <a href="#" class="btn btn-danger btn-xs btnBorrarGestion" data-id="${gestion.id}" title="Borrar">--}%
            %{--                            <i class="fa fa-trash"></i>--}%
            %{--                        </a>--}%
            %{--                        <a href="#" class="btn btn-info btn-xs btnObservacionGestion" data-id="${gestion.id}" title="Observaciones">--}%
            %{--                            <i class="fa fa-book"></i>--}%
            %{--                        </a>--}%
            %{--                    </td>--}%
            %{--                </tr>--}%
            %{--            </g:each>--}%

            </tbody>
        </table>
    </div>
</g:if>
<g:else>
    <div class="alert alert-warning" style="text-align: center; font-size: 14px"><i class="fa fa-exclamation-triangle fa-3x text-info"></i> No existe profesor asignado para: <br> <strong>${paralelo?.nivel?.descripcion + " - " + paralelo?.numero + " , "  + asignatura?.nombre}</strong> </div>
</g:else>
