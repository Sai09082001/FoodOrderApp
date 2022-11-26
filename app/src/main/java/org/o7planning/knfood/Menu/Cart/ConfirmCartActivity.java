package org.o7planning.knfood.Menu.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.o7planning.knfood.Adapter.ListCartAdapter;
import org.o7planning.knfood.CommonUtils;
import org.o7planning.knfood.Menu.HoaDon.HistoryBillActivity;
import org.o7planning.knfood.Model.Cart;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class ConfirmCartActivity extends AppCompatActivity {
    private Toolbar tb;
    private TextView tvSumBill,tvDiscountBill,tvShipBill,tvDoneBill;
    private ArrayList<Cart> dscart = new ArrayList<>();
    private RecyclerView rv_list_confirm_cart;
    private Button btn_confirm_cart_xacnhan;
    private SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_cart);
        //custom toolbart
        tvSumBill = findViewById(R.id.tv_sum_bill);
        tvDiscountBill = findViewById(R.id.tv_discount_bill);
        tvShipBill = findViewById(R.id.tv_ship_bill);
        tvDoneBill = findViewById(R.id.tv_bill_done);
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
        db = new SQLiteHelper(getApplicationContext());
        double sum = 0;
        List<Food> foodList = db.getAll();
        for (int i = 0; i < foodList.size(); i++) {
            sum += Double.parseDouble(foodList.get(i).getPrice());
        }
        double doneBill = sum ;
        String temp1 = String.valueOf(sum).substring(0,String.valueOf(sum).length()-2);
        String temp2 = String.valueOf(doneBill).substring(0,String.valueOf(doneBill).length()-2);
        tvSumBill.setText(temp1);

        tvDoneBill.setText(temp2);
        ListCartAdapter adapter = new ListCartAdapter(db.getAll());
        rv_list_confirm_cart.setLayoutManager(new LinearLayoutManager(this));
        rv_list_confirm_cart.setAdapter(adapter);
       // adapter.setOnItemClickListener(onItemClickListener);
//        Cart cart = new Cart("acb",287.987,"Combo gà rán 2 người + nước Size Vừa - \n"
//                ,4);
//        Cart cart2 = new Cart("acb",287.987,"Combo gà rán 3 người + nước Size Vừa \n"
//                ,5);
//        Cart cart3 = new Cart("acb",287.987,"Combo gà rán 4 người + nước Size Vừa - \n"
//                ,12);
//        Cart cart4 = new Cart("acb",287.987,"Combo gà rán 2 người + nước Size Vừa \n"
//                ,4);
//        dscart.add(cart); dscart.add(cart2); dscart.add(cart3); dscart.add(cart4);
       // ConfirmCartAdapter adapter = new ConfirmCartAdapter(dscart);
        //rv_list_confirm_cart.setLayoutManager(new LinearLayoutManager(this));
       // rv_list_confirm_cart.setAdapter(adapter);
        // Chuyển đến màn lịch sử hóa đơn
        btn_confirm_cart_xacnhan=findViewById(R.id.btn_cart_dathang);
        btn_confirm_cart_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < db.getAll().size(); i++) {
                    Food foodTemp =db.getAll().get(i);
                    Food foodUpdate = new Food(foodTemp.getfName(),foodTemp.getNote(),foodTemp.getPrice(),
                            CommonUtils.getInstance().convertDateToString(), "Đã thanh toán");
                    db.delete(foodTemp.getId());
                    db.addFood(foodUpdate);
                }
                startActivity(new Intent(v.getContext(), HistoryBillActivity.class));
            }
        });
        // Chuyển đến màn lịch sử hóa đơn
    }

}
