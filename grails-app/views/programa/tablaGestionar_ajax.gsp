<div class="" style="width: 99.7%;height: 600px; overflow-y: auto;float: right; margin-top: -20px">
    <table class="table-bordered table-striped table-condensed table-hover" style="width: 100%">
        <tbody>
        <g:if test="${resp.size() > 0}">
            <g:set var="total" value="${0}"/>
            <g:set var="asig" value="${resp[0]?.asig__id}"/>
            <g:each in="${resp}" var="registro">
                <tr>
                    <td style="width: 10%">${registro?.prdodscr}</td>
                    <td style="width: 32%">${registro?.asignmbr}</td>
                    <td style="width: 15%">${registro?.profapll}</td>
                    <td style="width: 15%">${registro?.profnmbr}</td>
                    <td style="width: 8%; text-align: center">${registro?.gstnhora}</td>
                    <td style="width: 20%">${registro?.gstnobsr}</td>
%{--                    <td style="width: 15%; text-align: center">--}%
%{--                        <a href="#" data-id="${paralelo?.id}" class="btn btn-success btn-xs btn-edit btn-ajax" title="Editar">--}%
%{--                            <i class="fa fa-edit"></i>--}%
%{--                        </a>--}%
%{--                        <a href="#" data-id="${paralelo?.id}" class="btn btn-danger btn-xs btn-borrar btn-ajax" title="Eliminar">--}%
%{--                            <i class="fa fa-trash"></i>--}%
%{--                        </a>--}%
%{--                    </td>--}%
                    <g:set var="total" value="${total += registro?.gstnhora}"/>
                </tr>
            </g:each>
                <tr style="font-weight: bold">
                    <td colspan="2" style="text-align: right">${asig == 87 ? "2 lectores por cada tesis: ${Math.round(hric*2)} lectores --> ${hric/2.5} horas" : ''}</td>
                    <td colspan="2" style="text-align: right">TOTAL ${asig == 87 ? '(0.2h por cada Lectura)' : ''}</td>
                    %{--<td style="text-align: center">${asig == 87 ? total * 5 + ' TT': total }</td>--}%
                    <td style="text-align: center">${total}</td>
                    <td></td>
                </tr>
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

<script type="text/javascript">

    // $(".btn-edit").click(function () {
    //     var id = $(this).data("id");
    //     createEditRowParalelo(id);
    // });
    // $(".btn-borrar").click(function () {
    //     var id = $(this).data("id");
    //     deleteRow(id);
    // });

</script>