<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table {
        border-collapse: collapse;
        width: 50%;
    }

    table, td {
        border: 1px solid black;
        padding: 5px;
        text-align: center;
    }
</style>
</head>
<body>
    <h1>Gestión de Jefes de Tienda</h1>
    <br>
		<form action="jefe" method="get">
		    <input type="hidden" name="opcion" value="buscarJefe">
		    Apellido Paterno: <input type="text" name="apellidoPaterno">
		    Apellido Materno: <input type="text" name="apellidoMaterno">
		    <button type="submit">Buscar</button>
		</form>

    <br>
    <br>
    <table>
    	<tr>
    		<td>Código</td>
    		<td>Nombre</td>
    		<td>Apellido Paterno</td>
    		<td>Apellido Materno</td>
    		<td>DNI</td>
    		<td>Acciones</td>
    	</tr>
    	<c:forEach var="jefe" items="${listaJefeTienda}">
    		<tr>
    			<td>${jefe.codigo}</td>
    			<td>${jefe.nombre}</td>
    			<td>${jefe.apellidoPaterno}</td>
    			<td>${jefe.apellidoMaterno}</td>
    			<td>${jefe.dni}</td>
    			<td><a href="jefe?opcion=editar&codigo=${jefe.codigo}">Editar</a> 
    			<a href="jefe?opcion=eliminar&codigo=${jefe.codigo}">Eliminar</a></td>
    		</tr>
    	</c:forEach>
    </table>
    <form action="jefe" method="POST">
    	<input type="hidden" name="opcion" value="nuevoJefeTienda">
    	<button>Nuevo</button>
    </form>
    
</body>
</html>