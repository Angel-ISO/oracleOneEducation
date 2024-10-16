package com.angel.presentation;


import com.angel.datos.TasaCambioRepository;
import com.angel.http.ClienteCambioMoneda;

import java.io.IOException;
import java.util.Scanner;

public class App {
    private TasaCambioRepository repositorio;
    private ClienteCambioMoneda clienteHttp;

    public App(TasaCambioRepository repositorio, ClienteCambioMoneda clienteHttp) {
        this.repositorio = repositorio;
        this.clienteHttp = clienteHttp;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Conversor de Monedas");

        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 2) {
                System.out.println("Gracias por usar el conversor. Hecho por Angel ");
                break;
            }

            System.out.println("Ingrese el código de las siguientes moneda origen (USD, ARS, COP, BRL, BOB, PEN):");
            String codigoOrigen = scanner.next().toUpperCase();
            System.out.println("Ingrese el código de las siguientes moneda destino (USD, ARS, COP, BRL, BOB, PEN):");
            String codigoDestino = scanner.next().toUpperCase();
            System.out.println("Ingrese la cantidad a convertir:");
            double cantidad = scanner.nextDouble();

            try {
                double tasa = clienteHttp.obtenerTasaCambio(codigoOrigen, codigoDestino);
                double resultado = cantidad * tasa;
                System.out.printf("Resultado: %.2f %s\n", resultado, codigoDestino);
            } catch (IOException e) {
                System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
