package com.example.guia.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Iniciar extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);
        adapter = new AdaptadorJugador(Iniciar.this,MainActivity.listaJugadores);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();

    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent lista = new Intent(getApplicationContext(),Juego.class);
            lista.putExtra("Posicion", position);
            startActivity(lista);
            finish();
    }
}
