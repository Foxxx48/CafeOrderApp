package com.fox.cafeorderapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.fox.cafeorderapp.databinding.ActivityCreateOrderBinding

class CreateOrderActivity : AppCompatActivity() {
    private var _binding: ActivityCreateOrderBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityCreateOrderBinding = null")

    private lateinit var name: String
    private lateinit var password: String
    private lateinit var drink: String
    private lateinit var additions: String
    private var builderAdditions = StringBuilder()
    private lateinit var optionsOfDrink: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCreateOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        parseIntent()

        drink = getString(R.string.tea)
        additions = String.format(getString(R.string.additions), drink)
        binding.tvAdditions.text = additions

        binding.radioBtnTea.setOnClickListener {
            drink = getString(R.string.tea)

            binding.checkBoxLemon.visibility = View.VISIBLE

            binding.spinnerTea.visibility = View.VISIBLE
            binding.spinnerCoffee.visibility = View.INVISIBLE

            additions = String.format(getString(R.string.additions), drink)
            binding.tvAdditions.text = additions

        }

        binding.radioBtnCoffee.setOnClickListener {
            drink = getString(R.string.coffee)
            binding.checkBoxLemon.visibility = View.INVISIBLE

            binding.spinnerCoffee.visibility = View.VISIBLE
            binding.spinnerTea.visibility = View.INVISIBLE

            additions = String.format(getString(R.string.additions), drink)
            binding.tvAdditions.text = additions

        }

        binding.imageButtonChocolate.setOnClickListener {
            myLog("imageButtonChocolate click")
            checkedAdditions()
            getOptionOfDrink()
            val order = Order(
                1,
                name = name,
                password = password,
                drink = drink,
                additions = builderAdditions,
                optionOfDrink = optionsOfDrink
            )
            val intent = OrderDetailActivity.newIntent(this, order)
            startActivity(intent)

        }


    }

    private fun parseIntent() {
        if (intent.hasExtra(NAME) && intent.hasExtra(PASSWORD)) {
            name = intent.getStringExtra(NAME).toString()
            password = intent.getStringExtra(PASSWORD).toString()
            val hello = String.format(getString(R.string.hello_client), name)
            binding.tvHelloName.text = hello
            myLog(hello)
            myLogNullable(name)

        } else {
            name = getString(R.string.default_name)
            password = getString(R.string.default_password)
            val hello = String.format(getString(R.string.hello_client), name)
            binding.tvHelloName.text = hello
            myLog(name)
        }
    }

    private fun checkedAdditions() {
        builderAdditions.setLength(0)

        if (binding.checkBoxSugar.isChecked) {
            builderAdditions.append(getString(R.string.check_box_sugar)).append(" ")
        }

        if (binding.checkBoxMilk.isChecked) {
            builderAdditions.append(getString(R.string.check_box_milk)).append(" ")
        }
        if (binding.checkBoxLemon.isChecked && drink == getString(R.string.tea)) {
            builderAdditions.append(getString(R.string.checkbox_lemon)).append(" ")
        }
    }

    private fun getOptionOfDrink() {
        if (drink == getString(R.string.tea)) {
            optionsOfDrink = binding.spinnerTea.selectedItem.toString()
        }
        if (drink == getString(R.string.coffee)) {
            optionsOfDrink = binding.spinnerCoffee.selectedItem.toString()
        }
    }

    private fun myLog(message: Any) {
        Log.d(TAG, "CreateOrderActivity  $message  myLog")
    }

    private fun myLogNullable(message: String?) {
        Log.d(TAG, "CreateOrderActivity $message  myLogNullable")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val NAME = "name"
        private const val PASSWORD = "password"
        private const val TAG = "myApp"

        fun newIntent(context: Context, name: String, password: String): Intent {
            return Intent(context, CreateOrderActivity::class.java).apply {
                putExtra(NAME, name)
                putExtra(PASSWORD, password)
            }
        }
    }
}