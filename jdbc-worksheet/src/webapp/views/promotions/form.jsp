<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name"
			required value="${promocion.getNombre()}">
	</div>
	<div class="mb-3"> Lista de atracciones:<br>
	<c:forEach items="${atracciones}" var="atraccion">
		<label for="lista"
			class='col-form-label ${promocion.getErrores().get("lista") != null ? "is-invalid" : "" }'>${atraccion.getNombre()}</label>
		<input class="form-control" type="checkbox" id="lista" name="lista" value = "${atraccion.getNombre()}"
			required value="${atraccion.getNombre()}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.getErrores().get("precio")}'></c:out>
		</div>
		</c:forEach>
	</div>
	<div class="mb-3">Tipo de promocion:<br>
		<label for="tipo"
			class='col-form-label ${promocion.getErrores().get("tipo") != null ? "is-invalid" : "" }'> 
			
			<select class="form-select" aria-label="Default select example" name ="tipo">
  <option selected>Seleccionar tipo de promocion</option>
  <option value="Porcentual">Porcentual</option>
  <option value="Absoluta">Absoluta</option>
  <option value="AxB">AxB</option>
</select>
			</label>
			<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
  <label class="form-check-label" for="flexCheckDefault">
    Default checkbox
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
  <label class="form-check-label" for="flexCheckChecked">
    Checked checkbox
  </label>
</div>
			
		<div class="invalid-feedback">
			<c:out value='${promocion.getErrores().get("tipo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="descuento"
			class='col-form-label ${promocion.getErrores().get("descuento") != null ? "is-invalid" : "" }'>Descuento o precio absoluto:</label>
		<input class="form-control" type="number" id="descuento" name="descuento"
			required value="${promocion.getDescuento()}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.getErrores().get("cupoDisponible")}'></c:out>
		</div>
	</div>
	</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
