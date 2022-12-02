package org.o7planning.knfood.Ticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.o7planning.knfood.Adapter.VoucherAdapter;
import org.o7planning.knfood.CommonUtils;
import org.o7planning.knfood.Menu.MenuActivity;
import org.o7planning.knfood.Menu.Store.StoreDetailsActivity;
import org.o7planning.knfood.Model.Voucher;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;

import java.io.Serializable;
import java.util.ArrayList;

public class VoucherActivity extends AppCompatActivity implements VoucherAdapter.OnItemClick {
    private Toolbar tb;
    private SQLiteHelper db;
    private RecyclerView rcvVoucher;

//    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
//            int position = viewHolder.getAdapterPosition();
//            Voucher voucher = dsticket.get(position);
//            ticketdetails = voucher.getTitle();
//
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list);
        db = new SQLiteHelper(this);
        //custom toolbar
        tb=findViewById(R.id.toolbar_ticket);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MenuActivity.class);
                startActivity(i);
            }
        });
        //custom toolbar
        //List ticket
        rcvVoucher=findViewById(R.id.rcv_voucher);
        //dsticket = new ArrayList<>();
        VoucherAdapter adapter = new VoucherAdapter(db.getVoucherAll());
        rcvVoucher.setLayoutManager(new LinearLayoutManager(this));
        rcvVoucher.setAdapter(adapter);
        adapter.setOnItemClick(this);
        //List ticket



    }

    @Override
    public void onItemClick(Voucher data) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("voucher", data);
        Intent i = new Intent(this, VoucherDetails.class);
        i.putExtras(bundle);
        startActivity(i);
    }
}
