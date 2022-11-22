package org.o7planning.knfood.Menu.Personal;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaNhanFragment extends Fragment {
    LinearLayout btn_logout;
    TextView btn_chinhsua;
    TextView username;
    public CaNhanFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login,container,false);
        username = view.findViewById(R.id.ed_username);



        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.fragment_ca_nhan, container, false);

      btn_logout= root.findViewById(R.id.btn_logout);
      btn_logout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(v.getContext(), "Đăng xuất", Toast.LENGTH_SHORT).show();
          }
      });
      btn_chinhsua=root.findViewById(R.id.btn_chinhsua);
      btn_chinhsua.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(v.getContext(),UpdateInfo.class);
              startActivity(i);
          }
      });
        return root;
    }

}
