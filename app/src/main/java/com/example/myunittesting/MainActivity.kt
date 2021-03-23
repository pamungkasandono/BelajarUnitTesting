package com.example.myunittesting

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var _mainViewModel: MainViewModel

    private lateinit var _etPanjang: EditText
    private lateinit var _etLebar: EditText
    private lateinit var _etTinggi: EditText
    private lateinit var _btnHitung: Button
    private lateinit var _tvHasil: TextView
    private lateinit var _btnHitVolume: Button
    private lateinit var _btnHitLuasPermukaan: Button
    private lateinit var _btnHitKeliling: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _mainViewModel = MainViewModel(CuboidModel())

        _etLebar = findViewById(R.id.et_lebar)
        _etPanjang = findViewById(R.id.et_panjang)
        _etTinggi = findViewById(R.id.et_tinggi)
        _tvHasil = findViewById(R.id.tv_hasil)
        _btnHitung = findViewById(R.id.btn_hitung)
        _btnHitVolume = findViewById(R.id.btn_hit_volume)
        _btnHitLuasPermukaan = findViewById(R.id.btn_hit_luas_permukaan)
        _btnHitKeliling = findViewById(R.id.btn_hit_keliling)

        _btnHitung.setOnClickListener(this)
        _btnHitVolume.setOnClickListener(this)
        _btnHitLuasPermukaan.setOnClickListener(this)
        _btnHitKeliling.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        val lebar = _etLebar.text.toString().trim()
        val panjang = _etPanjang.text.toString().trim()
        val tinggi = _etTinggi.text.toString().trim()

        val errorText = "Field ini tidak boleh kosong"
        when {
            lebar.isEmpty() -> _etLebar.error = errorText
            panjang.isEmpty() -> _etPanjang.error = errorText
            tinggi.isEmpty() -> _etTinggi.error = errorText
            else -> {
                val l = lebar.toDouble()
                val p = panjang.toDouble()
                val t = tinggi.toDouble()

                when (v?.id) {
                    R.id.btn_hitung -> {
                        _mainViewModel.save(l, p, t)
                        tampil()
                    }
                    R.id.btn_hit_volume -> {
                        _tvHasil.text = _mainViewModel.getVolume().toString()
                        sembunyi()
                    }
                    R.id.btn_hit_luas_permukaan -> {
                        _tvHasil.text = _mainViewModel.getLuasPermukaan().toString()
                        sembunyi()
                    }
                    R.id.btn_hit_keliling -> {
                        _tvHasil.text = _mainViewModel.getKeliling().toString()
                        sembunyi()
                    }
                }
            }
        }
    }
    private fun tampil() {
        _btnHitVolume.visibility = View.VISIBLE
        _btnHitLuasPermukaan.visibility = View.VISIBLE
        _btnHitKeliling.visibility = View.VISIBLE
        _btnHitung.visibility = View.GONE
    }
    private fun sembunyi() {
        _btnHitVolume.visibility = View.GONE
        _btnHitLuasPermukaan.visibility = View.GONE
        _btnHitKeliling.visibility = View.GONE
        _btnHitung.visibility = View.VISIBLE
    }
}