
<g:form class="form-horizontal" name="frmAntecedentes" role="form" controller="paciente" action="savePaciente_ajax" method="POST">
    <g:hiddenField name="id" value="${paciente?.id}" />

    <div class="form-group ${hasErrors(bean: paciente, field: 'antecedentes', 'error')}">
        <span class="grupo">
            <label for="antecedentes" class="col-md-2 control-label text-info">
                Antecedentes
            </label>
            <span class="col-md-8">
                <g:textArea name="antecedentes" style="resize: none; height: 130px" maxlength="255" class="form-control" value="${paciente?.antecedentes}"/>
            </span>
        </span>
    </div>

    <div class="form-group ${hasErrors(bean: paciente, field: 'antecedentesPatologicosFam', 'error')}">
        <span class="grupo">
            <label for="antecedentes" class="col-md-2 control-label text-info">
                Antecedentes patológicos familiares
            </label>
            <span class="col-md-8">
                <g:textArea name="antecedentesPatologicosFam" style="resize: none; height: 130px" maxlength="255" class="form-control" value="${paciente?.antecedentesPatologicosFam}"/>
            </span>
        </span>
    </div>

    <g:if test="${paciente?.sexo == 'F'}">
        <div class="form-group ${hasErrors(bean: paciente, field: 'antecedentesGinecobstreticos', 'error')}">
            <span class="grupo">
                <label for="antecedentes" class="col-md-2 control-label text-info">
                    Antecedentes Gineco Obstétricos
                </label>
                <span class="col-md-8">
                    <g:textArea name="antecedentes" style="resize: none; height: 130px" maxlength="255" class="form-control" value="${paciente?.antecedentesGinecobstreticos}"/>
                </span>
            </span>
        </div>
    </g:if>
</g:form>