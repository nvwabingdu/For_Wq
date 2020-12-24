package com.easy.kotlin

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by jack on 2017/7/5.
 */

class NormalPropertiesDemo {
    var content: String = "NormalProperties init content"
}
/*委托属性，延迟，可观察，把多个属性存储在一个映射中，而不是存在单独的字段中*/



//kotlin支持委托属性
class DelegatePropertiesDemo {
    var content: String by Content()//委托之后自己使用会报异常

    override fun toString(): String {
        return "DelegatePropertiesDemo Class"
    }
}

class Content {
    //这个相当于上面的content的get（）
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>): String {
        return "${delegatePropertiesDemo} property '${property.name}' = 'Balalala ... ' "
    }

    //这个相当于上面的content的set（）
    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>, value: String) {
        println("${delegatePropertiesDemo} property '${property.name}' is setting value: '$value'")
    }
}

//可观察属性，我们把属性委托给Delegates.observable函数，当属性被重新复核的时候，触发其中的回调函数，onChange
class PostHierarchy {
    var level: String by Delegates.observable("P0",
            { property: KProperty<*>,
              oldValue: String,
              newValue: String ->
                println("$oldValue -> $newValue")
            })

    val onChange2 = { property: KProperty<*>,
                      oldValue: String,
                      newValue: String ->
        println("$oldValue -> $newValue")
    }
    var level2: String by Delegates.observable("P0", onChange2)

    /**
     * If the callback returns `true` the value of the property is being set to the new value,
     *  and if the callback returns `false` the new value is discarded and the property remains its old value.
     */
    //可否决属性委托
    //当我们把这个属性委托给这个函数时，可以通过onchange函数返回值为true，来选择属性的值是否需要改变
    var grade: String by Delegates.vetoable("T0", {
        property, oldValue, newValue ->
        true
    })

    var notChangeGrade: String by Delegates.vetoable("T0", {
        property, oldValue, newValue ->
        false
    })

    //非空赋值委托
    var name: String by Delegates.notNull()
}

//委托给map映射
class Account(val map: Map<String, Any?>) {
    val name: String by map
    val password: String by map
}


class MutableAccount(val map: MutableMap<String, Any?>) {
    var name: String by map
    var password: String by map
}

fun getNormalValue(): String {
    println("normal we go 3!")
    println("normal we go 2!")
    println("normal we go 1!")
    return "Hello, normal ! "
}

fun main(args: Array<String>) {
    val n = NormalPropertiesDemo()
    println(n.content)
    n.content = "Lao tze"
    println(n.content)

    val e = DelegatePropertiesDemo()
    println(e.content) // call Content.getValue
    e.content = "Confucius" // call Content.setValue
    println(e.content) // call Content.getValue

    val normalValue = getNormalValue()
    println(normalValue)
    println(normalValue)

    val lambdaValue: String = {
        println("lambda we go 3!")
        println("lambda we go 2!")
        println("lambda we go 1!")
        "Hello, lambda ! "
    }.invoke()

    println(lambdaValue)
    println(lambdaValue)

//懒加载属性委托  接受一个lambda表达式，并返回一个Lazy实例的一个函数  返回的实例可以作为实现懒加载属性的委托
    //第一次调用get()会执行已传递给lazy()的lambda表达式并记录下结果，后续调用get()只是返回之前的结果
 val synchronizedLazyImpl = lazy {
     println("lazyValueSynchronized1  3!")
     println("lazyValueSynchronized1  2!")
     println("lazyValueSynchronized1  1!")
     "Hello, lazyValueSynchronized1 ! "
 }

    val synchronizedLazyImpl2 = lazy(LazyThreadSafetyMode.SYNCHRONIZED) {//线程安全 默认情况下是同步的 可以像第一种写法一样 简写即可
        println("lazyValueSynchronized1  3!")
        println("lazyValueSynchronized1  2!")
        println("lazyValueSynchronized1  1!")
        "Hello, lazyValueSynchronized1 ! "
    }

    val lazyValueSynchronized1: String by synchronizedLazyImpl
    println(lazyValueSynchronized1)
    println(lazyValueSynchronized1)


    val lazyValueSynchronized2: String by lazy {
        println("lazyValueSynchronized2  3!")
        println("lazyValueSynchronized2  2!")
        println("lazyValueSynchronized2  1!")
        "Hello, lazyValueSynchronized2 ! "
    }

    println(lazyValueSynchronized2)
    println(lazyValueSynchronized2)


    val lazyValuePublication: String by lazy(LazyThreadSafetyMode.PUBLICATION) {//可同时委托给多个线程  不需要同步锁
        println("lazyValuePublication 3!")
        println("lazyValuePublication 2!")
        println("lazyValuePublication 1!")
        "Hello, lazyValuePublication ! "
    }

    println(lazyValuePublication)
    println(lazyValuePublication)

    val lazyValueNone: String by lazy(LazyThreadSafetyMode.NONE) {//如果属性的初始化是单线程的，那么我们使用这个（性能最高）
        println("lazyValueNone 3!")
        println("lazyValueNone 2!")
        println("lazyValueNone 1!")
        "Hello, lazyValueNone ! "
    }

    println(lazyValueNone)
    println(lazyValueNone)

    //可观察属性
    val ph = PostHierarchy()
    ph.level = "P1"
    ph.level = "P1"
    ph.level = "P2"
    ph.level = "P3"
    println(ph.level) // P3

    ph.level2 = "M1"
    ph.level2 = "M2"
    println(ph.level2) // M2


    ph.grade = "T1"
    ph.grade = "T2"
    ph.grade = "T3"
    println(ph.grade) // T3

    ph.notChangeGrade = "T1"
    ph.notChangeGrade = "T2"
    ph.notChangeGrade = "T3"
    println(ph.notChangeGrade) // T0

//    ph.name = null
    ph.name = "Jack"
    println(ph.name)

    //委托给map映射
    val account = Account(mapOf(
            "name" to "admin",
            "password" to "admin"
    ))

    println("Account(name=${account.name}, password = ${account.password})")

    //如果是可变属性 也可以换成mutableMapOf
    val maccount = MutableAccount(mutableMapOf(
            "name" to "admin",
            "password" to "admin"
    ))

    maccount.password = "root"

    println("MutableAccount(name=${maccount.name}, password = ${maccount.password})")
}
