package com.example.myapplication.android;

import android.app.Activity;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.myapplication.android.utils.Tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-10-09
 * Time: 15:34
 */
class MyJava {
    /**
     * java学习篇1------------标志符，数据类型，运算符
     */
    public void indentifier() {
//一.标识符
//    1.标识符由 字母  数字  _  $  组成
//    2.数字不能作为开头，区别大小写，长度没有限制，不能有其他字符，不允许插入空白，不允许占用其他特殊关键字
//    3.java源代码使用的是Unicode（65536）,比ASCII码（255）大的多。

//    4.类名，接口名     HelloWrold   Customer    SortClass
//    5.方法名，变量名   setName      getAdress   balance
//    6.常量   BULE_COLOR      (尽量为大写字母，单词之间用_分隔)   用final标记

//二.数据类型
//    基本数据类型
//    类型  类型    默认值     位数
//    整数  byte   (byte)0  （8位 1字节）  -2^7~2^7-1     (-128~127)
//          short  (short)0 （16位 2字节） -2^15~-2^15-1  (-32768~32767)
//          int(0)   （32位 4字节） -2^31~-2^31-1  (-2147483648~2147483647)
//                                    2(10进制)   077（8进制）  0XBABE（16进制）
//          long(0l)  （64位 8字节） -2^63~-2^63-1  (-9223372036854775808~9223372036854775807)
//                                    2l（10进制长整型）  2L  077L（8进制长整型）   0xBABEL（16进制长整型）

//     浮点数
//                           float(0.0f)   （32位 4字节）  1.4e-45f~3.4028235e+38f
//                                  1.43f  1.343F
//                           double(0.0)  （64位 8字节）  4.9e-324d~1.7976931348623157e+308d
//                                  342.313d    3242.43D      (除非写f,否则默认为double类型)
//                  字符      char('\u0000')(null)  （一个char表示一个Unicode字符）  0-65535
//                                 普通：   'a'    转义字符：  \b 退格    \n换行      \r回车     \t水平制表符（tab）
//                                              转义字符：  \\反斜杠\   \'单引号'   \"双引号"
//                  布尔类型   Boolean  （8位）
//                            （false）

//    复合数据类型    类class    (null)
//                  数组[]  (null)
//                  接口interface  (null)
//                  String  ??

//三.运算符
//          1.算术运算符
//              +（加）     - （减）    *（乘）     /（除）   % （取模）
//                              3%2=1  15.2%5=0.2    5%-3=2   -5%-3=-2   (结果的符号取第一个操作数的符号)
//                              ++  --         i++(在i使用之后+1)   ++i（在i还没有之前就+1）
//          2.关系运算符
//                 >    <    >=   <=     ==   !=
//                               ==   !=  可以运用于任何数据类型
//          3.逻辑运算符
//               逻辑非!
//               &和&&：当且仅当 a、b 都为 true 时，结果为 true ；
//               |和|| ： 当且仅当 a、b 都为 false 时，结果为 false ；
//               ^ : a与b 相异时，结果为 true ；
//               短路与&&     短路或||    都只需要计算左边的就好了
//          4.位运算符
//              关于位运算符无非也就
//              与(&)、  同真为真
//              或(|)、  有真为真
//              异或(^)、真假为真
//              取反(~)、真假互换
//              左移(<<)、  12<<2   12向左移动2位
//              右移(>>)、  12>>2   12向右移动2位
//              无符号右移(>>>)
//          5.其他运算符
//              扩展赋值运算符（+=  -=  *=   /=  %=  |=  ^=  >>=   <<=   >>>= ）
//              条件运算符（?:）也叫三元运算符、三目运算符
//                            逻辑表达式？语句1：语句2；   =====》    Boolean ？true：flase；
//                            z = (x>y)?x:y;//z变量存储的就是两个数的大数
//              点运算符（.）
//              实例运算符（instanceof） 判断是不是某人的儿子
//              new运算符、数组下标运算符（[]）……

//

//
//    知识1：Java位运算是针对于整型（byte、char、short、int、long）数据类型的二进制进行的移位操作。
//    知识2：计算机表示数字正负不是用+ -加减号来表示，而是用最高位数字来表示，0表示正，1表示负 。
//    参考：https://www.cnblogs.com/SunArmy/p/9837348.html
//    参考：https://www.cnblogs.com/yuanhailiang/p/9479105.html
//    运算符的优先级（从高到低）
//    优先级	描述	                 运算符
//    1	括号	            ()、[]
//    2	正负号           +、-
//    3	自增自减，非     	++、--、!
//    4	乘除，取余	    *、/、%
//    5	加减	            +、-
//    6	移位运算	        <<、>>、>>>
//    7	大小关系        	>、>=、<、<=
//    8	相等关系	        ==、!=   、 .equals
//    9	按位与	        &
//    10按位异或	        ^
//    11按位或           |
//    12逻辑与	        &&
//    13逻辑或	        ||
//    14条件运算	        ?:
//    15赋值运算	        =、+=、-=、*=、/=、%=
//    16位赋值运算	    &=、|=、<<=、>>=、>>>=

        //关于位运算
        {
            /* 1 = 0000 0001 */
            /* 60 = 0011 1100 */
            int A = 60;
            int B = 13;
            Log.e("TAG", "A&B=" + (A & B));
            Log.e("TAG", "A&B=" + (A & B));
            Log.e("TAG", "A|B=" + (A | B));
            Log.e("TAG", "~A=" + (~A));
            Log.e("TAG", "A^B=" + (A ^ B));
            Log.e("TAG", "A<<B=" + (A << 2));
            Log.e("TAG", "A>>B=" + (A >> 2));
            Log.e("TAG", "A>>>B=" + (A >>> 2));
//          扩展：
//        场景1：判断奇偶数 a&1 结果为 0 ，a就是偶数 结果为 1 ，a就是奇数
//        场景2：求平均数 （x+y）/2 这样吗？考虑过 x+y可能超过int的范围吗？正确的姿势是 (x&y)+((x^y)>>1)
//        场景3：有两个int类型变量x、y,要求两者数字交换，不用临时变量？(当年学java的时候这可是奥数级别的题目) x ^= y; y ^= x; x ^= y;
//        场景4：求绝对值
//        int abs( int x ) { int y= x >> 31 ; return (x^y)-y ; //or: (x+y)^y }
//        场景5：取模 a % (2^n) 等价于 a & (2^n - 1)
//        场景6：快速乘法 a * (2^n) 等价于 a << n
//        场景7：快速除法 a / (2^n) 等价于 a >> n
//        场景8：求相反数 (~x+1)
        }
    }

