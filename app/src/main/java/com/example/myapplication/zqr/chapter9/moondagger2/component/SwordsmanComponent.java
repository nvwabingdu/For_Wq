package com.example.myapplication.zqr.chapter9.moondagger2.component;



import com.example.myapplication.zqr.chapter9.moondagger2.model.Swordsman;
import com.example.myapplication.zqr.chapter9.moondagger2.module.SwordsmanModule;

import dagger.Component;


/**
 * Created by Administrator on 2016/12/21 0021.
 */
@Component(modules = SwordsmanModule.class)
public interface SwordsmanComponent {
    Swordsman getSwordsman();
}
