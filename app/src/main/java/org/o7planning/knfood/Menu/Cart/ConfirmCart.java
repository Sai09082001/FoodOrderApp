package org.o7planning.knfood.Menu.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.o7planning.knfood.Adapter.ConfirmCartAdapter;
import org.o7planning.knfood.Menu.HoaDon.ListHoaDon;
import org.o7planning.knfood.Model.Cart;
import org.o7planning.knfood.R;

import java.util.ArrayList;

public class ConfirmCart extends AppCompatActivity {
Toolbar tb;
ArrayList<Cart> dscart = new ArrayList<>();
RecyclerView rv_list_confirm_cart;
    Button btn_confirm_cart_xacnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_cart);
        //custom toolbar
        tb=findViewById(R.id.tb_confirm_cart);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),CartActivity.class);
                startActivity(i);
            }
        });
        //custom toolbar
        // list confirm cart
        rv_list_confirm_cart = findViewById(R.id.rv_list_confirm_cart);
        Cart cart = new Cart("acb",287.987,"Combo gà rán 2 người + nước Size Vừa - \n"
                ,4);
        Cart cart2 = new Cart("acb",287.987,"Combo gà rán 3 người + nước Size Vừa \n"
                ,5);
        Cart cart3 = new Cart("acb",287.987,"Combo gà rán 4 người + nước Size Vừa - \n"
                ,12);
        Cart cart4 = new Cart("acb",287.987,"Combo gà rán 2 người + nước Size Vừa \n"
                ,4);
        dscart.add(cart); dscart.add(cart2); dscart.add(cart3); dscart.add(cart4);
        ConfirmCartAdapter adapter = new ConfirmCartAdapter(dscart);
        rv_list_confirm_cart.setLayoutManager(new LinearLayoutManager(this));
        rv_list_confirm_cart.setAdapter(adapter);
        // Chuyển đến màn lịch sử hóa đơn
        btn_confirm_cart_xacnhan=findViewById(R.id.btn_cart_dathang);
        btn_confirm_cart_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ListHoaDon.class));
            }
        });
        // Chuyển đến màn lịch sử hóa đơn
    }
}
