package com.example.myunittesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private var dmyLebar = 12.0
    private var dmyPanjang = 7.0
    private var dmyTinggi = 6.0

    private var dmyVol = 504.0
    private var dmyLP = 396.0
    private var dmyKell = 100.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun tesVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dmyLebar, dmyPanjang, dmyTinggi)
        val volume = mainViewModel.getVolume()
        assertEquals(dmyVol, volume, 0.0001)
    }

    @Test
    fun tesLuasPermukaan() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dmyLebar, dmyPanjang, dmyTinggi)
        val lP = mainViewModel.getLuasPermukaan()
        assertEquals(dmyLP, lP, 0.0001)
    }

    @Test
    fun tesKeliling () {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dmyLebar, dmyPanjang, dmyTinggi)
        val kell = mainViewModel.getKeliling()
        assertEquals(dmyKell, kell, 0.0001)
    }

    @Test
    fun tesMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dmyVol)
        val vol = mainViewModel.getVolume()
        verify(cuboidModel).getVolume()
        assertEquals(dmyVol, vol, 0.0001)
    }

    @Test
    fun tesMockKell() {
        `when`(mainViewModel.getKeliling()).thenReturn(dmyKell)
        val kell = mainViewModel.getKeliling()
        verify(cuboidModel).getKeliling()
        assertEquals(dmyKell, kell, 0.0001)
    }

    @Test
    fun tesMockLP() {
        `when`(mainViewModel.getLuasPermukaan()).thenReturn(dmyLP)
        val lp = mainViewModel.getLuasPermukaan()
        verify(cuboidModel).getLuasPermukaan()
        assertEquals(dmyLP, lp, 0.0001)
    }
}