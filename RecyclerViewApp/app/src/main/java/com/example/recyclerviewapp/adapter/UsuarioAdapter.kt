package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.Usuario

class UsuarioAdapter(var items: MutableList<Usuario>) : RecyclerView.Adapter<UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val user = items[position]
        holder.bind(
            usuario = user,
            onDeleteClick = { pos -> removeUser(pos) },
            onEditClick = { pos, updated ->
                updateUser(pos, updated)
            }
        )
    }

    override fun getItemCount(): Int = items.size

    fun addUser(user: Usuario) {
        items.add(user)
        notifyItemInserted(items.size - 1)
    }

    fun removeUser(position: Int) {
        if (position in items.indices) {
            items.removeAt(position)
            notifyItemRemoved(position)
            // Notifica el rango restante para mantener posiciones consistentes
            if (position < items.size) {
                notifyItemRangeChanged(position, items.size - position)
            }
        }
    }

    fun updateUser(position: Int, updated: Usuario) {
        if (position in items.indices) {
            items[position] = updated
            notifyItemChanged(position)
        }
    }
}