    /**
     * java学习篇2------------循环，if，foreach
     */
    private void myIf() throws Exception {
//-----if语句
//        if (true) { } else { }
//-----if else if语句
//        int a = 21;
//        if (a > 1) { } else if (a > 3) { } else if (a > 5) { }
//-----switch 语句
//        int b = 0;
//        switch (b) {
//            case 0,100,300,440,55://特殊写法
//            case 1:
//            case 2:/*你好*/ break;
//            case 3:/*他好*/ break;
//            default:/*大家好*/ break;
//        }
//-------for循环  for(初始语句;条件表达式;迭代器){语句}
//        for (int i = 0; i < 10; i++) {/*10次循环*/}
//        for (int a = 0, b = 0; a < 10; a++, b++) {/*要做什么操作*/}
//-------while (){}语句
//        int c = 10;
//        while (c < 3) {/*你是爱我的*/c++; }

//--------加上do的while循环
//        int d = 0;
//        do {/*我至少执行一次*/} while (d < 2);

//------- foreach语句用法
//        int[] arryA = new int[10];
//        for (int a : arryA) {
//            /*要做什么操作*/
//        }
    }

    /**
     * java学习篇3------------数组Arrays
     */
    private void myArrays() {
        //    一，声明
        int array[] = new int[10];
        int[] array2 = new int[10];
        int array3[];
        int array4[] = {1, 2, 3, 4, 5, 6};
        //   多维数组
        int anInt[][] = new int[1][];
        int[][] anInt2 = new int[0][1];
        int[] anInt3[] = new int[0][];
        //        anInt.length 二维数组也有length属性，但是只表示第一维长度。
        array.equals(array2[1]);
        Arrays.sort(array);//升序
        Arrays.fill(array, 1995);//所有值为1995
        Arrays.binarySearch(array, 3);//二分查找3
        String str = "你是一个大傻逼";
        StringBuffer strB = new StringBuffer().append(9);
        strB.capacity();//String没有此方法   StringBuffer有此方法  返回当前容量  一般来说返回的是当前字符串加上16个字符的内容
        // ==是用于判断两个字符串对象是否是同一实例，即它们在内存中的地址是否相同。
        // 二，数组的赋值
        // 方法一
        array[1] = 1;
        array[2] = 2;
        //方法二
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

    }

    /**
     * java学习篇4------------常用类
     */
    private void frequentlyClass() {

        /*String类:字符串常量，速度最慢*/
        {
            String str = "无名之辈";
        }

        /*StringBuffer类：字符串变量，线程不安全，速度较快*/
        {
            StringBuffer strbuf = new StringBuffer();
            strbuf.append("你好");
        }

        /*StringBuilder：字符串变量，线程安全，速度最快*/
        {
            StringBuilder strbul = new StringBuilder();
        }


        /*math类*/
        {
            Math.abs(21);
        }

        /*Random类*/
        {
            Random random = new Random();
            random.nextInt(10);
            new Random().nextDouble();//简写
        }

        /*Arrays*/
        {
            Arrays.sort(new int[]{21, 21, 12, 3, 43});
            Arrays.binarySearch(new int[]{1, 2, 3, 4}, 2);
        }

        /*Pattern正则类*/
        {
            Pattern p = Pattern.compile("\\d+");//指定正则表达式规则
            Matcher m = p.matcher("22bb23");//返回Matcher类实例
            m.lookingAt();//返回true,因为\d+匹配到了前面的22
            Matcher m2 = p.matcher("aa2223");
            m2.lookingAt();//返回false,因为\d+不能匹配前面的aa
        }
    }

