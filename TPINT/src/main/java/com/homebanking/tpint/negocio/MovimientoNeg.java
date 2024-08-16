package com.homebanking.tpint.negocio;

import java.util.ArrayList;

import com.homebanking.tpint.entidad.Movimientos;

public interface MovimientoNeg {
	
	public int CrearMovimiento(int CuentaOrigen,String detalle, double importe, int tipoMovimiento);
	public ArrayList<Movimientos> ObtenerMovimientosPorCliente (int nCuenta);
	/*
	public ArrayList<Movimientos> ObtenerMovimientosConFiltro (int nCuenta, String parametro);
	*/
}
