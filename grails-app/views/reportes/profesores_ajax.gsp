<div class="container">

    <div class="col-md-4">
        <label>
            Docentes
        </label>
        <g:select name="profesor" from="${tutor.Profesor.list().sort{it.apellido}}" class="form-control" optionKey="id" optionValue="${{it.apellido + " " + it.nombre}}" noSelection="[null: 'TODOS']" />
    </div>

</div>