package com.example.quizuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NombreActivity extends AppCompatActivity {


    private EditText nombreEstu;
    private EditText codigoEstu;
    private Button botonContinuar;
    private String codigosLista;
    private boolean noSeRepite;
    private  String[] codigosSeparados;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        SharedPreferences preferencias = getSharedPreferences("p", MODE_PRIVATE);
        codigosLista = preferencias.getString("Lista","");
        nombreEstu = findViewById(R.id.nombreEstu);
        codigoEstu = findViewById(R.id.codigoEstu);
        botonContinuar = findViewById(R.id.botonContinuar);
        noSeRepite = true;

        botonContinuar.setOnClickListener((v)-> {

            codigosLista = preferencias.getString("Lista","");
            codigosSeparados = codigosLista.split("");
            noSeRepite = true;

            if(nombreEstu.getText().toString().equals("")||codigoEstu.getText().toString().equals("")){
                Toast.makeText(this, "El nombre y codigo no pueden quedar vacios", Toast.LENGTH_SHORT).show();
            }
            else{
                for(int i = 0; i< codigosSeparados.length;i++){
                    if(codigosSeparados[i].equals(codigoEstu.getText().toString())){
                        noSeRepite = false;
                    }
                }
                if(noSeRepite==false){
                    Toast.makeText(this, "Error: código repetido", Toast.LENGTH_SHORT).show();
                }

                if(noSeRepite==true){
                    preferencias.edit().putString("Lista",preferencias.getString("Lista","")+ "\n" + codigoEstu.getText().toString()).apply();
                    preferencias.edit().putString("estudiante",nombreEstu.getText().toString()).apply();
                    Intent in = new Intent(this,PreparacionActivity.class);
                    startActivity(in);
                    finish();
                }
            }
        });



    }
}