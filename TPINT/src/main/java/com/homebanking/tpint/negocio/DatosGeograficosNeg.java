package com.homebanking.tpint.negocio;

import java.util.ArrayList;

import com.homebanking.tpint.entidad.Localidad;
import com.homebanking.tpint.entidad.Pais;
import com.homebanking.tpint.entidad.Provincia;

public interface DatosGeograficosNeg {
	
	public ArrayList<Pais>ObtenerPais();
	public ArrayList<Provincia> ObtenerProvincia();
	public ArrayList<Localidad> ObtenerLocalidad(int id);

}
