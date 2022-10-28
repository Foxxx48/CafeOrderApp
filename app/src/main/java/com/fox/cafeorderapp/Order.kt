package com.fox.cafeorderapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Locale


@Parcelize
 data class Order @JvmOverloads constructor(
    val orderId: Int = Int.MIN_VALUE,
    val name: String = "None",
    val password: String = "None",
    val drink: String = "None",
    val additions: StringBuilder,
    val optionOfDrink: String = "None"
) : Parcelable {

    override fun toString(): String {
        return when (Locale.getDefault().language) {
            Locale.US.language -> "Order ID $orderId " +
                    "Name $name " +
                    "Password $password " +
                    "Drink $drink " +
                    "Additions $additions " +
                    "OptionOfDrink $optionOfDrink "

            else -> "Номер заказа $orderId" +
                    "Имя $name " +
                    "Пароль $password " +
                    "Напиток $drink " +
                    "Добавки $additions " +
                    "Вид напитка $optionOfDrink "
        }
    }
}
