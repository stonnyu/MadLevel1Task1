package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun updateUI() {
        binding.lblLastThrow.text = getString(R.string.label_last_throw, lastThrow)

        when (currentThrow) {
            1 -> binding.imgDice.setImageResource(R.drawable.dice1)
            2 -> binding.imgDice.setImageResource(R.drawable.dice2)
            3 -> binding.imgDice.setImageResource(R.drawable.dice3)
            4 -> binding.imgDice.setImageResource(R.drawable.dice4)
            5 -> binding.imgDice.setImageResource(R.drawable.dice5)
            6 -> binding.imgDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun initViews() {
        updateUI()
        binding.btnHigher.setOnClickListener {
            onHigherClick()
        }
        binding.btnLower.setOnClickListener {
            onLowerClick()
        }
        binding.btnEquals.setOnClickListener {
            onEqualClick()
        }
    }

    /**
     * Replaces the previous dice value with the current one and replaces the current dice with a new dice
     * with a random number between 1 and 6 (inclusive).
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /**
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays an unsuccessful Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
}