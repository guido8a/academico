<%@ page import="tutor.Periodo" %>
<div class="container">
    <div style="width: 600px">
        <div class="col-md-4">
            <label>
                Periodo
            </label>
            %{--<g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"--}%
                      %{--class="form-control input-sm " optionValue="descripcion" optionKey="id"--}%
            %{--/>--}%
            <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                      class="form-control input-sm required" optionValue="descripcion" optionKey="id"
                      value="${activo}" style="color: #2060A0; font-weight: bold; background-color: #eed; border-color: #0a6aa1"
            />

        </div>
        <div class="col-md-4">
            <label>
                Nivel
            </label>
            <g:select name="nivel" from="${tutor.Nivel.list([sort: 'numero'])}"
                      class="form-control input-sm " optionValue="descripcion" optionKey="id" noSelection="[null: 'Todos']"     />
        </div>
    </div>
</div>