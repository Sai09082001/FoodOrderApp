package org.o7planning.knfood.Menu;


import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.o7planning.knfood.Adapter.BillAdapter;
import org.o7planning.knfood.Menu.HoaDon.HistoryBillActivity;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;
import org.o7planning.knfood.base.BaseFragment;
import org.o7planning.knfood.viewmodel.BillViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillFragment extends BaseFragment<BillViewModel> {

    private LinearLayout lnNonBill;
    private RecyclerView rcvBillRecent;
    private SQLiteHelper db;
    private TextView tv_lichsuhoadon;
    public BillFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initViews() {
        db = new SQLiteHelper(getContext());
        rcvBillRecent = findViewById(R.id.rcv_history_bill);
        lnNonBill = findViewById(R.id.ln_non_bill);
        tv_lichsuhoadon = findViewById(R.id.btn_lichsuhoadon);
        tv_lichsuhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), HistoryBillActivity.class));
            }
        });
        if (db.getAll().size()==0) {
            rcvBillRecent.setVisibility(View.GONE);
            lnNonBill.setVisibility(View.VISIBLE);
        }else {
            rcvBillRecent.setVisibility(View.VISIBLE);
            lnNonBill.setVisibility(View.GONE);

            // list hoa đơn
            BillAdapter adapter = new BillAdapter(db.getAll());
            rcvBillRecent.setLayoutManager(new LinearLayoutManager(getContext()));
            rcvBillRecent.setAdapter(adapter);
        }
    }

    @Override
    protected Class<BillViewModel> getClassViewModel() {
        return BillViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hoa_don;
    }

}
