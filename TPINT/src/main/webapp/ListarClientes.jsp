<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.homebanking.tpint.entidad.Usuario"%>
<%@page import="com.homebanking.tpint.entidad.Persona"%>
<%@page import="com.homebanking.tpint.entidad.Direccion"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
    <jsp:include page="css/Style.css"></jsp:include>
	
    .filtro-container {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
        margin-top: 10px;
    
    }

    #txtFiltro {
        width: 250px;
        margin-left: 10px;
    }
</style>

<meta charset="UTF-8">
    <title>Clientes Activos</title>
    <link rel="stylesheet" type="text/css" href="path_to_your_css_file.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<script type="text/javascript">
$(document).ready(function() {
    $('#table_id').DataTable({
    	order: [[0, 'desc']],
        language: {
            lengthMenu: "Mostrar _MENU_ registros",
            info: "Mostrando _START_ a _END_ de _TOTAL_ registros",
            infoEmpty: "Mostrando 0 a 0 de 0 registros",
            infoFiltered: "(filtrado de _MAX_ registros en total)",
            loadingRecords: "Cargando...",
            zeroRecords: "No se encontraron registros coincidentes",
            emptyTable: "No hay datos disponibles en la tabla",
            paginate: {
                first: "Primero",
                previous: "Anterior",
                next: "Siguiente",
                last: "�ltimo"
            },
            aria: {
                sortAscending: ": activar para ordenar columna ascendente",
                sortDescending: ": activar para ordenar columna descendente"
            },
            lengthMenu: "Cantidad registros _MENU_",
            search: "Buscar:"
        },
        dom: 'lfrtip'
    });
});
	
	
	document.addEventListener("DOMContentLoaded",function(){
		toggleClientes();
		let tabla = document.getElementById('table_id');
		let botones = tabla.querySelectorAll('input[type="button"]');
		
		//Se carga el EventListener de los botones de las celdas al cargar el DOM
		botones.forEach(function(btn){
			btn.addEventListener("click",function(e){
				let fila= btn.parentNode.parentNode;
				let dni = fila.cells[1].textContent;
				let nombre = fila.cells[4].textContent;
				let apellido = fila.cells[5].textContent;
				let usuario = fila.cells[6].textContent;
			
				if(e.target.value==="Eliminar"){
					let estado = 1;
					enviarDatosEliminar(dni,estado,usuario,nombre,apellido);
				}
				else if(e.target.value==="Habilitar"){
					let estado = 0;
					enviarDatosEliminar(dni,estado,usuario,nombre,apellido);
				}
				else if(e.target.value==="Modificar"){
					enviarDatosModificar(dni,usuario);
				}
				else if(e.target.value="Ver Detalles"){
					enviarDetalles(usuario);
				}
			})
		})
		
		
		//Se carga la funcionalidad del filtro al cargar el DOM
        const inputFiltro = document.querySelector('#txtFiltro');
        inputFiltro.addEventListener('keyup', function() {
            let filterValue = inputFiltro.value.toLowerCase();
            let table = document.querySelector('#table_id');
            let rows = table.getElementsByTagName('tr');

            for (let i = 1; i < rows.length; i++) {
                let cells = rows[i].getElementsByTagName('td');
                let match = false;
                for (let j = 0; j < cells.length; j++) {
                    if (cells[j].textContent.toLowerCase().includes(filterValue)) {
                        match = true;
                        break;
                    }
                }
                rows[i].style.display = match ? '' : 'none';
            }
        });
    })
    
    //Esta funcion es llamada desde el boton Eliminar/Habilitar y va al jsp con get EliminaCliente con parametros
    function enviarDatosEliminar(dni,estado,usuario,nombre,apellido){
			let xhr = new XMLHttpRequest();
			xhr.open("POST","EliminarCliente.jsp","true");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			let params="dniCliente1="+encodeURIComponent(dni)+"&estadoCliente1="+encodeURIComponent(estado)+"&usuario1="+encodeURIComponent(usuario)
						+"&nombre1="+encodeURIComponent(nombre)+"&apellido1="+encodeURIComponent(apellido);
			xhr.send(params);
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4 && xhr.status===200){
					window.location.href='EliminarCliente.jsp?'+params;
				}
				else if(xhr.readyState===4){
					console.log("Error al enviar los datos");
				}
			}
		}
	
	//Esta funcion es llamada desde el boton Modificar y va al jsp con get ModificarCliente con parametros
	function enviarDatosModificar(dni,usuario){
		let xhr = new XMLHttpRequest();
		xhr.open("POST","ModificarCliente.jsp","true");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		let params="dniCliente1="+encodeURIComponent(dni)+"&usuario1="+encodeURIComponent(usuario)	
		xhr.send(params);
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4 && xhr.status===200){
				window.location.href='ModificarCliente.jsp?'+params;
			}
			else if(xhr.readyState===4){
				console.log("Error al enviar los datos");
			}
		}
	}
	
	//Esta funcion es llamada desde el boton Detalles y va al jsp EditarCliente mediante post con el parametro usuario
	function enviarDetalles(usuario){
		let form = document.createElement('form');
	    form.method = 'post';
	    form.action = 'ServletDatosCliente';
	    
	    let input = document.createElement('input');
	    input.type = 'hidden';
	    input.name = 'usuario';
	    input.value = usuario;
	    
	    form.appendChild(input);
	    document.body.appendChild(form);
	    form.submit();
	}
	
	function toggleClientes() {
        var checkbox = document.getElementById('toggleHabilitados');
        var habilitados = document.getElementsByClassName('habilitado');
        var noHabilitados = document.getElementsByClassName('no-habilitado');

        if (checkbox.checked) {
            for (var i = 0; i < noHabilitados.length; i++) {
                noHabilitados[i].style.display = '';
            }
            for (var j = 0; j < habilitados.length; j++) {
                habilitados[j].style.display = '';
            }
        } else {
            for (var i = 0; i < noHabilitados.length; i++) {
                noHabilitados[i].style.display = 'none';
            }
            for (var j = 0; j < habilitados.length; j++) {
                habilitados[j].style.display = '';
            }
        }
    }
