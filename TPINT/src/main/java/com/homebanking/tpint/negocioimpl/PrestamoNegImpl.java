package com.homebanking.tpint.negocioimpl;

import java.util.ArrayList;

import com.homebanking.tpint.datos.PrestamoDao;
import com.homebanking.tpint.datosimpl.PrestamoDaoImpl;
import com.homebanking.tpint.entidad.EstadoPrestamo;
import com.homebanking.tpint.entidad.PagosPrestamos;
import com.homebanking.tpint.entidad.Prestamo;
import com.homebanking.tpint.negocio.PrestamoNeg;

public class PrestamoNegImpl implements PrestamoNeg {

	private PrestamoDao prestamoDao;
	public PrestamoNegImpl () {
		
		prestamoDao = new PrestamoDaoImpl();
	}
	
	@Override
	public boolean guardarPrestamo(Prestamo prestamo, String clienteDni, int estadoPrestamo, int nCuenta) {

		return prestamoDao.guardarPrestamo(prestamo, clienteDni, estadoPrestamo, nCuenta);
		
	}
	
	@Override
	public ArrayList<Prestamo> obtenerPrestamos() {
		ArrayList<Prestamo> listaPrestamos= null;
		listaPrestamos = prestamoDao.obtenerPrestamos();
		return listaPrestamos;
		
		
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamosPorCliente(String DNI) {
		// TODO Auto-generated method stub
		return prestamoDao.obtenerPrestamosPorCliente(DNI);
	}

	@Override
	public int actualizarEstadoPrestamo(int idPrestamo, int estadoPrestamo) {
		return prestamoDao.actualizarEstadoPrestamo(idPrestamo, estadoPrestamo);
	}

	@Override
	public ArrayList<EstadoPrestamo> obtenerListadeEstado() {
		ArrayList<EstadoPrestamo> listaEstadoPrestamos= null;
		listaEstadoPrestamos = prestamoDao.obtenerListadeEstado();
		return listaEstadoPrestamos;
	}

	@Override
	public int registrarCuotas(PagosPrestamos pagosPrestamo) {
		return prestamoDao.registrarCuotas(pagosPrestamo);
	}

	@Override
	public int actualizarCuota(int idPrestamo, int cuota, int estado) {
		return prestamoDao.actualizarCuota(idPrestamo, cuota, estado);
	}

	@Override
	public int actualizarCuotaYsaldoRestantePrestamo(int id, int cuota, float importeCuota) {
		return prestamoDao.actualizarCuotaYsaldoRestantePrestamo(id, cuota, importeCuota);
	}

	@Override
	public int obtenerCuotasPrestamo(int id) {
		return prestamoDao.obtenerCuotasPrestamo(id);
	}

	@Override
	public int ajustePorRedondeo(int id) {
		return prestamoDao.ajustePorRedondeo(id);
	}



}
