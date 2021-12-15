<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name"
			required value="${atraccion.getNombre()}">
	</div>
	<div class="mb-3">
		<label for="precio"
			class='col-form-label ${atraccion.getErrores().get("precio") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="precio" name="precio"
			required value="${atraccion.getPrecio()}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.getErrores().get("precio")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="duration"
			class='col-form-label ${atraccion.getErrores().get("tiempoEnHoras") != null ? "is-invalid" : "" }'>Duracion en horas:</label>
		<input class="form-control" type="number" id="duration" name="duration"
			required value="${atraccion.getTiempoEnHoras()}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.getErrores().get("tiempoEnHoras")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label ${atraccion.getErrores().get("cupoDisponible") != null ? "is-invalid" : "" }'>Cupo o lugares disponibles:</label>
		<input class="form-control" type="number" id="capacity" name="capacity"
			required value="${atraccion.getCupoDisponible()}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.getErrores().get("cupoDisponible")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="description"
			class='col-form-label ${atraccion.getErrores().get("descripcion") != null ? "is-invalid" : "" }'>Description:</label>
		<input class="form-control" type="text" id="description" name="description"
			required value="${atraccion.getDescripcion()}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.getErrores().get("descripcion")}'></c:out>
		</div>
	</div>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
