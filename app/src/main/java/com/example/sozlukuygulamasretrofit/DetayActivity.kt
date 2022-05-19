package com.example.sozlukuygulamasretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sozlukuygulamasretrofit.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private var _binding: ActivityDetayBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val kelime = intent.getSerializableExtra("nesne") as Kelimeler


        binding.textViewDetayTurkce.text=kelime.turkce
        binding.textViewIDetayngilizce.text=kelime.ingilizce
    }}