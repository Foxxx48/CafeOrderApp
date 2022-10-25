package com.fox.cafeorderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.cafeorderapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
        private var _binding: ActivityLoginBinding? = null
        private val binding get() = _binding?: throw RuntimeException("ActivityLoginBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}