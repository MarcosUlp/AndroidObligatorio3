package com.example.obligatorio3.ui.listar;

import static com.example.obligatorio3.MainActivity.stock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.obligatorio3.Modelo.Producto;

import java.util.ArrayList;

public class ListarViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Producto>> mLista;

    public LiveData<ArrayList<Producto>> getMLista() {
        if (mLista == null) mLista = new MutableLiveData<>();
        return mLista;
    }

    public void cargarLista() {
        mLista.setValue(stock);
    }
}