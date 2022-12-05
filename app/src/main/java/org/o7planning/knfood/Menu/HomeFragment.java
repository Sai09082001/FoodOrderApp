package org.o7planning.knfood.Menu;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.o7planning.knfood.Adapter.HomeFoodAdapter;
import org.o7planning.knfood.CommonUtils;
import org.o7planning.knfood.Function.OrderFoodActivity;
import org.o7planning.knfood.Model.FoodHome;
import org.o7planning.knfood.Model.Voucher;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;
import org.o7planning.knfood.Ticket.VoucherActivity;
import org.o7planning.knfood.map.MapActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private ArrayList<FoodHome> listfood;
    private RecyclerView rvlist_food;
    private ImageView img_ticket;
    private ImageView ivMap,ivVoucher;
    private Button btDatNgay;
    private LinearLayout btn_datmonan;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            final ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);
            rvlist_food= root.findViewById(R.id.rv_listfood);
            img_ticket= root.findViewById(R.id.img_ticket);
            ivMap= root.findViewById(R.id.iv_map);
            btDatNgay = root.findViewById(R.id.btn_datngay);
            ivVoucher= root.findViewById(R.id.iv_voucher);
            FoodHome fd = new FoodHome("abc","Món Châu Á");
            FoodHome fd2 = new FoodHome("avc","Món Châu Âu");
            FoodHome fd3 = new FoodHome("avc","Món Châu Mỹ");
            listfood = new ArrayList<>();
            listfood.add(fd);   listfood.add(fd2); listfood.add(fd3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvlist_food.setLayoutManager(layoutManager);
        HomeFoodAdapter adapter = new HomeFoodAdapter(listfood);
        rvlist_food.setAdapter(adapter);
        // recycleview list food
        img_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), VoucherActivity.class);
                startActivity(i);
            }
        });
        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });
        ivVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VoucherActivity.class);
                startActivity(intent);
            }
        });
        btDatNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),VoucherActivity.class));
            }
        });
        //click chuyển sang ticket list
        //Nút Đặt món ăn
        btn_datmonan= root.findViewById(R.id.btn_datmonan);
        btn_datmonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(v.getContext(), OrderFoodActivity.class));
            }
        });
        //Nút Đặt món ăn
    return root;
    }

}
