package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */

//默认被open修饰  接口也该是
open class Student constructor(var name: String, var age: Int) : Any() {

    init {//初始化代码块  主构造的参数可以在此块中使用
        println("Student{name=$name, age=$age} created!")
    }

    var addr: String = ""        //类中的属性必须要初始化
    open val weight: Float = 0.0f   //kotlin中的字段自动带有get和set方法

    //一方法需要被重写  就需要加上  open关键字

    //使用方法   var studentss=Student()
    //              studentss.addr   就可以了

    fun doEat() {//具体实现的方法默认被final修饰       子类继承抽象类的时候  属性必须初始化
        println("Student Eating ... ")
    }

    fun doWalk() {
        println("Student Walking ... ")
    }

    open fun doSwim() {
        println("Student Swimming ... ")
    }

    open fun doSleep() {
        println("Student Sleeping ... ")
    }
}

annotation class MyAutowired

class ElementarySchoolStudent public @MyAutowired constructor(name: String, age: Int) : Student(name, age) {
    override var weight: Float = 80.0f

    constructor(name: String, age: Int, weight: Float) : this(name, age) {//次级构造  不能声明var  val
        this.weight = weight  //用this 委托给次级构造函数
    }


//    class DontCreatMe private constructor(){}   //私有构造

    override fun doSleep() {
        super.doSleep()
        println("ElementaryStudent is Sleeping ... ")
    }

    override fun doSwim() {
        super.doSwim()
        println("ElementaryStudent is Swimming ... ")
    }
}


class MiddleSchoolStudent {
    constructor(name: String, age: Int) {
    }
}

class DontCreateMe private constructor() {
    var name: String = ""

    constructor(name: String) : this() {
        this.name = name
    }
}

fun main(args: Array<String>) {
    val student = Student("Jack", 10)
    student.doEat()
    student.doWalk()
    student.doSwim()
    student.doSleep()

    val elementaryStudent = ElementarySchoolStudent("Alice", 12)
    elementaryStudent.doEat()
    elementaryStudent.doWalk()
    elementaryStudent.doSwim()
    elementaryStudent.doSleep()

    // val dontCreateMe = DontCreateMe() // cannot access it
    val dontCreateMe = DontCreateMe("Me")

    val middleSchoolStudent = MiddleSchoolStudent("Jack", 12)
}
