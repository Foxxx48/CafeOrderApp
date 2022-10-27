package com.fox.cafeorderapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Locale


@Parcelize
data class Order(
    val name: String,
    val password: String,
    val drink: String,
    val additions: StringBuilder,
    val optionOfDrink: String
) : Parcelable {
    override fun toString(): String {
        return when (Locale.getDefault()) {
            Locale.US -> "Name $name " +
                    "Password $password " +
                    "Drink $drink " +
                    "Additions $additions " +
                    "OptionOfDrink $optionOfDrink "

            else -> "Имя $name " +
                    "Пароль $password " +
                    "Напиток $drink " +
                    "Добавки $additions " +
                    "Вид напитка $optionOfDrink "
        }
    }
}
