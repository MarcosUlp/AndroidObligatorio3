package com.example.obligatorio3.ui.cargar;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.obligatorio3.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {
    private FragmentCargarBinding binding;
    private CargarViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(CargarViewModel.class);


        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btAgregar.setOnClickListener(v ->
                mv.validar(binding.etCodigo.getText().toString(),
                        binding.etDescripcion.getText().toString(),
                        binding.etPrecio.getText().toString()));

        mv.getMError().observe(getViewLifecycleOwner(), s ->
                new AlertDialog.Builder(getContext())
                        .setTitle("ERROR")
                        .setMessage(s)
                        .setNeutralButton("OK", null)
                        .show());

        mv.getMCorrecto().observe(getViewLifecycleOwner(), s ->
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
