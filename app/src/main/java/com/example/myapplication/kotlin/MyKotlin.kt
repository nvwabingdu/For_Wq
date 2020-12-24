package com.example.myapplication.kotlin

import android.os.Build
import androidx.annotation.RequiresApi
import rx.functions.Function
import rx.functions.Functions
import java.lang.Exception
import java.lang.Integer.parseInt
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-12-15
 * Time: 17:46
 */
class MyKotlin {
//  ：：用于打印类   用于引用一个函数？？？
    //  +  不能用于字符串相加


    fun main(args: Array<String>) {
        print("Hello world");
        println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()));
    }


    fun method() {
//        1.kotlin中所有的都为对象 所有变量都为对象    又分为可变 不可变
        var a = 9 //可变的
        val b = 90 //不可变的

        val e: Int = 45 //
        val ee: Int // 没有初始值时不能省略数据类型

        val Str = ""
        val bool = true

        val array = arrayOf(1, 2, 3)

//        2.is运算符检测是否为儿子
        var result: String = ""
        if (result is String) {
        }

//        3.原始字符串由 """ 可以包含换行符  和其他任意字符
        var rawString = """ fun helloworld(val name : String){  }"""

//        4.字符串 可以包含模板表达式   以$符号开始
        var footemplateString = "$rawString has ${rawString.length} characters"
    }


    //5.流程控制语句
    fun method2(a: Int, b: Int): Int {
        val max = if (a > b) a else b                //else 为可选
        return max //  return if (a>b) a else b   //if为一个表达式 可以返回一个值
    }

    fun m3(a: Int, b: Int): Int {
        var max2 = a
        if (a < b) max2 = b
        return max2
    }

    fun m4(a: Int, b: Int): Int {
        var max2: Int
//        while else
        if (a < b) {
            max2 = a
        } else {
            max2 = b
        }
        return max2
    }

    fun m5(a: Int, b: Int): Int {
        //if分支可以为代码块，最后的表达式作为该块的值：
        val max = if (a > b) {
            print("")
            a
        } else {
            print("")
            b
        }
        return max
    }


    //6.没有三元运算符  用下列方式
    fun m6(a: Int, b: Int) {
        //没有 true?0:1
        if (true) a else b

        val x = if (1 == 1) true else false
        x

    }


    //7.用于替代while 的 when
    fun cases(obj: Any, num: Int) {

        when (obj) {
            1 -> print("第一项")
            1, 0, 34, 32, 21 -> print("多项加逗号分隔")
            parseInt(obj as String) -> print("obj is 123")
            parseInt("123") -> print("obj is 123")
            "hello" -> print("字符串 hello")
            is Long -> print("这是一个long类型的数据")
            !is String -> print("obj is s")
            else -> print("else类似于java中的default")
        }

        val numArray = arrayOf(1, 3, 45)
        when (num) {
            in 12..323 -> print("")
            !in 12..344 -> print("")
            in numArray -> print("在这个集合之中")
        }

    }

    fun me(args: Array<String>) {
//        for (item in collection){ print("")}//  for可以对任何带迭代器的对象进行遍历

//        for(i in intArray){ ...  }//循环体可以是一个代码块
//        例如：

        for (arg in args) {//  这里类似于 foreach
            print(arg)
        }
        args.forEach { //牛批
            print(args)
        }

        for (i in args.indices) {//通过索引遍历一个数组或者一个list
            print(args[i])
        }

        //或者可以用库函数
//        for ((index,value) in array.withIndex()){
//            print("the element at $index is $value")
//        }

        //8.while  do while  基本上和java相同

//        break  continue 都是用来控制循环结构
        for (i in 10..20) {
            print(i)
            if (i == 13) {
                break
//                continue//和java一样  调出本次   仅仅这一次的循环
            }
        }
    }


    //9.直接用=符号  替代 return
    fun sum(a: Int, b: Int) = a + b
    fun maX(a: Int, b: Int) = if (a > b) a else b

    var sum2 = fun(a: Int, b: Int) = a + b
    val sumf = fun(a: Int, b: Int) = { a + b }
    //带大括号的返回值是函数

    //10.标签     adc@   jarOfLove@     跟着@的即为标签
    fun mm() {
        val array = arrayOf(1, 3, 2, 3, 4, 2, 2, 3, 2, 2)
        array.forEach eww@{                          //创建标签
            if (it == 12) {
                return@eww
            }                  // 跳转到标签处       it  为   每个值  自己理解
        }

    }

    fun mda() {
        var arrar = arrayOf(1, 23, 41, 21, 31, 13, 13, 13, 131)
        arrar.forEach {
            if (it == 12) {
                return@forEach                        //隐式操作
            }
        }
    }


    //11.throw是表达式  它的特殊类型是返回值为Nothing   相当于java中的void

    //用Nothing来标记无返回值的函数：
    fun fail(msg: String): Nothing {
        throw IllegalAccessException(msg)
    }

    fun mmas(a: Int) {}

    var bian: Nothing = throw Exception("")//因为是Nothing  所以不能作为参数传给函数


    //12.修饰符
