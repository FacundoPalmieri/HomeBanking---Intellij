package com.homebanking.tpint.negocioimpl;

import java.util.ArrayList;

import com.homebanking.tpint.datos.UsuarioDao;
import com.homebanking.tpint.datosimpl.UsuarioDaoImpl;
import com.homebanking.tpint.entidad.Cuenta;
import com.homebanking.tpint.entidad.Direccion;
import com.homebanking.tpint.entidad.Localidad;
import com.homebanking.tpint.entidad.Persona;
import com.homebanking.tpint.entidad.Provincia;
import com.homebanking.tpint.entidad.Usuario;
import com.homebanking.tpint.negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	private UsuarioDao usuarioDao;

    public UsuarioNegImpl() {
        usuarioDao = new UsuarioDaoImpl();
    }
    
    
    @Override
	public int validarLogin(String usuario, String contrasenia) {
		return usuarioDao.validarLogin(usuario, contrasenia);
		
	}

    @Override
    public boolean validarDNI(String DNI) {
    	
        return usuarioDao.validarDNI(DNI);
    }

	@Override
	public boolean agregarCliente(Usuario usuario, Persona persona, Direccion direccion) {
		return usuarioDao.agregarCliente(usuario, persona, direccion);
	}


	@Override
	public Usuario obtenerUsuario(String usuario) {
		return usuarioDao.ObtenerUsuario(usuario);
	}
	

	@Override
	public Persona ObtenerCliente(String usuario) {
		return usuarioDao.ObtenerCliente(usuario);
	}

	
	@Override
	public Usuario obtenerUsuarioPorDNI(String DNI) {
		return usuarioDao.ObtenerUsuarioPorDni(DNI);
	}


	@Override
	public boolean editarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.editarUsuario(usuario);
	}
	
	@Override
	public boolean editarContrasena(Usuario usuario) {
		return usuarioDao.editarContrasena(usuario);
	}


	
	public ArrayList<Usuario> listaUsuarios(){
		ArrayList<Usuario> lista = null;
		lista = usuarioDao.listarUsuarios();
		return lista;
	}
	
	@Override
	public ArrayList<Persona> listarPersonas() {
		ArrayList<Persona> lista = null;
		lista = usuarioDao.listarPersonas();
		return lista;
	}


	@Override
	public ArrayList<Direccion> listarDirecciones() {
		ArrayList<Direccion> lista = null;
		lista = usuarioDao.listarDirecciones();
		return lista;
	}


	@Override
	public boolean eliminarUsuario(Usuario usuario) {
		return usuarioDao.eliminarUsuario(usuario);
	}


	@Override
	public Direccion ObtenerDireccionCliente(int IDdireccion) {
		return usuarioDao.ObtenerDireccionCliente(IDdireccion);
	}


	@Override
	public Provincia ObtenerProvinciaCliente(int IDprovincia) {
		return usuarioDao.ObtenerProvinciaCliente(IDprovincia);
	}


	@Override
	public Localidad ObtenerLocalidadCliente(int IDlocalidad) {
		return usuarioDao.ObtenerLocalidadCliente(IDlocalidad);
	}

	public ArrayList<Persona> listarPersonasComposicion(){
		return usuarioDao.listarPersonasComposicion();
	}

	
	@Override
	public Persona ObtenerPersonaCompleta(String usuario) {
		return usuarioDao.ObtenerPersonaCompleta(usuario);
	}
	
	
	public Usuario obtenerUsuarioEstado1o2(String usuario) {
		return usuarioDao.obtenerUsuarioEstado1o2(usuario);
	}


	@Override
	public Persona obtenerClientePorDNI(int dni) {
		return usuarioDao.obtenerClientePorDNI(dni);
	}


	@Override
	public Persona obtenerPersonaCompleta(String dni) {
		return usuarioDao.obtenerPersonaCompleta(dni);
	}


	@Override
	public boolean actualizarPersonaCompleta(Persona persona) {
		return usuarioDao.actualizarPersonaCompleta(persona);
	}


	@Override
	public int validarMail(String email) {
		return usuarioDao.validarMail(email);
	}

	
	@Override
	public boolean validarUsuario(String usuario) {
		return usuarioDao.validarUsuario(usuario);
	}

	
}


	

	

