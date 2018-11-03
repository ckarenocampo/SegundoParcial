package com.example.guia.examen2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Configuracion extends AppCompatActivity {

    RadioButton rbt1,rbt2,rbt3;
    RadioButton rbtt1,rbtt2,rbtt3;
    EditText txtNick;
    int nivel,generar;
    int tiempo,segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        rbt1 = findViewById(R.id.rbtn1);
        rbt2= findViewById(R.id.rbtn2);
        rbt3= findViewById(R.id.rbtn3);
        rbtt1 = findViewById(R.id.rbtnt1);
        rbtt2= findViewById(R.id.rbtnt2);
        rbtt3= findViewById(R.id.rbtnt3);
        txtNick = findViewById(R.id.txtNick);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void OnClickGuardar(View v){
        String jugador = txtNick.getText().toString();

        if(jugador.isEmpty()){
            txtNick.setHint("Ingresa un nickname");
            txtNick.setHintTextColor(Color.rgb(255, 128, 128));
        }else {
            Intent activity = new Intent(this, MainActivity.class);
            if (rbt1.isChecked()) {
                nivel = 3;
                generar=50;
            }
            if (rbt2.isChecked()) {
                nivel = 2;
                generar=100;
            }
            if (rbt3.isChecked()) {
                nivel = 1;
                generar=150;
            }
            if (rbtt1.isChecked()) {
                tiempo=60000;
                segundos=60;
            }
            if (rbtt2.isChecked()) {
                tiempo =120000;
                segundos=120;
            }
            if (rbtt3.isChecked()) {
                tiempo = 180000;
                segundos=180;
            }
            activity.putExtra("NOMBRE",jugador);
            activity.putExtra("TIEMPO", tiempo);
            activity.putExtra("GENERAR", generar);
            activity.putExtra("DIFICULTAD", nivel);
            setResult(MainActivity.NIVEL, activity);
            finish();


        }
    }
}
