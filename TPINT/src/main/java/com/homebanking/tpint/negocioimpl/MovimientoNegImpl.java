package com.homebanking.tpint.negocioimpl;
import java.util.ArrayList;

import  com.homebanking.tpint.datos.MovimientoDao;
import com.homebanking.tpint.datosimpl.MovimientoDaoImpl;
import com.homebanking.tpint.entidad.Movimientos;
import com.homebanking.tpint.negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{
	
	private MovimientoDao movimientoDao;
	
	 public MovimientoNegImpl() {
	        movimientoDao = new MovimientoDaoImpl();
	    }

	@Override
	public int CrearMovimiento(int CuentaOrigen,String detalle, double importe, int tipoMovimiento) {
		return movimientoDao.CrearMovimiento(CuentaOrigen, detalle, importe, tipoMovimiento);
	}

	@Override
	public ArrayList<Movimientos> ObtenerMovimientosPorCliente(int nCuenta) {
		ArrayList<Movimientos> listaMovimientos = new ArrayList<Movimientos>();
		listaMovimientos = movimientoDao.ObtenerMovimientosPorCliente(nCuenta);
		System.out.println("MOVIMIENTO DAO");
		return listaMovimientos;
	}
	
	/*
	@Override
	public ArrayList<Movimientos> ObtenerMovimientosConFiltro (int nCuenta, String parametro) {
		ArrayList<Movimientos> listaMovimientos = new ArrayList<Movimientos>();
		listaMovimientos = movimientoDao.ObtenerMovimientosConFiltro(nCuenta, parametro);
		System.out.println("MOVIMIENTO DAO");
		return listaMovimientos;
	}
	*/
}
