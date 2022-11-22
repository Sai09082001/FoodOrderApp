package org.o7planning.knfood.Menu.Messenger;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.o7planning.knfood.Adapter.MessengerAdapter;
import org.o7planning.knfood.Model.Messenger;
import org.o7planning.knfood.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TinNhanFragment extends Fragment {

RecyclerView rv_list_mess;

public static String username;
public ArrayList<Messenger> dsMess = new ArrayList<>();
    public TinNhanFragment() {
        // Required empty public constructor
    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
            int position = viewHolder.getAdapterPosition();
            Messenger mess = dsMess.get(position);
            username=mess.getUsername();
            Intent i = new Intent(v.getContext(),MessRoom.class);
            startActivity(i);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     ViewGroup root =  (ViewGroup)inflater.inflate(R.layout.fragment_tin_nhan, container, false);
     // list chat
        rv_list_mess = root.findViewById(R.id.rv_mess_list);
        Messenger user = new Messenger("ac","Trần Hiếu","Xin chào! Tôi cần giúp đỡ...","Trực tuyến");
        Messenger user2 = new Messenger("ac","Ngọc Anh","Xin chào! Tôi cần giúp đỡ...","Đang bận");
        Messenger user3 = new Messenger("ac","Văn Hải","Xin chào! Tôi cần giúp đỡ...","Ngoại tuyến");
        dsMess.add(user);   dsMess.add(user2);   dsMess.add(user3); dsMess.add(user2);   dsMess.add(user3);
        MessengerAdapter adapter = new MessengerAdapter(dsMess);
        rv_list_mess.setLayoutManager(new LinearLayoutManager(root.getContext()));
        rv_list_mess.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
        return root;
    }

}
