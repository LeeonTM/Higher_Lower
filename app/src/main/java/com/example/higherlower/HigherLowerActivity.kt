package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)

        btnLower.setOnClickListener{onLowerClick()}
        btnEquals.setOnClickListener{onEqualsClick()}
        btnHigher.setOnClickListener{onHigherClick()}

        initViews()
    }

    private fun initViews() {
        updateUI()
    }

    private fun updateUI() {
        lblLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onLowerClick() {
        rollDice()

        when {
            currentThrow < lastThrow -> answerCorrect()
            else -> answerIncorrect()
        }
    }

    private fun onEqualsClick() {
        rollDice()

        when(lastThrow) {
            currentThrow -> answerCorrect()
            else -> answerIncorrect()
        }
    }

    private fun onHigherClick() {
        rollDice()

        when {
            currentThrow > lastThrow -> answerCorrect()
            else -> answerIncorrect()
        }
    }

    private fun answerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }

    private fun answerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
}
