//En este programa agregamos 2 actividades las cuales una es para el editor de texto con su respectivo boton de confirmacion ,y  el otro para las opciones luego de haber confirmado la escritura
//Autor: Luis Gonzalo Basurco Monroy
//fecha creacion: 25 de septiembre
//ultima modificacion: 25 de septiembre

package com.example.editornotarapida

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {

    companion object {
        private const val CLAVE_NOTA = "nota"
    }

    private lateinit var tvNota: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        tvNota = findViewById(R.id.tvNota)
        val btnCompartirCorreo: Button = findViewById(R.id.btnCompartirCorreo)
        val btnEditarDeNuevo: Button = findViewById(R.id.btnEditarDeNuevo)

        val notaInicial = savedInstanceState?.getString(CLAVE_NOTA)
            ?: intent.getStringExtra(CLAVE_NOTA).orEmpty()
        tvNota.text = notaInicial

        btnCompartirCorreo.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
        }

        btnEditarDeNuevo.setOnClickListener {
            // Devolver la nota actual a EditorActivity
            val data = intent.apply {
                putExtra(CLAVE_NOTA, tvNota.text.toString())
            }
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(CLAVE_NOTA, tvNota.text.toString())
    }
}
