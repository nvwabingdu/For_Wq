package com.example.myapplication.zqr.chapter2.myrecyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.android.webviewsss.WebActivity;
import com.example.myapplication.zqr.chapter1.mooncoordinatorlayout.CollapsingToolbarActivity;
import com.example.myapplication.zqr.chapter1.mooncoordinatorlayout.CoordinatorLayoutActivity;
import com.example.myapplication.zqr.chapter1.moondesignsupportlibrary.ShowSnackActivity;
import com.example.myapplication.zqr.chapter1.moondesignsupportlibrary.TextInputLayoutActivity;
import com.example.myapplication.zqr.chapter3.mooncustomgroup.CostGrouppActivity;
import com.example.myapplication.zqr.chapter3.mooncustomview.InvaldTextActivity;
import com.example.myapplication.zqr.chapter3.mooncustomviewgroup.CosTomMyActivity;
import com.example.myapplication.zqr.chapter3.moonviewslide.ViewslideActivity;
import com.example.myapplication.zqr.chapter4.MyAsyncTaskActivity;
import com.example.myapplication.zqr.chapter5.moonokhttp3.OkHttpActivity;
import com.example.myapplication.zqr.chapter5.moonretrofit.MyRetrofitActivity;
import com.example.myapplication.zqr.chapter5.moonvolley.MyVolleyActivity;
import com.example.myapplication.zqr.chapter7.mooneventbus.OneEventBusActivity;
import com.example.myapplication.zqr.chapter8.moonrxjava.RxMainActivity;
import com.example.myapplication.zqr.chapter8.moonrxjava.OneActivity;
import com.example.myapplication.zqr.chapter9.moonbutterknife.ButterKnifeActivity;
import com.example.myapplication.zqr.moonpermissions.PermissonsActivity;
import com.example.myapplication.zqr.chapter2.moontoolbar.ToolbarActivity;
import com.example.myapplication.zqr.chapter2.mycardview.CardViewActivity;
import com.example.myapplication.zqr.chapter2.mynotification.MyNotificationActivity;
import com.example.myapplication.zqr.chapter2.mytablayout.TablayoutActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<String> mList;
    private  HomeAdapter mHomeAdaper;
    private RecyclerView mRecyclerView;
    private StaggeredHomeAdapter mStaggeredHomeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initData();
        initView();

    }

    private void initData() {
        mList=new ArrayList<String>();

        mList.add("CardViewActivity");
        mList.add("MyNotificationActivity");
        mList.add("ToolbarActivity");
        mList.add("PermissonsActivity");
        mList.add("CoordinatorLayoutActivity");
        mList.add("CollapsingToolbarActivity");
        mList.add("ShowSnackActivity");
        mList.add("TextInputLayoutActivity");
        mList.add("TablayoutActivity");
        mList.add("ViewslideActivity");
        mList.add("CosTomMyActivity");
        mList.add("InvaldTextActivity");
        mList.add("CostGrouppActivity");
        mList.add("MyAsyncTaskActivity");
        mList.add("OkHttpActivity");
        mList.add("MyVolleyActivity");
        mList.add("MyRetrofitActivity");
        mList.add("OneEventBusActivity");
        mList.add("RxMainActivity");
        mList.add("OneActivity");
        mList.add("WebActivity");
        mList.add("ButterKnifeActivity");







    }

    private void initView() {
        mRecyclerView= (RecyclerView) this.findViewById(R.id.id_recyclerview);
        //设置GridView
//        setGridView();
        //设置ListView
        setListView();
         //设置瀑布流
//        setWaterfallView();
    }


    public void setListView(){
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置为横向
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置为竖向
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(RecyclerViewActivity.this, DividerItemDecoration.VERTICAL_LIST));
        //设置item增加和删除的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHomeAdaper=new HomeAdapter(this, mList);
        setLister();
        mRecyclerView.setAdapter(mHomeAdaper);
    }
    public void setGridView(){
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHomeAdaper=new HomeAdapter(this, mList);
        setLister();
        mRecyclerView.setAdapter(mHomeAdaper);
    }
    public void setWaterfallView(){
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mStaggeredHomeAdapter=new StaggeredHomeAdapter(this, mList);
        mRecyclerView.setAdapter(mStaggeredHomeAdapter);
    }
    private void setLister(){
        mHomeAdaper.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "点击第" + (position + 1) + "条", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        sentTO(CardViewActivity.class);
                        break;
                    case 1:
                        sentTO(MyNotificationActivity.class);
                        break;
                    case 2:
                        sentTO(ToolbarActivity.class);
                        break;
                    case 3:
                        sentTO(PermissonsActivity.class);
                        break;
                    case 4:
                        sentTO(CoordinatorLayoutActivity.class);
                        break;
                    case 5:
                        sentTO(CollapsingToolbarActivity.class);
                        break;
                    case 6:
                        sentTO(ShowSnackActivity.class);
                        break;
                    case 7:
                        sentTO(TextInputLayoutActivity.class);
                        break;
                    case 8:
                        sentTO(TablayoutActivity.class);
                        break;
                    case 9:
                        sentTO(ViewslideActivity.class);
                        break;
                    case 10:
                        sentTO(CosTomMyActivity.class);
                        break;
                    case 11:
                        sentTO(InvaldTextActivity.class);
                        break;
                        case 12:
                        sentTO(CostGrouppActivity.class);
                        break;
                    case 13:
                        sentTO(MyAsyncTaskActivity.class);
                        break;
                    case 14:
                        sentTO(OkHttpActivity.class);
                        break;
                        case 15:
                        sentTO(MyVolleyActivity.class);
                        break;
                    case 16:
                        sentTO(MyRetrofitActivity.class);
                        break;
                    case 17:
                        sentTO(OneEventBusActivity.class);
                        break;
                    case 18:
                        sentTO(RxMainActivity.class);
                        break;
                    case 19:
                        sentTO(OneActivity.class);
                        break;
                    case 20:
                        sentTO(WebActivity.class);
                        break;
                    case 21:
                        sentTO(ButterKnifeActivity.class);
                        break;



                }

            }

            @Override
            public void onItemLongClick(View view, final int position) {
                new AlertDialog.Builder(RecyclerViewActivity.this)
                        .setTitle("确认删除吗？")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mHomeAdaper.removeData(position);
                            }
                        })
                        .show();
            }
        });
    }

    void sentTO(Class<?> als){
        startActivity(new Intent(RecyclerViewActivity.this, als));
    }
}

