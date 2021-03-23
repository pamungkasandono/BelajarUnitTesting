package com.example.myunittesting

class CuboidModel {
    private var _lebar: Double = 0.0
    private var _panjang: Double = 0.0
    private var _tinggi: Double = 0.0

    fun save(lebar: Double, panjang: Double, tinggi: Double) {
        this._lebar = lebar
        this._panjang = panjang
        this._tinggi = tinggi
    }

    fun getVolume(): Double = _lebar * _panjang * _tinggi

    fun getLuasPermukaan(): Double {
        val pl = _panjang * _lebar
        val lt = _lebar * _tinggi
        val pt = _panjang * _tinggi

        return 2 * (pl + lt + pt)
    }
    fun getKeliling(): Double = 4 * (_lebar + _panjang + _tinggi)
}