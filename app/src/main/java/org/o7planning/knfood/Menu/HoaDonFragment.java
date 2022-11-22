package org.o7planning.knfood.Menu;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.o7planning.knfood.Menu.HoaDon.ListHoaDon;
import org.o7planning.knfood.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HoaDonFragment extends Fragment {

TextView tv_lichsuhoadon;
    public HoaDonFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      ViewGroup root =(ViewGroup) inflater.inflate(R.layout.fragment_hoa_don, container, false);
      tv_lichsuhoadon = root.findViewById(R.id.btn_lichsuhoadon);
     tv_lichsuhoadon.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(v.getContext(), ListHoaDon.class));
         }
     });
        return root;
    }

}
