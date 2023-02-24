package com.github.ninogerber.bootcamp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Enumeration

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val message = intent.getStringExtra("MESSAGE")

        val textView = findViewById<TextView>(R.id.GreetingId).apply {
            text = message
        }

        val button = findViewById<FloatingActionButton>(R.id.idRetBut)
        button.setOnClickListener {
            (
                    callActivity()
                    )
        }

    }

    private fun callActivity() {
        val intent = Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }
    }
}

