package org.o7planning.knfood.Menu.Store;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import org.o7planning.knfood.Adapter.ListStoreAdapter;
import org.o7planning.knfood.CommonUtils;
import org.o7planning.knfood.Function.OrderFoodActivity;
import org.o7planning.knfood.Model.Food;
import org.o7planning.knfood.Model.Store;
import org.o7planning.knfood.R;
import org.o7planning.knfood.base.BaseActivity;
import org.o7planning.knfood.viewmodel.ListStoreViewModel;

import java.io.Serializable;
import java.util.ArrayList;

public class ListStoreActivity extends BaseActivity<ListStoreViewModel> {
       private Toolbar tb;
       private RecyclerView rv_list_store;
       private ArrayList<Store> dsStore = new ArrayList<>();
       private ArrayList<Food> listFood = new ArrayList<>();
       public static String store_title,store_content,store_time,store_rating;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
            int position = viewHolder.getLayoutPosition();
            Store st = dsStore.get(position);
            Log.i("KMFG", "onClick: "+position);

            Bundle bundle = new Bundle();
            listFood= CommonUtils.getInstance().convertListFood(CommonUtils.getInstance().getJsonStore(R.raw.store1));
            bundle.putSerializable("foods", (Serializable) listFood);
            Intent i = new Intent(v.getContext(), StoreDetailsActivity.class);
            i.putExtras(bundle);
            store_title = st.getName();
            store_content=st.getContent();
            store_time=st.getTime();
            store_rating=st.getRating()+"";
            startActivity(i);
        }
    };

    @Override
    protected Class<ListStoreViewModel> getClassViewModel() {
        return ListStoreViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_list_store;
    }

    @Override
    protected void initViews() {
      //  Log.i("KMFG", "initViews: "+jsonString);
        initDummyStore();

        tb=findViewById(R.id.toolbar_store);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), OrderFoodActivity.class);
                startActivity(i);
            }
        });
        //custom toolbar
        rv_list_store = findViewById(R.id.rv_list_store);
        ListStoreAdapter adapter = new ListStoreAdapter(dsStore);
        rv_list_store.setLayoutManager(new LinearLayoutManager(this));
        rv_list_store.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
    }

    private void initDummyStore() {
        String jsonString1 = CommonUtils.getInstance().getJsonStore(R.raw.store1);
        String jsonString2 = CommonUtils.getInstance().getJsonStore(R.raw.store2);
        String jsonString3 = CommonUtils.getInstance().getJsonStore(R.raw.store3);
        String jsonString4 = CommonUtils.getInstance().getJsonStore(R.raw.store4);
        String jsonString5 = CommonUtils.getInstance().getJsonStore(R.raw.store5);
        String jsonString6 = CommonUtils.getInstance().getJsonStore(R.raw.store6);
        String jsonString7 = CommonUtils.getInstance().getJsonStore(R.raw.store7);
        String jsonString8 = CommonUtils.getInstance().getJsonStore(R.raw.store8);
        String jsonString9 = CommonUtils.getInstance().getJsonStore(R.raw.store9);
        String jsonString10 = CommonUtils.getInstance().getJsonStore(R.raw.store10);
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString1));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString2));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString3));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString4));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString5));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString6));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString7));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString8));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString9));
        dsStore.add(CommonUtils.getInstance().convertStore(jsonString10));
    }
}
