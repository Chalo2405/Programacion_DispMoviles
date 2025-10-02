//Tengo que realizar un app basica que registre pedidos y vaya en orden , es decir primero la comida luego los extras y luego el boton  de confirmar pedidos , debo usar fragments
//Autor: Luis Gonzalo Basurco Monroy
//fecha creacion: 2 De Octubre del 2025
//fecha ultima modificacion: 2 de Octubre del 2025

package com.example.comida

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class InicioFragment : Fragment(R.layout.fragment_inicio) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btnNuevoPedido).setOnClickListener {
            findNavController().navigate(R.id.action_inicio_to_seleccionComida)
        }
    }
}