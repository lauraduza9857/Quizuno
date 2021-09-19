package com.example.quizuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class PreparacionActivity extends AppCompatActivity {



    private CheckBox checkUnopre;
    private CheckBox checkDospre;
    private CheckBox checkTrespre;
    private Button botonContipre;
    int puntaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparacion);

        checkUnopre = findViewById(R.id.checkUnopre);
        checkDospre = findViewById(R.id.checkDospre);
        checkTrespre = findViewById(R.id.checkTrespre);
        botonContipre = findViewById(R.id.botonContipre);

        botonContipre.setOnClickListener((v)->{
            SharedPreferences preferencias = getSharedPreferences("p", MODE_PRIVATE);
            puntaje = 0;
            if(checkUnopre.isChecked()==false&&checkDospre.isChecked()==false&&checkTrespre.isChecked()==false){
                Toast.makeText(this, "Error: seleccione al menos una opción", Toast.LENGTH_SHORT).show();
            }
            else{

                if(checkUnopre.isChecked()==true){
                    puntaje +=3;
                }

                if(checkDospre.isChecked()==true){
                    puntaje +=1;
                }

                preferencias.edit().putInt("puntaje1", puntaje).apply();
                Intent i = new Intent(this, AutoEvaluacionActitvity.class);
                startActivity(i);
                finish();
            }


        });
    }
}