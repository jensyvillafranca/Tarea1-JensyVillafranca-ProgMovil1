package com.example.tarea1;

import android.content.Context;
import android.content.Intent;

public class Operaciones {
    private double numero1, numero2;
    public static double resultado;

    public Operaciones(double numero1, double numero2, int oper) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        if(oper == 1){
            resultado = Suma();
        }
        if(oper == 2){
            resultado = Resta();
        }
        if(oper == 3){
            resultado = Multiplicacion();
        }
        if(oper == 4){
            resultado= Division();
        }

    }

    private double Suma (){
        double suma = numero1 + numero2;
        return suma;
    }
    private double Resta (){
        double resta = numero1 - numero2;
        return resta;
    }
    private double Multiplicacion (){
        double multi = numero1 * numero2;
        return multi;
    }
    private double Division (){
        double div = numero1 / numero2;
        return div;
    }


}
