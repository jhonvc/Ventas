package com.example.tecsup.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioVentas {
    @GET("ventas.json")
    Call<VentaDia> obtenerVentaDia();

}
