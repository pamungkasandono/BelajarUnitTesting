package com.example.myunittesting

class MainViewModel(private val _cuboidModel: CuboidModel) {
    fun getVolume(): Double = _cuboidModel.getVolume()

    fun getLuasPermukaan(): Double = _cuboidModel.getLuasPermukaan()

    fun getKeliling(): Double = _cuboidModel.getKeliling()

    fun save(l: Double, p: Double, t:Double) {
        _cuboidModel.save(l, p, t)
    }
}