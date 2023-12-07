<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<g:else>
    <g:if test="${carrera?.id}">
        <div class="row">
            <div class="col-md-2 show-label">
                Id
            </div>
            <div class="col-md-8">
                <g:fieldValue bean="${carrera}" field="id"/>
            </div>
        </div>
    </g:if>
    <g:if test="${carrera?.nombre}">
        <div class="row">
            <div class="col-md-2 show-label">
                Nombre
            </div>
            <div class="col-md-8">
                %{--<g:fieldValue bean="${carrera}" field="nombre"/> --}%
                <span>${carrera?.nombre}</span>
            </div>
        </div>
    </g:if>
    <g:if test="${carrera?.facultad}">
        <div class="row">
            <div class="col-md-2 show-label">
                Facultad
            </div>
            <div class="col-md-8">
                %{--<g:fieldValue bean="${carrera}" field="nombre"/> --}%
                <span>${carrera?.facultad?.nombre}</span>
            </div>
        </div>
    </g:if>
</g:else>