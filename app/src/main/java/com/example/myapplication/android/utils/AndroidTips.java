package com.example.myapplication.android.utils;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-09-30
 * Time: 10:21
 */
public class AndroidTips {
//    小技巧1：如何自定义类的注释：https://blog.csdn.net/xuaho0907/article/details/82761576
    /**
     * Created by ${PRODUCT_NAME}.
     * User: ${USER}
     * Date: ${DATE}
     * Time: ${TIME}
     */

//    小技巧2：Math.random()的值：0.0~1.0之间的双精度之间的随机数值；
    int a = (int) (Math.random() * 10);

//    小技巧3：  标号:语句；
//    break单独的意思是调出本语句块；     break 标号；跳出这个标号语句
//    continue在循环中理解结束本次循环，开始下一次循环；
//    return 返回；

    {
        int i, j = 0, k = 0, h;
        log1:
        for (i = 0; i < 100; i++, j += 2)
            log2:{
                log3:
                switch (i % 2) {
                    case 1:
                        continue log1;
                    case 2:

                        break log3;
                }
                break log1;
            }
    }

//    小技巧4  数组的高效复制方法
    {
        int arrayA[] = {1, 2, 3, 4, 5, 6};
        int arrayB[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//    把数组arrayA数组中的所有元素复制到arrayB数组中，下标从0开始；
        System.arraycopy(arrayA, 1, arrayB, 0, 3);
//                              （arrayA，arrayA的下标，arrayB，arrayB的下标，复制的长度）

    }

//    小技巧5   基本需要用的插件
    {
         /*1、GsonFormat
将Json字符串快速转成JavaBean对象，免去我们根据Json字符串手写对应Java Bean的过程。
2、Android ButterKnife Zelezny
配合butterknife实现注解，不用再手动实现findViewById了。
3、Android Methods Count
显示依赖库中得方法数
4、Lifecycle Sorter
可以根据Activity或者fragment的生命周期对其生命周期方法位置进行先后排序， windows 快捷键Ctrl + alt + K . Mac 快捷键 option + command + K
5、Android Code Generator
根据布局文件快速生成对应的Activity，Fragment，Adapter，Menu。
6、CodeGlance
在右边实现代码预览，类似于sublime，快速定位。
7、FindBugs-IDEA
查找bug的插件。
8、ADB WIFI
使用wifi无线调试你的app，无需root权限
9、JSONOnlineViewer
在Android Studio中，请求、调试接口
10、Android Styler
根据xml自动生成style代码的插件。需要把要生成style的代码copy到styles.xml中，选中进行设置。
11、Android Drawable Importer
这是一个非常强大的图片导入插件。它导入Android图标与Material图标的Drawable ，批量导入Drawable ，多源导入Drawable（即导入某张图片各种dpi对应的图片）
12、Genymotion
一款速度较快的Android模拟器，可以在Android Studio中直接开启。
13、SQLScout
在Android Studio中调试数据库 (SQLite)
14、GradleDependenciesHelperPlugin
maven gradle依赖支持自动补全
15、RemoveButterKnife
ButterKnife这个第三方库每次更新之后，绑定view的注解都会改变，从bind,到inject，再到bindview，搞得很多人都不敢升级，一旦升级，就会有巨量的代码需要手动修改
16、AndroidProguardPlugin
一键生成项目混淆代码插件，值得你安装
17、EventBus3 Intellij Plugin
为EventBus提供快速索引和跳转（目前只支持 EventBus 3.x 版本）
18、Android Studio Prettify
可以将代码中的字符串写在string.xml文件中选中字符串鼠标右键选择图中所示
19、ECTranslation
Android Studio翻译插件,可以将英文翻译为中文。
20、Exynap
Exynap一个帮助开发者自动生成样板代码的 AndroidStudio 插件
21、MVPHelper
一款Intellj IDEA和Android Studio的插件，可以为MVP生成接口以及实现类，解放双手。
*/
    }

//    小技巧6：字符串比较 compareTo( ) ：不忽略大小写 compareToIgnoreCase( )：忽略大小写
    public static void method() {
        String text = "";
        if (text.equals("2") & text.equalsIgnoreCase("213")) {

        }

    }

//    小技巧7： 可变参数
//    注意  1.只能有一个且在末尾
//         2.使用可变参数会默认构建一个对应的数组
    public void variableParameter(int... ints){ }
    //使用  如下
    {
        variableParameter(2,1,2);
        variableParameter(1,2,3,4,5,6,6);
        variableParameter(3,43,21232,4);
    }
//    小技巧8：代码执行顺序
/*父类静态属性
父类静态代码块

子类静态属性
子类静态代码块

父类代码块
父类构造函数
父类普通方法

子类代码块
子类构造函数
子类普通方法
*/
//小技巧8  设置toolbar 为没有在style里面设置


    //小技巧9  有空研究下fiddler

    //小技巧10  okhttpfinal 笔者推荐的开源框架

}
