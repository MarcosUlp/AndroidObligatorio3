package com.example.obligatorio3.ui.Salir;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.obligatorio3.R;


public class SalirFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_salir, container, false);

        new AlertDialog.Builder(getContext())
                .setTitle("Salir")
                .setMessage("¿Desea cerrar la aplicación?")
                .setPositiveButton("Sí", (dialog, which) -> getActivity().finish())
                .setNegativeButton("No", null)
                .show();

        return root;
    }
}