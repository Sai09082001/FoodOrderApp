package org.o7planning.knfood.Menu.Store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.o7planning.knfood.Adapter.ListStoreAdapter;
import org.o7planning.knfood.Function.DatMonAn;
import org.o7planning.knfood.Model.Store;
import org.o7planning.knfood.R;

import java.util.ArrayList;

public class ListStore extends AppCompatActivity {
Toolbar tb;
RecyclerView rv_list_store;
ArrayList<Store> dsStore = new ArrayList<>();
public static String store_title,store_content,store_time,store_rating;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
            int position = viewHolder.getAdapterPosition();
            Store st = dsStore.get(position);
            store_title = st.getTitle();
            store_content=st.getContent();
            store_time=st.getTime();
            store_rating=st.getRating()+"";
            startActivity(new Intent(v.getContext(),StoreDetails.class));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_store);
        //custom toolbar
        tb=findViewById(R.id.toolbar_store);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DatMonAn.class);
                startActivity(i);
            }
        });
        //custom toolbar
        rv_list_store = findViewById(R.id.rv_list_store);
        Store st = new Store("dsa","Gà rán KFC, Nguyễn Văn Cừ",4.5,"6km(45 phút)","Fast Food, thức ăn trưa, Món Châu Á");
        Store st2 = new Store("dsa","Gà rán KFC, Ba Tháng Hai",3.5,"2km(15 phút)","Fast Food, thức ăn trưa, Món Châu Á");
        Store st3 = new Store("dsa","Gà rán KFC, Ba Tháng Hai",3.5,"2km(15 phút)","Fast Food, thức ăn trưa, Món Châu Á");
        Store st4= new Store("dsa","Gà rán KFC, Nguyễn Văn Cừ",4.5,"6km(45 phút)","Fast Food, thức ăn trưa, Món Châu Á");
        Store st5 = new Store("dsa","Gà rán KFC, Ba Tháng Hai",3.5,"2km(15 phút)","Fast Food, thức ăn trưa, Món Châu Á");
        Store st6 = new Store("dsa","Gà rán KFC, Ba Tháng Hai",3.5,"2km(15 phút)","Fast Food, thức ăn trưa, Món Châu Á");
        dsStore.add(st); dsStore.add(st2); dsStore.add(st3); dsStore.add(st4); dsStore.add(st5); dsStore.add(st6);
        ListStoreAdapter adapter = new ListStoreAdapter(dsStore);
        rv_list_store.setLayoutManager(new LinearLayoutManager(this));
        rv_list_store.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);


    }
}
