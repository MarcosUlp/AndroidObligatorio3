package com.example.obligatorio3.ui.Eliminar;

import static com.example.obligatorio3.MainActivity.stock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.obligatorio3.Modelo.Producto;
import com.example.obligatorio3.databinding.FragmentEliminarBinding;
import com.example.obligatorio3.Modelo.Producto;

import java.util.Optional;

public class EliminarViewModel extends ViewModel {
    private final MutableLiveData<Boolean> volverDespuesDeEliminar = new MutableLiveData<>();
    private final MutableLiveData<Producto> productoEncontrado = new MutableLiveData<>();
    private final MutableLiveData<String> mensaje = new MutableLiveData<>();
    private final MutableLiveData<Boolean> eliminado = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> navegarADetalle = new MutableLiveData<>();
    public LiveData<Boolean> getVolverDespuesDeEliminar() { return volverDespuesDeEliminar; }
    public LiveData<Producto> getProductoEncontrado() {
        return productoEncontrado;
    }

    public LiveData<String> getMensaje() {
        return mensaje;
    }

    public LiveData<Boolean> getEliminado() {
        return eliminado;
    }

    public LiveData<Boolean> getNavegarADetalle() {
        return navegarADetalle;
    }

    // Buscar por código
    public void buscarProducto(String codigo) {
        Optional<Producto> producto = stock.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();

        if (producto.isPresent()) {
            productoEncontrado.setValue(producto.get());
            mensaje.setValue("Producto encontrado");

            // 🔹 Solo dispara navegación si realmente hay un producto
            if (Boolean.TRUE.equals(navegarADetalle.getValue())) {
                // ya estaba en true, no hacer nada (evita doble disparo)
            } else {
                navegarADetalle.setValue(true); // dispara navegación
            }

        } else {
            productoEncontrado.setValue(null);
            mensaje.setValue("No se encontró el producto");
            navegarADetalle.setValue(false);
        }
    }

    // Eliminar producto
    public void eliminarProducto() {
        Producto p = productoEncontrado.getValue();
        if (p != null) {
            stock.remove(p);
            mensaje.setValue("Producto eliminado correctamente");
            volverDespuesDeEliminar.setValue(true); // dispara volver
        }
    }
    public void volverDespuesDeEliminarConsumido() {
        volverDespuesDeEliminar.setValue(false);
    }
    public void navegarADetalleConsumido() {
        navegarADetalle.setValue(false);
    }
}



