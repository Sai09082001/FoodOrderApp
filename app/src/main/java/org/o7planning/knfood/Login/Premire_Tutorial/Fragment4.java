package org.o7planning.knfood.Login.Premire_Tutorial;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {
Button btn_gotohome;

    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    ViewGroup rootview =(ViewGroup)inflater.inflate(R.layout.fragment_fragment4, container, false);
    btn_gotohome=rootview.findViewById(R.id.btn_gotohome);
    btn_gotohome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), MenuActivity.class);
            startActivity(i);
        }
    });
        return rootview;
    }

}
