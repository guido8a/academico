<div role="main" style="margin-top: 10px;">
    <table class="table table-bordered table-striped table-condensed table-hover">
        <thead>
        <tr>
            <th style="width: 10%">Período</th>
            <th style="width: 25%">Asignatura</th>
            <th style="width: 20%">Profesor</th>
            <th style="width: 25%">Horas</th>
            <th style="width: 10%">Observaciones</th>
            <th style="width: 5%">Acciones</th>
        </tr>
        </thead>
    </table>
</div>

<div class="" style="width: 99.7%;height: 600px; overflow-y: auto;float: right; margin-top: -20px">
    <table class="table-bordered table-striped table-condensed table-hover" style="width: 100%">
        <tbody>
        <g:if test="${gestiones.size() > 0}">
            <g:each in="${gestiones}" status="i" var="gestion">
                <tr data-id="${gestion.id}">
                    <td style="width: 10%">${gestion?.periodo?.descripcion}</td>
                    <td style="width: 25%">${gestion?.asignatura?.nombre}</td>
                    <td style="width: 20%">${gestion?.profesor?.apellido + " " + gestion?.profesor?.nombre}</td>
                    <td style="width: 25%">${gestion?.hora}</td>
                    <td style="width: 10%">${gestion?.observaciones}</td>
                    <td style="width: 5%;">
                        <a href="#" class="btn btn-success btn-xs">
                            <i class="fa fa-edit"></i>
                        </a>
                        <a href="#" class="btn btn-danger btn-xs">
                            <i class="fa fa-trash"></i>
                        </a>
                    </td>
                </tr>
            </g:each>
        </g:if>
        <g:else>
            <div class="alert alert-warning" style="text-align: center"><i class="fa fa-exclamation-triangle fa-3x text-info"></i> No existen datos para el período <strong>${periodo?.descripcion}</strong> </div>
        </g:else>
        </tbody>
    </table>
</div>