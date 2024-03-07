package com.example.countertesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

/**
 * In a unit test, only one class can be tested, in this example the class MainViewModel()
 */

class MainViewModelTest {
    //System under test (sut) or fixture. (To describe the name of the class being tested in a unit test)
    private val sut = MainViewModel()


    //Rule to ensure that LiveData updates are instantly executed in unit tests.
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun initialStateIsEqualNull() {
        val expected = null
        val result = sut.state.value

        assertEquals(expected, result)
    }

    //In tests (and only in tests), you can use method names with spaces enclosed in backticks. (Kotlin convention)
    @Test
    fun `given initial state, when add is invoked then the state count is 1`() {
        //Given
        val expected = MainViewModel.State(1, false)

        //When
        sut.add()

        //Then
        assertEquals(expected, sut.state.value)
    }

    @Test
    fun `given initial state, when add is invoked 10 times then the count is 10`() {
        //Given
        val expected = MainViewModel.State(10, false)

        //When
        repeat(10) {
            sut.add()
        }

        //Then
        assertEquals(expected, sut.state.value)
    }

    @Test
    fun `given initial state, when sub is invoked then the state count is -1`() {
        //Given
        val expected = MainViewModel.State(-1, true)

        //When
        sut.sub()

        //Then
        assertEquals(expected, sut.state.value)
    }

    @Test
    fun `given initial state, when sub is invoked 10 times then the count is -10`() {
        //Given
        val expected = MainViewModel.State(-10, true)

        //When
        repeat(10) {
            sut.sub()
        }

        //Then
        assertEquals(expected, sut.state.value)
    }

    @Test
    fun `given initial state, when add and sub are invoked 2 times each then the count is 0`() {
        //Given
        val expected = MainViewModel.State(0, false)

        //When
        sut.add()
        sut.add()
        sut.sub()
        sut.sub()

        //Then
        assertEquals(expected, sut.state.value)
    }
}