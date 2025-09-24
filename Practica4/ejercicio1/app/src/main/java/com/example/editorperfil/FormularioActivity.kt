
//En este script tenemos la creacion del formulario , en donde la persona coloca los datos respectivos
//Autor : Luis Gonzalo Basurco Monroy
//Fecha Creación: 24 de Septiembre


package com.example.editorperfil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnContinuar: Button

    companion object {
        private const val STATE_NOMBRE = "state_nombre"
        private const val STATE_EDAD = "state_edad"
        private const val STATE_CIUDAD = "state_ciudad"
        private const val STATE_EMAIL = "state_email"
        const val EXTRA_USUARIO = "extra_usuario"
    }

    private val resumenLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etEmail = findViewById(R.id.etEmail)
        btnContinuar = findViewById(R.id.btnContinuar)

        if (savedInstanceState != null) {
            etNombre.setText(savedInstanceState.getString(STATE_NOMBRE, ""))
            etEdad.setText(savedInstanceState.getString(STATE_EDAD, ""))
            etCiudad.setText(savedInstanceState.getString(STATE_CIUDAD, ""))
            etEmail.setText(savedInstanceState.getString(STATE_EMAIL, ""))
        }

        btnContinuar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val edadTxt = etEdad.text.toString().trim()
            val ciudad = etCiudad.text.toString().trim()
            val email = etEmail.text.toString().trim()

            val edad = edadTxt.toIntOrNull()
            if (nombre.isEmpty() || edad == null || ciudad.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(nombre, edad, ciudad, email)
            //se envia al resumen activity
            val intent = Intent(this, ResumenActivity::class.java).apply {
                putExtra(EXTRA_USUARIO, usuario)
            }
            resumenLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(STATE_NOMBRE, etNombre.text?.toString())
        outState.putString(STATE_EDAD, etEdad.text?.toString())
        outState.putString(STATE_CIUDAD, etCiudad.text?.toString())
        outState.putString(STATE_EMAIL, etEmail.text?.toString())
        super.onSaveInstanceState(outState)
    }
}
