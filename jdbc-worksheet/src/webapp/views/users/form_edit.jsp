<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="name" class="col-form-label">Username:</label> <input
		type="text" class="form-control" id="name" name="username"
		required value="${tmp_user.getUsername()}">
</div>
<div class="mb-3">
	<label for="coins"
		class='col-form-label ${tmp_user.getErrores().get("coins") != null ? "is-invalid" : "" }'>Puntos:</label>
	<input class="form-control" type="number" id="coins" name="coins"
		required value="${tmp_user.getDinero()}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.getErrores().get("coins")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="time"
		class='col-form-label ${tmp_user.getErrores().get("time") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="time" name="time"
		required value="${tmp_user.getTiempoEnHoras()}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.getErrores().get("time")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="admin"
		class='col-form-label ${tmp_user.getErrores().get("admin") != null ? "is-invalid" : "" }'>Admin:</label>
		<select class="form-select" aria-label="Default select example" name = "admin">
  <option selected>Abrir selector</option>
  <option value="true">Si</option>
  <option value="false">No</option>

</select>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.getErrores().get("admin")}'></c:out>
	</div>
</div>


<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
