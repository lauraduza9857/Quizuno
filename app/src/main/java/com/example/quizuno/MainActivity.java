package com.example.quizuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView registradosEst;
    private Button botonRegistrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        registradosEst = findViewById(R.id.registradosEst);
        botonRegistrar = findViewById(R.id.botonRegistro);

        botonRegistrar.setOnClickListener((v)->{
            Intent i = new Intent(this, NombreActivity.class);
            startActivity(i);
        } );




    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferencias = getSharedPreferences("p", MODE_PRIVATE);
        registradosEst.setText(preferencias.getString("registros", "No existe"));

    }
}