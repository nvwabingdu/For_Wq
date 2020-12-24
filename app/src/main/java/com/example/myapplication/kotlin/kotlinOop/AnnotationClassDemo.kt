package com.easy.kotlin

/**
 * Created by jack on 2017/7/3.
 */


@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.FIELD,
        AnnotationTarget.LOCAL_VARIABLE,
        AnnotationTarget.TYPE,
        AnnotationTarget.TYPEALIAS,
        AnnotationTarget.TYPE_PARAMETER,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Repeatable
annotation class MagicClass


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Repeatable
annotation class MagicFunction


@Target(AnnotationTarget.CONSTRUCTOR)  //指定这个注解可用于哪些元素（类，属性，函数，表达式，等）
@Retention(AnnotationRetention.SOURCE)  //指定这个注解信息是否被保存到编译后的class文件中，以及运行时，是否可以通过反射访问

@MustBeDocumented        //表示这个注解是公开api的一部分，在自动产生的API文档的类或者函数签名中，应该包含这个注解的信息
@Repeatable             //允许在单个元素上，可以多次使用同一个注解
annotation class MagicConstructor


@MagicClass class Foo @MagicConstructor constructor() {

    constructor(index: Int) : this() {
        this.index = index
    }

    @MagicClass var index: Int = 0
    @MagicFunction fun magic(@MagicClass name: String) {

    }
}

