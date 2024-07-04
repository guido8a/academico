<%@ page import="tutor.Periodo" %>
<div class="container">
    <div style="">
        <div class="col-md-2">
            <label>
                Periodo
            </label>
            %{--<g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"--}%
                      %{--class="form-control input-sm required" optionValue="descripcion" optionKey="id"--}%
            %{--/>--}%
            <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                      class="form-control input-sm required" optionValue="descripcion" optionKey="id"
                      value="${activo}" style="color: #2060A0; font-weight: bold; background-color: #eed; border-color: #0a6aa1"
            />

        </div>
        <div class="col-md-4">
            <label>
                Docente
            </label>
            <g:select name="profesor" from="${tutor.Profesor.list().sort{it.apellido}}" class="form-control"
                      optionKey="id" optionValue="${{it.apellido + " " + it.nombre}}" noSelection="[null: 'TODOS']" />
        </div>

        <div class="col-md-9"></div>

        <div class="col-md-5" style="border: solid 1px; margin-top: 5px; margin-left: 15px">
           <label class="col-md-12 text-info" style="font-style: italic"> Opciones de impresión </label>

            <div class="col-md-4">
                <label>
                    Archivos separados
                </label>
                <input type="checkbox" id="separados">
            </div>

                <div class="col-md-5">
                    <label>
                        Cabecera
                    </label>
                    <input type="checkbox" id="cabecera">
                </div>
        </div>
    </div>
</div>