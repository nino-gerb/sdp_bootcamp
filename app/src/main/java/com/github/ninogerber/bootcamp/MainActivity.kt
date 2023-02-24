package com.github.ninogerber.bootcamp

import android.R.attr.value
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnMainId)

        button.setOnClickListener{(
            callActivity()
        )
    }}

    private fun callActivity() {
        val editText = findViewById<EditText>(R.id.NameId)
        val message = editText.text.toString()

        val intent = Intent(this, GreetingActivity::class.java).also{
            it.putExtra("MESSAGE",message)
            startActivity(it)
        }
    }
}