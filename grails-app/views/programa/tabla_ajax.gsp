<table class="table-condensed table-bordered table-striped table-hover" style="margin-top: 20px">
    <thead style="text-align: center">
    <tr>

        <th>Hora</th>
        <g:each in="${dias}" var="d">
            <th>${d?.nombre}</th>
        </g:each>

    </tr>
    </thead>
    <tbody>
    %{--<g:each in="${horas}" var="hora">--}%
    <g:each in="${horario}" var="h">
        <tr data-id="${h?.lun?.split(';')[0]}" >
        <td width="15%">${h?.hora}</td>

        %{--"${h.lun}"--}%
        %{--"${h.lun.toString().split(';')}"--}%
        <g:if test="${h?.lun?.size() > 10}">
            <td width="10%" data-id="${h?.lun?.split(';')[2]}" class="${h?.lun?.split(';')[3] == 'S' ? 'usado' : 'otro' }"><i class="fa fa-check"></i>
                <a href="#" data-hora="${h?.lun?.split(';')[2]}" class="btn-danger btn-sm btn-borra-hora btn-ajax"
                   title="Eliminar">
                    <i class="fa fa-trash"></i>
                </a>
            </td>
        </g:if>
        <g:else>
            <td width="10%" class="horas libre"
                data-dia="${h?.lun?.split(';')[0]}" data-hora="${h?.lun?.split(';')[1]}">
                Libre
                %{--${h?.lun?.split(';')[0]}--}%
            </td>
        </g:else>

        <g:if test="${h?.mar?.size() > 10}">
            <td width="10%" data-id="${h?.mar?.split(';')[2]}" class="usado"><i class="fa fa-check"></i>
                <a href="#" data-hora="${h?.mar?.split(';')[2]}" class="btn-danger btn-sm btn-borra-hora btn-ajax"
                   title="Eliminar">
                    <i class="fa fa-trash"></i>
                </a>
            </td>
        </g:if>
        <g:else>
            <td width="10%" class="horas libre"
                data-dia="${h?.mar?.split(';')[0]}" data-hora="${h?.mar?.split(';')[1]}">
                Libre
            </td>
        </g:else>

        <g:if test="${h?.mie?.size() > 10}">
            <td width="10%" data-id="${h?.mie?.split(';')[2]}" class="usado"><i class="fa fa-check"></i>
                <a href="#" data-hora="${h?.mie?.split(';')[2]}" class="btn-danger btn-sm btn-borra-hora btn-ajax"
                   title="Eliminar">
                    <i class="fa fa-trash"></i>
                </a>
            </td>
        </g:if>
        <g:else>
            <td width="10%" class="horas libre"
                data-dia="${h?.mie?.split(';')[0]}" data-hora="${h?.mie?.split(';')[1]}">
                Libre
            </td>
        </g:else>

        <g:if test="${h?.jue?.size() > 10}">
            <td width="10%" data-id="${h?.jue?.split(';')[2]}" class="usado"><i class="fa fa-check"></i>
                <a href="#" data-hora="${h?.jue?.split(';')[2]}" class="btn-danger btn-sm btn-borra-hora btn-ajax"
                   title="Eliminar">
                    <i class="fa fa-trash"></i>
                </a>
            </td>
        </g:if>
        <g:else>
            <td width="10%" class="horas libre"
                data-dia="${h?.jue?.split(';')[0]}" data-hora="${h?.jue?.split(';')[1]}">
                Libre
            </td>
        </g:else>

        <g:if test="${h?.vie?.size() > 10}">
            <td width="10%" data-id="${h?.vie?.split(';')[2]}" class="usado"><i class="fa fa-check"></i>
                <a href="#" data-hora="${h?.vie?.split(';')[2]}" class="btn-danger btn-sm btn-borra-hora btn-ajax"
                   title="Eliminar">
                    <i class="fa fa-trash"></i>
                </a>
            </td>
        </g:if>
        <g:else>
            <td width="10%" class="horas libre"
                data-dia="${h?.vie?.split(';')[0]}" data-hora="${h?.vie?.split(';')[1]}">
                Libre
            </td>
        </g:else>

        <g:if test="${h?.sab?.size() > 10}">
            <td width="10%" data-id="${h?.sab?.split(';')[2]}" class="usado"><i class="fa fa-check"></i>
                <a href="#" data-hora="${h?.sab?.split(';')[2]}" class="btn-danger btn-sm btn-borra-hora btn-ajax"
                   title="Eliminar">
                    <i class="fa fa-trash"></i>
                </a>
            </td>
        </g:if>
        <g:else>
            <td width="10%" class="horas libre"
                data-dia="${h?.sab?.split(';')[0]}" data-hora="${h?.sab?.split(';')[1]}">
                Libre
            </td>
        </g:else>

        <g:if test="${h?.dom?.size() > 10}">
            <td width="10%" data-id="${h?.dom?.split(';')[2]}" class="usado"><i class="fa fa-check"></i>
                <a href="#" data-hora="${h?.dom?.split(';')[2]}" class="btn-danger btn-sm btn-borra-hora btn-ajax"
                   title="Eliminar">
                    <i class="fa fa-trash"></i>
                </a>
            </td>
        </g:if>
        <g:else>
            <td width="10%" class="horas libre"
                data-dia="${h?.dom?.split(';')[0]}" data-hora="${h?.dom?.split(';')[1]}">
                Libre
            </td>
        </g:else>

    </g:each>

    </tr>
    %{--</g:each>--}%
    </tbody>
</table>

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
