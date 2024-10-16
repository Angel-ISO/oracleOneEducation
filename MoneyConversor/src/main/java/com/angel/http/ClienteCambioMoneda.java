package com.angel.http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ClienteCambioMoneda {
    private OkHttpClient client = new OkHttpClient();
    private static final List<String> CODIGOS_MONEDA = Arrays.asList("USD", "ARS", "COP", "BRL", "BOB", "PEN");

    public double obtenerTasaCambio(String codigoOrigen, String codigoDestino) throws IOException {
        if (!esCodigoValido(codigoOrigen) || !esCodigoValido(codigoDestino)) {
            throw new IllegalArgumentException("Código de moneda no válido. Use uno de los siguientes: " + CODIGOS_MONEDA);
        }

        String url = "https://api.exchangerate-api.com/v4/latest/" + codigoOrigen;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error en la respuesta: " + response);
            }

            String jsonResponse = response.body().string();
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("rates");

            if (rates.has(codigoDestino)) {
                return rates.get(codigoDestino).getAsDouble();
            } else {
                throw new IOException("La tasa de cambio para " + codigoDestino + " no está disponible.");
            }
        }
    }

    private boolean esCodigoValido(String codigo) {
        return CODIGOS_MONEDA.contains(codigo);
    }
}
