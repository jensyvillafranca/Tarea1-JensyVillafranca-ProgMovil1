package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText number_one, number_two;
    Button btn_add, btn_subtract, btn_multiply, btn_split;
    //add -> sumar, subtract -> restar, multiply -> multiplicar, split ->division

    int type_Operation;
    //type_Operation -> Tipo de operacion
    double number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_one = (EditText) findViewById(R.id.txtNumero1);
        number_two = (EditText) findViewById(R.id.txtNumero2);
        btn_add = (Button) findViewById(R.id.btnSum);
        btn_subtract = (Button) findViewById(R.id.btnRes);
        btn_multiply = (Button) findViewById(R.id.btnMulti);
        btn_split = (Button) findViewById(R.id.btnDiv);


        btn_add.setOnClickListener(new View.OnClickListener() { //Para sumar
            @Override
            public void onClick(View view) {
                llamarDeclaracion();
                if(validar() == true && validarPuntos() == true) {
                    type_Operation = 1;
                    Operaciones objeto = new Operaciones(number1,number2,type_Operation);
                    Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn_subtract.setOnClickListener(new View.OnClickListener() { //Para restar
            @Override
            public void onClick(View view) {
                llamarDeclaracion();
                if(validar() == true && validarPuntos() == true) {
                    type_Operation = 2;
                    Operaciones objeto = new Operaciones(number1,number2,type_Operation);
                    Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() { //Para multiplicar
            @Override
            public void onClick(View view) {
                llamarDeclaracion();
                if(validar() == true && validarPuntos() == true) {
                    type_Operation = 3;
                    Operaciones objeto = new Operaciones(number1,number2,type_Operation);
                    Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
                    startActivity(intent);
                }
            }
        });

        btn_split.setOnClickListener(new View.OnClickListener() { //Para dividir
            @Override
            public void onClick(View view) {
                llamarDeclaracion();
                if(validar() == true && validarDivisionInvalida()==true && validarPuntos() == true) {
                    type_Operation = 4;
                    Operaciones objeto = new Operaciones(number1,number2,type_Operation);
                    Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean validar(){
        boolean retorna = true;

        if(number_one.getText().toString().isEmpty()){
            number_one.setError("No se permiten campos vacios");
            retorna = false;
        }
        if(number_two.getText().toString().isEmpty()){
            number_two.setError("No se permiten campos vacios");
            retorna = false;
        }
        return retorna;
    }

    //Validar la división entre 0
    public boolean validarDivisionInvalida(){
        boolean retornaDiv = true;

        if(number_two.getText().toString().equals("0") || number2 == 0.0 ){
            Log.d("Mostrar",""+number2);
            number_two.setError("No se permite la división entre 0");
            retornaDiv = false;
        }
        String prueba = String.valueOf(retornaDiv);
        Log.d("Mensaje",prueba);
        return retornaDiv;
    }

    //Validar que no se permita ingresar puntos solos o acompañados de un numéro.
    public boolean validarPuntos(){
        boolean retornaPuntos = true;

        if(number_one.getText().toString().substring(0).equals(".") || number_one.getText().toString().substring(number_one.getText().toString().length()-1).equals(".")){ //hay un punto en la primera posición o ultima posicion de la cadena
            number_one.setError("Formato Incorrecto y/o Incompleto");
            retornaPuntos = false;
        }
        if(number_two.getText().toString().substring(0).equals(".") || number_two.getText().toString().substring(number_two.getText().toString().length()).equals(".")){
            number_two.setError("Formato Incorrecto y/o Incompleto");
            retornaPuntos = false;
        }
        return retornaPuntos;
    }

    public void llamarDeclaracion(){
        number1 = Double.parseDouble(String.valueOf(number_one.getText()));
        number2 = Double.parseDouble(String.valueOf(number_two.getText()));
    }
}