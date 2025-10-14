<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Nuevo Jefe Tienda</h1>
	<br>
	<br>
	<form action="jefe" method="POST">
	 	<input type="hidden" name="opcion" value="registrarJefe">
		Nombre: <input type="text" name="nombre"><br><br>
		Apellido Paterno: <input type="text" name="apellidoPaterno"><br><br>
		Apellido Materno: <input type="text" name="apellidoMaterno"><br><br>
		DNI: <input type="text" name="dni"><br><br>
		<button>Grabar</button>
	</form>
</body>
</html>