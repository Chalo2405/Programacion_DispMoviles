package com.example.comida

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ResumenPedidoFragment : Fragment(R.layout.fragment_resumen_pedido) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val comida = arguments?.getString(SeleccionComidaFragment.KEY_COMIDA).orEmpty()
        val extras = arguments?.getStringArrayList(SeleccionComidaFragment.KEY_EXTRAS).orEmpty()

        view.findViewById<TextView>(R.id.tvResumen).text =
            "Comida: $comida\nExtras: ${if (extras.isEmpty()) "(ninguno)" else extras.joinToString()}"

        view.findViewById<Button>(R.id.btnConfirmar).setOnClickListener {
            Toast.makeText(requireContext(), "Pedido confirmado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_resumen_to_inicio)
        }

        view.findViewById<Button>(R.id.btnEditar).setOnClickListener {
            val result = Bundle().apply {
                putString(SeleccionComidaFragment.KEY_COMIDA, comida)
                putStringArrayList(SeleccionComidaFragment.KEY_EXTRAS, ArrayList(extras))
            }
            parentFragmentManager.setFragmentResult("editarPedido", result)
            findNavController().popBackStack(R.id.seleccionComidaFragment, false)
        }
    }
}