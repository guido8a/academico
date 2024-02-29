<%@ page import="tutor.Periodo" %>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="col-md-1">
                <label>
                    Período
                </label>
            </div>
            <div class="col-md-4">
                <g:select name="periodo" from="${tutor.Periodo.list([sort: 'descripcion'])}"
                          class="form-control input-sm required" optionValue="descripcion" optionKey="id"
                />
            </div>
        </div>
    </div>
</div>
