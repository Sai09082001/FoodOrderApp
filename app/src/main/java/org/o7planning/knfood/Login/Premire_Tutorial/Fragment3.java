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
public class Fragment3 extends Fragment {


    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview =(ViewGroup)inflater.inflate(R.layout.fragment_fragment3, container, false);
        return rootview;
    }

}
