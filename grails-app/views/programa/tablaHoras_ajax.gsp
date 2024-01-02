<div class="" style="width: 99.7%;height: 600px; overflow-y: auto;float: right; margin-top: -20px">
    <table class="table-bordered table-striped table-condensed table-hover" style="width: 100%">
        <tbody>
        <g:if test="${dicta.size() > 0}">
            <g:each in="${dicta}" var="horas">
                <tr >
                    <td style="width: 15%">${horas?.curso?.asignatura?.carrera?.nombre}</td>
                    <td style="width: 30%">${horas?.curso?.asignatura?.nombre}</td>
                    <td style="width: 15%">${horas?.curso?.asignatura?.creditos}</td>
                    <td style="width: 10%">${horas?.curso?.asignatura?.factorPreparacion}</td>
                    <td style="width: 10%">${horas?.curso?.asignatura?.creditos * horas?.curso?.asignatura?.factorPreparacion}</td>
                    <td style="width: 10%">${horas?.curso?.asignatura?.creditos + (horas?.curso?.asignatura?.creditos?.toInteger() * horas?.curso?.asignatura?.factorPreparacion?.toDouble())}</td>
                </tr>
            </g:each>
        </g:if>
        <g:else>
            <tr>
                <td class="text-center" colspan="3">
                    <i class="fa fa-exclamation-triangle text-info fa-3x"></i> <strong style="font-size: 14px"> No se encontraron registros que mostrar </strong>
                </td>
            </tr>
        </g:else>
        </tbody>
    </table>
</div>

