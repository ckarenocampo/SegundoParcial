package com.example.guia.examen2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    private ArrayAdapter adapter;
    Boolean Listado;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        adapter = new AdaptadorJugador(Lista.this,MainActivity.listaJugadores);
        MainActivity.sortArrayList(adapter);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Listado=getIntent().getBooleanExtra("Listado", false);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if(!Listado){
            //Para seleccionar con que jugador iniciar el juego
            Intent lista = new Intent(Lista.this,Juego.class);
            lista.putExtra("Posicion", position);
            startActivity(lista);
            finish();
        }else{
            //Solo para visualizar los mejores puntajes
            Jugador.quickSortPun(MainActivity.listaJugadores);

        }
    }

}
