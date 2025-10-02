package com.example.comida

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SeleccionComidaFragment : Fragment(R.layout.fragment_seleccion_comida) {
    companion object {
        const val KEY_COMIDA = "key_comida"
        const val KEY_EXTRAS = "key_extras"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentFragmentManager.setFragmentResultListener("editarPedido", this) { _, result ->
            val comida = result.getString(KEY_COMIDA)
            view?.findViewById<RadioGroup>(R.id.rgComidas)?.apply {
                when (comida) {
                    "pizza" -> check(R.id.rbPizza)
                    "hamburguesa" -> check(R.id.rbHamburguesa)
                    "ensalada" -> check(R.id.rbEnsalada)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btnSiguiente).setOnClickListener {
            val seleccionado = when (view.findViewById<RadioGroup>(R.id.rgComidas).checkedRadioButtonId) {
                R.id.rbPizza -> "pizza"
                R.id.rbHamburguesa -> "hamburguesa"
                else -> "ensalada"
            }
            val bundle = Bundle().apply { putString(KEY_COMIDA, seleccionado) }
            findNavController().navigate(R.id.action_comida_to_extras, bundle)
        }
    }
}