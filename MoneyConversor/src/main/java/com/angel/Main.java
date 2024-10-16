package com.angel;

import com.angel.datos.TasaCambioRepository;
import com.angel.http.ClienteCambioMoneda;
import com.angel.presentation.App;

public class Main {
    public static void main(String[] args) {
        TasaCambioRepository repositorio = new TasaCambioRepository();
        ClienteCambioMoneda clienteHttp = new ClienteCambioMoneda();
        App app = new App(repositorio, clienteHttp);

        app.iniciar();
    }
}