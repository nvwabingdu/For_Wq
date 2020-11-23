package com.example.myapplication.zqr.chapter9.moonannotation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myapplication.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;


/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-17
 * Time: 16:35
 */
public class AnnActivity extends AppCompatActivity {
    @BindView(value = R.id.tv_text)
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    标准注解
//    @Override：对覆盖超类中方法进行标记，如果没有覆盖，则编译器会发出错误警告
//    @Deprecated：对不鼓励，或者过时的方法添加注解，当编程时会在编译时显示提示信息
//    @SuppressWarnings()：选择性的取消特定代码片段中的警告
//    @SafeVarargs：JDK7，用来声明使用了可变长度参数的方法，其在与泛型类一起使用时，不会出现类型安全问题。

//    元注解
//    @Target():取值是一个ElementType类型的数组
//        ElementType.TYPE:修饰类，接口，枚举
//        ElementType.FIELD:修饰成员方法
//        ElementType.METHOD:修饰方法
//        ElementType.CONSTRUCTOR:修饰构造方法
//        ElementType.LOCAL_VARIABLE:修饰局部变量
//        ElementType.ANNOTATION_TYPE:修饰注解
//        ElementType.PACKAGE:修饰包
//        ElementType.TYPE_PARAMETER:类型参数申明
//        ElementType.TYPE_USE:使用类型
//    @Inherited：表示注解可以被继承
//    @Documented：表示这个注解应该被javadoc工具记录
//    @Retention():表示不同级别的保留策略。
//        RetentionPolicy.SOURCE:源码级注解，注解信息只会保留在.java源码，源码在编译后，注解信息会被丢弃，不会保留在.class中。
//        RetentionPolicy.CLASS:编译时注解，注解信息只会保留在.java源码以及.class中，运行时java程序时，JVM会丢弃该注解信息，不会保留在JVM
//        RetentionPolicy.RUNTIME:运行时注解，当运行java程序时，JVM也会保留该注解信息，可以通过反射获取该注解信息。
//    @Repeatable()：JDK8新增，允许一个注解在同一个声明类型（类，属性，方法）上多次使用

    //    定义注解
//    1.基本定义
//    定义新的注解类型 用@interface 如下
    private @interface ZqrAnnotation {

    }

    @ZqrAnnotation
    private class ZqrClass {

    }

    //    2.定义成员变量
//    注解只有成员变量，没有方法，
//    注解的成员变量在注解定义中以“无形参的方法”形式来声明，
//    其“方法名"，定义了该成员变量的名字，其返回值定义了该成员变量的的类型  如下
    public @interface ZqrAnnotation2 {
        String name();

        int age();
    }

    private class Test2 {
        @ZqrAnnotation2(name = "zqr", age = 25)
        private void method() {
        }
    }

    //默认的形式
    public @interface ZqrAnnotation3 {
        String name() default "zqr";

        int age() default 25;
    }

    private class Test3 {
        @ZqrAnnotation3
        private void method() {

        }
    }

    //    3.定义运行时注解
//    可以用@retention来设定注解的保留策略，这3个策略的生命周期长度为SOURCE<CLASS<RUNTIME.
//    RetentionPolicy.RUNTIME :如果需要在运行时动态获取注解信息
//    RetentionPolicy.CLASS:如果需要编译时进行一些预处理操作，比如生成一些辅助代码
//    RetentionPolicy.Source:只是做一些检查性的操作，比如@Override,@SupperessWarning
//    当设定为RetentionPolicy.RUNTIME时，这个注解就是运行时注解。如下

    @Retention(RetentionPolicy.RUNTIME)//运行时注解      RetentionPolicy.CLASS==>编译时注解
    public @interface ZqrRunAnnotation {
        String name() default "zqr";
        int age() default 25;
    }
    class Test4 {
        @ZqrRunAnnotation()
        private void method() {

        }
    }

//    注解处理器




}
