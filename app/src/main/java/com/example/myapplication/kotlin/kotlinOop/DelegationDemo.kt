package com.easy.kotlin

import java.util.*
import kotlin.Comparator

/**
 * Created by jack on 2017/7/5.
 */

interface Subject {
    fun hello()
}

class RealSubject(val name: String) : Subject {
    override fun hello() {
        val now = Date()
        println("Hello, REAL $name! Now is $now")
    }
}

class ProxySubject(val sb: Subject) : Subject by sb {//继承于 Subject  并将所有公有方法委托给SB
    override fun hello() {
        println("Before ! Now is ${Date()}")
        sb.hello()
        println("After ! Now is ${Date()}")
    }
}

fun main(args: Array<String>) {
    val subject = RealSubject("World")
    subject.hello()
    println("-------------------------")
    val proxySubject = ProxySubject(subject)
    proxySubject.hello()
}

fun countCompare(){ //通过object直接实现比较器
    var list= mutableListOf(1,4,3,7,11,9,10,20)
    var contCompare=0
    Collections.sort(list,object :Comparator<Int>{
        override fun compare(o1: Int?, o2: Int?): Int {
            contCompare++

            if (o1 != null&&o2 != null) {
                return o1.compareTo(o2)
            }
            return -1}
    })
}


