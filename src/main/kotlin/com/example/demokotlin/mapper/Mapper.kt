package com.example.demokotlin.mapper

fun interface Mapper<T, U> {

    fun map(parameter: T): U
}
