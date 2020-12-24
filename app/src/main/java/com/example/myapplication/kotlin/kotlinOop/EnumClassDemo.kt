package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */


enum class Direction {
    NORTH, SOUTH, WEST, EAST
}
//每个enum都有name   ordinal   名称和地址



enum class RGB { RED, GREEN, BLUE }


enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


fun main(args: Array<String>) {
    val north = Direction.NORTH//上面的enum类使用方法
    val red = Color.RED
    println(red.rgb)

    //枚举类 遍历属性如下
    val rgbs = enumValues<RGB>().joinToString { "${it.name} : ${it.ordinal} " }//使用这个enumValues列出枚举
    println(rgbs)

    val colors = enumValues<Color>().joinToString { "${it.rgb} : ${it.name} : ${it.ordinal} " }
    println(colors)


    val s = ActivtyLifeState.onCreate
    println(s.signal())
}

//枚举常量也可以声明自己的匿名类
enum class ActivtyLifeState {
    onCreate {
        override fun signal() = onStart
    },

    onStart {
        override fun signal() = onStop
    },

    onStop {
        override fun signal() = onStart
    },

    onDestroy {
        override fun signal() = onDestroy
    };

    abstract fun signal(): ActivtyLifeState
}
