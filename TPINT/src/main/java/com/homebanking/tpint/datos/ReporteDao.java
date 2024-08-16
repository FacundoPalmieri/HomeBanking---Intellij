package com.homebanking.tpint.datos;

import java.time.LocalDate;
import java.util.ArrayList;

import com.homebanking.tpint.entidad.Movimientos;
import com.homebanking.tpint.entidad.PagosPrestamos;
import com.homebanking.tpint.entidad.Prestamo;

public interface ReporteDao {
	
	public boolean busquedaDNI(String dni);
	
	public boolean busquedaUsuario(String nombreUsuario);
	
	public ArrayList<Prestamo> prestamos(String dni, ArrayList<Integer> estado,LocalDate fecha1, LocalDate fecha2);
	
	public ArrayList <Movimientos> PromedioIngresosMensuales(LocalDate fechaInicio, LocalDate fechaFin);
	
	public ArrayList<PagosPrestamos> pagosPrestamos(int idPrestamo);
}