</script>
</head>
<body>
    <% if(session.getAttribute("tipoUsuario") != null) { %>
        <div class="banner">
            <div class="logo_encabezado_izquierda">
                <img src="img/Grupo 13_encabezado.png" alt="Logo" class="logo_encabezado">
                <h3>Listado Clientes</h3>
            </div>
            <div class="logo_encabezado_derecha">
                <%= (String) session.getAttribute("usuario") %>
                <a href="ServletCerrarSesion" class="logout">
                    <img src="img/logout.png" alt="Logout" class="logo_encabezado">
                </a>
            </div>
        </div>
      

 
        
         <div class="table-container" >
               	<div class="toggle-container filtro-container" style="margin-top:2%;" >
	        	<input type="checkbox" id="toggleHabilitados" onchange="toggleClientes()">
	            <label for="toggleHabilitados">Mostrar todos los clientes</label>
      		  </div>
            <table id="table_id" class="display">
                <thead>
                    <tr>
                    	<th> Cliente</th>
                        <th>DNI</th>
                        <th>Direcci�n</th>
                        <th>Email</th>
                        <th>Nombre</th>
            			<th>Apellido</th>
                        <th>Usuario</th>
                        <th>habilitaci�n</th>
                        <th>Datos</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody id="clientesTableBody">
                    <%
                    ArrayList<Persona> listaPersona = (ArrayList<Persona>) session.getAttribute("listaPersonas");    
                    if(listaPersona!=null){
                    	for (Persona persona : listaPersona){
                    %>
                    <tr class="<%= persona.getUsuario().getHabilitado() == 1 ? "habilitado" : "no-habilitado" %>">
                    	<td><%= persona.getApellido() %>, <%= persona.getNombre() %></td>
                        <td><%= persona.getDni() %></td>
                        <td>
                            <%= persona.getDireccion().getCalle() %> <%= persona.getDireccion().getAltura() %>
                            <% if (persona.getDireccion().getPiso() != null && !persona.getDireccion().getPiso().isEmpty()) { %>
                                , Piso: <%= persona.getDireccion().getPiso() %>
                            <% } %>
                            <% if (persona.getDireccion().getDepartamento() != null && !persona.getDireccion().getDepartamento().isEmpty()) { %>
                                , Depto: <%= persona.getDireccion().getDepartamento() %>
                            <% } %>
                        </td>
                        <td><%= persona.getEmail() %></td>
                        <th><%= persona.getNombre() %></th>
            			<th><%= persona.getApellido() %></th>
                        <td><%= persona.getUsuario().getUsuario() %></td>
                        <td>
					    <input type="button" 
					           value="<%= persona.getUsuario().getHabilitado() == 1 ? "Eliminar" : "Habilitar" %>" 
					           name="<%= persona.getUsuario().getHabilitado() == 1 ? "btnListarEliminar" : "btnListarHabilitar" %>" 
					           class="btnEspecial <%= persona.getUsuario().getHabilitado() == 1 ? "" : "btnHabilitar" %>">
						</td>
						<% if (persona.getUsuario().getHabilitado() == 1) { %>
						   <td>
						       <input type="button" value="Modificar" name="btnListarModificar" class="btnEspecial">
						   </td>
						<% } else { %>
						   <td>
						       <input type="button" value="Inactivo" name="sinFuncion" class="btnEspecial">
						   </td>
						<% } %>      
						<td>
						    <input type="button" value="Ver Detalle" name="btnListarDetalles" class="btnEspecial">
						</td>
	
	                    </tr>
	                    	<%}%>
                    <%} else{%>
                    <tr>
                        <td colspan="7">No hay datos disponibles</td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <div style="display:flex; justify-content: end; margin: 2%;" >
        	<input type="button" value="Volver" name="btnVolver" onclick="window.location.href='ABMLclientes.jsp';">
        </div>
    <%} else{%>
        <h1>No tiene permisos para trabajar en esta URL, presione <a href="Login.jsp">aqu�</a> para volver al Login</h1>
    <%}%>
</body>

</html>
