package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var diceNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            diceNumber = savedInstanceState.getInt(DICE_NUMBER)
            setImageResource()
        }

        binding.btnRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        diceNumber = Random.nextInt(6) + 1
        setImageResource()
    }

    private fun setImageResource() {
        val drawableResource = when(diceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.imgDice.setImageResource(drawableResource)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DICE_NUMBER, diceNumber)
    }

    companion object {
        const val DICE_NUMBER = "diceNumber"
    }
}