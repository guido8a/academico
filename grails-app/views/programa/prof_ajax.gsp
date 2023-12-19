<g:if test="${existe}">
    <table class="table-condensed table-bordered table-striped table-hover" style="margin-top: 20px; width: 100%">
        <thead style="text-align: center">
        <tr>

            <th width="9%">Hora</th>
            <g:each in="${dias}" var="d">
                <th width="13%">${d?.nombre}</th>
            </g:each>

        </tr>
        </thead>
        <tbody>
        <g:each in="${horario}" var="h">
            <tr data-id="${h?.lun}" >
            <td width="9%">${h?.hora}</td>

            <g:if test="${h?.lun?.size() > 10}">
                <td width="10%" data-id="${h?.lun}" class="${h?.lun?.split(';')[1].toInteger() > 1 ? 'otro' : 'usado'}">
                    ${h.lun}
                    <a href="#" data-hora="" class="btn btn-xs btn-danger btn-borra-hora "
                       title="Eliminar">
                        <i class="fa fa-trash"> </i>
                    </a>

                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.lun}" data-hora="${h?.lun}">
                    Libre
                    %{--${h?.lun?}--}%
                </td>
            </g:else>

            <g:if test="${h?.mar?.size() > 10}">
                <td width="10%" data-id="${h?.mar}"  class="${h?.mar?.split(';')[1].toInteger() > 1 ? 'otro' : 'usado'}">
                    ${h.mar}
                    <a href="#" data-hora="${h?.mar}" class= "btn btn-xs btn-danger btn-borra-hora"
                       title="Eliminar">
                        <i class="fa fa-trash"> </i>
                    </a>
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.mar}" data-hora="${h?.mar}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.mie?.size() > 10}">
                <td width="10%" data-id="${h?.mie}"  class="${h?.mie?.split(';')[1].toInteger() > 1 ? 'otro' : 'usado'}">
                    ${h.mie}
                    <a href="#" data-hora="${h?.mie}" class= "btn btn-xs btn-danger btn-borra-hora"
                       title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.mie}" data-hora="${h?.mie}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.jue?.size() > 10}">
                <td width="10%" data-id="${h?.jue}"  class="${h?.jue?.split(';')[1].toInteger() > 1 ? 'otro' : 'usado'}">
                    ${h.jue}
                    <a href="#" data-hora="${h?.jue}" class= "btn btn-xs btn-danger btn-borra-hora"
                       title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.jue}" data-hora="${h?.jue}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.vie?.size() > 10}">
                <td width="10%" data-id="${h?.vie}"  class="${h?.vie?.split(';')[1].toInteger() > 1 ? 'otro' : 'usado'}">
                    ${h.vie}
                    <a href="#" data-hora="${h?.vie}" class= "btn btn-xs btn-danger btn-borra-hora"
                       title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.vie}" data-hora="${h?.vie}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.sab?.size() > 10}">
                <td width="10%" data-id="${h?.sab}"  class="${h?.sab?.split(';')[1].toInteger() > 1 ? 'otro' : 'usado'}">
                    ${h.sab}
                    <a href="#" data-hora="${h?.sab}" class= "btn btn-xs btn-danger btn-borra-hora"
                       title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.sab}" data-hora="${h?.sab}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.dom?.size() > 10}">
                <td width="10%" data-id="${h?.dom}"  class="${h?.dom?.split(';')[1].toInteger() > 1 ? 'otro' : 'usado'}">
                    ${h.dom}
                    <a href="#" data-hora="${h?.dom}" class= "btn btn-xs btn-danger btn-borra-hora"
                       title="Eliminar">
                        <i class="fa fa-trash"></i>
                    </a>
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.dom}" data-hora="${h?.dom}">
                    Libre
                </td>
            </g:else>

        </g:each>

        </tr>
        </tbody>
    </table>
</g:if>
<g:else>
    <div class="alert alert-danger" style="text-align: center"> <i class="fa fa-exclamation-triangle fa-2x text-info"></i>
        <strong style="font-size: 14px"> No se ha programado a este profesor  </strong>
    </div>
</g:else>


<script type="text/javascript">
    $(".horas").click(function () {
        var dias = $(this).data("dia");
        var hora = $(this).data("hora");
        console.log("dia:", dias, 'hora: ', hora)
        creaHora(dias, hora)
    });

    $(".btn-borra-hora").click(function () {
        var id = $(this).data("hora");
        console.log("horario id:", id)
        borraHora(id)
    });

</script>
