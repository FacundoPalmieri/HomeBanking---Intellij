package com.homebanking.tpint.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homebanking.tpint.negocio.CuentaNeg;
import com.homebanking.tpint.negocioimpl.CuentaNegImpl;
import com.homebanking.tpint.entidad.Cuenta;

/**
 * Servlet implementation class ServletListarCuentas
 */
@WebServlet("/ServletListarCuentas")
public class ServletListarCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CuentaNeg cuentaNeg;
	
    public ServletListarCuentas() {
        super();
        cuentaNeg = new CuentaNegImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        Integer tipoUsuario = (Integer) session.getAttribute("tipoUsuario");

        // Verificar que el usuario est� autenticado y es un administrador
        if (tipoUsuario == null || tipoUsuario != 1) {
            response.sendRedirect("login.jsp"); // Redirigir a login si el tipo de usuario no est� en la sesi�n o no es administrador
            return;
        }

        // Obtener todas las cuentas
        ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
    	listaCuentas = cuentaNeg.listarTodasLAsCuentas();
    	request.setAttribute("listaCuentas", listaCuentas);

    	if(listaCuentas != null) {
        	request.setAttribute("listaCuentas", listaCuentas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarCuentas.jsp");
            dispatcher.forward(request, response);
            
        	}
        	 else {
    			 System.out.println("LISTA CUENTAS NULA");
    		 }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