//    lateinit  //后期初始化
//     open    //可继承open类
//    sealed class  //密封类
//    data class //数据类

    //权限修饰符
//    private
//    protected
//    public
//    internal    //整个模块？   用public差不多的吧

    //泛型可变型
//    in
//    out


//    noinline
//    crossinline
//    vararg            //变长参数


//    tailrec   //尾递归
//

    //13.this
    class thismm {
        val thisis = ""

        fun mm() {}

        fun meth(): thismm {
            print(this.thisis) //引用成员变量
            this.mm()//引用成员函数
            return this  //返回实例
        }

    }

    class Outer {
        val oh = "OH!"

        inner class Inner {
            fun m() {
                val outer = this@Outer
                val inner = this@Inner
                val pthis = this
                print("outer=" + outer)
                print("inner=" + inner)
                print("pthis=" + pthis)
                print(this@Outer.oh)

                val fun1 = hell0@ fun String.() {
                    val dl = this//fun1的接受者
                    print("dl" + dl)
                }

                val fun2 = { s: String ->
                    val d2 = this
                    print("d2" + d2)
                }
                "abc".fun1()

                fun2
            }
        }
    }


    //14  super  指向亲生父亲
    open class Father {
        open val firstName = "121"
        open val lastName = "3131"
        fun ff() {
            print("dddddd")
        }
    }


    class child : Father {
        var firstname = super.firstName
        var lastname = "77"

        constructor(lastName: String) {
            this.lastname = lastName
        }

        fun loveee() {
            super.ff()
        }

    }

    //15.操作符
    //重载操作符的函数需要用 operator 修饰符标记
    //中缀操作符的函数使用infix修饰符标记
//    var erd=1+"ddada"    //此种方式不OK
    var erd = 1.toString() + "dadadad"   //此种方式OK


//    16.相等与不相等
//    引用相等 ===   !==  (两个引用指向同一个对象)   不可重载
//    结构相等 ==   != (使用equals()判断)           a == null 时  自动转为 a===null  ?

//    Elvis操作符？：

//            ?:主要用于和null进行比较  用于判空
//    y=x ?: 0
//    等价于
//    val y=if(x!==null) x else 0

    val x = null
    val y = x ?: 0
//    结果为 y=0

    val xx = false
    val yy = x ?: 0
//    yy=false

    val x3 = ""
    val y3 = x ?: 0
//    y

    val x4 = "abc"
    val y4 = x ?: 0
//    y4=abc

//17:通过自定义infix函数来实现中缀操作符
//    date class Person(val name: String ,val age:Int)
//    infix fun Person.grow(years:Int):Person{
//        return Person(name,age+years)
//    }

    //就是构造函数  妈卖批  写的死复杂

    //18.扩展函数 和扩展属性  能够扩展一个类的新功能 而无需继承该类 或者使用像装饰者这样的设计模式等
    val <T> List<T>.lastIndex: Int get() = size - 1
    fun String.notEmpty(): Boolean {
        return !this.isEmpty()
    }

//    fun usage(baz: Baz){
//        baz.goo()
//    }

    //为String类型扩展一个notEmpty()的函数
//    fun String.notEmpty(): Boolean{
//        return !this.isEmpty()
//    }
//
//    "".notEmpty()      false
//
//    "123".notEmpty()   true

    //    下面代码为MutableList<Int>添加一个swap函数
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]//this对应该列表
        this[index1] = this[index2]
        this[index2] = tmp
    }

    //this关键字在扩展函数内部对应到接受者对象（传过来的，在.符号前的对象）。现在我们对任意MutableList<Int>调用该函数了
    //当然这个函数对应任何MutableList<T>起作用，我们可以泛化它

    val <T> List<T>.lastindex: Int get() = size - 1
