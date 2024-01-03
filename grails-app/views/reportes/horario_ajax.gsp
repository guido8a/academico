<%@ page import="tutor.Periodo" %>
<div class="container">
    <div class="row">
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
    <div class="row">
        <div class="col-md-1">
            <label>
                Nivel
            </label>
        </div>
        <div class="col-md-4">
        <g:select name="nivel" from="${tutor.Nivel.list([sort: 'numero'])}" class="form-control" optionKey="id" optionValue="descripcion"/>
        </div>
    </div>

    <div class="row">
        <div class="col-md-1">
            <label>
                Paralelo
            </label>
        </div>
        <div class="col-md-4" id="divParalelo">

        </div>
    </div>
</div>

<script type="text/javascript">


    function cargarParalelo(periodo, nivel){

    }


</script>