    /**
     * java学习篇5------------IO流
     */
    private void myIoStream() throws Exception {
        // 记住，只要用到缓冲区，就要记得刷新。
        //字节流(8位)
        //1.字节输入流
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        //1.1  构造：（String name）（File file）（FileDescriptor fdObj）
        FileInputStream fileInputStream = new FileInputStream("文件");//文件流
        //1.2  构造：（InputStream in）（InputStream in, int size）
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);//缓冲流
        //1.3  构造：(InputStream in)
        DataInputStream dataInputStream = new DataInputStream(inputStream);//数据流
        //1.4  构造：（InputStream in）
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);//对象流


        //2.字节输出流
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };
        //2.1
        FileOutputStream fileOutputStream = new FileOutputStream("");
        //2.2
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        //2.3
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //2.4
        ObjectOutputStream objectInputStream1 = new ObjectOutputStream(outputStream);


        //字符流(16位Unicode)
        //1.字符写入流
        Reader reader = new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };
        //1.1
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //1.1.1
        FileReader fileReader = new FileReader("");//文件写入流
        //1.2
        BufferedReader bufferedReader = new BufferedReader(reader);

        //2.字符写出流
        Writer writer = new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {

            }

            @Override
            public void flush() throws IOException {

            }

            @Override
            public void close() throws IOException {

            }
        };
        //2.1
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        //2.1.1
        FileWriter fileWriter = new FileWriter("");//文件写出流
        //2.2
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        //实现序列化接口  序列化就是保存对象的值


    }

    /**
     * java学习篇6------------序列化Serializable
     */
    private void mySerializable() {
        //关于序列化：
        //1.Thread线程类/static静态类/成员方法/静态成员变量  都不适用于序列化
        //2.关键字：transient 表示为不用于序列化

        class A implements Serializable {
            transient String name = "";

            void method() {
            }
        }

    }

    /**
     * java学习篇7------------多线程Thread
     */
    private class myThread {
//                       ④阻塞状态
//①新建状态	②就绪状态	③运行状态 	⑤终止状态
//                线程的创建
//        1、继承Thread类
//        Java.lang包中的Thread类，是一个专门用来创建线程的类，该类中提供了线程所用到的属性和方法。我们通过创建该类的子类来实现多线程。
//        1)  子类覆盖父类中的run方法，将线程运行的代码存放在run中。
//        2)  建立子类对象的同时线程也被创建。
//        3)通过调用start方法开启线程。

        //        线程创建的方式
//        1.继承Thread类
        class TestThread extends Thread {
            //run方法
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Tools.showLog("打印" + i + "次");
                }
                try {
                    sleep(500);//线程睡觉
                    wait(1000);//线程等待   和notify  notifyall是一对，先wait 在notify
                    notify();//唤醒某个等待线程
                    notifyAll();//唤醒所有等待线程
                    setPriority(Thread.NORM_PRIORITY);//5
                    join();
                    //t.join();//调用join方法，等待线程t执行完毕
                    // t.join(1000); //等待 t 线程，等待时间是1000毫秒。
                    yield();//强制终止线程  线程的礼让
                    interrupt();//中断线程
                    interrupted();//判断是否被中断，并清除当前中断状态
                    isInterrupted();//判断是否被中断
                    //stop已经过时不再使用，因为用stop会导致数据异常。
                    //interrupt();//为线程设置中断标志，不会立即结束线程
                    int i = 0;
                    while (true) {
                        i++;
                        if (i == 90) {
                            this.interrupt();//设置中断标志
                        }
                        if (this.isInterrupted()) {//是否有中断标记，有的话就结束？？？？  不如直接设置！！！
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //测试和线程的方法
        {
            TestThread testThread = new TestThread();
            try {
                testThread.start();//启动线程
                testThread.getId();
                testThread.getName();
                testThread.getPriority();
                testThread.interrupt();
                testThread.isAlive();//测试当前线程是否在活动
                testThread.setDaemon(true);
                testThread.wait(100);
                testThread.notify();
                testThread.notifyAll();
                testThread.stop();//已经不再使用
                testThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 2.实现Runnable接口
        class Test2Thread implements Runnable {
            int i = 0;

            @Override
            public void run() {
                while (true) {
                    Tools.showLog("打印了" + i + "次");
                }
            }
        }

        //测试方法
        {
            Runnable t2 = new Test2Thread();
            Thread tt2 = new Thread(t2);
            tt2.start();//线程开始
        }

        //3. 实现Callable  好处有返回值   可以抛出异常  可以得到一个Future对象 用于监视线程，但会阻塞 直到得到结果
        class Test3Thread implements Callable {

            @Override
            public Object call() throws Exception {
                return null;
            }

        }

        //测试方法
        {
            Test3Thread callThread = new Test3Thread();
            ExecutorService mExe = Executors.newSingleThreadExecutor();
            Future mfuture = mExe.submit(callThread);

            try {
                mfuture.get();//等待线程结束 并返回结果
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //3.简写方法 匿名内部类
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //具体的操作
                }
            }).start();
            //4.简写方法 lambda表达式
            Runnable runnable = () -> {
                //run方法写在这里？
            };
            runnable.run();
        }

        //synchronized 同步锁  最好用此种写法
        void method11() {
            synchronized (this) {
                //同步方法写在这里
            }
        }

        //synchronized 同步锁   写法2 简写方式
        synchronized void method22() {
        }

        //------------------------线程池

        //创建方式
        {
            Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
            Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
            Executors.newFixedThreadPool(10);    //创建固定容量大小的缓冲池
            Executors.newScheduledThreadPool(2);//创建一个定长线程池，支持定时及周期性任务执行
            Executors.newScheduledThreadPool(2).schedule(new Runnable() {
                @Override
                public void run() {
                    //定时为3秒
                }
            }, 3, TimeUnit.SECONDS);
        }

        {
            //使用方式
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    //run方法
                }
            });
        }

        //简写方式  直接开多线程
        {
            Executors.newCachedThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    //run方法
                }
            });
        }

        //一些说明
        class PoolThread extends ThreadPoolExecutor {
            public PoolThread(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
                super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
            }
           /* corePoolSize：核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，默认情况下，线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，从这2个方法的名字就可以看出，是预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程。默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
            maximumPoolSize：线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；
            keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0；
            unit：参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：
            复制代码
            TimeUnit.DAYS;               //天
            TimeUnit.HOURS;             //小时
            TimeUnit.MINUTES;           //分钟
            TimeUnit.SECONDS;           //秒
            TimeUnit.MILLISECONDS;      //毫秒
            TimeUnit.MICROSECONDS;      //微妙
            TimeUnit.NANOSECONDS;       //纳秒
            复制代码
            workQueue：一个阻塞队列，用来存储等待执行的任务，这个参数的选择也很重要，会对线程池的运行过程产生重大影响，一般来说，这里的阻塞队列有以下几种选择：
            1）ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；
　　        2）LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；
　　        3）synchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。
　　        ArrayBlockingQueue和PriorityBlockingQueue使用较少，一般使用LinkedBlockingQueue和Synchronous。线程池的排队策略与BlockingQueue有关。

            threadFactory：线程工厂，主要用来创建线程；
            handler：表示当拒绝处理任务时的策略，有以下四种取值：
            ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
            ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
            ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
            ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务*/

            volatile int runState;
            static final int RUNNING = 0;
            static final int SHUTDOWN = 1;
            static final int STOP = 2;
            static final int TERMINATED = 3;

            /*runState表示当前线程池的状态，它是一个volatile变量用来保证线程之间的可见性；
              下面的几个static final变量表示runState可能的几个取值。
              当创建线程池后，初始时，线程池处于RUNNING状态；
              如果调用了shutdown()方法，则线程池处于SHUTDOWN状态，此时线程池不能够接受新的任务，它会等待所有任务执行完毕；
              如果调用了shutdownNow()方法，则线程池处于STOP状态，此时线程池不能接受新的任务，并且会去尝试终止正在执行的任务；
              当线程池处于SHUTDOWN或STOP状态，并且所有工作线程已经销毁，任务缓存队列已经清空或执行结束后，线程池被设置为TERMINATED状态。*/

            //某些参数和方法：
            // private final BlockingQueue<Runnable> workQueue;              //任务缓存队列，用来存放等待执行的任务
            private final ReentrantLock mainLock = new ReentrantLock();   //线程池的主要状态锁，对线程池状态（比如线程池大小
            //、runState等）的改变都要使用这个锁
            // private final HashSet<Worker> workers = new HashSet<Worker>();  //用来存放工作集
            private volatile long keepAliveTime;    //线程存活时间
            private volatile boolean allowCoreThreadTimeOut;   //是否允许为核心线程设置存活时间
            private volatile int corePoolSize;     //核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
            private volatile int maximumPoolSize;   //线程池最大能容忍的线程数
            private volatile int poolSize;       //线程池中当前的线程数
            private volatile RejectedExecutionHandler handler; //任务拒绝策略
            private volatile ThreadFactory threadFactory;   //线程工厂，用来创建线程
            private int largestPoolSize;   //用来记录线程池中曾经出现过的最大线程数
            private long completedTaskCount;   //用来记录已经执行完毕的任务个数


        }


        //线程中断   在中断前  先睡10秒  然后中断？？？？
        {
//            Thread thread=new Thread();
//            thread.start();
//            TimeUnit.MICROSECONDS.sleep(1000);//使主线程休眠？？天才
//            thread.interrupt();
        }

