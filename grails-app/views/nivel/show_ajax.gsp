<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<g:else>
    <g:if test="${nivel?.id}">
        <div class="row">
            <div class="col-md-4 show-label">
                Id
            </div>
            <div class="col-md-6">
                <g:fieldValue bean="${nivel}" field="id"/>
            </div>
        </div>
    </g:if>
    <g:if test="${nivel?.descripcion}">
        <div class="row">
            <div class="col-md-4 show-label">
                Descripción
            </div>
            <div class="col-md-6">
                %{--<g:fieldValue bean="${nivel}" field="descripcion"/> --}%
                <span>${nivel?.descripcion}</span>
            </div>
        </div>
    </g:if>
</g:else>