package com.dam2.intent2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Declaramos el TextView del resultado
        val resultText = findViewById<TextView>(R.id.resultado)
        // Recogemos el Intent
        val intent = getIntent()
        // Recogemos los valores de los numeros
        val numero1 = intent.getIntExtra("numero1", 0)
        val numero2 = intent.getIntExtra("numero2", 0)
        // Hacemos la operacion
        var resultado = numero1 * numero2

        intent.putExtra("multiplicacion", resultado.toString());
        //Hacemos un setResult para enviarselo al Intent
        setResult(RESULT_OK, intent);
        //Cambiamos el resultado en el TextView
        resultText.text = resultado.toString()
        //Mandamos un mensaje por el LogCat que nos muestra el resultado
        Log.d("Resultado",  numero1 + " * " + numero2 + "Resultado = " + resultado)
        // Cerramos la activity
        finish()

    }
}