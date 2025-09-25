package com.example.editorperfil

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USUARIO = FormularioActivity.EXTRA_USUARIO
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val tvNombre: TextView = findViewById(R.id.tvNombre)
        val tvEdad: TextView = findViewById(R.id.tvEdad)
        val tvCiudad: TextView = findViewById(R.id.tvCiudad)
        val tvEmail: TextView = findViewById(R.id.tvEmail)
        val btnConfirmar: Button = findViewById(R.id.btnConfirmar)
        val btnVolver: Button = findViewById(R.id.btnVolverEditar)

        val usuario = intent.getSerializableExtra(EXTRA_USUARIO) as? Usuario

        tvNombre.text = usuario?.nombre ?: ""
        tvEdad.text = usuario?.edad?.toString() ?: ""
        tvCiudad.text = usuario?.ciudad ?: ""
        tvEmail.text = usuario?.email ?: ""

        btnConfirmar.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        btnVolver.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
