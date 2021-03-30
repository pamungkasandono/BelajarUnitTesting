package com.example.myunittesting

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myunittesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var _mainViewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _mainViewModel = MainViewModel(CuboidModel())

        binding.btnHitung.setOnClickListener(this)
        binding.btnHitVolume.setOnClickListener(this)
        binding.btnHitLuasPermukaan.setOnClickListener(this)
        binding.btnHitKeliling.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val lebar = binding.etLebar.text.toString().trim()
        val panjang = binding.etPanjang.text.toString().trim()
        val tinggi = binding.etTinggi.text.toString().trim()

        val errorText = "Field ini tidak boleh kosong"
        when {
            lebar.isEmpty() -> binding.etLebar.error = errorText
            panjang.isEmpty() -> binding.etPanjang.error = errorText
            tinggi.isEmpty() -> binding.etTinggi.error = errorText
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
                        binding.tvHasil.text = _mainViewModel.getVolume().toString()
                        sembunyi()
                    }
                    R.id.btn_hit_luas_permukaan -> {
                        binding.tvHasil.text = _mainViewModel.getLuasPermukaan().toString()
                        sembunyi()
                    }
                    R.id.btn_hit_keliling -> {
                        binding.tvHasil.text = _mainViewModel.getKeliling().toString()
                        sembunyi()
                    }
                }
            }
        }
    }

    private fun tampil() {
        binding.btnHitVolume.visibility = View.VISIBLE
        binding.btnHitLuasPermukaan.visibility = View.VISIBLE
        binding.btnHitKeliling.visibility = View.VISIBLE
        binding.btnHitung.visibility = View.GONE
    }

    private fun sembunyi() {
        binding.btnHitVolume.visibility = View.GONE
        binding.btnHitLuasPermukaan.visibility = View.GONE
        binding.btnHitKeliling.visibility = View.GONE
        binding.btnHitung.visibility = View.VISIBLE
    }
}