package org.o7planning.knfood.Ticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.Model.Voucher;
import org.o7planning.knfood.R;

import java.util.ArrayList;

public class VoucherDetails extends AppCompatActivity {
   private Toolbar tb;
   private TextView tv_ticket_details_title,tv_voucher_time_detail;
   private Voucher voucher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_details);
        //custom toolbar
        Bundle b = getIntent().getExtras();
//getting the arraylist from the key
        voucher = (Voucher) b.getSerializable("voucher");

        tb=findViewById(R.id.toolbar_ticket_details);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VoucherDetails.this, VoucherActivity.class));
            }
        });
        tb.setTitle(voucher.getTitle()+"");
        //custom toolbar
        tv_ticket_details_title=findViewById(R.id.tv_ticket_details_title);
        tv_voucher_time_detail=findViewById(R.id.tv_voucher_time_detail);
        tv_ticket_details_title.setText(voucher.getTitle());
        tv_voucher_time_detail.setText(voucher.getTime());
    }
}
