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
import com.example.obligatorio3.R;
import com.example.obligatorio3.databinding.FragmentEliminarBinding;

public class EliminarFragment extends Fragment {
    private FragmentEliminarBinding binding;
    private EliminarViewModel mv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mv = new ViewModelProvider(requireActivity()).get(EliminarViewModel.class);
        binding = FragmentEliminarBinding.inflate(inflater, container, false);

        // Botón buscar
        binding.btBuscarEliminar.setOnClickListener(v ->
                mv.buscarProducto(binding.etCodigoEliminar.getText().toString())
        );

        // Observa mensajes
        mv.getMensaje().observe(getViewLifecycleOwner(),
                msg -> Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show());

        // Observa navegación al detalle (lo decide el ViewModel)
        mv.getNavegarADetalle().observe(getViewLifecycleOwner(), go -> {
            if (Boolean.TRUE.equals(go)) {
                mv.navegarADetalleConsumido();
                NavHostFragment.findNavController(this).navigate(R.id.nav_detalleProducto);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
