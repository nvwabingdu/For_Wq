package com.example.myapplication.zqr.chapter99.pak1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-21
 * Time: 14:29
 */
@Module
public class PersonModule {
    //--------------------------------Named
    @Provides
    @Named("Child")
    public Person provides(){
        return new Child();
    }

    @Provides
    @Named("Girl")
    public Person provides1(){
        return new Girl();
    }
//
//    public class Home {
//        private com.example.myapplication.zqr.chapter99.pak1.Child child;
//
//        @Inject
//        public Home(@Named("Child") com.example.myapplication.zqr.chapter99.pak1.Child child){
//            this.child=child;
//        }
//
//        public String walk(){
//            return child.walk();
//        }
//
//
//    }


    //------------------------------------------Qualifier
    //标记在注解上
    //1.
//    @Qualifier
//    @Retention(RetentionPolicy.RUNTIME)
//    public @interface Child{
//    }
//
//    @Qualifier
//    @Retention(RetentionPolicy.RUNTIME)
//    public @interface Girl{
//    }
//
//    //2.
//    @Module
//    public class  ChildModule{
//        @Provides
//        @Child
//        public Person providesChild(){
//            return new com.example.myapplication.zqr.chapter99.pak1.Child();
//        }
//        @Provides
//        @Child
//        public Person providesGirl(){
//            return new com.example.myapplication.zqr.chapter99.pak1.Girl();
//        }
//
//    }
//
//    public class Home2 {
//        private com.example.myapplication.zqr.chapter99.pak1.Child child;
//
//        @Inject
//        public Home2(@Child com.example.myapplication.zqr.chapter99.pak1.Child child){
//            this.child=child;
//        }
//
//        public String walk(){
//            return child.walk();
//        }
//    }



}
