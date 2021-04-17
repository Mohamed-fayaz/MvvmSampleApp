package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModelProviders
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : DiceRollerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DiceRollerViewModel::class.java) // creating object for DiceRoller view model class

        setContentView(R.layout.activity_main)

        var rollBtn = findViewById<Button>(R.id.roll_button)  // creating variable for button
        var diceImage = findViewById<ImageView>(R.id.diceimage) // creating variable for image view

        rollBtn.setOnClickListener {  // set on click listener for the button
         viewModel.rollDice() //  called the roll dice method in the viewModel class

            
        }

        viewModel.currentDice.observe(this, { DiceNum ->
            val drawableResource = when (DiceNum) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResource)
        })


    }


}
