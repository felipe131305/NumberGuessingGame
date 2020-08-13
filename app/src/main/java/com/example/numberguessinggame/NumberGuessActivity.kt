package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class NumberGuessActivity : AppCompatActivity() {
    var nAleatorio = Random()
    var num = 0;
    var intentos = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun generar(v: View) {

        num = nAleatorio.nextInt(1000) + 1
        intentos = 0;
        txtnumero.setText("");
    }

    fun doClick(v: View) {




        var texto = " sigue intentando";

        if (txtnumero.toString().isNotEmpty()) {
            Toast.makeText(this, "ingrese un numero", Toast.LENGTH_LONG).show();
        } else {
            var numero = txtnumero.text.toString();
            var numero1: Int = numero.toInt();

            if (numero1 < num) {
                Toast.makeText(
                    this,
                    "el numero es mayor del que elegiste  " + numero1,
                    Toast.LENGTH_LONG
                ).show();
                intentos = intentos + 1;

                txtresultado.setText(texto + " el numero es mayor al que elegiste tu numero es " + numero1);

            } else if (numero1 > num) {
                Toast.makeText(
                    this,
                    "el numero es menor del que elegiste  " + numero1,
                    Toast.LENGTH_LONG
                ).show();
                intentos = intentos + 1;
                txtresultado.setText(texto + " el numero es menor al que elegiste tu numero es " + numero1);
            } else {
                intentos = intentos + 1;
                Toast.makeText(
                    this,
                    "adivinaste el numero es " + +num + " lo hiciste en " + " " + intentos + " intentos",
                    Toast.LENGTH_LONG
                ).show();

                texto = " felicidades ganaste para seguir jugando genera otro numero"
                txtresultado.setText(texto);
            }
        }


    }
}



