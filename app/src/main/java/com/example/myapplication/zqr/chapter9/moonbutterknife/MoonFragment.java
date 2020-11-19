package com.example.myapplication.zqr.chapter9.moonbutterknife;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/12/10 0010.
 */

public class MoonFragment extends Fragment {
    @BindView(R.id.tv_toptext)
    TextView tv_toptext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moon, container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_toptext.setText("MoonFragment");
    }
}
