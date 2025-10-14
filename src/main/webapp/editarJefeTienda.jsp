<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Editar Jefe de Tienda</h1>
	<br>
	<br>
	<form action="jefe" method="POST">
	 	<input type="hidden" name="opcion" value="actualizarJefe">
		Código: <input type="text" name="codigo" value="${jefe.codigo}"><br><br>
		Nombre: <input type="text" name="nombre" vale="${jefe.nombre}"><br><br>
		Apellido Paterno: <input type="text" name="apellidoPaterno" vale="${jefe.apellidoPaterno}"><br><br>
		Apellido Materno: <input type="text" name="apellidoPaterno" vale="${jefe.apellidoPaterno}"><br><br>
		DNI: <input type="text" name="dni" value="${jefe.dni}"><br><br>
		<button>Grabar</button>
	</form>
</body>
</html>