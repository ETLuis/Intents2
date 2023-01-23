package com.dam2.intent2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val resultText = findViewById<TextView>(R.id.resultado)
        val intent = getIntent()
        val numero1 = intent.getIntExtra("numero1", 0)
        val numero2 = intent.getIntExtra("numero2", 0)
        var resultado = numero1 * numero2

        intent.putExtra("multiplicacion", resultado.toString());
        setResult(RESULT_OK, intent);
        resultText.text = resultado.toString()
        Log.d("Resultado",  numero1 + " * " + numero2 + "Resultado = " + resultado)
        finish()

    }
}