//    fun String.notEmpty(): Boolean{
//         return !this.isEmpty()
//    }

//    fun MutableList<Int>.swap(index1: Int,index2: Int){
//        val tmp=this[index1]//this对应该列表m
//        this[index1]=this[index2]
//        this[index2]=tmp
//    }
//
//    fun <T> MutableList<T>.mswap(index1: Int,index2: Int){
//        val tmp=this[index1]//this对应该列表
//        this[index1]=this[index2]
//        this[index2]=tmp
//    }


//    19.扩展属性
//    val <T> List<T>.lastIndex:Int get() = size-1   //妈的皮写啥鸡儿

//    20.要允许为空  如下
//    var a:String?="abc"
//    a=null
//    var one:Int?=1
//    one=null
//    var arryInts:IntArray?= intArrayOf(1,2,3)
//    arryInts=null
//    arryInts=null
//    arryInts  =   null

//            ?. 安全调用      !!.   非空断言调用
//    na?.length
//    结果为null
//
//    na!!.length
//    空指针

//    val listWithNulls:List<String?> =listof("a","b"null)
//    listWithNulls
//    [a,b,null]

//    listWithNull.forEach{
//        it?.let{ print(it)}
//    }
//    a
//    b


//    21:所有类型的爹    Any
//    val any=Any()
//    结果 any   java.lang.Object@2e377400
//    any::class
//            class kotlin.Any
//    any::class.java
//    clas java.lang.Object

