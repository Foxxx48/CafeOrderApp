package com.fox.cafeorderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fox.cafeorderapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityLoginBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateOrder.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (name.isNotEmpty() && password.isNotEmpty()) {
                val intent = CreateOrderActivity.newIntent(this, name, password)
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.Toast_data), Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun createOrder() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}