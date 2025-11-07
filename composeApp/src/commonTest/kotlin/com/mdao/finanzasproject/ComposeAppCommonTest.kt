package com.mdao.finanzasproject

import kotlin.test.Test
import kotlin.test.assertEquals

class ComposeAppCommonTest {

    @Test
    fun myFirstTest(){ //Aprendiendo metodologia para test
        //Give
        val x = 5
        val y= 10

        //When
        val result = x+y

        //Then
        assertEquals(15, result)
    }
}