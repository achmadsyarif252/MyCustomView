package com.example.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var myButton: MyButton
    private lateinit var myEditText: MyEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton = findViewById(R.id.my_button)
        myEditText = findViewById(R.id.my_edit_text)

        setMyButtonEnabled()

        myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("Halllo")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setMyButtonEnabled()
            }

            override fun afterTextChanged(p0: Editable?) {
                println("After text changed")
            }
        })
        myButton.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                myEditText.text,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setMyButtonEnabled() {
        val result = myEditText.text
        myButton.isEnabled = result != null && result.toString().isNotEmpty()
    }
}