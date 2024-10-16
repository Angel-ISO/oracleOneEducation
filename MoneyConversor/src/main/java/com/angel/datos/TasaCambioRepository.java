package com.angel.datos;

import com.angel.dominio.TasaCambio;
import com.angel.dominio.Moneda;

import java.util.HashMap;
import java.util.Map;

public class TasaCambioRepository {
    private Map<String, TasaCambio> tasas = new HashMap<>();


    public void agregarTasaCambio(TasaCambio tasaCambio) {
        String key = generarClave(tasaCambio.getMonedaOrigen().getCodigo(), tasaCambio.getMonedaDestino().getCodigo());
        tasas.put(key, tasaCambio);
    }

    public TasaCambio obtenerTasaCambio(Moneda origen, Moneda destino) {
        String key = generarClave(origen.getCodigo(), destino.getCodigo());
        return tasas.get(key);
    }

    private String generarClave(String codigoOrigen, String codigoDestino) {
        return codigoOrigen + "_" + codigoDestino;
    }
}
