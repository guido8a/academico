<g:if test="${existe}">
    <table class="table table-condensed table-bordered table-striped table-hover" style="margin-top: 20px; width: 100%">
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
            <g:set var="clorLun" value=""/>
            <g:set var="clorMar" value=""/>
            <g:set var="clorMie" value=""/>
            <g:set var="clorJue" value=""/>
            <g:set var="clorVie" value=""/>
            <g:set var="clorSab" value=""/>
            <g:set var="clorDom" value=""/>
            <g:if test="${h?.lun?.size() > 10}">
               <g:set var="clorLun" value="#${h?.lun.split('#')[1]}"/>
            </g:if>
            <g:if test="${h?.mar?.size() > 10}">
               <g:set var="clorMar" value="#${h?.mar.split('#')[1]}"/>
            </g:if>
            <g:if test="${h?.mie?.size() > 10}">
               <g:set var="clorMie" value="#${h?.mie.split('#')[1]}"/>
            </g:if>
            <g:if test="${h?.jue?.size() > 10}">
               <g:set var="clorJue" value="#${h?.jue.split('#')[1]}"/>
            </g:if>
            <g:if test="${h?.vie?.size() > 10}">
               <g:set var="clorVie" value="#${h?.vie.split('#')[1]}"/>
            </g:if>
            <g:if test="${h?.sab?.size() > 10}">
               <g:set var="clorSab" value="#${h?.sab.split('#')[1]}"/>
            </g:if>
            <g:if test="${h?.dom?.size() > 10}">
               <g:set var="clorDom" value="#${h?.dom.split('#')[1]}"/>
            </g:if>

            <tr data-id="${h?.lun}" >
            <td width="9%">${h?.hora}</td>


            %{--<td width="10%" class="dia" style="background-color:${clorLun}">--}%
                %{--${h?.lun?.size() > 20 ? h?.lun.split('#')[0] : 'Libre'}--}%
            %{--</td>--}%
            %{--<td width="10%" class="dia" style="background-color:${clorMar}">--}%
                %{--${h?.mar?.size() > 20 ? h?.mar.split('#')[0] : 'Libre'}--}%
            %{--</td>--}%
            %{--<td width="10%" class="dia" style="background-color:${clorMie}">--}%
                %{--${h?.mie?.size() > 20 ? h?.mie.split('#')[0] : 'Libre'}--}%
            %{--</td>--}%
            %{--<td width="10%" class="dia" style="background-color:${clorJue}">--}%
                %{--${h?.jue?.size() > 20 ? h?.jue.split('#')[0] : 'Libre'}--}%
            %{--</td>--}%
            %{--<td width="10%" class="dia" style="background-color:${clorVie}">--}%
                %{--${h?.vie?.size() > 20 ? h?.vie.split('#')[0] : 'Libre'}--}%
            %{--</td>--}%
            %{--<td width="10%" class="dia" style="background-color:${clorSab}">--}%
                %{--${h?.sab?.size() > 20 ? h?.sab.split('#')[0] : 'Libre'}--}%
            %{--</td>--}%
            %{--<td width="10%" class="dia" style="background-color:${clorDom}">--}%
                %{--${h?.dom?.size() > 20 ? h?.dom.split('#')[0] : 'Libre'}--}%
            %{--</td>--}%


            <g:if test="${h?.lun?.size() > 10}">
                <td width="10%" data-id="${h?.mar}"  class="${h?.lun?.split(';').size() > 1 ? 'otro' : 'usado'}">
                    ${h?.lun.split('#').size() > 2 ? h?.lun.split('#')[0] + ' || ' + h?.lun.split(';')[1].split('#')[0] : h?.lun.split('#')[0]}
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.lun}" data-hora="${h?.lun}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.mar?.size() > 10}">
                <td width="10%" data-id="${h?.mar}"  class="${h?.mar?.split(';').size() > 1 ? 'otro' : 'usado'}">
                    %{--${h.mar}--}%
                    ${h?.mar.split('#').size() > 2 ? h?.mar.split('#')[0] + ' || ' + h?.mar.split(';')[1].split('#')[0] : h?.mar.split('#')[0]}
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.mar}" data-hora="${h?.mar}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.mie?.size() > 10}">
                <td width="10%" data-id="${h?.mie}"  class="${h?.mie?.split(';').size() > 1 ? 'otro' : 'usado'}">
                    %{--${h.mie}--}%
                    ${h?.mie.split('#').size() > 2 ? h?.mie.split('#')[0] + ' || ' + h?.mie.split(';')[1].split('#')[0] : h?.mie.split('#')[0]}
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.mie}" data-hora="${h?.mie}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.jue?.size() > 10}">
                <td width="10%" data-id="${h?.jue}"  class="${h?.jue?.split(';').size() > 1 ? 'otro' : 'usado'}">
                    %{--${h.jue}--}%
                    ${h?.jue.split('#').size() > 2 ? h?.jue.split('#')[0] + ' || ' + h?.jue.split(';')[1].split('#')[0] : h?.jue.split('#')[0]}
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.jue}" data-hora="${h?.jue}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.vie?.size() > 10}">
                <td width="10%" data-id="${h?.vie}"  class="${h?.vie?.split(';').size() > 1 ? 'otro' : 'usado'}">
                    %{--${h.vie}--}%
                    ${h?.vie.split('#').size() > 2 ? h?.vie.split('#')[0] + ' || ' + h?.vie.split(';')[1].split('#')[0] : h?.vie.split('#')[0]}
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.vie}" data-hora="${h?.vie}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.sab?.size() > 10}">
                <td width="10%" data-id="${h?.sab}"  class="${h?.sab?.split(';').size() > 1 ? 'otro' : 'usado'}">
                    %{--${h.sab}--}%
                    ${h?.sab.split('#').size() > 2 ? h?.sab.split('#')[0] + ' || ' + h?.sab.split(';')[1].split('#')[0] : h?.sab.split('#')[0]}
                </td>
            </g:if>
            <g:else>
                <td width="10%" class="horas libre"
                    data-dia="${h?.sab}" data-hora="${h?.sab}">
                    Libre
                </td>
            </g:else>

            <g:if test="${h?.dom?.size() > 10}">
                <td width="10%" data-id="${h?.dom}"  class="${h?.dom?.split(';').size() > 1 ? 'otro' : 'usado'}">
                    ${h.dom}
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


