package org.o7planning.knfood.Menu.HoaDon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.o7planning.knfood.R;

public class HoaDonChiTiet extends AppCompatActivity {
Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chi_tiet);
        //custom toolbar
        tb=findViewById(R.id.tb_hoadonchitiet);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), HistoryBillActivity.class));
            }
        });
        //custom toolbar

    }
}
