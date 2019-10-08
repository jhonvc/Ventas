package com.example.tecsup.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorVentas extends BaseAdapter {
    int layout;
    Context context;
    List<Pedidos>pedidos;
    List<Clientes>clientes;

    public AdaptadorVentas( Context context,int layout, List<Pedidos> pedidos, List<Clientes> clientes) {
        this.layout = layout;
        this.context = context;
        this.pedidos = pedidos;
        this.clientes = clientes;
    }

    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int i) {
        return pedidos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view , ViewGroup viewGroup) {
        view=LayoutInflater.from(context).inflate(layout,null);
        TextView nombre=view.findViewById(R.id.txt_nombre);
        TextView fecha=view.findViewById(R.id.txt_fecha);
        TextView total=view.findViewById(R.id.txt_total);
        fecha.setText(pedidos.get(i).getFecha());
        total.setText(pedidos.get(i).getTotal());
        return view;

    }
}
