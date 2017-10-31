package com.example.jhordan.people_mvvm.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jhordan.people_mvvm.R;
import com.example.jhordan.people_mvvm.databinding.ListNewsBinding;
import com.example.jhordan.people_mvvm.viewmodel.ListViewModel;

import java.util.Observable;
import java.util.Observer;

public class ListFragment extends Fragment implements Observer {
    private ListNewsBinding listNewsBinding;
    private ListViewModel listViewModel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initDataBinding();
        //инициализация списков, тулбаров и т.д.

        setupObserver(listViewModel);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    private void initDataBinding() {
        listNewsBinding = DataBindingUtil.setContentView(getActivity(), R.layout.list_news);
        listViewModel = new ListViewModel(getActivity());
        listNewsBinding.setListModel(listViewModel);

    }
    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        // TODO: 25.10.2017 Обнавление адаптера списка
    }
}
