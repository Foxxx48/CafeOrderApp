package com.fox.cafeorderapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.cafeorderapp.databinding.ActivityCreateOrderBinding
import com.fox.cafeorderapp.databinding.ActivityLoginBinding

class CreateOrderActivity : AppCompatActivity() {
    private var _binding: ActivityCreateOrderBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityCreateOrderBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCreateOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.tvName.text = intent.getStringExtra(NAME)
//        binding.tvPassword.text = intent.getStringExtra(PASSWORD)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        private const val NAME = "name"
        private const val PASSWORD = "password"

        fun newIntent(context: Context, name: String, password: String): Intent {
            return Intent(context, CreateOrderActivity::class.java).apply {
                putExtra(NAME, name)
                putExtra(PASSWORD, password)
            }
        }
    }
}