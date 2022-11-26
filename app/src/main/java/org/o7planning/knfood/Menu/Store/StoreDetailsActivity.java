package org.o7planning.knfood.Menu.Store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.o7planning.knfood.Adapter.StoreDetailsAdapter;
import org.o7planning.knfood.CommonUtils;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.Model.Store;
import org.o7planning.knfood.R;
import org.o7planning.knfood.SQLite.SQLiteHelper;

import java.util.ArrayList;

import static org.o7planning.knfood.Menu.Store.ListStoreActivity.store_content;
import static org.o7planning.knfood.Menu.Store.ListStoreActivity.store_rating;
import static org.o7planning.knfood.Menu.Store.ListStoreActivity.store_time;
import static org.o7planning.knfood.Menu.Store.ListStoreActivity.store_title;

public class StoreDetailsActivity extends AppCompatActivity implements StoreDetailsAdapter.OnItemClick{
    private Toolbar tb;
    private TextView tv_title, tv_content, tv_time, tv_rating;
    private RecyclerView rv_list_store_food;
    private ArrayList<Food> dsfood = new ArrayList<>();
    // click sự kiện trên list food
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
            int position = viewHolder.getLayoutPosition();
            Food fTemp = dsfood.get(position);
            SQLiteHelper db = new SQLiteHelper(getApplicationContext());
            Food food = new Food(fTemp.getfName(),fTemp.getNote(), fTemp.getPrice());
            db.addFood(food);
            Log.i("KMFG", "onClick: "+food.toString());
            Toast.makeText(StoreDetailsActivity.this, "Đã thêm món", Toast.LENGTH_SHORT).show();
        }
    };
    // click sự kiện trên list food
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        Bundle b = getIntent().getExtras();
//getting the arraylist from the key
        dsfood = (ArrayList<Food>) b.getSerializable("foods");

        //custom toolbar
        tb=findViewById(R.id.tb_store_details);
        tb.setTitle(store_title+"");
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ListStoreActivity.class));
            }
        });
        //custom toolbar
        tv_title= findViewById(R.id.tv_store_details_title);
        tv_content=findViewById(R.id.tv_store_details_content);
        tv_time=findViewById(R.id.tv_store_details_time);
        tv_rating=findViewById(R.id.tv_store_details_rating);
        //store_title,store_content,store_time,store_rating
        tv_title.setText(store_title);
        tv_content.setText(store_content);
        tv_rating.setText(store_rating);
        tv_time.setText(store_time);
        // list store food
        rv_list_store_food = findViewById(R.id.rv_list_store_food);
//        Food fd = new Food("Phần gà rán gia đình - dành cho \n" +
//                "4 người",29.000,118.800,"abc");
//        Food fd2= new Food("Gà rán phô mai",79.000,288.800,"abc");
//        Food fd3= new Food("Gà rán đi bộ",29.000,88.800,"abc");
//        Food fd4 = new Food("Phần gà rán gia đình - dành cho \n" +
//                "4 người",29.000,118.800,"abc");
//        Food fd5= new Food("Gà rán phô mai",79.000,288.800,"abc");
//        Food fd6= new Food("Gà rán đi bộ",29.000,88.800,"abc");
     //   dsfood.add(fd); dsfood.add(fd2); dsfood.add(fd3); dsfood.add(fd4); dsfood.add(fd5); dsfood.add(fd6);
        StoreDetailsAdapter adapter = new StoreDetailsAdapter(dsfood);
        rv_list_store_food.setLayoutManager(new LinearLayoutManager(this));
        rv_list_store_food.setAdapter(adapter);
        adapter.setOnItemClick(this);
       // adapter.setOnItemClickListener(onItemClickListener);




    }

    @Override
    public void onItemClick(Food data) {
        SQLiteHelper db = new SQLiteHelper(getApplicationContext());
        Food food = new Food(data.getfName(),data.getNote(), data.getPrice(),
                            CommonUtils.getInstance().convertDateToString(),"Đang chờ xác nhận");
        db.addFood(food);
        Toast.makeText(StoreDetailsActivity.this, "Đã thêm món", Toast.LENGTH_SHORT).show();
    }
}
