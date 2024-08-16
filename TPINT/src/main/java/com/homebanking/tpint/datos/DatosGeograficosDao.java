package com.homebanking.tpint.datos;
import java.util.ArrayList;
import com.homebanking.tpint.entidad.Pais;
import com.homebanking.tpint.entidad.Provincia;
import com.homebanking.tpint.entidad.Localidad;

public interface DatosGeograficosDao {
	
	public ArrayList<Pais>ObtenerPais();
	public ArrayList<Provincia> ObtenerProvincia();
	public ArrayList<Localidad> ObtenerLocalidad(int id);
	

}
