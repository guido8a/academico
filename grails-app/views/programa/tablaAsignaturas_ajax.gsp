<div class="" style="width: 99.7%;height: 600px; overflow-y: auto;float: right; margin-top: -20px">
    <table class="table-bordered table-striped table-condensed table-hover" style="width: 100%">
        <tbody>
        <g:if test="${resp.size() > 0}">
            <g:set var="total" value="${0}"/>
            <g:each in="${resp}" var="registro">
                <tr>
                    <td style="width: 10%">${registro?.prdodscr}</td>
                    <td style="width: 25%">${registro?.asignmbr}</td>
                    <td style="width: 6%">${registro?.nvel__id}</td>
                    <td style="width: 5%">${registro?.parlnmro}</td>
                    <td style="width: 15%">${registro?.profapll}</td>
                    <td style="width: 15%">${registro?.profnmbr}</td>
                    <td style="width: 8%; text-align: center">${registro?.asigcred}</td>
                    <td style="width: 8%">${registro?.asigfcpr}</td>
                    <td style="width: 8%"><g:formatNumber number="${registro?.total}" format="##,##" minFractionDigits="1" maxFractionDigits="1" /></td>
                    <g:set var="total" value="${total += registro?.asigcred}"/>
                </tr>
            </g:each>
            <tr style="font-weight: bold">
                <td colspan="4" style="text-align: right">TOTAL</td>
                <td style="text-align: center">${total}</td>
                <td colspan="2"></td>
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


</script>