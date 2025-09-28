package com.example.obligatorio3.ui.listar;



import static com.example.obligatorio3.MainActivity.stock;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.obligatorio3.databinding.FragmentListarBinding;
import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mv = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getMLista().observe(getViewLifecycleOwner(), new Observer<ArrayList<com.example.obligatorio3.Modelo.Producto>>() {
            @Override
            public void onChanged(ArrayList<com.example.obligatorio3.Modelo.Producto> productos) {
                ListaAdapter la = new ListaAdapter(productos, getLayoutInflater(), getContext());
                GridLayoutManager glm = new GridLayoutManager(getContext(), 1);
                binding.recyclerProductos.setLayoutManager(glm);
                binding.recyclerProductos.setAdapter(la);
            }
        });

        mv.cargarLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
