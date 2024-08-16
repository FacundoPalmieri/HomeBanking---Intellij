package com.homebanking.tpint.negocioimpl;

import java.util.ArrayList;

import com.homebanking.tpint.datos.DatosGeograficosDao;
import com.homebanking.tpint.datosimpl.DatosGeograficosDaoImpl;
import com.homebanking.tpint.entidad.Localidad;
import com.homebanking.tpint.entidad.Pais;
import com.homebanking.tpint.entidad.Provincia;
import com.homebanking.tpint.negocio.DatosGeograficosNeg;

public class DatosGeograficosNegImpl implements DatosGeograficosNeg {
	
	private DatosGeograficosDao datosGeoDao;
	
	public DatosGeograficosNegImpl() {
		datosGeoDao = new DatosGeograficosDaoImpl();
    }

	@Override
	public ArrayList<Pais> ObtenerPais() {
		return (ArrayList<Pais>) datosGeoDao.ObtenerPais();
	}

	@Override
	public ArrayList<Provincia> ObtenerProvincia() {
		return  (ArrayList<Provincia>) datosGeoDao.ObtenerProvincia();
	}

	@Override
	public ArrayList<Localidad> ObtenerLocalidad(int id) {
		return  (ArrayList<Localidad>) datosGeoDao.ObtenerLocalidad(id);
	}

}