/*
* 十进制：123
* Long：123L
* 十六进制：0x0F
* 0b000001011
* double:123.5    123.5e10
* Float 123.4F  12.3f
* 123_131231_13231    可以使用此方式写
* 不能隐式转换  只有用显式转换
* val i:Int  =b.toInt()
*
* 可以使用+   则会自动转大
*
*
* val l=1L+3   可以的
*
*
* 位运算  没有如java般的符号 只有如下调用
* val x=(1  shl   2) and 0x000ff000
* shl(bits)  -----有符号左移（java的<<）
* shr(bits)  -----有符号右移（java的>>）
* ushr(bits)  -----无符号右移（java的>>>）
* and    与
* or      或
* xor     异或
* inv   非
*
*
* 转义字符  \t  \b  \n  \r  \'   \"   \\   \$
*
* char
*
* 'a'+1=b  char字符集的+
*'a'+1L=  error     没有重载+Long的数据
*
* 'c'-'a'=2
*
* 不能直接使用++'a'
*
*
* 索引运算符
* val a="abc"
*
* a[0]=a
*
*for(a1 in a){print(a1)}
*
*
* 字符串
*
* "acb".plus(true)
* abctrue
*
* "aca"+null
* acanull
*
* "abc"+arrayOf(1,3,4,5,4)
* 结果为  abc+地址
*
*
* 截取字符串
* "acsada".subSequence(0,12)
*
* """    中间的字符串不会变    """  叫原生字符串
*
* "acsada".trimIndex("<")     默认以|截取
*
* "acsada".trimIndex("<")   字符串行的左边空白对其切割
*
* 如
*               2313123
*         31231231
* 结果为
*
*       2313123
* 31231231
*
*字符串模板
*
*
* 用$在前方就好     如    你好$name      你好${s.length}
*
*
*
* 数组
* Array表示
* arrayOf(1,2,3,4)     就是    array[1,2,3,4]
* val arr=arrayOf(12,2,3,true)    允许不同元素  牛批
*
* arr.foreach(print(it))    牛批 可以用it代替
*
*
* arrayofNulls<Int>(10).foreach{print(it)}    创建固定长度的 空数组
*
* 也有 DoubleArray  FloatArray 等
*
* null is Any  false     null  is  Any?   true   null是安全空
*
*
* var x:String ="ssdada"
* x=null   error
*
* var x:String?="dadas"
* x=null    正确
*
* var x:String!!.="dadasd"   不能这样写      非空断言  !!.
*
* return str!!.length  就会出现null 异常      非空断言 !!.
*
*
*
*
*
*
*
* 函数    Uint    相当于void
*
* fun  m(){}
* fun m2(){return Unit}
* fun  m3():Unit{}
*
*
* 最底层类型  Nothing        Nothing()  is  Any       error
*
*
* Unit  返回值是   Unit        Nothing没有返回值  几乎和void相同
*
*
* Nothing?=null    是可以的
*
*
*
* Any最高层  String    Int   MyClass    最底层  Nothing
*
* Any?最高层  String?    Int?   MyClass?    最底层  Nothing?
*
* as运算符  用于执行引用类型的显示类型转换       类型兼容 转换就成功      类型不兼容  使用as？运算符就会返回null
*
* 所以就还是使用  as？    ????
*
* open class Foo
*
* class Goo:Foo()
*
* val foo=Foo()
* val goo=Goo()
*
* foo  as  Goo        excption
*
* foo as? Goo      null
*
* goo   as   Foo      line71$Goo@73dce0e6
*
*
*
*
*
*
*
*
*
*
*
*
*
* */


    fun myList() {
        //分为可变Mutable     不可变  Inmutable
//        list列表
//        List不可变   MutableList可变
        var mmlist: List<Int> = listOf()    //不能省略变量类型
        var m2list = listOf(12, 2, 312, 21, 31, 3, 12, 1, 2)
        var m3list = arrayListOf(12, 2, 312, 21, 31, 3, 12, 1, 2)
        //list::class     返回的是包名？
        var mmlist1: List<Int> = mutableListOf()    //不能省略变量类型
        var m2list2 = mutableListOf(12, 2, 312, 21, 31, 3, 12, 1, 2)
        var m3list3 = mutableListOf(12)

//        互相转化
        val newList = mmlist.toMutableList()

        //遍历
        val iterator2 = newList.iterator()
        while (iterator2.hasNext()) {

        }
        //遍历2
        newList.forEach { print(it) }


        newList.forEach { print(it) }
    }

    //集合操作
    fun listmm() {
        val mutableList = mutableListOf(1, 2, 3)
        val mutableList2 = mutableListOf(1, 2, 3, 4, 5)
        val list = listOf(1, 2, 3)
        val list2 = listOf("1212", "2121212", "21212")
        val emptylist = listOf<Int>()



        mutableList.add(1)
        mutableList.add(0, 21)
        mutableList.remove(1) //删除元素1
        mutableList.removeAt(1)  //删除角标1处的数据
        mutableList.removeAll(listOf(1, 2, 3)) //删除子集合
        mutableList.addAll(listOf(1, 2, 3))

        mutableList.set(0, 100) //更新下标为0的数据为100

        mutableList.clear()//清空
        mutableList.toList()//将可变集合 变为不可变集合

        mutableList.retainAll(mutableList2)//取交集   1 2 3

        list.contains(1)//

        list.elementAt(1)//查找对应下标的值
        list.elementAtOrElse(1, { 12 })  //查找不到  返回默认值
        list.elementAtOrNull(1)//找不到 返回null

        list.first()//返回第一个

        emptylist.first()//
        emptylist.firstOrNull()//null

        list.first({ it % 2 == 0 })//返回满足条件的
        list.first({ it > 100 })//牛批

        list2.indexOf("1")//没有就返回-1
        list.indexOfFirst({ it > 10 })//此处条件为Boolean型  -1
        list2.indexOfFirst({ it.contains("12") })//此处条件为Boolean型  -1

        list2.lastIndexOf("34")
        list.indexOfLast { it > 12 }//  返回下标
        list2.last()//返回最后一个
        list2.last { it.contains("12") }// 返回符合条件的最后一个元素


        list.single()//只有一个元素就返回这个元素  否则异常

        list2.single { it.contains("dad") }//返回符合条件的数据   没有  或者  不止一个都抛出异常？
        list2.singleOrNull() { it.contains("dad") }//                        不抛异常了  返回null

        list.any()//至少有一个元素   返回值Bleaoon
        list.any { it > 1 } //是否有满足条件的
        list.all { it > 1 }//是否所有的都满足
        list.none()//判断有无数据
        list.none { it > 1 }//是否所有的元素都不满足条件

        list.count()//返回个数
        list.count { it > 2 }

        list.reduce { sum, next -> sum + next }//累计运算
        list.reduce { total, s -> total + s }//

        list.reduceRight { total, s -> s + total }//从右边开始累加

        list.fold(100, { sum, next -> sum + next })//带初始值的累加
        list.foldRight(100, { sum, next -> next + sum })//带初始值的累加 从右边

        list2.forEach { print(it) }
        list2.forEachIndexed { index, i -> if (i.contains("da")) println(i) }

        list.max()
        list.min()

        //  "a">"b"   "abd"<"abc"    true>false
        val list3 = listOf(100, -500, 200, 300)
        list3.maxBy { it }//300
        list3.maxBy { it > 180 } //100
        list3.maxBy { it * it }//-500

        //同理还有  minBy   sumBy  用法一样的

        list.take(2)//返回前N个元素的子集合
        list.takeLast(2)//


        list.takeWhile { it % 2 == 0 }//返回依次满足条件的 遇到第一个不满足的就跳出
        list.takeLastWhile { it % 2 == 0 }

        list.drop(2)//去掉前面两个  然后返回集合
//        list.dropLast()
//        list.dropWhile {  }
//        list.dropLastWhile {  }


        list.slice(0..3)//取出0-3角标的集合
        list.slice(listOf(1, 2, 3))//返回指定下标的元素子集合


        val list4 = mutableListOf<Int>()
        list.filterTo(list4, { it > 2 })

        list.filter { it > 2 }//筛选
        list.filterNot { it < 3 }//所有不满足条件的
        list.filterNotNull()//过滤掉nullt


        list.map { it }//映射到map
        list.mapIndexed { index, it -> index + it }//index为下标
        list.mapNotNull { it }//返回无null


        list.map { it -> listOf(it + 1, it + 2, it + 3) }//floatmap [[1,2,3][1,3,4]]
        list.map({ it -> listOf(it + 1, it + 2, it + 3) }).flatten()//[1,2,3,1,3,4]

        val list5 = listOf("a", "b", "c")
        list.map { it -> listOf(it + 1, it + 2, it + 3) }
        //[[a1,a2,a3][b1,b2,b3][c1,c2,c3]]
        list.flatMap { it -> listOf(it + 1, it + 2, it + 3) }
        //[a1,a2,a3,b1,b2,b3,c1,c2,c3]

        val words = listOf("a", "abc", "ab", "def", "abcd")
        val lengthGroup = words.groupBy { it.length }
//        {[1=[a],3=[abc.def],2=[ab],4=[abcd]}
        words.groupBy({ it.length }, { it.contains("b") })
//        {[1=[false],3=[true.false],2=[true],4=[true]}

        //统计函数
        val words2 = "one two three four five six seven eight nine ten".split("")
        words2.groupingBy { it.first() }.eachCount()    //统计首字母出现的次数
//        {0=1,t=3,f=2,s=2,e=1,n=1}

        list.reversed()//反转输出

        list.sorted()//升序
        words.sortedBy { it.length }//以长度为规则升序

        list.sortedByDescending { it }//降序排列
        words.sortedByDescending { it.length }//降序排列

        //配合函数
        val n = listOf(1, 2, 3, 4)
        val m = listOf("A", "b", "ada")
        n.zip(m)
        //{[1,A][2,b][3,aba]}
        n.zip(listOf<Int>())
        //[]


        val mm = listOf(1, 2, 3, 4, 5, 5)
        mm.partition { it > 4 } //根据条件拆分为两个集合  挺有用
//        {[5,5][1,2,3,4]}


        //合并函数
        val qlist = listOf(1, 2, 3)
        val wlist = listOf(4, 5)
        qlist.plus(wlist)
        qlist + wlist//牛批
        qlist.plus(4)//
//        [1,2,3,4,5]

        qlist.plusElement(12)
        qlist + 12//牛批
//        [1,2,3,12]
    }

    //set集合
    fun mSet() {
//        不可变 set    可变mutableSET
        //支持序列化
        val emptySet = emptySet<Int>()//空集  size 0    isEmpty() true   hashcode 0
        val ssss = setOf<Int>()//空集

        //创建方式如下
        val sets = setOf(1, 2, 3, 4, 4, 4) //牛批  hashcode   equals 皆会判断
//        [1,2,3,4]

        //小于3的时候  初始容量为 n+1
        //n小于2147483647/2+1   ,初始容量为 n+n/3  否则为2147483647

//        对list去重
//        list.toset()

        val hashset1 = hashSetOf(1, 2, 3, 8, 4)     //hashSet 按照hash来存取，存取速度快
//        [1,2,3,4,8]
        val linked1 = linkedSetOf(1, 2, 3, 8, 4)    //linkedSet相当于这个   具有hash的查询速度 内部链表实现  频繁插入，删除的场景使用
//        [1,2,3,8,4]
        val linked2 = mutableSetOf(1, 3, 2, 7)    //linkedSet相当于这个加排序    具有hash的查询速度 内部链表实现  频繁插入，删除的场景使用
//        [1,3,2,7]
        val linked3 = sortedSetOf(1, 3, 2, 7)     //treeSet         实现了sorted  可以排序

        sets + 1
        sets + listOf(1, 2, 3)
        sets - 3
        sets - listOf(1, 3)


//        [1,2,3,7]
    }


    //map集合
    @RequiresApi(Build.VERSION_CODES.N)
    fun mMap() {
//        map   不可变         mutableMap  可变  可编辑
        val map1 = mapOf<String, Int>()
        var map2 = mapOf(1 to "a", 2 to "b", 3 to "c")
        map2.entries  //[1=a,2=b,3=c]
        map2.get(2) //跟java差不多

        val map3 = mutableMapOf<Int, Any?>()
        map3[1] = "da"
        map3[2] = 1


        val map4 = mutableMapOf(1 to "a", 2 to "b", 1 to "c")
        //[1=c,2=b]    //相同的话   后面的直接覆盖前面的

        val map5 = linkedMapOf(1 to 1, 2 to 3)
        val map6 = hashMapOf(1 to 1, 2 to 3)
        val map7 = sortedMapOf(1 to 1, 2 to 3)

        map2.entries//获取所有键值对
        map2.entries.forEach { println("key" + it.key + "value" + it.value) }

        map2.keys//获取所有 key值
        map2.values//获取所有value

        map2.get(1)
        map2[1]

        map2.getOrDefault(1, "12")//为null的时候返回  默认值  且默认值要和类型匹配   否则会报错
        map2.containsKey(1)
        map2.containsValue("!2")
        map2.entries.forEach { println(it.toPair()) }
        map2.getOrElse(1, { 1 })
        map2.getValue(1)
//        map2.getorput()  //没有此方法了？
        for ((k, v) in map2) {
            print("key=$k" + "value=$v")
        }//牛批

        map2.mapKeys { it.key + 3 }//会被后面的key值覆盖

        map2.mapValues { it.value + 3 }//会被后面的value值覆盖

        map2.filterKeys { it > 2 } //it是key值

        map2.filter { it.key > 2 && it.value.equals("1") }

        map2.toMutableMap()//

        val pairList = listOf(Pair(1, 22), Pair(3, 32), Pair(4, 55))
        pairList.toMutableList()//

        map2 + Pair(1, 2)
        map2 + listOf(Pair(1, 22), Pair(3, 32))
        map2 + arrayOf(Pair(1, 22), Pair(3, 32))
        map2 + sequenceOf(Pair(1, 22), Pair(3, 32))//
        map2 + mapOf(1 to 2, 43 to 12)

        //减法类似

        map2 += listOf(Pair(45, "22"), Pair(23, "32"))

        val map22 = mutableMapOf(1 to "2", 3 to "")
        map22.put(1, "2")//添加 存在就更新
        map22.putAll(map2)

        //有重复则会覆盖

        map22.remove(12) //根据key 删除  不是角标哦

        map22.clear()//清空
    }

    //泛型
    fun mfanxin() {
        //泛型    <k,V>这里面的就是泛型   <T>这个也是   作用    解释为：参数化类型
//        <String,Integer>
//        <"a",100>
//        <"b",100>
//        <"c",100>
//
//        in  T     ====>    ? extends T
//         out T =====>    ? super T
//         *   =====>   ?


        //泛型类  一般不用泛型类
        class Box<T>(t: T) {
            var value = t
        }

//        val box:Box<Int> =Bok<Int>(1)

        val box = Box(1)//可以省略写法

        //泛型函数   类型参数要放在函数名称之前
//        fun <T> mmm(item: T): List<T> {}

//        fun <T> T.basicToString():Stirng{}//扩展函数？

//        val ll = mmm<Int>(1)//调用方法
    }
}