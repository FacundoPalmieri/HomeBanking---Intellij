package com.homebanking.tpint.datos;

import java.util.ArrayList;

import com.homebanking.tpint.entidad.EstadoPrestamo;
import com.homebanking.tpint.entidad.PagosPrestamos;
import com.homebanking.tpint.entidad.Prestamo;

public interface PrestamoDao {
	public boolean guardarPrestamo(Prestamo prestamo, String clienteDni, int estadoPrestamo, int nCuenta); // OK	
	public ArrayList<Prestamo> obtenerPrestamos(); // OK
    public ArrayList<Prestamo> obtenerPrestamosPorCliente(String DNI);
    public int actualizarEstadoPrestamo(int idPrestamo, int estadoPrestamo);
    public ArrayList<EstadoPrestamo> obtenerListadeEstado();
    public int registrarCuotas(PagosPrestamos pagosPrestamo);
    public int actualizarCuota(int idPrestamo, int cuota, int estado);
    public int actualizarCuotaYsaldoRestantePrestamo(int id, int cuota, float importeCuota);  
    public int obtenerCuotasPrestamo(int id);
    public int ajustePorRedondeo(int id);

}