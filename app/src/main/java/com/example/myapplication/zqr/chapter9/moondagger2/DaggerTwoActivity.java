package com.example.myapplication.zqr.chapter9.moondagger2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.zqr.chapter9.moondagger2.model.Car;
import com.example.myapplication.zqr.chapter9.moondagger2.model.Man;
import com.example.myapplication.zqr.chapter9.moondagger2.model.Watch;
import com.google.gson.Gson;


import javax.inject.Inject;

public class DaggerTwoActivity extends AppCompatActivity {
    private static final String TAG="Dagger2";
    private Button bt_jump;
    @Inject
    Watch watch;
    @Inject
    Gson gson;
    @Inject
    Gson gson1;
    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
//        DaggerActivityComponent.builder().build().inject(this);
        App.get(DaggerTwoActivity.this).getActivityComponent().inject(this);
        onClick();
        watch.work();
        String jsonData = "{'name':'zhangwuji', 'age':20}";
        Man man = gson.fromJson(jsonData, Man.class);
        Log.d(TAG, "name---" + man.getName());
        String str = car.run();
        Log.d(TAG, "car---" + str);
        Log.d(TAG, gson.hashCode() + "---------" + gson1.hashCode());

    }

    private void onClick() {
        bt_jump = (Button) findViewById(R.id.bt_jump);
        bt_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaggerTwoActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

//    dagger // dagger包下大多是核心注解
//├── Binds.class // 注解@Module中的抽象方法，主要场景是@Inject注解构造函数+有继承关系的对象上
//├── BindsInstance.class // 注解@Component.Builder中的方法，用于绑定某个实例以提供数据依赖
//├── BindsOptionalOf.class // 需要结合JDK 1.8中的Optional类使用，用于某个对象可空的情景上，在kotlin中实在鸡肋
//├── Component$Builder.class // 用于自定义Component的Builder对象
//├── Component.class // dagger核心注解之一，用于定义一个桥接类，其中有modules和dependencies两个属性，分别指定依赖的数据仓库 和 依赖的其他桥接类
//├── Component$Factory.class // 与Component$Builder作用一样，dagger2.22引入，目前不常用
//├── internal // internal包中是一些辅助类，常用于dagger生成的代码中（此包中的内容有所省略，挑重点总结）
//│   ├── DoubleCheck.class // 提供了provider()和lazy()两个静态方法，分别用于实现局部单例和dagger.Lazy懒加载数据上
//│   ├── MapBuilder.class // 用于辅助@IntoMap等构建Map容器，最终生成的是一个不可修改的Map容器
//│   ├── SetBuilder.class // 用于辅助@IntoSet等构建Set容器，最终生成的是一个不可修改的Set容器
//├── Lazy.class // dagger.Lazy对象，用于dagger注入懒加载对象
//├── MapKey.class // 用于辅助Map注入的自定义Key的注解
//├── MembersInjector.class // 注入器的接口
//├── Module.class // dagger核心注解之一，用于定义一个数据仓库，其中有includes和subcomponents两个属性，分别指定对其他数据仓库的简单组合 和 对@Subcomponent桥接类的依赖
//├── multibindings // multibindings包下是一些有关与dagger的multibing特性的东西
//│   ├── ClassKey.class // 用于辅助@IntoMap，指定Map容器的Key类型
//│   ├── ElementsIntoSet.class // 用于辅助Set注入，可以将一个已有的Set注入到最终的Set中
//│   ├── IntKey.class // 用于辅助@IntoMap，指定Map容器的Key类型
//│   ├── IntoMap.class // 用于辅助@IntoMap，指定Map容器的Key类型
//│   ├── IntoSet.class // 用于辅助@IntoMap，指定Map容器的Key类型
//│   ├── LongKey.class // 用于辅助@IntoMap，指定Map容器的Key类型
//│   ├── Multibinds.class // 用于辅助Set和Map注入，适用在编译器不确定是否有注入元素时，使得可以注入空容器
//│   └── StringKey.class // 用于辅助@IntoMap，指定Map容器的Key类型
//├── Provides.class // dagger核心注解之一，注解@Module中的方法表示此方法可以提供某种类型的数据
//├── Reusable.class // dagger中对@Scope的一个特殊实现，目前处于测试阶段，相较于普通的@Scope，@Reusable不用在@Component上再次声明作用域
//├── Subcomponent$Builder.class // 用于自定义Subcomponent的Builder对象
//├── Subcomponent.class // 用于自定义一个桥接类，此桥接类不能单独使用也不会被dagger单独生成对应Daggerxxx类，需要配合@Module.subcomponent使用
//└── Subcomponent$Factory.class // 与Subcomponent$Builder作用一致

}
