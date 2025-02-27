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

import com.homebanking.tpint.entidad.Persona;
import com.homebanking.tpint.entidad.Usuario;
import com.homebanking.tpint.negocio.CuentaNeg;
import com.homebanking.tpint.negocio.UsuarioNeg;
import com.homebanking.tpint.negocioimpl.CuentaNegImpl;
import com.homebanking.tpint.negocioimpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletEliminarCliente
 */
@WebServlet("/ServletEliminarCliente")
public class ServletEliminarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioNeg usuarioNeg = new UsuarioNegImpl();
	CuentaNeg cuentaNeg = new CuentaNegImpl();
       
  
    public ServletEliminarCliente() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
		if (request.getParameter("btnBuscarEliminar") != null) {
		    String DNI = new String();
		    Usuario usuario; 
		    Persona persona;
		        	
		    DNI = (request.getParameter("dniCliente"));
		    usuario = usuarioNeg.obtenerUsuarioPorDNI(DNI);
		    persona = usuarioNeg.ObtenerCliente(usuario.getUsuario());
		    
		    if(usuario.getUsuario()==null) {
		    	//si el usuario con ese dni no existe, volver al EliminarCliente.jsp
        		 request.setAttribute("encontrado", 0);
        		 request.setAttribute("Mensaje", "Cliente no encontrado");
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCliente.jsp");
	            dispatcher.forward(request, response); 
        	}
		    
		    if(usuario.getPersona_dni() != null && persona.getNombre() != null && persona.getApellido() != null) {
		       request.setAttribute("usuario", usuario.getUsuario());
			   request.setAttribute("nombre", persona.getNombre());
			   request.setAttribute("apellido", persona.getApellido());
			   request.setAttribute("estadoCliente", usuario.getHabilitado());
			   RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCliente.jsp");
			   dispatcher.forward(request, response); 	    	
		    }else {
	 	        request.setAttribute("Mensaje", "Cliente no encontrado");
	 	        System.out.println("INGRESE AL ELSE PORQUE ES NULO ");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCliente.jsp");
			    dispatcher.forward(request, response); 	    	
		    }
		 } 
		
		
		
		
		//Si el Servlet es llamado desde los botones de las celdas de ListarClientes
		  else if (request.getParameter("btnEliminar") != null || request.getParameter("btnHabilitar")!=null) {

	    	Usuario usuarioEditado = new Usuario();
			usuarioEditado.setPersona_dni(request.getParameter("dniCliente"));
			//Si el usuario esta deshabilitado, habilitarlo  o al reves
			if(request.getParameter("btnHabilitar")!=null){
			   usuarioEditado.setHabilitado(1);
			}else{
			    usuarioEditado.setHabilitado(0);
			}
			
			boolean filas2 = usuarioNeg.eliminarUsuario(usuarioEditado);
			
			//SETEO EL ESTADO DE  TODAS LAS CUENTAS DEL CLIENTE
	        int estado = 0;   
	        estado = cuentaNeg.setearEstadoCuenta(usuarioEditado.getPersona_dni(), usuarioEditado.getHabilitado());

			
		    String resultadoOperacion = "3";
		    System.out.println(resultadoOperacion);
		    //Se actualiza el objeto de la session 'listaPersonas' con los datos modificados
		    if(filas2 == true) {
		    	resultadoOperacion = request.getParameter("btnHabilitar")!=null ? "2" : "1";
		    	System.out.println(resultadoOperacion);
		    	
		    	UsuarioNeg un = new UsuarioNegImpl();
		    	ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		    	listaPersonas = un.listarPersonasComposicion();
		    	
		    	HttpSession session = request.getSession();
		    	session.setAttribute("listaPersonas", listaPersonas);
		    	
		    	String mensaje = resultadoOperacion;
		    	response.setContentType("text/plain"); 
		    	response.setCharacterEncoding("UTF-8"); 
		    	response.getWriter().write(mensaje);
		      }
		     else {
		    	 String mensaje = "Error"; 
			     response.setContentType("text/plain"); 
			     response.setCharacterEncoding("UTF-8"); 
			     response.getWriter().write(mensaje);
		     }
	    }
		
		
		
		
		
		
		
	    if (request.getParameter("btnConfirmacion") != null) {
	    	
	    	// SETEO EL ESTADO del CLIENTE
	        Usuario usuarioEditado = new Usuario();
	        usuarioEditado.setPersona_dni(request.getParameter("dniCliente"));
	        usuarioEditado.setHabilitado(0);
	        boolean filas = usuarioNeg.eliminarUsuario(usuarioEditado);
	       
	        
	        
	        //SETEO EL ESTADO DE  TODAS LAS CUENTAS DEL CLIENTE
	        int estado = 0;   
	        estado = cuentaNeg.setearEstadoCuenta(usuarioEditado.getPersona_dni(), usuarioEditado.getHabilitado());
	        

	        if(filas != false && estado != 0) {
	            request.setAttribute("filas", true);
	        } else {
	            request.setAttribute("filas", false);
	        }
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/EliminarCliente.jsp");
	        dispatcher.forward(request, response);
	    } 
        
	}

}
