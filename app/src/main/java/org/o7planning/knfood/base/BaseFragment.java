package org.o7planning.knfood.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseFragment<T extends ViewModel> extends Fragment implements View.OnClickListener {
    protected T mModel;
    protected View rootView;
    protected Context mContext;

    @Override
    public final void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        mModel = new ViewModelProvider(this).get(getClassViewModel());
        initViews();
        return rootView;
    }

    protected abstract void initViews();

    protected abstract Class<T> getClassViewModel();

    protected abstract int getLayoutId();

    public final <T extends View> T findViewById(int id, View.OnClickListener event) {
        T v = rootView.findViewById(id);
        if (v != null && event != null) {
            v.setOnClickListener(this);
        }
        return v;
    }

    public final <T extends View> T findViewById(int id) {
        return findViewById(id, null);
    }

    @Override
    public void onClick(View v) {

    }

}
