package com.example.quizuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class AutoEvaluacionActitvity extends AppCompatActivity {


    private CheckBox checkUno;
    private CheckBox checkDos;
    private CheckBox checkTres;
    private Button botonFinalizar;
    int puntaje;
    private String registro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_evaluacion_actitvity);


        checkUno = findViewById(R.id.checkUno);
        checkDos = findViewById(R.id.checkDos);
        checkTres = findViewById(R.id.checkTres);
        botonFinalizar = findViewById(R.id.botonFin);


        botonFinalizar.setOnClickListener((v)->{
            SharedPreferences preferencias = getSharedPreferences("p", MODE_PRIVATE);
            puntaje = preferencias.getInt("puntaje1", 0);
            if(checkUno.isChecked()==false&&checkDos.isChecked()==false&&checkTres.isChecked()==false){
                Toast.makeText(this, "Error: seleccione al menos una opción", Toast.LENGTH_SHORT).show();
            }
            else{

                if(checkUno.isChecked()==true){
                    puntaje +=3;
                }

                if(checkDos.isChecked()==true){
                    puntaje +=3;
                }

                registro = preferencias.getString("estudiante", "No existe") +"   "+ puntaje;
                preferencias.edit().putString("registros", preferencias.getString("registros", "") + "\n" + registro).apply();
                finish();
            }


        });







    }
}