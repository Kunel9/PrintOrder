package com.bignerdranch.android.printorder

import android.graphics.SumPathEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textE: EditText
    private lateinit var textV: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbA4 : RadioButton
    private lateinit var rbA3 : RadioButton
    private lateinit var rbA1 : RadioButton
    private lateinit var button: Button
    private var cost: Int = 0
    private var sum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radioGroup)
        textE = findViewById(R.id.inputCount)
        textV = findViewById(R.id.outputSum)
        button = findViewById(R.id.button)
        rbA4 = findViewById(R.id.radioButtonA4)
        rbA3 = findViewById(R.id.radioButtonA3)
        rbA1 = findViewById(R.id.radioButtonA1)
        rbA4.setOnClickListener(rbListener)
        rbA3.setOnClickListener(rbListener)
        rbA1.setOnClickListener(rbListener)

        button.setOnClickListener()
        {
            updateSum(cost)
        }
    }

    private val rbListener=View.OnClickListener{
        when (radioGroup.checkedRadioButtonId) {
            R.id.radioButtonA4 -> updateCost(10)
            R.id.radioButtonA3 -> updateCost(30)
            R.id.radioButtonA1 -> updateCost(100)
            else -> updateCost(0)
        }
    }
    private fun updateCost(c: Int)
    {
        cost = c
    }
    private fun updateSum(cost: Int)
    {
        sum = textE.text.toString().toInt() * cost
        textV.text = "Итого: " + sum.toString() + "руб"
    }
}