//        重入锁  ？？？   支持重进入
{
        Lock mLock=new ReentrantLock();
        mLock.lock();
        try {

        }finally {
           mLock.unlock();
        }


}



    }

    /**
     * java学习篇8------------反射机制Reflection
     */
    private void myReflection() {
//        http://www.cnblogs.com/lzq198754/p/5780331.html
//        反射是在运行中  对于任意一个类  都能够知道这个类的所有属性和方法 对于任意一个对象，都能调用他的任意一个方法和属性
//        为什么用反射？
//        系统里不是所有类都是开放的。
//        使用方法  只用知道包名和类名  而不用实例化。

        //测试类，用于测试反射
        class Demo {
            //放射方法测试
            void reflectionMethod() {
                //不通过new生成对象的方式
                //1.反序列化 2.克隆 3.反射

                //2.1反射的方式
                try {
                    Class<?> reflectUser = Class.forName("aaa.bbb.ccc.User");//此处包名随意的
                    User user2 = (User) reflectUser.newInstance();
                    user2.setAge(22);
                    user2.setName("小王");
                    System.out.println(user2);

                    // 2.2取得本类的全部属性  (import java.lang.reflect.Field;)(import java.lang.reflect.Modifier;)
                    Field[] field = reflectUser.getDeclaredFields();
                    for (Field f : field) {
                        System.out.println("访问权限修饰符：" + Modifier.toString(f.getModifiers()));
                        System.out.println("属性类型：" + f.getType());
                        System.out.println("变量名字：" + f.getName());
                    }
                    //通过反射调用方法：（import java.lang.reflect.Method;）
                    Method method = reflectUser.getMethod("show");
                    method.invoke(reflectUser.newInstance());
                    Method method1 = reflectUser.getMethod("show1", int.class, String.class);
                    method1.invoke(reflectUser.newInstance(), 33, "小黄");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            class User {
                private String name;
                private int age;

                public User() {
                    super();
                    // TODO Auto-generated constructor stub
                }

                public User(String name, int age) {
                    super();
                    this.name = name;
                    this.age = age;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getAge() {
                    return age;
                }

                public void setAge(int age) {
                    this.age = age;
                }

                @Override
                public String toString() {
                    return "User [name=" + name + ", age=" + age + "]";
                }

                public void show() {
                    System.out.println("这一定是一个假方法");
                }

                public void show1(int a, String b) {
                    System.out.println("这一定是一个假方法" + a + b);
                }
            }
        }
        //需要注意反射的效率和风险，以后补充
    }

    /**
     * java学习篇9------------文件类File
     */
    private void myFile() throws Exception {
//        File file = new File("D" + File.separator + "路径");//文件地址
//        File file1 = new File(new URI("wwww.wwww.wwww"));//URI也是可以的
//        /*	·  windows下。分隔符是“\”        linux下。分隔符是“/”  */
//        file.exists();//文件或目录是否存在
//        file.isFile();//是否是文件
//        file.isDirectory();//是否是目录
//        file.getName();//获取文件或目录的名字
//        file.getPath();//文件路径
//        file.getAbsolutePath();
//        file.lastModified();//获取最后的修改日期
//        file.length();//获取文件大小，字节为单位
//        String strFile[] = file.list();//如果对象是目录，则返回目录下所有文件和目录名字的列表
//        File file2[] = file.listFiles();//
//        file.mkdir();//创建File中的目录
//        file.mkdirs();//创建File中的目录，如果父目录不存在，还会创建父目录
//        file.renameTo(new File("c:adad/dada/23.txt"));//修改文件的名称，会删除原文件
//        file.createNewFile();//如果File代表文件，则创建一个空文件
//        file.delete();//删除文件或目录(如果目录下包含子目录或文件，则不能删除)
    }

    /**
     * java学习篇10------------java面向对象
     */
    class myObject {
        //定义的常量 变量
        private final int PI = 21;
        private final String TX = "腾讯";
        private String mName, mBlance, mAccount, mMoney;
        private int a, b, c;
        private ArrayList<Integer> MList;

        //    三，引用变量的赋值
        {
            String s = "hello";
            String t = s;
            s = "world";
//    对于引用数据类型  就是对象  数组  String
            if (s.equals(t)) {
                Log.e("tag", "我比较的是值");
            }
            if (s == t) {
                Log.e("tag", "我比较的是空间地址");
            }
/*
 关于equals与==的区别从以下几个方面来说：
（1） 如果是基本类型比较，那么只能用==来比较，不能用equals
（2） 对于基本类型的包装类型，比如Boolean、Character、Byte、Shot、Integer、Long、Float、Double等的引用变量，
     ==是比较地址的，而equals是比较内容的。
（3） 注意：对于String(字符串)、
     StringBuffer(线程安全的可变字符序列)、
     StringBuilder(可变字符序列)这三个类作进一步的说明。
     */
        }

        ;//默认的构造方法

        //构造（没有返回值）
        public myObject() {
        }
        //单参数的构造方法

        public myObject(String a) {
        }
        //多参数的构造方法

        public myObject(int b, double c) {
        }

        //自动生成的构造方法，一般用于对象数组
        public myObject(String mName, String mBlance, String mAccount, String mMoney, int a, int b, int c, ArrayList<Integer> MList) {
            this.mName = mName;
            this.mBlance = mBlance;
            this.mAccount = mAccount;
            this.mMoney = mMoney;
            this.a = a;
            this.b = b;
            this.c = c;
            this.MList = MList;
        }

        ;

        //普通方法，非构造方法
        public void JavaThree(int a) {
        }


/*面向对象的三大特征：封装 继承  多态  还有六大原则 自己看
---------封装：
讲一个类的属性私有化，同时对外提供公共的访问方法。封装的作用：为了保护数据安全。
---------继承：
就是以现有的类为模板，扩展新功能，创建出新的类的过程。其中，模板类被称为父类或者基类，扩展的类被称为子类或者派生类
              子类会完全的继承父类中的所有非私有的数据成员，而且子类无法选择性的继承父类。
              Java中的继承是单继承，也就说一个子类只能直接继承自一个父类。
              继承只能继承属性  不能继承值。
----------多态：
编译时数据类型和运行时的数据类型不一致，就会发生多态。父类对象的位置可以用一个子类对象来代替，实际运行时，活动的就是这一个子类对象。
                 大前提 ：必须有继承或者实现，通常还有一个前提 存在复写
      多态也叫里式替换原则：子类对象完美替换父类对象并且对程序本身不造成任何伤害

      多态：对外一个接口，内部多种实现分为编译时多态和运行时多态
             编译时多态：分为重写和重载
             运行时多态：向上转型和向下转型

              向上转型：Animal   animal  =new  Dog();
              调用的是父类的 和子类复写的   不能调用子类的  说到底父类的（但是子类复写，相当于扩展了方法）

              向下转型：Dog   dog  = (Dog)animal;（必须经过向上转型，拿到Animal的实例）
              调用的是子类所有和父类非私有，也就是子类继承的  说到底还是子类的（这样来说，用向上转型的作用似乎更大）

              Dog   dog  =new Animal();
              此转型有待参考
              */

//    二，关于修饰符的访问权限
//    类型            无修饰符   private    protected    public
//    同类              是        是           是         是
//    同一包中的子类      是                    是          是
//    同一包中的非子类    是                    是          是
//    不同包中的子类                           是           是
//    不同包中的非子类                                      是

        //方法的重载  (方法名相同，参数列表不同)
        public void JavaThree(String a, int b) {
        }

        //    父类：Throwable     子类：异常 Exception     子类：错误 Error
        public void method() throws Throwable {
            int a = 1 + 2;
            try {
                /*有可能出异常的语句*/
            } catch (NullPointerException e) {
                e.getMessage();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.toString();
            } catch (Exception e) {
                e.toString();
                throw e;//抛出到头方法
            } finally {
                a = 56;
            }

        }
    }

    /**
     * java学习篇11------------集合List
     */
    private class myList {
        /*集合继承关系*/
//Collection 接口的接口 对象的集合（单列集合）
//├——-List 接口：元素按进入先后有序保存，可重复
//│—————-├ LinkedList 接口实现类， 链表， 插入删除， 没有同步， 线程不安全，查询慢，增删快
//│—————-├ ArrayList（常用） 接口实现类， 数组， 随机访问， 没有同步， 线程不安全，查询快，增删慢
//│—————-└ Vector 接口实现类 数组， 同步， 线程安全,  性能较低，查询快，增删慢
//│ ———————-└ Stack 是Vector类的实现类
//└——-Set 接口： 仅接收一次，不可重复，并做内部排序 所有的重复内容是靠hashCode()和equals()两个方法区分的
//├—————-└HashSet（常用）使用hash表（数组）存储元素 散列存放 无序
//│————————└ LinkedHashSet 链表维护元素的插入次序
//└ —————-TreeSet（常用） 底层实现为二叉树，元素排好序 （使用TreeSet则对象所在的类必须实现Compable接口，然后再Arrays.sort()）
//
//Map 接口 键值对的集合 （双列集合）
//├———Hashtable 接口实现类， 同步， 线程安全  速度慢 key不允许重复
//├———HashMap （常用）接口实现类 ，没有同步， 线程不安全  快
//│—————–├ LinkedHashMap 双向链表和哈希表实现
//│—————–└ WeakHashMap
//├ ——–TreeMap （常用）红黑树对所有的key进行排序 key不允许重复
//└———IdentifyHashMap


        /*迭代器 用不上 了解下就可以了*/ {
            //Iterator接口的操作原理：Iterator是专门的迭代输出接口，
            //使用迭代器的时候  就不能用自己的删除方法
            List<String> all = new ArrayList<String>();
            all.add("hello");
            // Iterator接口
            Iterator<String> iter = all.iterator();
            while (iter.hasNext()) {
                iter.next();//取出当前元素
                iter.remove();//移除
            }
            // ListIterator接口
            ListIterator<String> iter1 = all.listIterator();
            while (iter1.hasNext()) {  //判断是否有下一个元素 由前向后输出
                iter1.set("");// 替换元素
            }
            while (iter1.hasPrevious()) {  // 判断是否有上一个元素  由前向后输出
                iter1.previous();        // 取出内容
                iter1.add("");
                iter1.nextIndex();//返回下一个元素的索引号
                iter1.previousIndex();//返回上一个元素的索引号
            }
        }

        /*foreach的操作*/ {
            List<String> all = new ArrayList<String>();    // 实例化List接口
            all.add("hello");                // 增加元素
            for (String str : all) {                // 输出foreach输出
                //做操作
            }
        }
        //和其他语言使用ASCII码字符集不同，java使用Unicode字符集来表示字符串和字符。
        // ASCII使用（8bit）表示一个字节，可以认为一个字符就是一个字节（byte）
        // Unicode用两个字节（16bit），表示一个字符。一个字符就是两个字节（byte）了。
        // Queue：队列接口:继承了List接口和Queue接口
        //         方法	            类型	描述
        // public E element()	普通	找到链表的表头
        // public boolean offer(E o)	普通	将指定元素增加到链表的结尾
        // public E peek()	普通	找到但并不删除链表的头
        // public E poll()	普通	找到并删除此链表的头
        // public E remove ()	普通	检索并移除表头
        // SortedSet接口：可以对集合中的数据进行排序。

        /*map键值对集合*/ {
            // public void clear()	普通	清空Map集合
            // public boolean containsKey(Object key)	普通	判断指定的key是否存在
            // public boolean containsValue(Object value)	普通	判断指定的value是否存在
            // public Set<Map.Entry<K,V>> entrySet()	普通	将Map对象变为Set集合
            // public boolean equals(Object o)	普通	对象比较
            // public V get(Object key)	普通	根据key取得value
            // public int hashCode()	普通	返回哈希码
            // public boolean isEmpty()	普通	判断集合是否为空
            // public Set<K> keySet()	普通	取得所有的key
            // public V put(K key, V value)	普通	向集合中加入元素
            // public void putAll(Map<? extends K,? extends V> t)	普通	将一个Map集合中的内容加入到另一个Map
            // public V remove(Object key)	普通	根据key删除value
            // public int size()	普通	取出集合的长度
            // public Collection<V> values()	普通	取出全部的value
            /*虽然存入的时候是KEY  和 VALUE 两个对象，但是最后还是以Map.Entry对象保存在集合中的*/

            //Map接口的常用子类：
            // HashMap：无序存放的，是新的操作类，key不允许重复。不安全，异步操作，速度快，key和value可以设置为null
            Map<String, String> map = new HashMap<String, String>();    // key和value是String
            // MAP增加元素：
            map.put("mldn", "www.mldn.cn");//放入数据
            map.get("mldn");    // 根据key求出value
            map.containsKey("mldn");       // 查找指定的key是否存在
            map.containsValue("www.mldn.cn");   // 查找指定的value是否存在
            Set<String> keys = map.keySet(); // 得到全部的key
            Iterator<String> iter = keys.iterator(); // 实例化Iterator
            System.out.print("全部的key：");            // 输出信息
            while (iter.hasNext()) {                // 迭代输出全部的key
                String str = iter.next();            // 取出集合的key
            }
            //把Value变成Collection集合在输出：
            Collection<String> values = map.values();
            Iterator<String> iter2 = values.iterator();        // 实例化Iterator
            System.out.print("全部的value：");            // 输出信息
            while (iter2.hasNext()) {                // 迭代输出
                String str = iter2.next();            // 取出value
                System.out.print(str + "、");        // 输出内容
            }
            //Hashtable：无序存放的，是旧的操作类，key不允许重复。（过时）。安全，同步，速度慢，不可以设置为空
            // TreeMap：可以排序的Map集合，按集合中的key排序，key不允许重复。
            // TreeMap根据Key来对元素进行排序
            // 如果Key是对象那么必须实现 Comparable接口
            {
                Map<String, String> map1 = null;
                map = new TreeMap<String, String>();        // 实例化Map对象
                map.put("A、mldn", "www.mldn.cn");            // 增加内容
                Set<String> keys1 = map1.keySet();            // 得到全部的key
                Iterator<String> iter1 = keys.iterator();        // 实例化Iterator
                while (iter1.hasNext()) {                // 迭代输出
                    String str = iter1.next();            // 取出key
                    System.out.println(str + " --> " + map.get(str));    // 取出key对应的内容
                }
            }
        }

        /*迭代器输出map的方法  不常用迭代吧 个人意见 */ {
            Map<String, String> map = null;        // 声明Map对象，指定泛型类型
            map = new HashMap<String, String>();        // 实例化Map对象
            map.put("mldn", "www.mldn.cn");                        // 增加内容
            map.put("zhinangtuan", "www.zhinangtuan.net.cn");    // 增加内容
            map.put("mldnjava", "www.mldnjava.cn");        // 增加内容
            Set<Map.Entry<String, String>> allSet = null;    // 声明一个Set集合，指定泛型
            allSet = map.entrySet();            // 将Map接口实例变为Set接口实例
            Iterator<Map.Entry<String, String>> iter = null;    // 声明Iterator对象
            iter = allSet.iterator();            // 实例化Iterator对象
            while (iter.hasNext()) {
                Map.Entry<String, String> me = iter.next();// 找到Map.Entry实例
                System.out.println(me.getKey()
                        + " --> " + me.getValue());    // 输出key和value
            }
            //foreach 输出集合
            Map<String, String> map2 = null;        // 声明Map对象，指定泛型类型
            map2 = new HashMap<String, String>();    // 实例化Map对象
            map2.put("mldn", "www.mldn.cn");        // 增加内容
            map2.put("zhinangtuan", "www.zhinangtuan.net.cn");    // 增加内容
            map2.put("mldnjava", "www.mldnjava.cn");        // 增加内容
            for (Map.Entry<String, String> me : map2.entrySet()) {
                System.out.println(me.getKey() + " --> " + me.getValue());// 输出key和value
            }
        }

        /*Stack类是Vector的子类*/ {
            // public boolean empty()	常量	测试栈是否为空
            // public E peek()	常量	查看栈定，但不删除
            // public E pop()	常量	出栈，同时删除
            // public E push(E item)	普通	入栈
            // public int search(Object o)	普通	在栈中查找
            Stack<String> s = new Stack<String>();    // 实例化Stack对象
            s.push("A");                // 入栈
            s.push("B");                // 入栈
            s.push("C");                // 入栈
            System.out.print(s.pop() + "、");        // 出栈
            System.out.print(s.pop() + "、");        // 出栈
            System.out.println(s.pop() + "、");    // 出栈
            System.out.print(s.pop() + "、");        // 错误，出栈，出现异常，栈为空
        }

        void mVector() {
            //向量  Vector类
            //1.可以是不同的对象，不能是基本数据类型 如int
            //2.变长的空间
            //初始为100   超出之后50递增
            Vector<Object> mVetor = new Vector(100, 50);
            mVetor.addElement(123);//添加到尾部
            mVetor.insertElementAt("你好", 34);//指定角标插入
            mVetor.add(12, 34);//指定位置添加
            mVetor.add(12);//
            mVetor.setElementAt("787", 12);//指定位置修改
            mVetor.removeElementAt(21);//移除角标处
            mVetor.removeAllElements();//清空，长度为0
            mVetor.capacity();//容量 ，没有length方法
        }

        void mTreeSet() {
            class Person implements Comparable<Person> {    // 定义Person类，实现比较器
                private String name;            // 定义name属性
                private int age;            // 定义age属性

                public Person(String name, int age) {    // 通过构造方法为属性赋值
                    this.name = name;            // 为name属性赋值
                    this.age = age;            // 为age属性赋值
                }

                // 覆写toString()方法
                public String toString() {
                    return "姓名：" + this.name + "；年龄：" + this.age;
                }

                // 覆写compareTo()方法，指定排序规则 通过年纪排序
                public int compareTo(Person per) {
                    if (this.age > per.age) {
                        return 1;
                    } else if (this.age < per.age) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

                //复写方法
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Person)) {
                        return false;
                    }
                    Person per = (Person) obj;
                    if (per.name.equals(this.name) && per.age == this.age) {
                        return true;
                    } else {
                        return false;
                    }
                }

                //复写方法
                public int hashCode() {
                    return this.name.hashCode() * this.age;
                }
            }
        }
    }

    /**
     * java学习篇12------------Lambda表达式
     */
    private static class myLambda {
        //        Lambda简介#
//        Lambda 表达式是 JDK8 的一个新特性，可以取代大部分的匿名内部类，写出更优雅的 Java 代码，尤其在集合的遍历和其他集合操作中，可以极大地优化代码结构。
//        JDK 也提供了大量的内置函数式接口供我们使用，使得 Lambda 表达式的运用更加方便、高效。
//        对接口的要求#
//        虽然使用 Lambda 表达式可以对某些接口进行简单的实现，但并不是所有的接口都可以使用 Lambda 表达式来实现。Lambda 规定接口中只能有一个需要被实现的方法，不是规定接口中只能有一个方法
//        jdk 8 中有另一个新特性：default， 被 default 修饰的方法会有默认实现，不是必须被实现的方法，所以不影响 Lambda 表达式的使用。
//        @FunctionalInterface#
//        修饰函数式接口的，要求接口中的抽象方法只有一个。 这个注解往往会和 lambda 表达式一起出现。
//        Lambda 基础语法#
//        我们这里给出六个接口，后文的全部操作都利用这六个接口来进行阐述。
//        语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，-> 为 lambda运算符 ，读作(goes to)。
// 先定义两个接口
        interface LambdaInter1 {
            void method();
        }

        interface LambdaInter2 {
            void method(int a, String sss);
        }

        //        这里是测试方法
        {
            LambdaInter1 lambdaInter1 = () -> {
                Tools.showLog("212");
            };
            lambdaInter1.method();

            LambdaInter2 lambdaInter2 = (int a, String b) -> {
                Tools.showLog("2121");
            };
            lambdaInter2.method(12, "1221");

            //线程简写式runnable  个人理解  但是并不简单啊  还不好理解
            Runnable runnable = () -> {
            };//run方法写在花括号
            runnable.run();
            new Thread(runnable).start();

            //有待加深理解
        }

    }

    /**
     * java学习篇13------------IntStream无限流
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private class myNewJava {
        //volatile申明一个共享数据（变量）
        volatile int asa = 90;

        //Intstream无限流
        {
            IntStream.range(1, 5).forEach(a -> Tools.showLog("adahdhada"));
        }
        //有time的时候在了解
    }

    /**
     * java学习篇14------------网络编程Socket----http
     */
    private class myNet {
        //简单说明一下，最基本的：利用socket技术  客户端传递一个数据  到服务器端打印出来
        // 服务器端
        private void serverMethod() throws Exception {
            ServerSocket serversocket = new ServerSocket(7000);// 创建一个服务器端的socket
            Socket socket = serversocket.accept();// 设置监听 并用socket接收  (接受请求)
            // 1.socket的输入流 加入缓冲
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            // 2.socket的输出流 加入缓冲
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            // 然后开始读取接受到的 socket信息
            dos.writeDouble(dis.readDouble());
            dos.flush();
            socket.close();// 关闭socket
            serversocket.close();// 关闭服务器端socket
        }

        // 客户端
        private void clientSocket() throws Exception {
            //建立socket ip+端口号
            Socket socket = new Socket("localhost", 7000);
            // 1.socket的输入流 加入缓冲
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            // socket的输出流（这里就用简写了）
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            dos.writeDouble(3000);
            dos.flush();

            System.out.println("服务器返回的计算面积为:" + dis.readDouble());
            dos.writeInt(0);
            dos.flush();

            socket.close();
        }

        //线程池服务器端
        public void SocketServerM() throws Exception {
            int clientNo = 1;//客户端1号 用于标记是第几个客户端
            ServerSocket serverSocket = new ServerSocket(7000);
            ExecutorService exec = Executors.newCachedThreadPool();//创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
            try {
                while (true) {//不停的接受 某些客户端的消息
                    Socket socket = serverSocket.accept();
                    exec.execute(new ServerRunnable(socket, clientNo));//线程池启动 开始放入任务
                    clientNo++;
                }
            } finally {
                serverSocket.close();
            }
        }

        //线程池服务器端的任务 runnable
        class ServerRunnable implements Runnable {
            private Socket socket;
            private int clientNo;//标记是第几个客户端

            public ServerRunnable(Socket socket, int clientNo) {
                this.socket = socket;
                this.clientNo = clientNo;
            }

            @Override
            public void run() {
                try {
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                    do {
                        dos.writeDouble(dis.readDouble());
                        dos.flush();
                    } while (dis.readInt() != 0);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("与客户端" + clientNo + "通信结束");
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        /*GET 请求获取Request-URI 所标识的资源；
        POST 在Request-URI 所标识的资源后附加新的数据；
        HEAD 请求获取由Request-URI 所标识的资源的响应消息报头；
        PUT 请求服务器存储一个资源，并用Request-URI作为其标识；
        DELETE 请求服务器删除Request-URI 所标识的资源；
        TRACE 请求服务器回送收到的请求信息，主要用于测试或诊断；
        CONNECT 保留将来使用；
        OPTIONS 请求查询服务器的性能，或者查询不资源相关的选项和需求。*/

        /*1xx：指示信息--表示请求已接收，继续处理
        2xx：成功--表示请求已被成功接收、理解、接受
        3xx：重定向--要完成请求必须迚行更迚一步的操作
        4xx：客户端错误--请求有语法错误戒请求无法实现
        5xx：服务器端错误--服务器未能实现合法的请求*/

        /*200 OK 客户端请求成功
        400 Bad Request 客户端请求有语法错误，丌能被服务器所理解
        401 Unauthorized 请求未经授权，这个状态代码必须和WWW-Authenticate 报//头域一起使用
        403 Forbidden 服务器收到请求，但是拒绝提供服务
        404 Not Found 请求资源丌存在，eg：输入了错误的URL
        500 Internal Server Error 服务器发生丌可预期的错误
        503 Server Unavailable 服务器当前丌能处理客户端的请求，一段时间后， //可能恢复正常*/

        URL url;

        {
            try {
                url = new URL("wwww.dada.com");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestMethod("GET");
                connection.setRequestMethod("POST");
                /*使用Http的Range头字段指定每条线程从文件的什么位置开始下载，下载到什么位置：
                如：指定从文件的2M位置开始下载，下载的位置(4M-1byte)为止，代码——*/
                connection.setRequestProperty("Range", "bytes=2097152-4194303");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * java学习篇14------------异步操作----AsyncTask
     */
    private abstract class MyAcynvTask extends AsyncTask{
        // 类中参数为3种泛型类型
// 整体作用：控制AsyncTask子类执行线程任务时各个阶段的返回类型
// 具体说明：
        // a. Params：开始异步任务执行时传入的参数类型，对应excute（）中传递的参数
        // b. Progress：异步任务执行过程中，返回下载进度值的类型
        // c. Result：异步任务执行完成后，返回的结果类型，与doInBackground()的返回值类型保持一致
// 注：
        // a. 使用时并不是所有类型都被使用
        // b. 若无被使用，可用java.lang.Void类型代替
        // c. 若有不同业务，需额外再写1个AsyncTask的子类

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //主线程工作  一般做一些UI标记
        }
        @Override
        protected Object doInBackground(Object[] objects) {
            //线程池中执行   onPreExecute之后  耗时操作  调用publishProgress来更新进度信息
            // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
            publishProgress(this);//???
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
            //主线程执行   调用publishProgress时来将进度更新到 UI上
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            //主线程  收尾工作  更新UI
        }



        {
            MyAcynvTask  myAcynvTask=new MyAcynvTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    return super.doInBackground(objects);
                }
            };
            //
            myAcynvTask.execute();
            myAcynvTask.publishProgress();
        }

    }

}


