package com.homebanking.tpint.negocio;

import java.util.ArrayList;

import com.homebanking.tpint.entidad.EstadoPrestamo;
import com.homebanking.tpint.entidad.PagosPrestamos;
import com.homebanking.tpint.entidad.Prestamo;

public interface PrestamoNeg {
	
	public boolean guardarPrestamo(Prestamo prestamo, String ClienteDni, int estadoPrestamo, int nCuenta);
	
	public ArrayList<Prestamo> obtenerPrestamos();
	public ArrayList<Prestamo> obtenerPrestamosPorCliente(String DNI);
    public int actualizarEstadoPrestamo(int idPrestamo, int estadoPrestamo);
    public ArrayList<EstadoPrestamo> obtenerListadeEstado();
    public int registrarCuotas(PagosPrestamos pagosPrestamo);
    public int actualizarCuota(int idPrestamo, int cuota, int estado);
    public int actualizarCuotaYsaldoRestantePrestamo(int id, int cuota, float importeCuota);    
    public int obtenerCuotasPrestamo(int id);
    public int ajustePorRedondeo(int id);

 
}