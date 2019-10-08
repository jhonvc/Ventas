package com.example.tecsup.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.lista_pedidos);


        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://172.23.8.85/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ServicioVentas servicioVentas=retrofit.create(ServicioVentas.class);
        Call<VentaDia> llamada=servicioVentas.obtenerVentaDia();
        llamada.enqueue(new Callback<VentaDia>() {
            @Override
            public void onResponse(Call<VentaDia> call, Response<VentaDia> response) {


              //  Toast.makeText(MainActivity.this,response.body()
                       // .getClientes()[0].getNombres(),Toast.LENGTH_SHORT).show();
                AdaptadorVentas adaptador = new AdaptadorVentas(MainActivity.this,R.layout.pedidoitem,response.body().getPedidos(),response.body().getClientes());
                listview.setAdapter(adaptador);



            }

            @Override
            public void onFailure(Call<VentaDia> call, Throwable t) {
                Log.e("ErrorServicio",t.toString());


            }
        });

    }
}
