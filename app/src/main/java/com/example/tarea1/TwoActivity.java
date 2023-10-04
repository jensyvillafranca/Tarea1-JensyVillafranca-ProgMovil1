package com.example.tarea1;

import static com.example.tarea1.Operaciones.resultado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.text.DecimalFormat;


public class TwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //Lugar donde se colocara el dato
        TextView verResultado = findViewById(R.id.lblResultado);

        //Formato
        DecimalFormat df = new DecimalFormat("0.00");

        //Armar una etiqueta
        String mostrar = "El resultado de la operación es: "+df.format(resultado); //Redondear la respuesta

        //Cargar el mensaje
        verResultado.setText(mostrar);
    }
}