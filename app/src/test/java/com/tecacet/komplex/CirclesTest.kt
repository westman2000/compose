package com.tecacet.komplex

import androidx.compose.ui.geometry.Offset
import corp.wmsoft.drawcompose.toOffset
import corp.wmsoft.komplex.abs
import corp.wmsoft.komplex.exp
import corp.wmsoft.komplex.i
import corp.wmsoft.komplex.plus
import corp.wmsoft.komplex.times
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.PI

class CirclesTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun complex() {
        val a = -5.0
        val n = 0.0
        val m = 0.0
        val angle = 0.0


        val z1 = i + a
        val z2 = (1.0/(abs(z1))) * exp(i * (PI/2.0 + z1.arg))
        val z3 = 0.5 + 1.5 * i + 0.5 * exp(i * angle) + n + i * m
        val z4 = (1.0/(abs(z3))) * exp(i * (PI/2.0 + z3.arg))


        println("\nz1=$z1")
        println("z2=$z2")
        println("z3=$z3")
        println("z4=$z4 \n")


    }

    @Test
    fun testList() {
        val list = mutableListOf<Offset>()

        val m = 0
        val a = -5.0
        val n = 0.0



        for (angle in 0..360) {
            val z1 = i + a
            val z2 = (1.0 / (abs(z1))) * exp(i * (PI / 2.0 + z1.arg))
            val z3 = 0.5 + 1.5 * i + 0.5 * exp(i * angle) + n.toDouble() + i * m.toDouble()
            val z4 = (1.0 / (abs(z3))) * exp(i * (PI / 2.0 + z3.arg))

            list.add(z1.toOffset())
            list.add(z2.toOffset())
            list.add(z3.toOffset())
            list.add(z4.toOffset())
        }

        println(list.size)

        list.forEach {
            println(it)
        }
    }

}