<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<g:else>
    <g:if test="${facultad?.id}">
        <div class="row">
            <div class="col-md-2 show-label">
                Id
            </div>
            <div class="col-md-8">
                <g:fieldValue bean="${facultad}" field="id"/>
            </div>
        </div>
    </g:if>
    <g:if test="${facultad?.nombre}">
        <div class="row">
            <div class="col-md-2 show-label">
                Nombre
            </div>
            <div class="col-md-8">
                %{--<g:fieldValue bean="${facultad}" field="nombre"/> --}%
                <span style="background-color: #ddd">${facultad?.nombre}</span>
            </div>
        </div>
    </g:if>
</g:else>