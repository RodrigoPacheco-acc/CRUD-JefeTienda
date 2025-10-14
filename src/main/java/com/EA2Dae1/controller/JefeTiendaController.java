package com.EA2Dae1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.EA2Dae1.dao.JefeTiendaDAO;
import com.EA2Dae1.model.JefeTienda;

/**
 * Servlet implementation class JefeTiendaController
 */
@WebServlet("/jefe")
public class JefeTiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JefeTiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		 if (opcion == null) {
		        opcion = "listar";
		    }
		    switch (opcion) {
		        case "mostrargestionJefeTienda":
		            mostrargestionJefeTienda(request, response);
		            break;
		        case "buscarJefe":
				try {
					buscarJefe(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        case "eliminar":{
		        	try {
						eliminar(request,response);
					} catch (SQLException | ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	break;
		        }
		        case "editar":{
		        	try {
						editar(request,response);
					} catch (SQLException | ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	break;
		        }
		        default:
		            mostrargestionJefeTienda(request, response);
		            break;
		    }
	}


	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		JefeTiendaDAO jefetiendaDao = new JefeTiendaDAO();
		JefeTienda jefetienda = jefetiendaDao.buscarxcodigo(codigo);
		request.setAttribute("jefetienda", jefetienda);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarJefeTienda.jsp");
		dispatcher.forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		JefeTiendaDAO jefetiendaDao = new JefeTiendaDAO();
		jefetiendaDao.eliminar(codigo);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestionJefeTienda.jsp");
		dispatcher.forward(request, response);
	}

	private void buscarJefe(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		JefeTiendaDAO jefetiendaDao = new JefeTiendaDAO();
		List<JefeTienda> listaJefeTienda = jefetiendaDao.buscarJefexApellido(apellidoPaterno, apellidoMaterno);
		request.setAttribute("listaJefeTienda", listaJefeTienda);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestionJefeTienda.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrargestionJefeTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestionJefeTienda.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch (opcion) {
			case "nuevoJefeTienda": {
				nuevoJefeTienda(request, response);
				break;
			}
			case "registrarJefe": {
				try {
					registrarJefe(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "actualizarJefe":{
				try {
					actualizarJefe(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	private void actualizarJefe(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String dni = request.getParameter("dni");
		JefeTiendaDAO jefetiendaDao = new JefeTiendaDAO();
		jefetiendaDao.actualizar(codigo, nombre, apellidoPaterno, apellidoMaterno, dni);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestionJefeTienda.jsp");
		dispatcher.forward(request, response);
	}

	private void registrarJefe(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String dni = request.getParameter("dni");
		JefeTiendaDAO jefetiendaDao = new JefeTiendaDAO();
		jefetiendaDao.registrarJefe(nombre, apellidoPaterno, apellidoMaterno, dni);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestionJefeTienda.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevoJefeTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/nuevoJefeTienda.jsp");
		dispatcher.forward(request, response);
	}
}
