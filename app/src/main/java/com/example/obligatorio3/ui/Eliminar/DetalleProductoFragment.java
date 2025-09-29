package com.example.obligatorio3.ui.Eliminar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.obligatorio3.Modelo.Producto;
import com.example.obligatorio3.databinding.FragmentDetalleProductoBinding;
public class DetalleProductoFragment extends Fragment {
    private FragmentDetalleProductoBinding binding;
    private EliminarViewModel mv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mv = new ViewModelProvider(requireActivity()).get(EliminarViewModel.class);
        binding = FragmentDetalleProductoBinding.inflate(inflater, container, false);

        // mostrar detalles del producto
        mv.getProductoEncontrado().observe(getViewLifecycleOwner(), this::mostrarDetalle);

        // Botón confirmar eliminación
        binding.btConfirmarEliminar.setOnClickListener(v -> mv.eliminarProducto());

        // Observa mensajes
        mv.getMensaje().observe(getViewLifecycleOwner(),
                msg -> Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show());

        mv.getVolverDespuesDeEliminar().observe(getViewLifecycleOwner(), go -> {
            if (Boolean.TRUE.equals(go)) {
                mv.volverDespuesDeEliminarConsumido();
                NavHostFragment.findNavController(this).popBackStack();
            }
        });


        return binding.getRoot();
    }

    private void mostrarDetalle(Producto p) {
        String detalle = "Código: " + p.getCodigo() +
                "\nDescripción: " + p.getDescripcion() +
                "\nPrecio: $" + p.getPrecio();
        binding.tvDetalle.setText(detalle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
