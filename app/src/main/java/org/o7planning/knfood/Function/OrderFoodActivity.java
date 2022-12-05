package org.o7planning.knfood.Function;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.o7planning.knfood.Adapter.GoiY_MontrangmiengAdapter;
import org.o7planning.knfood.Menu.Cart.CartActivity;
import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.Model.FoodDesserts;
import org.o7planning.knfood.R;
import org.o7planning.knfood.Menu.Store.ListStoreActivity;
import org.o7planning.knfood.Ticket.VoucherActivity;

import java.util.ArrayList;

public class OrderFoodActivity extends AppCompatActivity {
    private EditText ed_timkiem;
    private Button btDatNgay;
    private LinearLayout btn_chaua;
    private ImageView btn_backhome,btn_cart;
    private ArrayList<FoodDesserts> dsdesert = new ArrayList<>();
    private RecyclerView rv_list_desert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mon_an);
        ed_timkiem = findViewById(R.id.ed_timkiem);
        btn_backhome = findViewById(R.id.btn_backhome);
        rv_list_desert = findViewById(R.id.rv_montrangmieng);
        btDatNgay = findViewById(R.id.btn_datngay);
        btDatNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderFoodActivity.this, VoucherActivity.class));
            }
        });
        FoodDesserts mtm= new FoodDesserts("sda","Cơm gà trứng");
        FoodDesserts mtm2= new FoodDesserts("sda","Mì hải sản");
        FoodDesserts mtm3= new FoodDesserts("sda","Phở bò tươi");
        dsdesert.add(mtm); dsdesert.add(mtm2);dsdesert.add(mtm3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_list_desert.setLayoutManager(layoutManager);
        GoiY_MontrangmiengAdapter adapter = new GoiY_MontrangmiengAdapter(dsdesert);
        rv_list_desert.setAdapter(adapter);
        // list mon trang miệng
        // click vào menu vào danh sách cửa hàng
        btn_chaua = findViewById(R.id.btn_com);
        btn_chaua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ListStoreActivity.class));
            }
        });
        // click vào menu vào danh sách cửa hàng
        //click vào back  về home
        btn_backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MenuActivity.class));
            }
        });
        // chuyển sang cart
        btn_cart = findViewById(R.id.btn_cart);
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CartActivity.class));
            }
        });
    }
}
