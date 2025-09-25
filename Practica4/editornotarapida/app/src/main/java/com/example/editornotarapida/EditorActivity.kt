package com.example.editornotarapida

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditorActivity : AppCompatActivity() {

    private lateinit var etNota: EditText

    // Clave para guardar/restaurar estado
    companion object {
        private const val CLAVE_NOTA = "nota"
    }

    // Registrar Activity Result API (StartActivityForResult)
    private val opcionesLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val textoDevuelto = result.data?.getStringExtra(CLAVE_NOTA)
            if (textoDevuelto != null) {
                etNota.setText(textoDevuelto)
                etNota.setSelection(textoDevuelto.length)
            }
        }
        // Si RESULT_CANCELED: no hacemos nada (se queda el texto actual)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        etNota = findViewById(R.id.etNota)
        val btnCompartir: Button = findViewById(R.id.btnCompartir)

        // Restaurar texto si hubo rotación
        val restaurado = savedInstanceState?.getString(CLAVE_NOTA)
        if (restaurado != null) {
            etNota.setText(restaurado)
            etNota.setSelection(restaurado.length)
        }

        btnCompartir.setOnClickListener {
            val texto = etNota.text?.toString().orEmpty()
            val intent = Intent(this, OpcionesActivity::class.java).apply {
                putExtra(CLAVE_NOTA, texto)
            }
            opcionesLauncher.launch(intent)
        }
    }

    // Guardar el contenido del EditText al rotar
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(CLAVE_NOTA, etNota.text?.toString().orEmpty())
    }
}
