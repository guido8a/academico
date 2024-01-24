<%@ page import="tutor.Periodo" %>
<div class="container">
    <div style="width: 600px">
        <div class="col-md-4">
            <label>
                Periodo
            </label>
            <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                      class="form-control input-sm required" optionValue="descripcion" optionKey="id"
            />
        </div>
    </div>
</div>