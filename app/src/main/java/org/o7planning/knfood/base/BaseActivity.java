package org.o7planning.knfood.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseActivity<T extends ViewModel> extends AppCompatActivity implements View.OnClickListener {
    protected T mModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        mModel=new ViewModelProvider(this).get(getClassViewModel());
        initViews();
    }

    protected abstract Class<T> getClassViewModel();

    protected abstract int getLayoutID();

    protected abstract void initViews();

    public final <T extends View> T findViewById(int id,View.OnClickListener event) {
        T v=findViewById(id);
        if(v!=null && event!=null){
            v.setOnClickListener(this);
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        // do something
    }
}
