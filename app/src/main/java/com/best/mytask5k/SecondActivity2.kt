package com.best.mytask5k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.best.mytask5k.Users.Member
import com.best.mytask5k.Users.User

class SecondActivity2 : AppCompatActivity() {
    private var TAG = SecondActivity2::class.java.toString()
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

            views()
    }

    private fun views() {
        val button = findViewById<Button>(R.id.btn2)
        button.setOnClickListener {
            val member = Member("Abbos", 7893)
            getBack(member)
        }
        textView  = findViewById(R.id.txtbtnn2)
        val user = intent.getParcelableExtra<User>("user")
        Log.d(TAG, user.toString())
        textView.text = user.toString()
    }

    private fun getBack(member: Member) {
        val intent = Intent()
        intent.putExtra("user", member)
        setResult(RESULT_OK, intent)
        finish()
    }
}