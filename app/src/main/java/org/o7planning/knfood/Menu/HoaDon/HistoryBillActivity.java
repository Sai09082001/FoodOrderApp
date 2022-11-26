package org.o7planning.knfood.Menu.HoaDon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.o7planning.knfood.Adapter.BillAdapter;
import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.Model.Bill;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;

import java.util.ArrayList;

public class HistoryBillActivity extends AppCompatActivity {
    private Toolbar tb;
    private RecyclerView rv_list_hoadon;
    private SQLiteHelper db;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
        int position = viewHolder.getAdapterPosition();
        startActivity(new Intent(HistoryBillActivity.this,HoaDonChiTiet.class));
      }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoa_don);
        //custom toolbar
        tb=findViewById(R.id.tb_lichsu_hoadon);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MenuActivity.class));
            }
        });
        db = new SQLiteHelper(this);
        // list hoa đơn
        rv_list_hoadon=findViewById(R.id.rv_list_hoadon);
//        Bill b1 = new Bill("19/10/2022 - 03:37","Gà rán KFC, Nguyễn Văn Cừ","19 thg 10, 03:37","237.000","Đã thanh toán",4.8);
//        Bill b2 = new Bill("19/10/2022 - 10:12","Gà rán KFC, Nguyễn Văn Cừ","19 thg 10, 02:17","135.000","Đã thanh toán",4.2);
//        Bill b3 = new Bill("19/10/2022 - 02:14","Gà rán KFC, Nguyễn Văn Cừ","19 thg 10, 01:34","65.000","Đã thanh toán",2.2);
//        dsBill.add(b1); dsBill.add(b2); dsBill.add(b3);
        BillAdapter adapter = new BillAdapter(db.getAll());
        rv_list_hoadon.setLayoutManager(new LinearLayoutManager(this));
        rv_list_hoadon.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);

    }
}
