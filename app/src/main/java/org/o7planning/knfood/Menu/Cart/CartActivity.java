package org.o7planning.knfood.Menu.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.o7planning.knfood.Adapter.ListCartAdapter;
import org.o7planning.knfood.CommonUtils;
import org.o7planning.knfood.Function.OrderFoodActivity;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
     private Toolbar tb;
     private RecyclerView rv_list_cart;
     private Button btn_cart_xacnhan;
     public ArrayList<Food> listFood = new ArrayList<>();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(CartActivity.this, "Đã click", Toast.LENGTH_SHORT).show();
        }
    };
    private SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //custom toolbar
        tb=findViewById(R.id.tb_cart);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), OrderFoodActivity.class));
            }
        });
        //List cart
        rv_list_cart=findViewById(R.id.rv_cart_list_food);
//        Cart cart = new Cart("acb",287.987,"Combo Gà rán 2 người - \n" +
//                "Nước size lớn",1);
//        Cart cart2 = new Cart("acb",287.987,"Combo Gà rán 2 người - \n" +
//                "Nước size lớn",1);
//        Cart cart3 = new Cart("acb",287.987,"Combo Gà rán 2 người - \n" +
//                "Nước size lớn",1);
//        Cart cart4 = new Cart("acb",287.987,"Combo Gà rán 2 người - \n" +
//                "Nước size lớn",1);
   //     dsCartActivity.add(cart); dsCartActivity.add(cart2); dsCartActivity.add(cart3); dsCartActivity.add(cart4);
        db = new SQLiteHelper(getApplicationContext());
        ListCartAdapter adapter = new ListCartAdapter(db.getAll());
        rv_list_cart.setLayoutManager(new LinearLayoutManager(this));
        rv_list_cart.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
        //List cart
        // chuyển sang màn xác nhận đơn
        btn_cart_xacnhan = findViewById(R.id.btn_cart_xacnnhan);
        btn_cart_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < db.getAll().size(); i++) {
                    Food foodTemp =db.getAll().get(i);
                    Food foodUpdate = new Food(foodTemp.getfName(),foodTemp.getNote(),foodTemp.getPrice(),
                            CommonUtils.getInstance().convertDateToString(), "Đã xác nhận");
                    db.delete(foodTemp.getId());
                    db.addFood(foodUpdate);
                }
                startActivity(new Intent(v.getContext(), ConfirmCartActivity.class));
            }
        });
    }
}
