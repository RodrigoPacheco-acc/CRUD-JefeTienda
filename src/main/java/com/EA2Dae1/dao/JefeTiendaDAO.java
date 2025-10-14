package com.EA2Dae1.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.EA2Dae1.model.JefeTienda;

public class JefeTiendaDAO {
	private String url;
	private Connection conexion;
	
	public JefeTiendaDAO() {
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=miSistemaBD;user=a1710203;password=supertyson123;encrypt=true;trustServerCertificate=true";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion = DriverManager.getConnection(this.url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<JefeTienda> buscarJefexApellido(String apellidoPaBuscado, String apellidoMaBuscado) throws SQLException{
		List<JefeTienda> listaJefeEncontrado = new ArrayList();
		Statement stmt = this.conexion.createStatement();
		String query = "SELECT * FROM JefeTienda WHERE apellidoPaterno LIKE '%" + apellidoPaBuscado + "%' AND apellidoMaterno LIKE '%"  + apellidoMaBuscado + "%'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			
			int codigo = rs.getInt(1);
			String nombre = rs.getString(2);
			String apellidoPaterno = rs.getString(3);
			String apellidoMaterno = rs.getString(4);
			String dni = rs.getString(5);
			
			 JefeTienda jefe = new JefeTienda();
	            jefe.setCodigo(codigo);
	            jefe.setNombre(nombre);
	            jefe.setApellidoPaterno(apellidoPaterno);
	            jefe.setApellidoMaterno(apellidoMaterno);
	            jefe.setDni(dni);
	            listaJefeEncontrado.add(jefe);	
		}
		
		return listaJefeEncontrado;
	}
	
	public void registrarJefe(String nombre, String apellidoPaterno, String apellidoMaterno, String dni) throws SQLException {
		String query = "INSERT INTO JefeTienda(nombre,apellidoPaterno,apellidoMaterno,dni)values (?,?,?,?)";
		PreparedStatement pstmt = this.conexion.prepareStatement(query);
		pstmt.setString(1, nombre);
		pstmt.setString(2, apellidoPaterno);
		pstmt.setString(3, apellidoMaterno);
		pstmt.setString(4, dni);
		pstmt.execute();
		this.conexion.close();
	}
	
	public void eliminar(int codigo) throws SQLException {
		String query = "DELETE FROM JefeTienda where codigo=?";
		PreparedStatement pstmt = this.conexion.prepareStatement(query);
		pstmt.setInt(1,codigo);
		pstmt.execute();
		this.conexion.close();
	}
	
	public void actualizar(int codigo, String nombre, String apellidoPaterno, String apellidoMaterno, String dni) throws SQLException {
		String query = "UPDATE JefeTienda set nombre=?, apellidoPaterno=?, apellidoMaterno=?, dni=? where codigo=?";
		PreparedStatement pstmt = this.conexion.prepareStatement(query);
		pstmt.setString(1, nombre);
		pstmt.setString(2, apellidoPaterno);
		pstmt.setString(3, apellidoMaterno);
		pstmt.setString(4, dni);
		pstmt.setInt(5, codigo);
		pstmt.execute();
		this.conexion.close();
	}
	
	public JefeTienda buscarxcodigo(int codigo) throws SQLException {
		String query = "select * from JefeTienda where codigo=?";
		PreparedStatement pstmt = this.conexion.prepareStatement(query);
		pstmt.setInt(1, codigo);
		ResultSet rs = pstmt.executeQuery();
		JefeTienda jefetienda = new JefeTienda();
		while (rs.next()) {
			int codigobd = rs.getInt(1);
			String nombre = rs.getString(2);
			String apellidoPaterno = rs.getString(3);
			String apellidoMaterno = rs.getString(4);
			String dni = rs.getString(5);
			
			jefetienda.setCodigo(codigo);
			jefetienda.setNombre(nombre);
	        jefetienda.setApellidoPaterno(apellidoPaterno);
	        jefetienda.setApellidoMaterno(apellidoMaterno);
	        jefetienda.setDni(dni);
		}
		return jefetienda;
	}
}
