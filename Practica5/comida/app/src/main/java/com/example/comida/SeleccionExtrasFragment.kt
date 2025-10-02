package com.example.comida
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
class SeleccionExtrasFragment : Fragment(R.layout.fragment_seleccion_extras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val comida = requireArguments().getString(SeleccionComidaFragment.KEY_COMIDA)
        view.findViewById<Button>(R.id.btnSiguiente).setOnClickListener {
            val bebida = view.findViewById<CheckBox>(R.id.cbBebida).isChecked
            val papas = view.findViewById<CheckBox>(R.id.cbPapas).isChecked
            val postre = view.findViewById<CheckBox>(R.id.cbPostre).isChecked
            val extras = arrayListOf<String>().apply {
                if (bebida) add("bebida")
                if (papas) add("papas")
                if (postre) add("postre")
            }
            val bundle = Bundle().apply {
                putString(SeleccionComidaFragment.KEY_COMIDA, comida)
                putStringArrayList(SeleccionComidaFragment.KEY_EXTRAS, extras)
            }
            findNavController().navigate(R.id.action_extras_to_resumen, bundle)
        }
    }
}