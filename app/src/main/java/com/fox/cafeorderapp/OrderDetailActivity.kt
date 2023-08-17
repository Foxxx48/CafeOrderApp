package com.fox.cafeorderapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fox.cafeorderapp.databinding.ActivityOrderDetailBinding
import java.util.Locale

class OrderDetailActivity : AppCompatActivity() {
    private var _binding: ActivityOrderDetailBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("ActivityOrderDetailBinding")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myLog(Locale.getDefault().language)

        val arguments = intent.extras
        val order = arguments?.getParcelable<Order>(EXTRA_PARCEL)
        order?.let {
            binding.tvOrderId.text = it.orderId.toString()
            binding.tvName.text = it.name
            binding.tvPassword.text = it.password
            binding.tvDrink.text = it.drink
            binding.tvDetailAdditions.text = it.additions
            binding.tvTypeOfDrink.text = it.optionOfDrink

        }



        order?.apply {
            name.format(Locale.getDefault())
            drink.format(Locale.getDefault())
        }
        myLog(order.toString())

    }

    fun myLog(message: String) {
        Log.d(TAG, "OrderDetailActivity $message")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        private const val TAG = "myApp"
        private const val EXTRA_PARCEL = "extra_parcel"

        fun newIntent(context: Context, order: Order): Intent {
            return Intent(context, OrderDetailActivity::class.java).apply {
               putExtra(EXTRA_PARCEL, order)
            }
        }
    }
}