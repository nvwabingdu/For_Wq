package com.example.myapplication.zqr.chapter8.moonrxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-17
 * Time: 11:46
 * rxjava常用操作符
 */
public class RxOperatorsActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*--------------------创建操作符*/
        // repeat();
        // range();
        // interval();
        /*---------------------变换操作符*/
        //map();
        //flatMap();
        //concatMap();
        //flatMapIterable();
        //buffer();
        //groupBy();
        /*----------------------过滤操作符*/
        //filter();
        //elementAt();
        //distinct();
        //skip();
        //take();
        //ignoreElements();
        //throttleFirst();
        //throttleWithTimeOut();
        /*-----------------------组合操作符*/
        //startWith();
        //merge();
        //concat();
        //zip();
        //combineLastest();
        /*------------------------条件和布尔操作符*/
        //all();
        //contains();
        //isEmpty();
        //amb();
        //defaultIfEmpty();
        /*-------------------------转换操作符*/
        //toList();
        //toMap();
        //toSortedList();
        /*-------------------------错误操作符*/
        //onErrorReturn();
        //retry();
        /*-------------------------辅助操作符*/
        //delay();
        //doOnNext();
        //subscribeOn();
        //timeout();
        /*============================RxJava的线程控制=======================*/
        /*
        * 内置的Scheduler
        * 如果不指定，默认是调用subscribe方法的线程上进行回调的，如果我们想切换线程，据需要用Scheduler
        *
        *Schedulers.immediate():直接在当前线程运行，是timeout，是timeInterval  timestamp操作符的默认调度器
        *
        *Schedulers.newThread():总是启用新线程，并在新线程执行
        *
        * Schedulers.io():io操作（读写文件，读写数据库，网络信息交互）和上面差不多，主要内部用了线程池。
        *
        * Schedulers.computation():计算用，如图形计算，线程池固定。大小为CPU核数，buffer，debounce,
        * delay,interval,sample,skip.的默认调度
        *
        * Schedulers.trampoline():当我们想在当前线程执行一个任务时，并不是立即时，可以用.trampoline()将它加入队，
        * 这个调度器将会处理它的队列并且按序运行队列中的每一个任务。是repeat和retry操作符的默认调度器。
        *
        * */

    }

    //-----------------------------------------------------------创建操作符
    /**
     * 创建一个N次重复发射的特定数据的Observable,如下
     */
    private void repeat() {
        Observable.range(0, 3)
                .repeat(2)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "repeat:" + integer.intValue());
                    }
                });
    }
    /**
     * 创建发射指定范围的整数序列的Observable,可以拿来替换for循环，发射一个范围内的有序整数序列，第一个参数是起始值，并且不小于0，
     * 第二个参数为整数序列的个数。
     */
    private void range() {
        Observable.range(0, 5)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "range:" + integer.intValue());
                    }
                });
    }
    /**
     * 创建一个按时间间隔发射整数序列的Observable，相当于定时器，如下
     */
    private void interval() {
        Observable.interval(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long mlong) {
                        Log.d(TAG, "interval:" + mlong.intValue());
                    }
                });
    }

    //-------------------------------------------------------------变换操作符
    /**
     * 变换操作符-----groupBy
     * 用于分组元素，将源Observable变换成一个发射Observable的新Observable（分组后的），
     * 他们中的每一个新的Observable都发射一组特定的数据
     */
    private void groupBy() {
        Swordsman s1 = new Swordsman("韦一笑", "A");
        Swordsman s2 = new Swordsman("张三丰", "SS");
        Swordsman s3 = new Swordsman("周芷若", "S");
        Swordsman s4 = new Swordsman("宋远桥", "S");
        Swordsman s5 = new Swordsman("殷梨亭", "A");
        Swordsman s6 = new Swordsman("张无忌", "SS");
        Swordsman s7 = new Swordsman("鹤笔翁", "S");
        Swordsman s8 = new Swordsman("宋青书", "A");

        Observable<GroupedObservable<String, Swordsman>> GroupedObservable = Observable.just(s1, s2, s3, s4, s5, s6, s7, s8)
                .groupBy(new Func1<Swordsman, String>() {
                    @Override
                    public String call(Swordsman swordsman) {
                        return swordsman.getLevel();
                    }
                });
        Observable.concat(GroupedObservable).subscribe(new Action1<Swordsman>() {
            @Override
            public void call(Swordsman swordsman) {
                Log.d(TAG, "groupBy:" + swordsman.getName() + "---" + swordsman.getLevel());
            }
        });


    }
    /**
     * 变换操作符-----buffer
     * 将源Observable变换成一个新的Observable，这个新的Observable每次发射一组列表值而不是一个一个发射。
     * （类似的还有window操作符，只不过window操作符发射的是Observable而不是数据列表）
     */
    private void buffer() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .buffer(3)//缓存容量为3
                .subscribe(new Action1<List<Integer>>() {
                    @Override
                    public void call(List<Integer> integers) {
                        for (Integer i : integers) {
                            Log.d(TAG, "buffer:" + i);
                        }
                        Log.d(TAG, "-----------------");
                    }
                });
    }
    /**
     * 变换操作符-----flatMapIterable
     * 将数据包装成Iterable，然后就可以操作了
     */
    private void flatMapIterable() {
        Observable.just(1, 2, 3).flatMapIterable(new Func1<Integer, Iterable<Integer>>() {
            @Override
            public Iterable<Integer> call(Integer s) {
                List<Integer> mlist = new ArrayList<Integer>();
                mlist.add(s + 1);
                return mlist;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "flatMapIterable:" + integer);
            }
        });
    }
    /**
     * 组合操作符-----concatMap
     * 将多个Observable发射的数据进行合并发射，concat严格按照顺序发射数据，前一个Observable没发射完成，不会发射后一个的
     */
    private void concatMap() {
        final String Host = "http://blog.csdn.net/";
        List<String> mlist = new ArrayList<>();
        mlist.add("itachi85");
        mlist.add("itachi86");
        mlist.add("itachi87");
        mlist.add("itachi88");
        Observable.from(mlist).concatMap(new Func1<String, Observable<?>>() {
            @Override
            public Observable<?> call(String s) {
                return Observable.just(Host + s);
            }
        }).cast(String.class).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "concatMap:" + s);
            }
        });
    }
    /**
     * 变换操作符-----flatmap
     * flatMap操作符将Observable发射的数据集合 变换为Observable集合，然后将这些发射的数据平坦化的放进一个单独的Observable。
     * <p>
     * cast操作符的作用是强制将Observable发射的所有数据转换为指定类型，
     * （flatmap允许交错，也就是说最后的顺序有可能不是原始数据顺序，有坑）
     */
    private void flatMap() {
        final String Host = "http://blog.csdn.net/";
        List<String> mlist = new ArrayList<>();
        mlist.add("itachi85");
        mlist.add("itachi86");
        mlist.add("itachi87");
        mlist.add("itachi88");
        Observable.from(mlist).flatMap(new Func1<String, Observable<?>>() {
            @Override
            public Observable<?> call(String s) {

                return Observable.just(Host + s);
            }
        }).cast(String.class).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

                Log.d(TAG, "flatMap:" + s);
            }
        });
    }
    /**
     * 变换操作符-----map
     * 通过指定一个Func对象，将Observable转换成一个新的Obseervable对象并发射，观察者将收到新的Observable进行处理。（如访问网络）
     */
    private void map() {
        final String Host = "http://blog.csdn.net/";
        Observable.just("itachi85").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return Host + s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "map:" + s);
            }
        });
        //结果为  http://blog.csdn.net/itachi85
    }

    //--------------------------------------------------------------过滤操作符
    /**
     * 过滤操作符----------throttleWithTimeOut
     * <p>
     * 通过时间来限流，源Observable每次发射出一个数据就会开始计时，如果设定为300ms,那么在300ms内的数据会被扔弃，同时开始重新计时。
     * <p>
     * 每隔100ms发射一个数据，当发射的数据是3的倍数的时候，下一个数据就延迟到300ms，这里设置过滤时间为200ms，
     * 也就说发射间隔小于200的将会被过滤掉
     */
    private void throttleWithTimeOut() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 10; i++) {
                    subscriber.onNext(i);
                    int sleep = 100;
                    if (i % 3 == 0) {
                        sleep = 300;
                    }
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }

        }).throttleWithTimeout(200, TimeUnit.MILLISECONDS).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "throttleWithTimeOut:" + integer);
            }
        });
    }
    /**
     * 过滤操作符----------会定期发射这个时间段里源Observable发射的第一个数据，默认在computation调度器上执行。
     * <p>
     * 每隔100ms发射一个数据，操作符设定的时间为200ms,因此会发射每个200ms内的第一个数据
     */
    private void throttleFirst() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 10; i++) {
                    subscriber.onNext(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        }).throttleFirst(200, TimeUnit.MILLISECONDS).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "throttleFirst:" + integer);
            }
        });

        //0 2  4 6 8  10
    }
    /**
     * 过滤操作符----------ignoreElements
     * <p>
     * 忽略所有源Observable产生的结果，只返回ONerror  Oncompleted 通知订阅者
     */
    private void ignoreElements() {
        Observable.just(1, 2, 3, 4).ignoreElements().subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.i("wangshu", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("wangshu", "onError");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i("wangshu", "onNext");
            }
        });
    }
    /**
     * 过滤操作符----------take
     * 只取前N项   (takelast  从后面)
     */
    private void take() {
        Observable.just(1, 2, 3, 4, 5, 6).take(2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "take:" + integer);
            }
        });
        //12
    }
    /**
     * 过滤操作符----------skip
     * 过滤前N项   (skiplast   从后面)
     */
    private void skip() {
        Observable.just(1, 2, 3, 4, 5, 6).skip(2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "skip:" + integer);
            }
        });
        //3456
    }
    /**
     * 过滤操作符----------distinct
     * <p>
     * 去重，只允许没有发射过的数据通过     （类似的有，distinctUntilChanged(),去掉连续重复的数据）
     */
    private void distinct() {
        Observable.just(1, 2, 2, 3, 4, 1).distinct().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "distinct:" + integer);
            }
        });
    }
    /**
     * 过滤操作符----------elementAt
     * 返回指定位置的数据   （类似还有elementAtOrDefault(int,T)其可以允许默认值）
     */
    private void elementAt() {
        Observable.just(1, 2, 3, 4).elementAt(2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "elementAt:" + integer);
            }
        });
    }
    /**
     * 过滤操作符----------filter
     * 对源Observable产生的结果进行自定义规则的过滤，只有满足条件的结果才会提交给订阅者
     */
    private void filter() {
        Observable.just(1, 2, 3, 4).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 2;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "filter:" + integer);
            }
        });
    }

    //--------------------------------------------------------------组合操作符
    /**
     * 组合操作符--------------combineLastest
     * 将多个Observable发射的数据组装起来然后在发射. 通过Func类来组装多个Observable发射的数据,
     * 等到最后一个Observable发射数据了, 然后把所有发射的数据交给Fun进行组合, 然后把组合后的数据发射出去.
     * <p>
     * 笔者解释：当两个Observable中的任何一个发射率了数据时，使用函数结合每个Observable发射的最近数据项，
     * 并且基于这个函数的结果发射数据。
     */
    private void combineLastest() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3);
        Observable<String> obs2 = Observable.just("a", "b", "c");
        Observable.combineLatest(obs1, obs2, new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return integer + s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "combineLastest:" + s);
            }
        });
        //3a   3b  3c
    }
    /**
     * 组合操作符--------------zip
     * <p>
     * 合并多个Observable发射出来的数据项，根据指定的函数变换他们，并发射一个新值
     */
    private void zip() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3);
        Observable<String> obs2 = Observable.just("a", "b", "c");
        Observable.zip(obs1, obs2, new Func2<Integer, String, String>() {

            @Override
            public String call(Integer integer, String s) {
                return integer + s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "zip:" + s);
            }
        });
        // 1a  2b  3c
    }
    /**
     * 组合操作符--------------concat
     * <p>
     * 将多个数据进行合并发射，并严格按照顺序
     */
    private void concat() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
        Observable<Integer> obs2 = Observable.just(4, 5, 6);
        Observable.concat(obs1, obs2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "concat:" + integer);
            }
        });
    }
    /**
     * 组合操作符--------------merge
     * <p>
     * 将多个Observable合并到一个Observable进行发射，可能会让合并的Observable交错
     */
    private void merge() {
        Observable<Integer> obs1 = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
        Observable<Integer> obs2 = Observable.just(4, 5, 6);
        Observable.merge(obs1, obs2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "merge:" + integer);
            }
        });
    }
    /**
     * 组合操作符--------------startWith
     * <p>
     * 在源Observable发射的数据前面插入一些数据
     */
    private void startWith() {
        Observable.just(3, 4, 5).startWith(1, 2)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "startWith:" + integer);
                    }
                });
    }

    //--------------------------------------------------------------条件操作符
    /**
     * 条件操作符--------------defaultIfEmpty
     * <p>
     * 发射来自原始Observable的数据，如果原始Observable没有发射数据，就发射一个默认数据
     * defaultIfEmpty(3)：默认数据3
     */
    private void defaultIfEmpty() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onCompleted();
            }
        }).defaultIfEmpty(3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "defaultIfEmpty:" + integer);
            }
        });
    }
    /**
     * 条件操作符---------amb
     * 对于给定的两个或多个Observable，它只发射首先发射数据或者通知的那个Observable的所有数据
     */
    private void amb() {
        Observable.amb(Observable.just(1, 2, 3).delay(2, TimeUnit.SECONDS), Observable.just(4, 5, 6))
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "amb:" + integer);
                    }
                });
        //第一个延时两秒，所以只会发射第二个
    }
    /**
     * 条件操作符------------------isEmpty
     * 是否发射过这个数据
     */
    private void isEmpty() {
        Observable.just(1, 2, 3).isEmpty().subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                Log.d(TAG, "isEmpty:" + aBoolean);
            }
        });
    }
    /**
     * 条件操作符------------------contains
     * 是否包含此数据
     */
    private void contains() {
        Observable.just(1, 2, 3).contains(1).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                Log.d(TAG, "contains:" + aBoolean);
            }
        });
    }
    /**
     * 条件操作符------------------all
     * 对Observable发射的所有数据用函数进行判断，并返回判断结果。所有数据满足返回true   不满足返回false
     */
    private void all() {
        Observable.just(1, 2, 3)
                .all(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        Log.d(TAG, "call:" + integer);
                        return integer < 2;
                    }
                }).subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError:" + e.getMessage());
            }

            @Override
            public void onNext(Boolean aBoolean) {
                Log.d(TAG, "onNext:" + aBoolean);
            }
        });
    }

    //---------------------------------------------------------------转换操作符
    /**
     * 转换操作符--------------toSortedList
     * 和list差不多，但是会默认升序。不实现compareable，会抛出异常，也可以使用toSortedList(func2)变体，用自定义函数比较
     */
    private void toSortedList() {
        Observable.just(3, 1, 2).toSortedList().subscribe(new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> integers) {
                for (int integer : integers) {
                    Log.i("wangshu", "toSortedList:" + integer);
                }
            }
        });

    }
    /**
     * 转换操作符---------------toMap
     * <p>
     * 收集所有原始Observable发射的所有数据项到一个map,默认HashMap,然后发射
     */
    private void toMap() {
        Swordsman s1 = new Swordsman("韦一笑", "A");
        Swordsman s2 = new Swordsman("张三丰", "SS");
        Swordsman s3 = new Swordsman("周芷若", "S");
        Observable.just(s1, s2, s3).toMap(new Func1<Swordsman, String>() {
            @Override
            public String call(Swordsman swordsman) {
                return swordsman.getLevel();
            }
        }).subscribe(new Action1<Map<String, Swordsman>>() {
            @Override
            public void call(Map<String, Swordsman> stringSwordsmanMap) {
                Log.i("wangshu", "toMap:" + stringSwordsmanMap.get("SS").getName());
            }
        });
    }
    /**
     * 转换操作符-----------------tolist
     * 将发射多项数据，且为每一项数据调用ONnext方法的Observable发射多项数据组合成一个list，然后调用一次OnNext传递整个列表
     */
    private void toList() {
        Observable.just(1, 2, 3).toList().subscribe(new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> integers) {
                for (int integer : integers) {
                    Log.i("wangshu", "toList:" + integer);
                }
            }
        });
    }

    //----------------------------------------------------------------错误操作符
    /**
     * 错误操作符--------------retry
     * 不会OnError，会重新给一次机会发射序列，
     * 示例：retry(2)  表示重复两次
     */
    private void retry() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    if (i == 1) {
                        subscriber.onError(new Throwable("Throwable"));
                    } else {
                        subscriber.onNext(i);//1
                    }
                }
                subscriber.onCompleted();
            }
        }).retry(2).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError:" + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext:" + integer);
            }
        });
        //0 0 0  throwable
    }
    /**
     * 错误操作符-----------onErrorReturn
     * onErrorReturn()：Observable遇到错误时，启用备用Observable。备用的会忽略原有的ONError，不会将错误传递给观察者，
     * 作为替代，会发射一个特殊的项，并调用观察者的onCompleted方法
     * <p>
     * onErrorResumeNext():Observable遇到错误时，启用备用Observable。备用的会忽略原有的ONError，不会将错误传递给观察者，
     * 作为替代，会发射备用Observable的数据。
     * <p>
     * onExceptionResumeNext():和上面类似，但是接收到的不是Exception，还是会调用OnError，也不会启动备用Observable
     */
    private void onErrorReturn() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    if (i > 2) {
                        subscriber.onError(new Throwable("Throwable"));
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).onErrorReturn(new Func1<Throwable, Integer>() {
            @Override
            public Integer call(Throwable throwable) {
                return 6;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError:" + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext:" + integer);
            }
        });
    }

    //-----------------------------------------------------------------辅助操作符
    /**
     * 辅助操作符------------timeout
     * <p>
     * 超时没有发射，会已onError通知，或者执行备用Observable。
     * 下面示例：timeout(200,TimeUnit.MILLISECONDS,Observable.just(10,11))  意思为:超时会切换到备用Observable
     */
    private void timeout() {
        Observable<Integer> obs = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 4; i++) {
                    try {
                        Thread.sleep(i * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).timeout(200, TimeUnit.MILLISECONDS, Observable.just(10, 11));
        obs.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "timeout:" + integer);
            }
        });
    }
    /**
     * 辅助操作符--------------subscribeOn
     * subscribeOn(Schedulers.newThread()) 用于指定自身在那个线程上运行，这里是新建了一个子线程
     * observeOn(AndroidSchedulers.mainThread())  用来指定发射后的数据在那个线程运行，一般就主线程，UI线程，
     */
    private void subscribeOn() {
        Observable<Integer> obs = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                Log.d(TAG, "Observable:" + Thread.currentThread().getName());
                subscriber.onNext(1);
                subscriber.onCompleted();
            }
        });
        obs.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.d(TAG, "Observer:" + Thread.currentThread().getName());
            }
        });
    }
    /**
     * do系列操作符------------------
     * 为原始Observable的生命周期时间注册一个回调，当Observable的某个事件发生时就会调用这些回调
     * doOnNext()：onNext
     * doOnEach():onNext  onCompleted  onError
     * doOnSubscribe():当观察者订阅的时候调用
     * doOnUnsubscribe()：当观察者取消订阅的时候调用，onCompleted  onError之后就会取消所有订阅
     * doOnCompleted()：
     * doOnError()：
     * doOnTerminate()：Observable终止时用，无论正常，异常，都会调用
     * finallyDo()过时，Observable终止时用
     */
    private void doOnNext() {
        Observable.just(1, 2)
                .doOnNext(new Action1<Integer>() {
                    @Override
                    public void call(Integer item) {
                        Log.d(TAG, "call:" + item);

                    }
                }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onNext(Integer item) {
                Log.d(TAG, "onNext:" + item);
            }

            @Override
            public void onError(Throwable error) {
                Log.d(TAG, "Error:" + error.getMessage());
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }
        });

    }
    /**
     * 辅助操作符-------------delay
     * <p>
     * 让原始Observable在发射每项数据之前都暂停一段指定的时间段
     */
    private void delay() {
        Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
                Long currentTime = System.currentTimeMillis() / 1000;
                subscriber.onNext(currentTime);
            }
        }).delay(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Log.d(TAG, "delay:" + (System.currentTimeMillis() / 1000 - aLong));
            }
        });
    }


}
