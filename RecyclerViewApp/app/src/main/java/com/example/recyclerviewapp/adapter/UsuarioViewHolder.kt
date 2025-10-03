package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.Usuario

class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val txtNombre = view.findViewById<TextView>(R.id.txtNombre)
    private val txtEdad = view.findViewById<TextView>(R.id.txtEdad)
    private val txtCorreo = view.findViewById<TextView>(R.id.txtCorreo)
    private val btnDelete = view.findViewById<ImageButton>(R.id.btnEliminar)

    fun bind(
        usuario: Usuario,
        onDeleteClick: (Int) -> Unit,
        onEditClick: (Int, Usuario) -> Unit
    ) {
        txtNombre.text = usuario.nombre
        txtEdad.text = usuario.edad.toString()
        txtCorreo.text = usuario.email

        btnDelete.setOnClickListener {
            val pos = bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onDeleteClick(pos)
            }
        }

        itemView.setOnLongClickListener {
            val pos = bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                AlertDialog.Builder(itemView.context)
                    .setTitle("Acción")
                    .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                        when (which) {
                            0 -> {
                                // Inflar layout del diálogo
                                val context = itemView.context
                                val dialogView = LayoutInflater.from(context)
                                    .inflate(R.layout.dialog_edit_usuario, null)

                                val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
                                val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
                                val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

                                // Setear valores actuales
                                editNombre.setText(usuario.nombre)
                                editEdad.setText(usuario.edad.toString())
                                editCorreo.setText(usuario.email)

                                AlertDialog.Builder(context)
                                    .setTitle("Editar usuario")
                                    .setView(dialogView)
                                    .setPositiveButton("Guardar") { _, _ ->
                                        val position = bindingAdapterPosition
                                        if (position != RecyclerView.NO_POSITION) {
                                            usuario.nombre = editNombre.text.toString()
                                            usuario.edad = editEdad.text.toString().toIntOrNull() ?: usuario.edad
                                            usuario.email = editCorreo.text.toString()
                                            onEditClick(position, usuario)
                                        }
                                    }
                                    .setNegativeButton("Cancelar", null)
                                    .show()
                            }
                            1 -> onDeleteClick(pos)
                        }
                    }
                    .show()
            }
            true
        }
    }
}
