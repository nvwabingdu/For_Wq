package com.easy.kotlin

/**
 * Created by jack on 2017/7/4.
 */

class Aook(name: String)

class Cook(name: String) {
    val name = name
}

class Dook(val name: String)
class Eook(var name: String)

data class Book(val name: String)
data class Fook(var name: String)
//主构造函数需要至少有一个参数，下面的写法是错误的
//data class Gook // error, data class must have at least one primary constructor parameter
//主构造的所有参数需要标记位val  var
//data class Hook(name: String)// error, data class must have only var/val property
//数据类不能是抽象   开放  密封  内部类
//abstract data class Iook(val name: String) // modifier abstract is incompatible with data
//open data class Jook(val name: String) // modifier abstract is incompatible with data
//sealed data class Kook(val name: String)// modifier sealed is incompatible with data
//inner data class Look(val name: String)// modifier inner is incompatible with data


final data class Mook(val name: String) // modifier abstract is incompatible with data

data class User(
        val name: String,
        val gender: String,
        val age: Int
) {
    fun validate(): Boolean {
        return true
    }
}


class P {
    inner class INBase
}

sealed class SBase
//可以继承下面这些
open class DBase
interface IBaseA
interface IBaseB

data class LoginUser(val name: String = "", val password: String = "") : DBase(), IBaseA, IBaseB {

    var isActive = true

    constructor(name: String, password: String, isActive: Boolean) : this(name, password) {
        this.isActive = isActive
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

//    override fun toString(): String {
//        return super.toString()
//    }

    fun validate(): Boolean {
        return true
    }
}


fun main(args: Array<String>) {
    val aook = Aook("Aook")

    val cook = Cook("Cook")
    cook.name


    val dook = Dook("Dook")
    dook.name
    val eook = Eook("Eook")
    eook.name

    val book = Book("Book")
    book.name
    book.copy("Book2")

    val jack = User("Jack", "Male", 1)
    jack.name
    jack.gender
    jack.age
    jack.toString()
    jack.validate()


    val olderJack = jack.copy(age = 2)
    val anotherJack = jack.copy(name = "Jacky", age = 10)

    val rose = User("Rose", "Female", 2)
    rose.name
    rose.gender
    rose.age
    rose.toString()
//数据类的解构  相当于component函数的逆向映射
    val helen = User("Helen", "Female", 15)
    val (name, gender, age) = helen
    println("$name, $gender, $age years of age")

    val loginUser1 = LoginUser("Admin", "admin")
    println(loginUser1.component1())
    println(loginUser1.component2())
    println(loginUser1.name)
    println(loginUser1.password)
    println(loginUser1.toString())

    val loginUser2 = LoginUser(password = "root", name = "root")

    val loginUser3 = LoginUser()
    loginUser3.name
    loginUser3.password

}

//标准数据类Pair和Tirple
//          Pair<out A,out B>
//        Triple<out A,out B,out c>
