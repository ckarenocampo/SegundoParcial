package com.example.guia.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    public static final int NIVEL=2;
    public static int nivel=50;
    public static int tiemposegundos=60;
    Jugador j;

    public static ArrayList<Jugador> listaJugadores;
    Button btnJuego, btnPuntajes, btnConfi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnJuego = findViewById(R.id.btnJuego);
        btnPuntajes = findViewById(R.id.btnPuntajes);
        btnConfi = findViewById(R.id.btnConfi);
        listaJugadores=new ArrayList<>();
        if(savedInstanceState!=null) {
            if (savedInstanceState.getParcelableArrayList("Lista") != null) {
                this.listaJugadores = savedInstanceState.getParcelableArrayList("Lista");
            }
        }
    }
    public void OnClickJuego(View v){
        if(listaJugadores.size()==0){
            Toast.makeText(this, "No hay ningun jugador registrado", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(MainActivity.this,Juego.class);
            intent.putExtra("Posicion",Posicionar(j));
            startActivity(intent);
        }
    }

    public void OnClickPuntajes(View v){
        if(listaJugadores.size()==0){
            Toast.makeText(this, "No hay ningun jugador registrado", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(MainActivity.this, Lista.class);
            startActivity(intent);
        }
    }

    public void OnClickConfi(View v){
        Intent intent = new Intent(MainActivity.this,Configuracion.class);
        startActivityForResult(intent,NIVEL);
    }

    public int Posicionar(Jugador j){
        int index = -1;
        int tam = listaJugadores.size();
        for (int i = 0; i < tam; i++) {
            if (listaJugadores.get(i).id ==(j.id)) {
                index = i;
                break;
            }
        }
        return index;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case NIVEL:
                if (data == null) return;
                nivel = data.getIntExtra("NIVEL",50);
                tiemposegundos = data.getIntExtra("TIEMPO",60000);
                String name = data.getStringExtra("NOMBRE");
                j = new Jugador(MainActivity.listaJugadores.size()+1,name, 0,nivel,0);
                listaJugadores.add(j);

                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("Lista",listaJugadores);
    }

}
