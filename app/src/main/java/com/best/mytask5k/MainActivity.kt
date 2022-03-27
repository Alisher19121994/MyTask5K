package com.best.mytask5k

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.best.mytask5k.Users.Member
import com.best.mytask5k.Users.User

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var TAG = MainActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn1)
        button.setOnClickListener {
            val user = User("Alisher", 1234)
            openNewPage(user)
        }
        accept()
    }

  private var launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val intent: Intent? = it.data
            val member = intent?.getParcelableExtra<Member>("user")
            Log.d(TAG,member.toString())
            textView.text = member.toString()
        }
    }
    private fun accept() {
        textView = findViewById(R.id.txtbtnn1)
        val member = intent.getParcelableExtra<Member>("user")
        Log.d(TAG, member.toString())
        textView.text = member.toString()
    }

    private fun openNewPage(user: User) {
        val intent = Intent(this, SecondActivity2::class.java)
        intent.putExtra("user", user)
        launcher.launch(intent)
    }
}