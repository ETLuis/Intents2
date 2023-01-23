package com.dam2.intent2

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    // Declaramos los resultados del request, el TextView de la imagen y el TextView del resultado
    val RESULTADO_UNO = 1
    val RESULTADO_DOS = 2
    val imagen = findViewById<ImageView>(R.id.imagen)
    val resultText = findViewById<TextView>(R.id.resultado)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            // Declaramos el boton para abrir la camara
            val camara = findViewById<Button>(R.id.camara)
            //Hacemos el evento de la camara
            camara.setOnClickListener() {
                //Le decimos que haga el metodo "dispatchTakePictureIntent()"
                dispatchTakePictureIntent()
            }
            // Declaramos el boton del resultado
            val resultado = findViewById<Button>(R.id.resultado)

            //Hacemos el evento del resultado
            resultado.setOnClickListener(){
                // Declaramos el Intent y la clase Random
                val intent = Intent(this, MainActivity2::class.java)
                val random = Random()

                // Declaramos los numeros que queremos operar
                val numero1 = random.nextInt(10) + 1
                val numero2 = random.nextInt(10) + 1

                // Añadimos números al Intent
                intent.putExtra("numero1", numero1)
                intent.putExtra("numero2", numero2)

                // Iniciamos la Segunda Activity
                startActivityForResult(intent, RESULTADO_DOS)
            }
    }
    // Declaramos el boton del resultado
    val REQUEST_IMAGE_CAPTURE = 1
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    // Declaramos el onActivityResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Le decimos que si el requestCode es igual a RESULTADO_UNO nos ponga la imagen en el TextView
        if (requestCode == RESULTADO_UNO && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imagen.setImageBitmap(imageBitmap)
        }
        // Le decimos que si el requestCode es igual a RESULTADO_DOS nos haga la operacion de multiplicacion en la Segunda Activity
        if (requestCode == RESULTADO_DOS && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            resultText.text = data?.getStringExtra("multiplicacion")
        }
    }
}