package org.o7planning.knfood.Login.Premire_Tutorial;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.o7planning.knfood.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.fragment_fragment1, container, false);
        return rootView;
    }

}
