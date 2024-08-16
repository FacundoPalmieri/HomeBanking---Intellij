package com.homebanking.tpint.negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import com.homebanking.tpint.entidad.Movimientos;
import com.homebanking.tpint.entidad.Prestamo;

public interface ReporteNeg {
	
	public boolean busquedaDNI(String dni);
	
	public boolean busquedaUsuario(String nombreUsuario);
	
	public ArrayList<Prestamo> prestamos(String dni, ArrayList<Integer> estado,LocalDate fecha1, LocalDate fecha2);
	
	public ArrayList <Movimientos> PromedioIngresosMensuales(LocalDate fechaInicio, LocalDate fechaFin);
	
	public ArrayList <Prestamo> verificarPagos (ArrayList<Prestamo> prestamo);
}
